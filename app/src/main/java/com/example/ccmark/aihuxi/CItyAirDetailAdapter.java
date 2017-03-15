package com.example.ccmark.aihuxi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by ccmark on 2017/3/10.
 */
class CItyAirDetailAdapter extends RecyclerView.Adapter<CItyAirDetailAdapter.MyViewHolder> implements View.OnClickListener{

    private static final String TAG = "CItyAirDetailAdapter";

    private QualityDetail qualityDetail;


    public CItyAirDetailAdapter(QualityDetail qualityDetail) {
        this.qualityDetail = qualityDetail;
    }


    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int data);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_citydetaillist, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_nearbysites_name.setText(qualityDetail.cityAirResult.getPosition().get(position).getPositionname());
        holder.tv_aqi.setText(qualityDetail.cityAirResult.getPosition().get(position).getAqi());
        holder.tv_pm2_5.setText(qualityDetail.cityAirResult.getPosition().get(position).getPm2_5());
        holder.tv_pm10.setText(qualityDetail.cityAirResult.getPosition().get(position).getPm10());
        holder.tv_o3.setText(qualityDetail.cityAirResult.getPosition().get(position).getO3());
        holder.tv_no2.setText(qualityDetail.cityAirResult.getPosition().get(position).getNo2());
        holder.tv_so2.setText(qualityDetail.cityAirResult.getPosition().get(position).getSo2());

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

        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nearbysites_name;
        TextView tv_aqi;
        TextView tv_pm2_5;
        TextView tv_pm10;
        TextView tv_o3;
        TextView tv_no2;
        TextView tv_so2;

        public MyViewHolder(View view) {
            super(view);

            tv_nearbysites_name = (TextView) view.findViewById(R.id.id_nearbysites_name);
            tv_aqi = (TextView) view.findViewById(R.id.id_nearbysites_aqi);
            tv_pm2_5 = (TextView) view.findViewById(R.id.id_nearbysites_pm2_5);
            tv_pm10 = (TextView) view.findViewById(R.id.id_nearbysites_pm10);
            tv_o3 = (TextView) view.findViewById(R.id.id_nearbysites_o3);
            tv_no2 = (TextView) view.findViewById(R.id.id_nearbysites_no2);
            tv_so2 = (TextView) view.findViewById(R.id.id_nearbysites_so2);

        }
    }
}
