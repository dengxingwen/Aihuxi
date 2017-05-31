package com.example.ccmark.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ccmark on 2017/4/14.
 */

public class HistoryWeek {
    /**
     * NO2 : 46
     * 日期 : 2017-05-24
     * PM2.5 : 17
     * SO2 : 4
     * 排名 : 218
     * 质量等级 : 良
     * AQI : 82
     * PM10 : 55
     * O3_8h : 138
     * CO : 0.4
     */

    private String NO2;
    private String 日期;
    @SerializedName("PM2.5")
    private String _$PM2510; // FIXME check this code
    private String SO2;
    private String 排名;
    private String 质量等级;
    private String AQI;
    private String PM10;
    private String O3_8h;
    private String CO;



    public String getNO2() {
        return NO2;
    }

    public void setNO2(String NO2) {
        this.NO2 = NO2;
    }

    public String get日期() {
        return 日期;
    }

    public void set日期(String 日期) {
        this.日期 = 日期;
    }

    public String get_$PM2510() {
        return _$PM2510;
    }

    public void set_$PM2510(String _$PM2510) {
        this._$PM2510 = _$PM2510;
    }

    public String getSO2() {
        return SO2;
    }

    public void setSO2(String SO2) {
        this.SO2 = SO2;
    }

    public String get排名() {
        return 排名;
    }

    public void set排名(String 排名) {
        this.排名 = 排名;
    }

    public String get质量等级() {
        return 质量等级;
    }

    public void set质量等级(String 质量等级) {
        this.质量等级 = 质量等级;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getPM10() {
        return PM10;
    }

    public void setPM10(String PM10) {
        this.PM10 = PM10;
    }

    public String getO3_8h() {
        return O3_8h;
    }

    public void setO3_8h(String O3_8h) {
        this.O3_8h = O3_8h;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }


}
