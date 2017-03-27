package com.example.ccmark.aihuxi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ccmark.NetApi.NetApi;
import com.example.ccmark.api.WeatherApi;
import com.example.ccmark.bean.CityAirResult;
import com.example.ccmark.bean.WeatherAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ccmark on 2017/3/13.
 */

public class QualityDetail extends AppCompatActivity {

    private TextView tv_city_name;
    private TextView tv_city_wendu;
    private TextView tv_city_weather;
    private ImageView img_city_id_weather_img;
    private TextView tv_city_quality;
    private TextView tv_city_aqi;
    private TextView tv_city_pm2_5;
    private TextView tv_city_o3;
    private TextView tv_city_no2;
    private TextView tv_city_so2;
    private TextView tv_city_pm_10;
    private TextView tv_city_level;
    private TextView tv_city_afect;
    private TextView tv_city_measure;

    private RecyclerView mRecyclerView;
    private CityAirDetailAdapter mAdapter;

    public CityAirResult cityAirResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualitydetail);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cityAirResult = (CityAirResult) getIntent().getSerializableExtra("resultdata");

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_nearby);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mAdapter = new CityAirDetailAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        initView();
        updataView();
        getWeatherData();
    }

    public void initView(){
        tv_city_name = (TextView) findViewById(R.id.id_cityname);
        tv_city_wendu = (TextView) findViewById(R.id.id_city_wendu);
        tv_city_weather = (TextView) findViewById(R.id.id_city_weather);
        img_city_id_weather_img = (ImageView) findViewById(R.id.id_weather_img);;
        tv_city_quality = (TextView) findViewById(R.id.id_city_quality);
        tv_city_aqi = (TextView) findViewById(R.id.id_city_aqi);
        tv_city_pm2_5 = (TextView) findViewById(R.id.id_city_pm2_5);
        tv_city_o3 = (TextView) findViewById(R.id.id_city_o3);
        tv_city_no2 = (TextView) findViewById(R.id.id_city_no2);
        tv_city_so2 = (TextView) findViewById(R.id.id_city_so2);
        tv_city_pm_10 = (TextView) findViewById(R.id.id_city_pm_10);
        tv_city_level = (TextView) findViewById(R.id.id_city_level);
        tv_city_afect = (TextView) findViewById(R.id.id_city_affect);
        tv_city_measure = (TextView) findViewById(R.id.id_city_measure);

    }

    public void updataView(){

        tv_city_name.setText(cityAirResult.getCity());
        img_city_id_weather_img.setColorFilter(Color.parseColor(cityAirResult.getAqiinfo().getColor()));
        tv_city_quality.setText(cityAirResult.getQuality());
        tv_city_aqi.setText(cityAirResult.getAqi());
        tv_city_pm2_5.setText(cityAirResult.getPm2_5());
        tv_city_o3.setText(cityAirResult.getO3());
        tv_city_no2.setText(cityAirResult.getNo2());
        tv_city_so2.setText(cityAirResult.getSo2());
        tv_city_pm_10.setText(cityAirResult.getPm10());
        tv_city_level.setText(cityAirResult.getAqiinfo().getLevel());
        tv_city_afect.setText(cityAirResult.getAqiinfo().getAffect());
        tv_city_measure.setText(cityAirResult.getAqiinfo().getMeasure());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getWeatherData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ali-weather.showapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherAll> call = weatherApi.getCityWeatherData(NetApi.APPCODE,"北京");
        call.enqueue(new Callback<WeatherAll>() {
            @Override
            public void onResponse(Call<WeatherAll> call, Response<WeatherAll> response) {

                WeatherAll weatherAll = response.body();
                System.out.println(weatherAll.getShowapi_res_code());
                tv_city_wendu.setText(weatherAll.getShowapi_res_body().getHourList().get(0).getTemperature()+"℃");
                tv_city_weather.setText(weatherAll.getShowapi_res_body().getHourList().get(0).getWeather());
            }

            @Override
            public void onFailure(Call<WeatherAll> call, Throwable t) {

            }
        });


    }

}
