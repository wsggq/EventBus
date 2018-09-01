package com.example.ggq.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_tiao)
    Button btnTiao;
    @BindView(R.id.tv_today)
    TextView tvToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.btn_tiao)
    public void onViewClicked() {
        //EventBus.getDefault().postSticky(new MessageEvent("北京欢迎你!"));
        startActivity(new Intent(this,Main2Activity.class));
    }
    @Subscribe
    public void Event(MessageEvent messageEvent){
        tvToday.setText(messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
