package com.firebase.uidemo.api;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.uidemo.R;
import com.firebase.uidemo.api.models.TvShow;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvMazeActivity extends AppCompatActivity {

    private static final String API_BASE_URL = "https://api.tvmaze.com/";
    private static final String LOG_TAG = "MiW";

    private TextView tvRespuesta;
    private EditText etCountryName;

    private TvMazeRESTAPIService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_maze);

        tvRespuesta = findViewById(R.id.tvRespuesta);
        etCountryName = findViewById(R.id.countryName);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(TvMazeRESTAPIService.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String parseDateToApiCall(LocalDateTime date) {
        DecimalFormat mFormat = new DecimalFormat("00");

        return date.getYear() +
                "-" +
                mFormat.format(date.getMonthValue()) +
                "-" +
                mFormat.format(date.getDayOfMonth());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void obtenerTodayShowsByCountry(View v) {
        LocalDateTime dateTime = LocalDateTime.now();
        String parsedDate = parseDateToApiCall(dateTime);
        String country = etCountryName.getText().toString();
        Log.i(LOG_TAG, "obtenerTodayShowsByCountry => country: " + country + ", date: " + parsedDate);
        tvRespuesta.setText(null);

        Call<List<TvShow>> call_async = apiService.getTodayShowsByCountry(country, parsedDate);

        // Asíncrona
        call_async.enqueue(new Callback<List<TvShow>>() {
            @Override
            public void onResponse(Call<List<TvShow>> call, Response<List<TvShow>> response) {
                List<TvShow> tvShows = response.body();
                if (null != tvShows) {
                    Log.i(LOG_TAG, "Contenido: " + tvShows);
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String formattedJson = gson.toJson(tvShows);
                    tvRespuesta.append(formattedJson + "\n\n");
                    Log.i(LOG_TAG, "obtenerTodayShowsByCountry => country: " + country + ", date: " + parsedDate);
                } else {
                    tvRespuesta.setText(getString(R.string.strErrorShowsDataNotFound));
                    Log.i(LOG_TAG, getString(R.string.strErrorShowsDataNotFound));
                }
            }

            @Override
            public void onFailure(Call<List<TvShow>> call, Throwable t) {
                Toast.makeText(
                        getApplicationContext(),
                        "ERROR: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
                Log.e(LOG_TAG, t.getMessage());
            }
        });
    }
}
