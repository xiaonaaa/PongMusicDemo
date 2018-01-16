package com.example.lenovo.pongmusicdemo.model;


import com.example.lenovo.pongmusicdemo.bean.SearchBean;
import com.example.lenovo.pongmusicdemo.commen.APIFactory;
import com.example.lenovo.pongmusicdemo.commen.AbstractObserver;;

import java.util.HashMap;
import java.util.Map;


public class SongModel {

    /*
      http://tingapi.ting.baidu.com
    /v1/restserver/ting?method=bai-du.ting.billboard.billList&format=json&type=23&size=15&offset=0&qq-pf-to=pcqq.group
   */
    public void getSong(String type, final SongModelCallBack songModelCallBack){
        String url = "/v1/restserver/ting";
        Map<String,String> map = new HashMap<>();
        map.put("method","bai-du.ting.billboard.billList");
        map.put("format","json");
        map.put("type",type);
        map.put("size","15");
        map.put("offset","0");
        map.put("qq-pf-to","pcqq.group");

        APIFactory.getInstance().get(url, map, new AbstractObserver<SearchBean>() {


            @Override
            public void onSuccess(SearchBean searchBean) {
                songModelCallBack.success(searchBean);
            }

            @Override
            public void onFailure(int code) {
                songModelCallBack.failure();
            }
        });
    }

}
