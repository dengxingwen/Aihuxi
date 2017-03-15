package com.example.ccmark.aihuxi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ccmark.bean.Air;


/**
 * Created by ccmark on 2017/3/10.
 */
class TopAirAdapter extends RecyclerView.Adapter<TopAirAdapter.MyViewHolder> implements View.OnClickListener{

    private static final String TAG = "TopAirAdapter";

    private TopFragment topFragment;


    public TopAirAdapter(TopFragment topFragment) {
        this.topFragment = topFragment;
    }


    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int data);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_index.setText(position+1+"");
        holder.tv_city.setText(topFragment.resultdata.get(position).getArea());
        holder.tv_quality.setText(topFragment.resultdata.get(position).getQuality());
        if (topFragment.segmentedGroupIndex == 0){
            holder.tv_value.setText(topFragment.resultdata.get(position).getAqi()+"");
        }else {
            holder.tv_value.setText(topFragment.resultdata.get(position).getPm2_5()+"");
        }


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

        if(topFragment.canUpdata){
            return topFragment.resultdata.size();
        }
        return 0;

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_index;
        TextView tv_city;
        TextView tv_quality;
        TextView tv_value;

        public MyViewHolder(View view) {
            super(view);

            tv_index = (TextView) view.findViewById(R.id.id_index);
            tv_city = (TextView) view.findViewById(R.id.id_city);
            tv_quality = (TextView) view.findViewById(R.id.id_quality);
            tv_value = (TextView) view.findViewById(R.id.id_value);

        }
    }
}
