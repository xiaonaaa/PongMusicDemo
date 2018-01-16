package com.example.lenovo.pongmusicdemo.presenter;

import com.example.lenovo.pongmusicdemo.bean.SearchBean;
import com.example.lenovo.pongmusicdemo.model.SongModel;
import com.example.lenovo.pongmusicdemo.model.SongModelCallBack;
import com.example.lenovo.pongmusicdemo.view.SongViewCallBack;

public class SongPresenter{
    SongModel songModel;

    SongViewCallBack songViewCallBack;
    public SongPresenter(SongViewCallBack songViewCallBack) {
        this.songViewCallBack = songViewCallBack;
        songModel = new SongModel();
    }

    public void getSong(String type){
     songModel.getSong(type,new SongModelCallBack() {
         @Override
         public void success(SearchBean searchBean) {
             System.out.println(searchBean);
             songViewCallBack.success(searchBean);
         }

         @Override
         public void failure() {
             songViewCallBack.failure();
         }
     });
    }
}
