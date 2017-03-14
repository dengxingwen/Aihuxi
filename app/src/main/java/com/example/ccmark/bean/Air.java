package com.example.ccmark.bean;

import android.support.annotation.NonNull;

/**
 * Created by ccmark on 2017/3/10.
 */

public class Air implements Comparable<Air>{

    private int so2;
    private int o3;
    private String area;
    private int aqi;
    private String  quality;
    private int pm10;
    private String ct;
    private int pm2_5;



    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public int getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
    }

    @Override
    public int compareTo(@NonNull Air o) {
        return this.pm2_5 - o.getPm2_5();
    }

}
