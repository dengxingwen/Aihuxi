package com.example.ccmark.bean;


import java.util.List;

/**
 * Created by ccmark on 2017/3/10.
 */

public class AirBody {
    private int ret_code;
    private List<Air> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public List<Air> getList() {
        return list;
    }

    public void setList(List<Air> list) {
        this.list = list;
    }
}
