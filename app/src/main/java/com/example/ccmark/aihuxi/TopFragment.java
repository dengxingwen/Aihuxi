package com.example.ccmark.aihuxi;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccmark.NetApi.NetApi;
import com.example.ccmark.api.AirApi;
import com.example.ccmark.bean.Air;
import com.example.ccmark.bean.AirAll;
import com.example.ccmark.bean.TopData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TopFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TopAirAdapter mAdapter;
    public TopData topData;
    public boolean canUpdata = false;
    public int segmentedGroupIndex = 0;

    public List<TopData.ShowapiResBodyBean.ListBean> resultdata;
    public List<TopData.ShowapiResBodyBean.ListBean> resultdata_AQI;
    public List<TopData.ShowapiResBodyBean.ListBean> resultdata_PM2_5;

    public static TopFragment newInstance(String info) {
        Bundle args = new Bundle();
        TopFragment fragment = new TopFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, null);

        SegmentedGroup segmented = (SegmentedGroup) view.findViewById(R.id.segmented);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);


        segmented.setTintColor(0xff3eb251);


        segmented.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.button1:
                        segmentedGroupIndex = 0;
                        resultdata = resultdata_AQI;
                        mAdapter.notifyDataSetChanged();
                        return;
                    case R.id.button2:
                        segmentedGroupIndex = 1;
                        resultdata = resultdata_PM2_5;
                        mAdapter.notifyDataSetChanged();
                        return;
                }
            }
        });

        initdata();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview_top);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TopAirAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        getAirTopData();

        return view;
    }

    public void initdata() {
        topData = new TopData();
        resultdata = new ArrayList<>();
        resultdata_AQI = new ArrayList<>();
        resultdata_PM2_5 = new ArrayList<>();
    }


    public void sortbyPM2_5() {
        //移除空数据
        for (int i = 0; i < resultdata_PM2_5.size(); i++) {
            if (resultdata_PM2_5.get(i).getPm2_5().equals("_")) {
                resultdata_PM2_5.remove(i);
            }
        }

        Collections.sort(resultdata_PM2_5);
    }

    //获取空气质量排行榜
    public void getAirTopData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ali-pm25.showapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AirApi airapi = retrofit.create(AirApi.class);
        Call<TopData> call = airapi.getAirData(NetApi.APPCODE);

        call.enqueue(new Callback<TopData>() {
            @Override
            public void onResponse(Call<TopData> call, Response<TopData> response) {

                if (response.code() == 200) {
                    topData = response.body();
                    if (0 == topData.getShowapi_res_code()) {

                        resultdata = topData.getShowapi_res_body().getList();
                        resultdata_AQI = topData.getShowapi_res_body().getList();
                        //移除空数据
                        for (int i = 0; i < resultdata_AQI.size(); i++) {
                            if (resultdata_AQI.get(i).getPm2_5().equals("_")) {
                                resultdata_AQI.remove(i);
                            }
                        }

                        resultdata_PM2_5.addAll(resultdata);
                        sortbyPM2_5();

                        canUpdata = true;
                        mAdapter.notifyDataSetChanged();

                    }

                }


            }

            @Override
            public void onFailure(Call<TopData> call, Throwable t) {

            }
        });

    }

}

