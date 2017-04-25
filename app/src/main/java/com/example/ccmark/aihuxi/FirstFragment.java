package com.example.ccmark.aihuxi;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.ccmark.NetApi.NetApi;
import com.example.ccmark.api.AirApi;
import com.example.ccmark.api.CityAirData;
import com.example.ccmark.api.WeatherApi;
import com.example.ccmark.bean.Air;
import com.example.ccmark.bean.AirAll;
import com.example.ccmark.bean.CityAirAll;
import com.example.ccmark.bean.CityAirResult;
import com.example.ccmark.bean.WeatherAll;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FirstFragment extends Fragment {


    private static final String TAG = "FirstFragment";

    private Timer timer;

    public CityAirAll cityAirAll;
    public CityAirResult cityAirResult;

    public SwipeRefreshLayout swipeRefreshLayout;

    public WeatherAll weatherAll;

    private ArcProgress arcProgress;

    private TextView tv_effect;
    private TextView tv_measure;

    private TextView tv_pm2_5;
    private TextView tv_pm10;
    private TextView tv_o3;
    private TextView tv_no2;
    private TextView tv_co;
    private TextView tv_so2;


    private Button loadmore_bt;


    public static FirstFragment newInstance(String info) {
        Bundle args = new Bundle();
        FirstFragment fragment = new FirstFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);

        Log.d(TAG, "onCreateView: ");

        initData();

        arcProgress = (ArcProgress) view.findViewById(R.id.arc_progress);

        tv_effect = (TextView) view.findViewById(R.id.effect);
        tv_measure = (TextView) view.findViewById(R.id.measure);
        tv_pm2_5 = (TextView) view.findViewById(R.id.main_pm2_5);
        tv_pm10 = (TextView) view.findViewById(R.id.main_pm10);
        tv_o3 = (TextView) view.findViewById(R.id.main_O3);
        tv_no2 = (TextView) view.findViewById(R.id.main_NO2);
        tv_co = (TextView) view.findViewById(R.id.main_CO);
        tv_so2 = (TextView) view.findViewById(R.id.main_SO2);
        loadmore_bt = (Button) view.findViewById(R.id.loadmore_bt);

        loadmore_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QualityDetail.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("resultdata", cityAirResult);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        swipeRefreshLayout.setRefreshing(true);
        getData();
        return view;
    }


    public void getData() {

        //获取城市空气质量数据
        getCityAirData();

    }

    protected void initData() {
        cityAirAll = new CityAirAll();
        cityAirResult = new CityAirResult();

    }

    public void updataAirView() {

        final int aqi = Integer.parseInt(cityAirResult.getAqi());
        ObjectAnimator anim = ObjectAnimator.ofInt(arcProgress, "progress", 0, aqi);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(2000);
        anim.start();

        arcProgress.setFinishedStrokeColor(Color.parseColor(cityAirResult.getAqiinfo().getColor()));


        tv_effect.setText(cityAirResult.getAqiinfo().getAffect());
        tv_measure.setText(cityAirResult.getAqiinfo().getMeasure());

        tv_pm2_5.setText(cityAirResult.getPm2_5());
        tv_pm10.setText(cityAirResult.getIpm10());
        tv_o3.setText(cityAirResult.getO3());
        tv_no2.setText(cityAirResult.getNo2());

        float co_float = Float.parseFloat(cityAirResult.getCo());
        co_float = (float) Math.round(co_float * 100) / 100;
        tv_co.setText(co_float + "");
        tv_so2.setText(cityAirResult.getSo2());

    }


    public void getCityAirData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jisuaqi.market.alicloudapi.com")
                .build();

        CityAirData cityAirData = retrofit.create(CityAirData.class);
        Call<ResponseBody> call = cityAirData.getCityAirdata(NetApi.APPCODE, "北京");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    Gson gson = new Gson();
                    if (response.code() == 200) {
                        cityAirAll = gson.fromJson(response.body().string(), CityAirAll.class);
                        if ("0".equals(cityAirAll.getStatus())) {
                            cityAirResult = cityAirAll.getResult();
                            updataAirView();
                            getWeatherData();
                            return;
                        }
                        return;
                    }
                    swipeRefreshLayout.setRefreshing(false);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    public void getWeatherData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ali-weather.showapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherAll> call = weatherApi.getCityWeatherData(NetApi.APPCODE, "北京");
        call.enqueue(new Callback<WeatherAll>() {
            @Override
            public void onResponse(Call<WeatherAll> call, Response<WeatherAll> response) {

                if (response.code() == 200) {
                    weatherAll = response.body();
                    System.out.println(weatherAll.getShowapi_res_code());
                    Log.i(TAG, "getWeatherData: " + weatherAll.getShowapi_res_code());

                } else {

                }

                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<WeatherAll> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
}
