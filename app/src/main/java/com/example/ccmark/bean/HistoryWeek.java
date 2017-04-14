package com.example.ccmark.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ccmark on 2017/4/14.
 */

public class HistoryWeek {

    /**
     * NO2 : 61.8
     * 范围 : 70~160
     * O3 : 69
     * 日期 : 2017-04-08
     * PM2.5 : 77.7
     * SO2 : 7.2
     * 排名 : 295
     * 质量等级 : 轻度污染
     * AQI : 114
     * PM10 : 139
     * CO : 0.921
     */

    private String NO2;
    private String 范围;
    private String O3;
    private String 日期;
    @SerializedName("PM2.5")
    private String _$PM25180; // FIXME check this code
    private String SO2;
    private String 排名;
    private String 质量等级;
    private String AQI;
    private String PM10;
    private String CO;

    public String getNO2() {
        return NO2;
    }

    public void setNO2(String NO2) {
        this.NO2 = NO2;
    }

    public String get范围() {
        return 范围;
    }

    public void set范围(String 范围) {
        this.范围 = 范围;
    }

    public String getO3() {
        return O3;
    }

    public void setO3(String O3) {
        this.O3 = O3;
    }

    public String get日期() {
        return 日期;
    }

    public void set日期(String 日期) {
        this.日期 = 日期;
    }

    public String get_$PM25180() {
        return _$PM25180;
    }

    public void set_$PM25180(String _$PM25180) {
        this._$PM25180 = _$PM25180;
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

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }
}
