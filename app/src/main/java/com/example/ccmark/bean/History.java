package com.example.ccmark.bean;

import java.util.List;

/**
 * Created by ccmark on 2017/4/8.
 */

public class History {

    /**
     * status : 0
     * msg : ok
     * result : {"cityid":"382","city":"杭州","hour":[{"so2":"11","so224":"10","no2":"49","no224":"56","co":"1.050","co24":"0.950","o3":"32","o38":"19","o324":"22","pm10":"104","pm1024":"85","pm2_5":"70","pm2_524":"59","iso2":"4","ino2":"25","ico":"11","io3":"11","io38":"10","ipm10":"73","ipm2_5":"94","aqi":"94","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 10:00:00","color":"#FFFF00"},{"so2":"11","so224":"9","no2":"47","no224":"56","co":"1.030","co24":"0.950","o3":"24","o38":"17","o324":"20","pm10":"101","pm1024":"83","pm2_5":"67","pm2_524":"58","iso2":"4","ino2":"24","ico":"11","io3":"8","io38":"9","ipm10":"71","ipm2_5":"91","aqi":"91","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 09:00:00","color":"#FFFF00"},{"so2":"11","so224":"10","no2":"47","no224":"56","co":"0.980","co24":"0.950","o3":"21","o38":"16","o324":"19","pm10":"96","pm1024":"81","pm2_5":"65","pm2_524":"56","iso2":"5","ino2":"24","ico":"10","io3":"7","io38":"8","ipm10":"73","ipm2_5":"87","aqi":"87","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 08:00:00","color":"#FFFF00"},{"so2":"11","so224":"9","no2":"47","no224":"56","co":"0.990","co24":"0.950","o3":"16","o38":"15","o324":"19","pm10":"95","pm1024":"79","pm2_5":"63","pm2_524":"55","iso2":"4","ino2":"24","ico":"10","io3":"6","io38":"8","ipm10":"72","ipm2_5":"86","aqi":"86","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 07:00:00","color":"#FFFF00"},{"so2":"11","so224":"9","no2":"46","no224":"55","co":"0.950","co24":"0.920","o3":"16","o38":"16","o324":"19","pm10":"92","pm1024":"77","pm2_5":"63","pm2_524":"53","iso2":"4","ino2":"23","ico":"10","io3":"6","io38":"8","ipm10":"71","ipm2_5":"85","aqi":"85","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 06:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"46","no224":"55","co":"0.920","co24":"0.920","o3":"16","o38":"15","o324":"18","pm10":"82","pm1024":"74","pm2_5":"63","pm2_524":"52","iso2":"4","ino2":"24","ico":"10","io3":"6","io38":"8","ipm10":"62","ipm2_5":"85","aqi":"85","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 05:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"50","no224":"55","co":"0.920","co24":"0.920","o3":"16","o38":"15","o324":"18","pm10":"82","pm1024":"72","pm2_5":"61","pm2_524":"50","iso2":"4","ino2":"25","ico":"10","io3":"6","io38":"8","ipm10":"59","ipm2_5":"83","aqi":"83","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 04:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"50","no224":"54","co":"0.930","co24":"0.910","o3":"16","o38":"15","o324":"17","pm10":"80","pm1024":"71","pm2_5":"59","pm2_524":"48","iso2":"4","ino2":"26","ico":"10","io3":"6","io38":"8","ipm10":"58","ipm2_5":"80","aqi":"80","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 03:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"50","no224":"54","co":"0.900","co24":"0.910","o3":"15","o38":"14","o324":"15","pm10":"91","pm1024":"69","pm2_5":"57","pm2_524":"47","iso2":"4","ino2":"25","ico":"9","io3":"5","io38":"8","ipm10":"67","ipm2_5":"78","aqi":"78","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 02:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"52","no224":"53","co":"0.900","co24":"0.900","o3":"13","o38":"13","o324":"13","pm10":"94","pm1024":"68","pm2_5":"61","pm2_524":"46","iso2":"4","ino2":"26","ico":"9","io3":"5","io38":"7","ipm10":"68","ipm2_5":"82","aqi":"82","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 01:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"51","no224":"52","co":"0.890","co24":"0.890","o3":"17","o38":"20","o324":"40","pm10":"101","pm1024":"67","pm2_5":"64","pm2_524":"45","iso2":"4","ino2":"26","ico":"9","io3":"6","io38":"11","ipm10":"71","ipm2_5":"79","aqi":"79","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 00:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"53","no224":"51","co":"0.920","co24":"0.890","o3":"19","o38":"23","o324":"58","pm10":"103","pm1024":"66","pm2_5":"64","pm2_524":"45","iso2":"4","ino2":"27","ico":"10","io3":"7","io38":"12","ipm10":"72","ipm2_5":"87","aqi":"87","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-07 23:00:00","color":"#FFFF00"}],"day":[{"so2":"11","so224":"13","no2":"53","no224":"67","co":"0.937","co24":"1.092","o3":"18","o38":"15","o324":"19","pm10":"50","pm1024":"72","pm2_5":"43","pm2_524":"50","iso2":"4","ino2":"27","ico":"10","io3":"6","io38":"8","ipm10":"65","ipm2_5":"77","aqi":"77","primarypollutant":"PM2.5","quality":"良","date":"2015-12-10","color":"#FFFF00"},{"so2":"18","so224":"21","no2":"70","no224":"66","co":"1.123","co24":"1.003","o3":"11","o38":"13","o324":"53","pm10":"90","pm1024":"92","pm2_5":"60","pm2_524":"62","iso2":"6","ino2":"35","ico":"12","io3":"4","io38":"6","ipm10":"71","ipm2_5":"84","aqi":"84","primarypollutant":"PM2.5","quality":"良","date":"2015-12-09","color":"#FFFF00"},{"so2":"19","so224":"16","no2":"65","no224":"71","co":"1.224","co24":"1.527","o3":"32","o38":"29","o324":"45","pm10":"121","pm1024":"155","pm2_5":"82","pm2_524":"102","iso2":"7","ino2":"33","ico":"13","io3":"11","io38":"15","ipm10":"103","ipm2_5":"135","aqi":"135","primarypollutant":"PM2.5","quality":"轻度污染","date":"2015-12-08","color":"#FF7E00"},{"so2":"16","so224":"14","no2":"68","no224":"54","co":"1.377","co24":"1.187","o3":"24","o38":"23","o324":"35","pm10":"127","pm1024":"80","pm2_5":"87","pm2_524":"57","iso2":"6","ino2":"34","ico":"14","io3":"8","io38":"12","ipm10":"64","ipm2_5":"78","aqi":"78","primarypollutant":"PM2.5","quality":"良","date":"2015-12-07","color":"#FFFF00"},{"so2":"14","so224":"13","no2":"55","no224":"60","co":"1.069","co24":"0.963","o3":"18","o38":"17","o324":"27","pm10":"52","pm1024":"52","pm2_5":"41","pm2_524":"37","iso2":"5","ino2":"28","ico":"11","io3":"6","io38":"9","ipm10":"48","ipm2_5":"52","aqi":"52","primarypollutant":"PM2.5","quality":"良","date":"2015-12-06","color":"#FFFF00"},{"so2":"19","so224":"22","no2":"65","no224":"58","co":"0.846","co24":"0.728","o3":"15","o38":"15","o324":"48","pm10":"77","pm1024":"86","pm2_5":"44","pm2_524":"41","iso2":"7","ino2":"33","ico":"9","io3":"5","io38":"8","ipm10":"68","ipm2_5":"58","aqi":"68","primarypollutant":"PM10","quality":"良","date":"2015-12-05","color":"#FFFF00"},{"so2":"20","so224":"18","no2":"43","no224":"38","co":"0.613","co24":"0.599","o3":"35","o38":"38","o324":"70","pm10":"74","pm1024":"74","pm2_5":"32","pm2_524":"32","iso2":"7","ino2":"22","ico":"7","io3":"11","io38":"19","ipm10":"62","ipm2_5":"46","aqi":"62","primarypollutant":"PM10","quality":"良","date":"2015-12-04","color":"#FFFF00"},{"so2":"16","so224":"13","no2":"39","no224":"39","co":"0.714","co24":"0.868","o3":"42","o38":"43","o324":"54","pm10":"85","pm1024":"90","pm2_5":"38","pm2_524":"50","iso2":"6","ino2":"20","ico":"8","io3":"14","io38":"22","ipm10":"70","ipm2_5":"70","aqi":"70","primarypollutant":"PM10","quality":"良","date":"2015-12-03","color":"#FFFF00"},{"so2":"12","so224":"20","no2":"45","no224":"63","co":"1.066","co24":"1.230","o3":"25","o38":"22","o324":"43","pm10":"96","pm1024":"130","pm2_5":"62","pm2_524":"81","iso2":"4","ino2":"23","ico":"11","io3":"8","io38":"11","ipm10":"89","ipm2_5":"108","aqi":"108","primarypollutant":"PM2.5","quality":"轻度污染","date":"2015-12-02","color":"#FF7E00"},{"so2":"27","so224":"25","no2":"77","no224":"70","co":"1.264","co24":"1.289","o3":"21","o38":"26","o324":"33","pm10":"149","pm1024":"152","pm2_5":"93","pm2_524":"95","iso2":"9","ino2":"39","ico":"13","io3":"7","io38":"13","ipm10":"100","ipm2_5":"126","aqi":"126","primarypollutant":"PM2.5","quality":"轻度污染","date":"2015-12-01","color":"#FF7E00"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * cityid : 382
         * city : 杭州
         * hour : [{"so2":"11","so224":"10","no2":"49","no224":"56","co":"1.050","co24":"0.950","o3":"32","o38":"19","o324":"22","pm10":"104","pm1024":"85","pm2_5":"70","pm2_524":"59","iso2":"4","ino2":"25","ico":"11","io3":"11","io38":"10","ipm10":"73","ipm2_5":"94","aqi":"94","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 10:00:00","color":"#FFFF00"},{"so2":"11","so224":"9","no2":"47","no224":"56","co":"1.030","co24":"0.950","o3":"24","o38":"17","o324":"20","pm10":"101","pm1024":"83","pm2_5":"67","pm2_524":"58","iso2":"4","ino2":"24","ico":"11","io3":"8","io38":"9","ipm10":"71","ipm2_5":"91","aqi":"91","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 09:00:00","color":"#FFFF00"},{"so2":"11","so224":"10","no2":"47","no224":"56","co":"0.980","co24":"0.950","o3":"21","o38":"16","o324":"19","pm10":"96","pm1024":"81","pm2_5":"65","pm2_524":"56","iso2":"5","ino2":"24","ico":"10","io3":"7","io38":"8","ipm10":"73","ipm2_5":"87","aqi":"87","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 08:00:00","color":"#FFFF00"},{"so2":"11","so224":"9","no2":"47","no224":"56","co":"0.990","co24":"0.950","o3":"16","o38":"15","o324":"19","pm10":"95","pm1024":"79","pm2_5":"63","pm2_524":"55","iso2":"4","ino2":"24","ico":"10","io3":"6","io38":"8","ipm10":"72","ipm2_5":"86","aqi":"86","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 07:00:00","color":"#FFFF00"},{"so2":"11","so224":"9","no2":"46","no224":"55","co":"0.950","co24":"0.920","o3":"16","o38":"16","o324":"19","pm10":"92","pm1024":"77","pm2_5":"63","pm2_524":"53","iso2":"4","ino2":"23","ico":"10","io3":"6","io38":"8","ipm10":"71","ipm2_5":"85","aqi":"85","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 06:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"46","no224":"55","co":"0.920","co24":"0.920","o3":"16","o38":"15","o324":"18","pm10":"82","pm1024":"74","pm2_5":"63","pm2_524":"52","iso2":"4","ino2":"24","ico":"10","io3":"6","io38":"8","ipm10":"62","ipm2_5":"85","aqi":"85","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 05:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"50","no224":"55","co":"0.920","co24":"0.920","o3":"16","o38":"15","o324":"18","pm10":"82","pm1024":"72","pm2_5":"61","pm2_524":"50","iso2":"4","ino2":"25","ico":"10","io3":"6","io38":"8","ipm10":"59","ipm2_5":"83","aqi":"83","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 04:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"50","no224":"54","co":"0.930","co24":"0.910","o3":"16","o38":"15","o324":"17","pm10":"80","pm1024":"71","pm2_5":"59","pm2_524":"48","iso2":"4","ino2":"26","ico":"10","io3":"6","io38":"8","ipm10":"58","ipm2_5":"80","aqi":"80","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 03:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"50","no224":"54","co":"0.900","co24":"0.910","o3":"15","o38":"14","o324":"15","pm10":"91","pm1024":"69","pm2_5":"57","pm2_524":"47","iso2":"4","ino2":"25","ico":"9","io3":"5","io38":"8","ipm10":"67","ipm2_5":"78","aqi":"78","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 02:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"52","no224":"53","co":"0.900","co24":"0.900","o3":"13","o38":"13","o324":"13","pm10":"94","pm1024":"68","pm2_5":"61","pm2_524":"46","iso2":"4","ino2":"26","ico":"9","io3":"5","io38":"7","ipm10":"68","ipm2_5":"82","aqi":"82","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 01:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"51","no224":"52","co":"0.890","co24":"0.890","o3":"17","o38":"20","o324":"40","pm10":"101","pm1024":"67","pm2_5":"64","pm2_524":"45","iso2":"4","ino2":"26","ico":"9","io3":"6","io38":"11","ipm10":"71","ipm2_5":"79","aqi":"79","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-08 00:00:00","color":"#FFFF00"},{"so2":"10","so224":"9","no2":"53","no224":"51","co":"0.920","co24":"0.890","o3":"19","o38":"23","o324":"58","pm10":"103","pm1024":"66","pm2_5":"64","pm2_524":"45","iso2":"4","ino2":"27","ico":"10","io3":"7","io38":"12","ipm10":"72","ipm2_5":"87","aqi":"87","primarypollutant":"PM2.5","quality":"良","timepoint":"2017-04-07 23:00:00","color":"#FFFF00"}]
         * day : [{"so2":"11","so224":"13","no2":"53","no224":"67","co":"0.937","co24":"1.092","o3":"18","o38":"15","o324":"19","pm10":"50","pm1024":"72","pm2_5":"43","pm2_524":"50","iso2":"4","ino2":"27","ico":"10","io3":"6","io38":"8","ipm10":"65","ipm2_5":"77","aqi":"77","primarypollutant":"PM2.5","quality":"良","date":"2015-12-10","color":"#FFFF00"},{"so2":"18","so224":"21","no2":"70","no224":"66","co":"1.123","co24":"1.003","o3":"11","o38":"13","o324":"53","pm10":"90","pm1024":"92","pm2_5":"60","pm2_524":"62","iso2":"6","ino2":"35","ico":"12","io3":"4","io38":"6","ipm10":"71","ipm2_5":"84","aqi":"84","primarypollutant":"PM2.5","quality":"良","date":"2015-12-09","color":"#FFFF00"},{"so2":"19","so224":"16","no2":"65","no224":"71","co":"1.224","co24":"1.527","o3":"32","o38":"29","o324":"45","pm10":"121","pm1024":"155","pm2_5":"82","pm2_524":"102","iso2":"7","ino2":"33","ico":"13","io3":"11","io38":"15","ipm10":"103","ipm2_5":"135","aqi":"135","primarypollutant":"PM2.5","quality":"轻度污染","date":"2015-12-08","color":"#FF7E00"},{"so2":"16","so224":"14","no2":"68","no224":"54","co":"1.377","co24":"1.187","o3":"24","o38":"23","o324":"35","pm10":"127","pm1024":"80","pm2_5":"87","pm2_524":"57","iso2":"6","ino2":"34","ico":"14","io3":"8","io38":"12","ipm10":"64","ipm2_5":"78","aqi":"78","primarypollutant":"PM2.5","quality":"良","date":"2015-12-07","color":"#FFFF00"},{"so2":"14","so224":"13","no2":"55","no224":"60","co":"1.069","co24":"0.963","o3":"18","o38":"17","o324":"27","pm10":"52","pm1024":"52","pm2_5":"41","pm2_524":"37","iso2":"5","ino2":"28","ico":"11","io3":"6","io38":"9","ipm10":"48","ipm2_5":"52","aqi":"52","primarypollutant":"PM2.5","quality":"良","date":"2015-12-06","color":"#FFFF00"},{"so2":"19","so224":"22","no2":"65","no224":"58","co":"0.846","co24":"0.728","o3":"15","o38":"15","o324":"48","pm10":"77","pm1024":"86","pm2_5":"44","pm2_524":"41","iso2":"7","ino2":"33","ico":"9","io3":"5","io38":"8","ipm10":"68","ipm2_5":"58","aqi":"68","primarypollutant":"PM10","quality":"良","date":"2015-12-05","color":"#FFFF00"},{"so2":"20","so224":"18","no2":"43","no224":"38","co":"0.613","co24":"0.599","o3":"35","o38":"38","o324":"70","pm10":"74","pm1024":"74","pm2_5":"32","pm2_524":"32","iso2":"7","ino2":"22","ico":"7","io3":"11","io38":"19","ipm10":"62","ipm2_5":"46","aqi":"62","primarypollutant":"PM10","quality":"良","date":"2015-12-04","color":"#FFFF00"},{"so2":"16","so224":"13","no2":"39","no224":"39","co":"0.714","co24":"0.868","o3":"42","o38":"43","o324":"54","pm10":"85","pm1024":"90","pm2_5":"38","pm2_524":"50","iso2":"6","ino2":"20","ico":"8","io3":"14","io38":"22","ipm10":"70","ipm2_5":"70","aqi":"70","primarypollutant":"PM10","quality":"良","date":"2015-12-03","color":"#FFFF00"},{"so2":"12","so224":"20","no2":"45","no224":"63","co":"1.066","co24":"1.230","o3":"25","o38":"22","o324":"43","pm10":"96","pm1024":"130","pm2_5":"62","pm2_524":"81","iso2":"4","ino2":"23","ico":"11","io3":"8","io38":"11","ipm10":"89","ipm2_5":"108","aqi":"108","primarypollutant":"PM2.5","quality":"轻度污染","date":"2015-12-02","color":"#FF7E00"},{"so2":"27","so224":"25","no2":"77","no224":"70","co":"1.264","co24":"1.289","o3":"21","o38":"26","o324":"33","pm10":"149","pm1024":"152","pm2_5":"93","pm2_524":"95","iso2":"9","ino2":"39","ico":"13","io3":"7","io38":"13","ipm10":"100","ipm2_5":"126","aqi":"126","primarypollutant":"PM2.5","quality":"轻度污染","date":"2015-12-01","color":"#FF7E00"}]
         */

        private String cityid;
        private String city;
        private List<HourBean> hour;
        private List<DayBean> day;

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<HourBean> getHour() {
            return hour;
        }

        public void setHour(List<HourBean> hour) {
            this.hour = hour;
        }

        public List<DayBean> getDay() {
            return day;
        }

        public void setDay(List<DayBean> day) {
            this.day = day;
        }

        public static class HourBean {
            /**
             * so2 : 11
             * so224 : 10
             * no2 : 49
             * no224 : 56
             * co : 1.050
             * co24 : 0.950
             * o3 : 32
             * o38 : 19
             * o324 : 22
             * pm10 : 104
             * pm1024 : 85
             * pm2_5 : 70
             * pm2_524 : 59
             * iso2 : 4
             * ino2 : 25
             * ico : 11
             * io3 : 11
             * io38 : 10
             * ipm10 : 73
             * ipm2_5 : 94
             * aqi : 94
             * primarypollutant : PM2.5
             * quality : 良
             * timepoint : 2017-04-08 10:00:00
             * color : #FFFF00
             */

            private String so2;
            private String so224;
            private String no2;
            private String no224;
            private String co;
            private String co24;
            private String o3;
            private String o38;
            private String o324;
            private String pm10;
            private String pm1024;
            private String pm2_5;
            private String pm2_524;
            private String iso2;
            private String ino2;
            private String ico;
            private String io3;
            private String io38;
            private String ipm10;
            private String ipm2_5;
            private String aqi;
            private String primarypollutant;
            private String quality;
            private String timepoint;
            private String color;

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getSo224() {
                return so224;
            }

            public void setSo224(String so224) {
                this.so224 = so224;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getNo224() {
                return no224;
            }

            public void setNo224(String no224) {
                this.no224 = no224;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getCo24() {
                return co24;
            }

            public void setCo24(String co24) {
                this.co24 = co24;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getO38() {
                return o38;
            }

            public void setO38(String o38) {
                this.o38 = o38;
            }

            public String getO324() {
                return o324;
            }

            public void setO324(String o324) {
                this.o324 = o324;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm1024() {
                return pm1024;
            }

            public void setPm1024(String pm1024) {
                this.pm1024 = pm1024;
            }

            public String getPm2_5() {
                return pm2_5;
            }

            public void setPm2_5(String pm2_5) {
                this.pm2_5 = pm2_5;
            }

            public String getPm2_524() {
                return pm2_524;
            }

            public void setPm2_524(String pm2_524) {
                this.pm2_524 = pm2_524;
            }

            public String getIso2() {
                return iso2;
            }

            public void setIso2(String iso2) {
                this.iso2 = iso2;
            }

            public String getIno2() {
                return ino2;
            }

            public void setIno2(String ino2) {
                this.ino2 = ino2;
            }

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }

            public String getIo3() {
                return io3;
            }

            public void setIo3(String io3) {
                this.io3 = io3;
            }

            public String getIo38() {
                return io38;
            }

            public void setIo38(String io38) {
                this.io38 = io38;
            }

            public String getIpm10() {
                return ipm10;
            }

            public void setIpm10(String ipm10) {
                this.ipm10 = ipm10;
            }

            public String getIpm2_5() {
                return ipm2_5;
            }

            public void setIpm2_5(String ipm2_5) {
                this.ipm2_5 = ipm2_5;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getPrimarypollutant() {
                return primarypollutant;
            }

            public void setPrimarypollutant(String primarypollutant) {
                this.primarypollutant = primarypollutant;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getTimepoint() {
                return timepoint;
            }

            public void setTimepoint(String timepoint) {
                this.timepoint = timepoint;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }
        }

        public static class DayBean {
            /**
             * so2 : 11
             * so224 : 13
             * no2 : 53
             * no224 : 67
             * co : 0.937
             * co24 : 1.092
             * o3 : 18
             * o38 : 15
             * o324 : 19
             * pm10 : 50
             * pm1024 : 72
             * pm2_5 : 43
             * pm2_524 : 50
             * iso2 : 4
             * ino2 : 27
             * ico : 10
             * io3 : 6
             * io38 : 8
             * ipm10 : 65
             * ipm2_5 : 77
             * aqi : 77
             * primarypollutant : PM2.5
             * quality : 良
             * date : 2015-12-10
             * color : #FFFF00
             */

            private String so2;
            private String so224;
            private String no2;
            private String no224;
            private String co;
            private String co24;
            private String o3;
            private String o38;
            private String o324;
            private String pm10;
            private String pm1024;
            private String pm2_5;
            private String pm2_524;
            private String iso2;
            private String ino2;
            private String ico;
            private String io3;
            private String io38;
            private String ipm10;
            private String ipm2_5;
            private String aqi;
            private String primarypollutant;
            private String quality;
            private String date;
            private String color;

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getSo224() {
                return so224;
            }

            public void setSo224(String so224) {
                this.so224 = so224;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getNo224() {
                return no224;
            }

            public void setNo224(String no224) {
                this.no224 = no224;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getCo24() {
                return co24;
            }

            public void setCo24(String co24) {
                this.co24 = co24;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getO38() {
                return o38;
            }

            public void setO38(String o38) {
                this.o38 = o38;
            }

            public String getO324() {
                return o324;
            }

            public void setO324(String o324) {
                this.o324 = o324;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm1024() {
                return pm1024;
            }

            public void setPm1024(String pm1024) {
                this.pm1024 = pm1024;
            }

            public String getPm2_5() {
                return pm2_5;
            }

            public void setPm2_5(String pm2_5) {
                this.pm2_5 = pm2_5;
            }

            public String getPm2_524() {
                return pm2_524;
            }

            public void setPm2_524(String pm2_524) {
                this.pm2_524 = pm2_524;
            }

            public String getIso2() {
                return iso2;
            }

            public void setIso2(String iso2) {
                this.iso2 = iso2;
            }

            public String getIno2() {
                return ino2;
            }

            public void setIno2(String ino2) {
                this.ino2 = ino2;
            }

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }

            public String getIo3() {
                return io3;
            }

            public void setIo3(String io3) {
                this.io3 = io3;
            }

            public String getIo38() {
                return io38;
            }

            public void setIo38(String io38) {
                this.io38 = io38;
            }

            public String getIpm10() {
                return ipm10;
            }

            public void setIpm10(String ipm10) {
                this.ipm10 = ipm10;
            }

            public String getIpm2_5() {
                return ipm2_5;
            }

            public void setIpm2_5(String ipm2_5) {
                this.ipm2_5 = ipm2_5;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getPrimarypollutant() {
                return primarypollutant;
            }

            public void setPrimarypollutant(String primarypollutant) {
                this.primarypollutant = primarypollutant;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }
        }
    }
}
