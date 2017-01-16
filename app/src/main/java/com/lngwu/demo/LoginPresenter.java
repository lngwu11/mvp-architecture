package com.lngwu.demo;

import android.content.Context;
import android.graphics.Color;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;

/**
 * Created by Administrator on 2017/1/7.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
        view.setPresenter(this);
    }

    @Override
    public void login(Context context) {
        final ACProgressFlower progressFlower = new ACProgressFlower.Builder(context)
                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                .themeColor(Color.WHITE)
                .fadeColor(Color.GRAY)
                .text("正在登录...")
                .build();
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
                mView.loginSuccess();
                progressFlower.cancel();
            }
        }).start();
    }

    @Override
    public void start() {

    }

}
