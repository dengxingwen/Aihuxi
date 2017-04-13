package com.example.ccmark.aihuxi;

import android.content.Intent;
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

import com.example.ccmark.NetApi.NetApi;
import com.example.ccmark.api.AirApi;
import com.example.ccmark.api.CityAirData;
import com.example.ccmark.api.WeatherApi;
import com.example.ccmark.bean.Air;
import com.example.ccmark.bean.AirAll;
import com.example.ccmark.bean.CityAirAll;
import com.example.ccmark.bean.CityAirResult;
import com.example.ccmark.bean.WeatherAll;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FirstFragment extends Fragment {


    private static final String TAG = "FirstFragment";

    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;

    public CityAirAll cityAirAll;
    public CityAirResult cityAirResult;

    public SwipeRefreshLayout swipeRefreshLayout;

    public WeatherAll weatherAll;


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

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mAdapter = new HomeAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new HomeAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int data) {

                Intent intent = new Intent(getContext(),QualityDetail.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("resultdata", cityAirResult);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

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


    public void getData(){

        //获取城市空气质量数据
        getCityAirData();

    }

    protected void initData()
    {
        cityAirAll = new CityAirAll();
        cityAirResult = new CityAirResult();

    }


    public void getCityAirData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jisuaqi.market.alicloudapi.com")
                .build();

        CityAirData cityAirData = retrofit.create(CityAirData.class);
        Call<ResponseBody> call = cityAirData.getCityAirdata(NetApi.APPCODE,"北京");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    Gson gson = new Gson();
                    if (response.code() == 200 ){
                        cityAirAll = gson.fromJson(response.body().string(),CityAirAll.class);
                        if ("0".equals(cityAirAll.getStatus())){
                            cityAirResult = cityAirAll.getResult();
                            getWeatherData();
                            return;
                        }
                        return;
                    }
                    swipeRefreshLayout.setRefreshing(false);

                }catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


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

                weatherAll = response.body();
                System.out.println(weatherAll.getShowapi_res_code());
                mAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<WeatherAll> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
}
