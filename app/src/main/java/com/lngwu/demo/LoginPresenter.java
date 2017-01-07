package com.lngwu.demo;

import android.content.Context;
import android.graphics.Color;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

/**
 * Created by Administrator on 2017/1/7.
 */

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void login(Context context) {
        ACProgressFlower.Builder builder = new ACProgressFlower.Builder(context);
        builder.direction(ACProgressConstant.DIRECT_CLOCKWISE);
        builder.themeColor(Color.WHITE);
        builder.fadeColor(Color.GRAY);
        builder.text("正在登录...");
        final ACProgressFlower progressFlower = builder.build();
        progressFlower.show();

        // 模拟登录耗时
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.loginSuccess();
                progressFlower.cancel();
            }
        }).start();
    }

    @Override
    public void start() {

    }

}
