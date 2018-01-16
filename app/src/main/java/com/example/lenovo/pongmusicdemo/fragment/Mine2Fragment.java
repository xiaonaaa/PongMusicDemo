package com.example.lenovo.pongmusicdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.pongmusicdemo.R;
import com.example.lenovo.pongmusicdemo.ScanMusic;
import com.example.lenovo.pongmusicdemo.activity.PlayerActivity;
import com.example.lenovo.pongmusicdemo.adpter.MineAdapter;
import com.example.lenovo.pongmusicdemo.applaction.App;
import com.example.lenovo.pongmusicdemo.bean.Model;
import com.example.lenovo.pongmusicdemo.bean.Titlebean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Mine2Fragment extends Fragment {

    @BindView(R.id.listvieww)
    ListView listvieww;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine2, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ScanMusic scanMusic = new ScanMusic();
        final List<Model> lists = scanMusic.query(getActivity());
        Log.i("---本地---",lists.size()+"");
        App.list_scan.addAll(lists);

        MineAdapter mineAdapter = new MineAdapter(lists,getActivity());

        if(lists.size()!=0){
            listvieww.setAdapter(mineAdapter);
        }


        listvieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //点击条目 传值eventbus
                EventBus.getDefault().postSticky(new Titlebean(lists.get(i).getText_song(),lists.get(i).getText_singer(),null));
                EventBus.getDefault().postSticky(lists.get(i));
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                intent.putExtra("flag",1);//传1 ,,是从本地音乐发送
                intent.putExtra("model",lists.get(i));
                startActivity(intent);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
