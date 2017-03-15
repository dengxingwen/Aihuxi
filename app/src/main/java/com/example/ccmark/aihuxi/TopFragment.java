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


public class TopFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TopAirAdapter mAdapter;
    public AirAll airall;
    public boolean canUpdata = false;
    public int segmentedGroupIndex = 0;

    public List<Air> resultdata;
    public List<Air> resultdata_AQI;
    public List<Air> resultdata_PM2_5;

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

        SegmentedGroup segmented = (SegmentedGroup)view.findViewById(R.id.segmented);
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

    public void initdata(){
        airall = new AirAll();
        resultdata = new ArrayList<Air>();
        resultdata_AQI = new ArrayList<Air>();
        resultdata_PM2_5 = new ArrayList<Air>();
    }


    public void sortbyPM2_5(){
        Collections.sort(resultdata_PM2_5);
    }

    //获取空气质量排行榜
    public void getAirTopData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ali-pm25.showapi.com")
                .build();

        AirApi airapi = retrofit.create(AirApi.class);
        Call<ResponseBody> call = airapi.getAirData(NetApi.APPCODE);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {

                    Gson gson = new Gson();
                    if (response.code() == 200 ){
                        airall = gson.fromJson(response.body().string(),AirAll.class);
                        if (0 == airall.getShowapi_res_code()){

                            resultdata = airall.getShowapi_res_body().getList();
                            resultdata_AQI = airall.getShowapi_res_body().getList();
                            resultdata_PM2_5.addAll(resultdata);
                            sortbyPM2_5();

                            canUpdata = true;
                            mAdapter.notifyDataSetChanged();

                        }

                    }

                }catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

}

