package com.example.ccmark.aihuxi;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.example.ccmark.NetApi.NetApi;
import com.example.ccmark.api.HistoryApi;
import com.example.ccmark.api.WeatherApi;
import com.example.ccmark.bean.History;
import com.example.ccmark.bean.WeatherAll;
import com.example.ccmark.utils.Custom;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TrendFragment extends Fragment {

    private static final String TAG = "TrendFragment";

    public static final int ThemeColor = 0xff3eb251;

    private LineChart lineChart;
    private LineChart lineChart_pm2_5;
    private LineChart lineChart_pm10;
    private LineChart lineChart_O3;

    protected String[] mHour = new String[]{
            "1点", "2点", "3点", "4点", "5点", "6点", "7点", "8点", "9点", "10点", "11点", "12点", "13点", "14点", "15点", "16点", "17点", "18点", "19点", "20点", "21点", "22点", "23点", "24点"};


    private History history;

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
        lineChart_pm2_5 = (LineChart) view.findViewById(R.id.chart2);
        lineChart_pm10 = (LineChart) view.findViewById(R.id.chart3);
        lineChart_O3 = (LineChart) view.findViewById(R.id.chart4);

        Log.i(TAG, "onResponse: start 001");


        ArrayList<Entry> values1 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            values1.add(new Entry(i, 50));
        }
        createLineChart(values1, lineChart, "AQI", 12);

        ArrayList<Entry> values2 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            values2.add(new Entry(i, 85));
        }
        createLineChart(values2, lineChart_pm2_5, "PM2.5", 12);

        ArrayList<Entry> values3 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            values3.add(new Entry(i, 95));
        }
        createLineChart(values3, lineChart_pm10, "PM10", 12);

        ArrayList<Entry> values4 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            values4.add(new Entry(i, 35));
        }
        createLineChart(values4, lineChart_O3, "O₃", 12);

        getHistoryData();


        return view;
    }

    public void createLineChart(ArrayList<Entry> values, LineChart lineChart, String lable, final int latesttime) {

        XAxis xAxis = lineChart.getXAxis();
        //设置X轴的文字在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
//        xAxis.setAxisMinimum(0f);//设置x轴的最小值
//        xAxis.setAxisMaximum(24f);//设置最大值
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        // xAxis.setLabelRotationAngle(10f);//设置x轴标签的旋转角度
//        设置x轴显示标签数量  还有一个重载方法第二个参数为布尔值强制设置数量 如果启用会导致绘制点出现偏差
        xAxis.setLabelCount(11);
        xAxis.setDrawGridLines(false);
//        xAxis.setTextColor(Color.BLUE);//设置轴标签的颜色
        xAxis.setTextSize(9f);//设置轴标签的大小
//        xAxis.setGridLineWidth(10f);//设置竖线大小
//        xAxis.setGridColor(Color.RED);//设置竖线颜色
//        xAxis.setAxisLineColor(Color.GREEN);//设置x轴线颜色
//        xAxis.setAxisLineWidth(5f);//设置x轴线宽度

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                int index = (int)value + (latesttime - 12);
                if (index < 0){
                    index += 24;
                }

                String xlableStr = mHour[index];

                return xlableStr;
            }

        });


        /**
         * Y轴默认显示左右两个轴线
         */
        //获取右边的轴线
        YAxis rightAxis = lineChart.getAxisRight();
        //设置图表右边的y轴禁用
        rightAxis.setEnabled(false);
        //获取左边的轴线
        YAxis leftAxis = lineChart.getAxisLeft();
        //设置网格线为虚线效果
        //leftAxis.enableGridDashedLine(10f, 10f, 0f);
        //是否绘制0所在的网格线
        leftAxis.setDrawZeroLine(true);
        leftAxis.setStartAtZero(true);    //设置Y轴坐标是否从0开始
        //leftAxis.setAxisMaxValue(100);    //设置Y轴坐标最大为多少
        leftAxis.setAxisMinValue(0);    //设置Y轴坐标最小为多少
        //leftAxis.setInverted(false);    //Y轴坐标反转,默认是false,即下小上大
        leftAxis.setSpaceTop(0);    //Y轴坐标距顶有多少距离，即留白
        leftAxis.setSpaceBottom(0);    //Y轴坐标距底有多少距离，即留白
        leftAxis.setLabelCount(10, false);    //第一个参数是Y轴坐标的个数，第二个参数是 是否不均匀分布，true是不均匀分布
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);  //参数是INSIDE_CHART(Y轴坐标在内部) 或 OUTSIDE_CHART(在外部（默认是这个）)

        leftAxis.setAxisMinimum(0);
        leftAxis.setSpaceTop(50);

        //设置与图表交互
        lineChart.setTouchEnabled(false); // 设置是否可以触摸
        lineChart.setDragEnabled(false);// 是否可以拖拽
        lineChart.setScaleEnabled(false);// 是否可以缩放 x和y轴, 默认是true
//        lineChart.setScaleXEnabled(true); //是否可以缩放 仅x轴
//        lineChart.setScaleYEnabled(true); //是否可以缩放 仅y轴
        lineChart.setPinchZoom(false);  //设置x轴和y轴能否同时缩放。默认是否
        lineChart.setDoubleTapToZoomEnabled(false);//设置是否可以通过双击屏幕放大图表。默认是true
//        lineChart.setHighlightPerDragEnabled(true);//能否拖拽高亮线(数据点与坐标的提示线)，默认是true
//        lineChart.setDragDecelerationEnabled(true);//拖拽滚动时，手放开是否会持续滚动，默认是true（false是拖到哪是哪，true拖拽之后还会有缓冲）
//        lineChart.setDragDecelerationFrictionCoef(0.99f);//与上面那个属性配合，持续滚动时的速度快慢，[0,1) 0代表立即停止。

        //lineChart.setDrawBorders(false); //启用/禁用绘制图表边框（chart周围的线）。


        Description description = new Description();
        description.setText("");
        description.setTextColor(Color.GRAY);
        description.setTextSize(12);
        lineChart.setDescription(description);//设置图表描述信息
        lineChart.setNoDataText("暂时没有数据！！！");//没有数据时显示的文字
        lineChart.setNoDataTextColor(Color.GRAY);//没有数据时显示文字的颜色
        lineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        lineChart.setDrawBorders(false);//禁止绘制图表边框的线
        //lineChart.setBorderColor(); //设置 chart 边框线的颜色。
        //lineChart.setBorderWidth(); //设置 chart 边界线的宽度，单位 dp。
        //lineChart.setLogEnabled(true);//打印日志
        //lineChart.notifyDataSetChanged();//刷新数据
        //lineChart.invalidate();//重绘


        //LineDataSet每一个对象就是一条连接线
        LineDataSet set;


        //判断图表中原来是否有数据
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set.setValues(values);

            //刷新数据
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
            lineChart.invalidate();
        } else {
            //设置数据1  参数1：数据源 参数2：图例名称
            set = new LineDataSet(values, lable);
            set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set.setColor(ThemeColor);
            set.setCircleColor(ThemeColor);
            set.setLineWidth(1.5f);//设置线宽
            set.setCircleRadius(4f);//设置焦点圆心的大小
            set.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
            set.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
            set.setHighlightEnabled(false);//是否禁用点击高亮线
            set.setHighLightColor(ThemeColor);//设置点击交点后显示交高亮线的颜色
            set.setValueTextSize(10f);//设置显示值的文字大小
            set.setDrawFilled(false);//设置禁用范围背景填充

            //格式化显示数据
            final DecimalFormat mFormat = new DecimalFormat("###,###,##0");
            set.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return mFormat.format(value);
                }
            });
            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.fade_red);
                set.setFillDrawable(drawable);//设置范围背景填充
            } else {
                set.setFillColor(Color.BLACK);
            }

            //保存LineDataSet集合
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set); // add the datasets
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData data = new LineData(dataSets);

            // 添加到图表中
            lineChart.setData(data);
            //绘制图表
            lineChart.invalidate();

        }

    }

    public void getHistoryData() {

        Log.i(TAG, "onResponse: getHistoryData 002");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jisuaqi.market.alicloudapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HistoryApi historyApi = retrofit.create(HistoryApi.class);
        Call<History> call = historyApi.getHistoryData(NetApi.APPCODE, "北京");
        call.enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {

                history = response.body();

                Log.i(TAG, "onResponse:getAqi 003: " + history.getResult().getHour().get(0).getAqi());

                updataCharts();

            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {

            }
        });

    }

    //更新图表
    public void updataCharts() {

        Log.i(TAG, "onResponse: updataCharts 004");

        int hour = Custom.getHour(history.getResult().getHour().get(0).getTimepoint());
//
//        int[] xData = new int[12];
//
//        for (int i = 0; i < xData.length; i++) {
//            xData[i] = i+(hour-11);
//            if(xData[i]<0) {
//                xData[i]+=24;
//            }
//        }


        ArrayList<Entry> values1 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int y_value = Integer.parseInt(history.getResult().getHour().get(11 - i).getAqi());
            values1.add(new Entry(i, y_value));
        }
        createLineChart(values1, lineChart, "AQI", hour);

        ArrayList<Entry> values2 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int y_value = Integer.parseInt(history.getResult().getHour().get(11 - i).getPm2_5());
            values2.add(new Entry(i, y_value));
        }
        createLineChart(values2, lineChart_pm2_5, "PM2.5", hour);

        ArrayList<Entry> values3 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int y_value = Integer.parseInt(history.getResult().getHour().get(11 - i).getPm10());
            values3.add(new Entry(i, y_value));
        }
        createLineChart(values3, lineChart_pm10, "PM10", hour);

        ArrayList<Entry> values4 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int y_value = Integer.parseInt(history.getResult().getHour().get(11 - i).getO3());
            values4.add(new Entry(i, y_value));
        }
        createLineChart(values4, lineChart_O3, "O₃", hour);
    }


}
