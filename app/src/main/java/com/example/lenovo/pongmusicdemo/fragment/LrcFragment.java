package com.example.lenovo.pongmusicdemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.pongmusicdemo.R;
import com.example.lenovo.pongmusicdemo.bean.Lrc;
import com.example.lenovo.pongmusicdemo.bean.LrcBean;
import com.example.lenovo.pongmusicdemo.commen.APIFactory;
import com.example.lenovo.pongmusicdemo.commen.AbstractObserver;
import com.example.lenovo.pongmusicdemo.lrcview.LrcView;
import com.example.lenovo.pongmusicdemo.service.MyService;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/1/2.
 */

public class LrcFragment extends Fragment {
    public static LrcView lrcView;
    Unbinder unbinder;
    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                //接收myservice类传来的消息
                long time = (long) msg.obj;
                lrcView.updateTime(time);
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lrc, container, false);
        lrcView = (LrcView) view.findViewById(R.id.lrc_view);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);

        lrcView.setOnPlayClickListener(new LrcView.OnPlayClickListener() {
            @Override
            public boolean onPlayClick(long time) {
                Message message = new Message();
                message.obj = (int)time;
                message.what=2;
                MyService.handler.sendMessage(message);
                return true;
            }
        });
    }

    //http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.song.lry&songid=877578
    @Subscribe(sticky = true)
    public void getLrc(Lrc lrc){
        Map<String,String> map = new HashMap<>();
        map.put("method","baidu.ting.song.lry");
        map.put("songid",lrc.getSongid());
        APIFactory.getInstance().get("/v1/restserver/ting", map, new AbstractObserver<LrcBean>() {
            @Override
            public void onSuccess(LrcBean lrcBean) {
                if(lrcBean!=null) {
                    lrcView.loadLrc(lrcBean.getLrcContent());
                }
            }

            @Override
            public void onFailure(int code) {
                System.out.println("网慢");
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
