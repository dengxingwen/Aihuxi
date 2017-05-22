package com.example.ccmark.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by ccmark on 2017/3/11.
 */

public interface CityAirData {
    @GET("/aqi/query")
    Call<ResponseBody> getCityAirdata(@Header("Authorization") String authorization,
                                      @Query("city") String city);
}
