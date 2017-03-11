package com.example.ccmark.aihuxi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ccmark.api.AirApi;
import com.example.ccmark.api.CityAirData;
import com.example.ccmark.api.DataApi;
import com.example.ccmark.bean.Air;
import com.example.ccmark.bean.AirAll;
import com.example.ccmark.bean.CityAirAll;
import com.example.ccmark.bean.CityAirResult;
import com.example.ccmark.bean.Contributor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
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
        //gatdata();
        //获取空气数据
       //getAirData();

        getCityAirData();

        return view;
    }

    protected void initData()
    {
        cityAirAll = new CityAirAll();
        cityAirResult = new CityAirResult();
        mDatas = new ArrayList<Air>();
//        for (int i = 0; i < 10; i++)
//        {
//            Air air = new Air();
//            air.setAqi(1);
//            air.setArea("北京");
//            mDatas.add(air);
//        }
    }


   public void gatdata(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://api.github.com/")
               .build();

       DataApi service = retrofit.create(DataApi.class);

       Call<ResponseBody> call = service.contributorsBySimpleGetCall("square","retrofit");

       call.enqueue(new Callback<ResponseBody>() {
           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               try {
                   Gson gson = new Gson();


                   if (response.code() != 200){
                       Toast.makeText(getActivity().getApplicationContext(), "网络错误 code:"+response.code(),
                               Toast.LENGTH_SHORT).show();
                       return;

                   }

                   ArrayList<Contributor> contributorsList = gson.fromJson(response.body().string(), new TypeToken<List<Contributor>>(){}.getType());


                   //mDatas = contributorsList;

                   //zmAdapter.notifyDataSetChanged();

                   for (Contributor contributor : contributorsList){

                       System.out.println(contributor.getLogin());
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {

           }
       });


   }

   //获取空气质量网络数据
   public void getAirData(){
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("http://ali-pm25.showapi.com")
               .build();

       AirApi airapi = retrofit.create(AirApi.class);
       Call<ResponseBody> call = airapi.getAirData("APPCODE 7e015486fcda437389317dca15f51814");

       call.enqueue(new Callback<ResponseBody>() {
           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

               try {

                   Gson gson = new Gson();

                   AirAll airall = gson.fromJson(response.body().string(),AirAll.class);

                   System.out.print("获取成功"+airall);
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
        Call<ResponseBody> call = cityAirData.getCityAirdata("APPCODE 7e015486fcda437389317dca15f51814","北京");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    Gson gson = new Gson();

                    cityAirAll = gson.fromJson(response.body().string(),CityAirAll.class);
                    System.out.println("-----------///////////--------------"+cityAirAll.getMsg());
                    System.out.println("-----------///////////--------------getLevel:"+cityAirAll.getResult().getAqiinfo().getLevel());

                    cityAirResult = cityAirAll.getResult();

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
}
