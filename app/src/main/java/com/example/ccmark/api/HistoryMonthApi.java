package com.example.ccmark.api;



import com.example.ccmark.bean.HistoryWeek;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ccmark on 2017/4/14.
 */

public interface HistoryMonthApi {
    @GET("air/historyMonth")
    Call<List<HistoryWeek>> getHistoryMonthData(@Query("city") String city, @Query("month") String month);
}
