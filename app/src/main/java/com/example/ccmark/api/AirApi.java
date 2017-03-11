package com.example.ccmark.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by ccmark on 2017/3/10.
 */

public interface AirApi {
    @GET("/pm25-top")
    Call<ResponseBody> getAirData(@Header("Authorization") String authorization);
}
