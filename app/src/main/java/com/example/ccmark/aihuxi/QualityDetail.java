package com.example.ccmark.aihuxi;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ccmark on 2017/3/13.
 */

public class QualityDetail extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CItyAirDetailAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualitydetail);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_nearby);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        mAdapter = new CItyAirDetailAdapter(this);
        mRecyclerView.setAdapter(mAdapter);


    }


}
