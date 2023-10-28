package com.firebase.uidemo.api;

import com.firebase.uidemo.api.models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface WeatherStackRESTAPIService {

    static final String API_KEY = "NOT WORKING";

    @GET("current?access_key=" + API_KEY + "&query={country}")
    Call<WeatherData> getCurrentWeatherDataByCountry(@Path("country") String country);

}