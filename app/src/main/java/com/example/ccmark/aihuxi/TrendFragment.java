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
import com.example.ccmark.fragment.FragTab3;

import java.util.ArrayList;
import java.util.List;

public class TrendFragment extends Fragment {

    private static final String TAG = "TrendFragment";

    private TabLayout tabs;
    private NoScrollViewPager viewPager;
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
        viewPager.setOffscreenPageLimit(2);
        //为TabLayout设置ViewPager
        tabs.setupWithViewPager(viewPager);
        //使用ViewPager的适配器
        tabs.setTabsFromPagerAdapter(adapter);

        return view;
    }

    //初始化V
    private void initView(View view) {

        tabs = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (NoScrollViewPager) view.findViewById(R.id.viewPager);
        viewPager.setScroll(false);
        mTitle.add("12小时趋势图");
        mTitle.add("7天趋势图");
        mTitle.add("30天趋势图");

        mFragment.add(new FragTab1());
        mFragment.add(new FragTab2());
        mFragment.add(new FragTab3());

    }



}
