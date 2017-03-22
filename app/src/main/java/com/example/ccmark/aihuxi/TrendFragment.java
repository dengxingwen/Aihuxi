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

        createLineChart();

        return view;
    }

    public void createLineChart(){

        XAxis xAxis = lineChart.getXAxis();
        //设置X轴的文字在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawLabels(true);//绘制标签  指x轴上的对应数值
        xAxis.setAxisMinimum(0f);//设置x轴的最小值
        xAxis.setAxisMaximum(24f);//设置最大值
        xAxis.setAvoidFirstLastClipping(true);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        //xAxis.setLabelRotationAngle(10f);//设置x轴标签的旋转角度
//        设置x轴显示标签数量  还有一个重载方法第二个参数为布尔值强制设置数量 如果启用会导致绘制点出现偏差
        xAxis.setLabelCount(8);
        xAxis.setDrawGridLines(false);
//        xAxis.setTextColor(Color.BLUE);//设置轴标签的颜色
//        xAxis.setTextSize(24f);//设置轴标签的大小
//        xAxis.setGridLineWidth(10f);//设置竖线大小
//        xAxis.setGridColor(Color.RED);//设置竖线颜色
//        xAxis.setAxisLineColor(Color.GREEN);//设置x轴线颜色
//        xAxis.setAxisLineWidth(5f);//设置x轴线宽度
//        xAxis.setValueFormatter();//格式化x轴标签显示字符



        /**
         * Y轴默认显示左右两个轴线
         */
        //获取右边的轴线
        YAxis rightAxis=lineChart.getAxisRight();
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



        Description description =new Description();
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

        ArrayList<Entry> values1 = new ArrayList<>();

        values1.add(new Entry(0,55));
        values1.add(new Entry(3,59));
        values1.add(new Entry(6,63));
        values1.add(new Entry(9,70));
        values1.add(new Entry(12,80));
        values1.add(new Entry(15,60));
        values1.add(new Entry(18,43));
        values1.add(new Entry(21,49));
        values1.add(new Entry(24,50));

        //LineDataSet每一个对象就是一条连接线
        LineDataSet set1;
        LineDataSet set2;


        //判断图表中原来是否有数据
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values1);

            //刷新数据
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            //设置数据1  参数1：数据源 参数2：图例名称
            set1 = new LineDataSet(values1, "AQI");
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setColor(ThemeColor);
            set1.setCircleColor(ThemeColor);
            set1.setLineWidth(1.5f);//设置线宽
            set1.setCircleRadius(4f);//设置焦点圆心的大小
            set1.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
            set1.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
            set1.setHighlightEnabled(false);//是否禁用点击高亮线
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

            //保存LineDataSet集合
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the datasets
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData data = new LineData(dataSets);

            // 添加到图表中
            lineChart.setData(data);
            //绘制图表
            lineChart.invalidate();


        }

    }

}
