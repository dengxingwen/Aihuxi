package com.example.ccmark.bean;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

/**
 * Created by ccmark on 2017/5/5.
 */

public class TopData{



    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }


    public static class ShowapiResBodyBean {

        private int ret_code;
        private List<ListBean> list;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Comparable<ListBean>{

            @Override
            public int compareTo(@NonNull ListBean o) {

                return Integer.parseInt(this.pm2_5) - Integer.parseInt(o.getPm2_5());

            }

            /**
             * o3 : 39
             * area_code : sanming
             * pm2_5 : 13
             * primary_pollutant :
             * ct : 2017-05-05 11:11:49.373
             * num : 2
             * co : 1.125
             * area : 三明
             * no2 : 25
             * aqi : 22
             * quality : 优
             * pm10 : 21
             * o3_8h : 12
             * so2 : 4
             */

            private String o3;
            private String area_code;
            private String pm2_5;
            private String primary_pollutant;
            private String ct;
            private String num;
            private String co;
            private String area;
            private String no2;
            private String aqi;
            private String quality;
            private String pm10;
            private String o3_8h;
            private String so2;

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getArea_code() {
                return area_code;
            }

            public void setArea_code(String area_code) {
                this.area_code = area_code;
            }

            public String getPm2_5() {
                return pm2_5;
            }

            public void setPm2_5(String pm2_5) {
                this.pm2_5 = pm2_5;
            }

            public String getPrimary_pollutant() {
                return primary_pollutant;
            }

            public void setPrimary_pollutant(String primary_pollutant) {
                this.primary_pollutant = primary_pollutant;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getO3_8h() {
                return o3_8h;
            }

            public void setO3_8h(String o3_8h) {
                this.o3_8h = o3_8h;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }
        }
    }
}
