package com.example.lenovo.pongmusicdemo.applaction;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.lenovo.pongmusicdemo.bean.Model;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menglucywhh on 2017/12/29.
 */

public class App extends Application{
    public static int xunhuan=1;
    public static List<Model> list_scan=new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
