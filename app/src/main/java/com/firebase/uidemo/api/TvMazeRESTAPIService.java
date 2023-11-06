package com.firebase.uidemo.api;

import com.firebase.uidemo.api.models.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface TvMazeRESTAPIService {

    @GET("schedule/web")
    Call<List<Episode>> getTodayEpisodesByCountry(@Query("country") String country, @Query("date") String date);

}