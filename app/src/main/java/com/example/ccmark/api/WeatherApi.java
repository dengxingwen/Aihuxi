package com.example.ccmark.api;

import com.example.ccmark.bean.WeatherAll;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by ccmark on 2017/3/20.
 */

public interface WeatherApi {
    @GET("/hour24")
    Call<WeatherAll> getCityWeatherData(@Header("Authorization") String authorization, @Query("area") String area);
}
