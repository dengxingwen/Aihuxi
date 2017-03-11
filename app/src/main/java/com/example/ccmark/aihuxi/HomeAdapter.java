package com.example.ccmark.aihuxi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by ccmark on 2017/3/10.
 */
class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private FirstFragment firstFragment;


    public HomeAdapter(FirstFragment firstFragment) {
        this.firstFragment = firstFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                firstFragment.getActivity()).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_city.setText("地区："+firstFragment.cityAirResult.getCity());
        holder.tv_aqi.setText("AQI："+firstFragment.cityAirResult.getAqi());
        holder.tv_quality.setText("空气质量状况："+firstFragment.cityAirResult.getQuality());
        holder.tv_pm2_5.setText("PM2.5："+firstFragment.cityAirResult.getPm2_5());
        holder.tv_level.setText("级别："+firstFragment.cityAirResult.getAqiinfo().getLevel());
        holder.tv_affect.setText(firstFragment.cityAirResult.getAqiinfo().getAffect());

    }

    @Override
    public int getItemCount() {

        if(firstFragment.cityAirAll.getStatus() == null){
            return  0;
        }
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_city;
        TextView tv_aqi;
        TextView tv_quality;
        TextView tv_pm2_5;
        TextView tv_level;
        TextView tv_affect;


        public MyViewHolder(View view) {
            super(view);
            tv_city = (TextView) view.findViewById(R.id.id_city);
            tv_aqi = (TextView) view.findViewById(R.id.id_aqi);
            tv_quality = (TextView) view.findViewById(R.id.id_quality);
            tv_pm2_5 = (TextView) view.findViewById(R.id.id_pm2_5);
            tv_level = (TextView) view.findViewById(R.id.id_level);
            tv_affect = (TextView) view.findViewById(R.id.id_affect);

        }
    }
}
