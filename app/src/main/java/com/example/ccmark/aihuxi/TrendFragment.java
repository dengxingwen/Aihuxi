package com.example.ccmark.aihuxi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import com.example.ccmark.adapter.TabPaagerAdapter;

import com.example.ccmark.fragment.FragTab1;
import com.example.ccmark.fragment.FragTab2;

import java.util.ArrayList;
import java.util.List;

public class TrendFragment extends Fragment {

    private static final String TAG = "TrendFragment";

    private TabLayout tabs;
    private ViewPager viewPager;
    private List<String> mTitle = new ArrayList<String>();
    private List<Fragment> mFragment = new ArrayList<Fragment>();


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


        initView(view);

        TabPaagerAdapter adapter = new TabPaagerAdapter(getFragmentManager(), mTitle, mFragment);
        viewPager.setAdapter(adapter);
        //为TabLayout设置ViewPager
        tabs.setupWithViewPager(viewPager);
        //使用ViewPager的适配器
        tabs.setTabsFromPagerAdapter(adapter);

        return view;
    }

    //初始化V
    private void initView(View view) {

        tabs = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mTitle.add("今日趋势图");
        mTitle.add("7日趋势图");

        mFragment.add(new FragTab1());
        mFragment.add(new FragTab2());

    }



}
