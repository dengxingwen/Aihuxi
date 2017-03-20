package com.example.ccmark.aihuxi;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by ccmark on 2017/3/10.
 */
class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener{

    private static final String TAG = "HomeAdapter";

    private FirstFragment firstFragment;


    public HomeAdapter(FirstFragment firstFragment) {
        this.firstFragment = firstFragment;
    }


    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , int data);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_city.setText(firstFragment.cityAirResult.getCity());
        holder.tv_aqi.setText("AQI："+firstFragment.cityAirResult.getAqi());
        holder.tv_quality.setText("空气质量状况："+firstFragment.cityAirResult.getQuality());
        holder.tv_pm2_5.setText("PM2.5："+firstFragment.cityAirResult.getPm2_5());
        holder.tv_level.setText("级别："+firstFragment.cityAirResult.getAqiinfo().getLevel());
        holder.tv_affect.setText(firstFragment.cityAirResult.getAqiinfo().getAffect());

        holder.tv_weather.setText(firstFragment.weatherAll.getShowapi_res_body().getHourList().get(0).getTemperature()+"℃");

        holder.itemView.setTag(position);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {

        if("0".equals(firstFragment.cityAirAll.getStatus())){
            return 1;
        }

        return 0;

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_city;
        TextView tv_aqi;
        TextView tv_quality;
        TextView tv_pm2_5;
        TextView tv_level;
        TextView tv_affect;

        TextView tv_weather;


        public MyViewHolder(View view) {
            super(view);
            tv_city = (TextView) view.findViewById(R.id.id_city);
            tv_aqi = (TextView) view.findViewById(R.id.id_aqi);
            tv_quality = (TextView) view.findViewById(R.id.id_quality);
            tv_pm2_5 = (TextView) view.findViewById(R.id.id_pm2_5);
            tv_level = (TextView) view.findViewById(R.id.id_level);
            tv_affect = (TextView) view.findViewById(R.id.id_affect);

            tv_weather = (TextView) view.findViewById(R.id.id_main_weather);

        }
    }
}
