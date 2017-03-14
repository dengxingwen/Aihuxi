package com.example.ccmark.aihuxi;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class TrendFragment extends Fragment{

    public static final int ThemeColor = 0xff3eb251;

    private LineChart lineChart;

    public static TrendFragment newInstance(String info) {
        Bundle args = new Bundle();
        TrendFragment fragment = new TrendFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trend, null);

        lineChart = (LineChart) view.findViewById(R.id.chart1);

        Description description =new Description();
        description.setText("");
        description.setTextColor(Color.GRAY);
        description.setTextSize(12);
        lineChart.setDescription(description);//设置图表描述信息
        lineChart.setNoDataText("没有数据哦！！！");//没有数据时显示的文字
        lineChart.setNoDataTextColor(Color.GRAY);//没有数据时显示文字的颜色
        lineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        lineChart.setDrawBorders(false);//禁止绘制图表边框的线
        //lineChart.setBorderColor(); //设置 chart 边框线的颜色。
        //lineChart.setBorderWidth(); //设置 chart 边界线的宽度，单位 dp。
        //lineChart.setLogEnabled(true);//打印日志
        //lineChart.notifyDataSetChanged();//刷新数据
        //lineChart.invalidate();//重绘

        ArrayList<Entry> values1 = new ArrayList<>();
        ArrayList<Entry> values2 = new ArrayList<>();

        values1.add(new Entry(4,10));
        values1.add(new Entry(6,15));
        values1.add(new Entry(9,20));
        values1.add(new Entry(12,5));
        values1.add(new Entry(15,30));

        values2.add(new Entry(3,110));
        values2.add(new Entry(6,115));
        values2.add(new Entry(9,130));
        values2.add(new Entry(12,85));
        values2.add(new Entry(15,90));

        //LineDataSet每一个对象就是一条连接线
        LineDataSet set1;
        LineDataSet set2;

        //判断图表中原来是否有数据
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values1);
            set2= (LineDataSet) lineChart.getData().getDataSetByIndex(1);
            set2.setValues(values2);
            //刷新数据
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            //设置数据1  参数1：数据源 参数2：图例名称
            set1 = new LineDataSet(values1, "AQI值");
            set1.setColor(ThemeColor);
            set1.setCircleColor(ThemeColor);
            set1.setLineWidth(1.3f);//设置线宽
            set1.setCircleRadius(3f);//设置焦点圆心的大小
            set1.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
            set1.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
            set1.setHighlightEnabled(true);//是否禁用点击高亮线
            set1.setHighLightColor(ThemeColor);//设置点击交点后显示交高亮线的颜色
            set1.setValueTextSize(10f);//设置显示值的文字大小
            set1.setDrawFilled(false);//设置禁用范围背景填充

            //格式化显示数据
            final DecimalFormat mFormat = new DecimalFormat("###,###,##0");
            set1.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return mFormat.format(value);
                }
            });
            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.fade_red);
                set1.setFillDrawable(drawable);//设置范围背景填充
            } else {
                set1.setFillColor(Color.BLACK);
            }

            //设置数据2
            set2 = new LineDataSet(values2, "PM2.5值");
            set2.setColor(Color.BLUE);
            set2.setCircleColor(Color.BLUE);
            set2.setLineWidth(1.3f);
            set2.setCircleRadius(3f);
            set2.setValueTextSize(10f);
            set2.setHighLightColor(Color.BLUE);

            //保存LineDataSet集合
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the datasets
            dataSets.add(set2);
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData data = new LineData(dataSets);
            // 添加到图表中
            lineChart.setData(data);
            //绘制图表
            lineChart.invalidate();

        }

        return view;
    }

}
