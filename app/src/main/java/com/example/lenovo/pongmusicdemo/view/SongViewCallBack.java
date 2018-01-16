package com.example.lenovo.pongmusicdemo.view;


import com.example.lenovo.pongmusicdemo.bean.SearchBean;

public interface SongViewCallBack {
    public void success(SearchBean songBean);
    public void failure();
}
