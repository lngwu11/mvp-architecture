package com.lngwu.demo.mvp;

import android.content.Context;

/**
 * Created by Administrator on 2017/1/7.
 * 登录契约类
 */

public interface LoginContract {
    interface Presenter extends BasePresenter {
        /**
         * 登录
         */
        void login(Context context);
    }
    interface View extends BaseView<Presenter> {
        /**
         * 返回登录结果
         */
        void loginSuccess();
        void loginFailed(String errorMessage);
    }
}
