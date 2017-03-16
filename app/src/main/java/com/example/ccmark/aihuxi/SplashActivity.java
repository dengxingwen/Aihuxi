package com.example.ccmark.aihuxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.ccmark.NetApi.AppConstants;
import com.example.ccmark.utils.SpUtils;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        boolean isFirstOpen = SpUtils.getBoolean(this, AppConstants.FIRST_OPEN);

//        if (!isFirstOpen) {
//            Intent intent = new Intent(this, WelcomeGuideActivity.class);
//            startActivity(intent);
//            finish();
//            return;
//        }

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                enterHomeActivity();
            }
        }, 3000);
    }

    private void enterHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
