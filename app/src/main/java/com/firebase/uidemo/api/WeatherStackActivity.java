package com.firebase.uidemo.api;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.uidemo.R;
import com.firebase.uidemo.api.models.WeatherData;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherStackActivity extends AppCompatActivity {

    private static final String API_BASE_URL = "http://api.weatherstack.com/";
    private static final String LOG_TAG = "MiW";

    private TextView tvRespuesta;
    private EditText etCountryName;

    private WeatherStackRESTAPIService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_stack);

        tvRespuesta = findViewById(R.id.tvRespuesta);
        etCountryName = findViewById(R.id.countryName);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(WeatherStackRESTAPIService.class);
    }

    public void obtenerWeatherDataByCountry(View v) {
        String country = etCountryName.getText().toString();
        Log.i(LOG_TAG, "obtenerWeatherDataByCountry => country: " + country);
        tvRespuesta.setText(null);

        Call<WeatherData> call_async = apiService.getCurrentWeatherDataByCountry(country);

        // Asíncrona
        call_async.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData = response.body();
                if (null != weatherData) {
                    Log.i(LOG_TAG, "Contenido: " + weatherData);
                    tvRespuesta.append(weatherData + "\n\n");
                    Log.i(LOG_TAG, "obtenerWeatherDataByCountry => respuesta= " + weatherData);
                } else {
                    tvRespuesta.setText(getString(R.string.strErrorWeatherDataNotFound));
                    Log.i(LOG_TAG, getString(R.string.strErrorWeatherDataNotFound));
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(
                        getApplicationContext(),
                        "ERROR: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
                Log.e(LOG_TAG, t.getMessage());
            }
        });

        // Síncrona... no aquí => NetworkOnMainThreadException
//        Call<Country> call_sync = apiService.getCountryByName("spain");
//        try {
//            Country country = call_sync.execute().body();
//            Log.i(LOG_TAG, "SYNC => " + country.toString());
//        } catch (IOException e) {
//            Log.e(LOG_TAG, e.getMessage());
//        }
    }
}
