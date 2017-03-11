package com.example.ccmark.aihuxi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccmark.NetApi.NetApi;
import com.example.ccmark.api.AirApi;
import com.example.ccmark.api.CityAirData;
import com.example.ccmark.bean.Air;
import com.example.ccmark.bean.AirAll;
import com.example.ccmark.bean.CityAirAll;
import com.example.ccmark.bean.CityAirResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class FirstFragment extends Fragment {

    private RecyclerView mRecyclerView;
    public List<Air> mDatas;
    private HomeAdapter mAdapter;

    public CityAirAll cityAirAll;
    public CityAirResult cityAirResult;


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


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);


        initData();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(this));

        getData();
        return view;
    }


    public void getData(){
        //获取空气质量排行榜
        //getAirTopData();
        //获取城市空气质量数据
        getCityAirData();
    }

    protected void initData()
    {
        cityAirAll = new CityAirAll();
        cityAirResult = new CityAirResult();
        //mDatas = new ArrayList<Air>();

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
                   AirAll airall = gson.fromJson(response.body().string(),AirAll.class);
                   mDatas = airall.getShowapi_res_body().getList();
                   mAdapter.notifyDataSetChanged();

               }catch (IOException e) {
                   e.printStackTrace();
               }


           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {

           }
       });



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
