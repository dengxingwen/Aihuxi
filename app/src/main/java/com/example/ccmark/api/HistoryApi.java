package com.example.ccmark.api;

import com.example.ccmark.bean.History;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by ccmark on 2017/4/8.
 */

public interface HistoryApi {
    @GET("aqi/history")
    Call<History> getHistoryData(@Header("Authorization") String authorization, @Query("city") String city);
}
