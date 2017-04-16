package com.example.ccmark.aihuxi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.ccmark.adapter.ViewPagerAdapter;
import com.example.ccmark.base.BaseAppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseAppCompatActivity {

    private static final String TAG = "MainActivity";

    BottomNavigationView bottomNavigationView;
    NoScrollViewPager viewPager;
    MenuItem prevMenuItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
//        getToolbarTitle().setText("主界面");
//        getSubTitle().setText("更多");


        Log.d(TAG, "onCreate: ");


        viewPager = (NoScrollViewPager) findViewById(R.id.viewpager);
        viewPager.setScroll(false);
        viewPager.setOffscreenPageLimit(2);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                viewPager.setCurrentItem(0);
                                setToolBarTitle("爱呼吸");
                                break;
                            case R.id.navigation_trend:
                                viewPager.setCurrentItem(1);
                                setToolBarTitle("空气质量趋势图");
                                break;
                            case R.id.navigation_top:
                                viewPager.setCurrentItem(2);
                                setToolBarTitle("排行榜");
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });


        setupViewPager(viewPager);
    }

    /**
     * 设置不显示返回按钮
     *
     * @return
     */
    protected boolean isShowBacking() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(FirstFragment.newInstance("1"));
        adapter.addFragment(TrendFragment.newInstance("2"));
        adapter.addFragment(TopFragment.newInstance("3"));
        viewPager.setAdapter(adapter);

    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }


}