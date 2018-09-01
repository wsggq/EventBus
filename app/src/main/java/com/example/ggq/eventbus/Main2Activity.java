package com.example.ggq.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    @BindView(R.id.btn_back)
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        //EventBus.getDefault().register(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("欢迎回家!"));
        finish();
    }
    /*@Subscribe(sticky = true)
    public void Enn(MessageEvent messageEvent) {
        Log.d(TAG, "receiveMessage: "+Thread.currentThread().getName());
        Log.d(TAG, "receiveMessage: "+messageEvent.getMessage());
    }*/
}
