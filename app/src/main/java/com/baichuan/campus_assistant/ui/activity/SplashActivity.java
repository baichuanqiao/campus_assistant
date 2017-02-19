package com.baichuan.campus_assistant.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.baichuan.campus_assistant.R;

import cn.bmob.v3.BmobUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

//		// 使用推送服务时的初始化操作
//		BmobInstallation.getCurrentInstallation(this).save();
//		// 启动推送服务
//		BmobPush.startWork(this, APPID);
        //一个延时跳转效果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirstRun();
                SplashActivity.this.finish();
            }
        }, 1000);
    }

    public void isFirstRun() {

        //获取本地磁盘缓存的用户信息
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            // 允许用户使用应用
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            //缓存用户对象为空时， 可打开用户登录注册界面…
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
    }


}
