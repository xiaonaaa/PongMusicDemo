package com.example.lenovo.pongmusicdemo.model;


import com.example.lenovo.pongmusicdemo.bean.SearchBean;

public interface SongModelCallBack {
    public void success(SearchBean searchBean);
    public void failure();

}
