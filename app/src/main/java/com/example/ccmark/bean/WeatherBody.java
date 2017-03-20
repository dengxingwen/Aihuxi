package com.example.ccmark.bean;

import java.util.List;

/**
 * Created by ccmark on 2017/3/20.
 */

public class WeatherBody {

    public int ret_code;
    public String area;
    public String areaid;
    public List<WeatherHour> hourList;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public List<WeatherHour> getHourList() {
        return hourList;
    }

    public void setHourList(List<WeatherHour> hourList) {
        this.hourList = hourList;
    }
}
