package com.example.ccmark.bean;

import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

/**
 * Created by ccmark on 2017/3/10.
 */

public class AirAll {

   private int showapi_res_code;
   private String showapi_res_error;
   private AirBody showapi_res_body;

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

   public AirBody getShowapi_res_body() {
      return showapi_res_body;
   }

   public void setShowapi_res_body(AirBody showapi_res_body) {
      this.showapi_res_body = showapi_res_body;
   }
}
