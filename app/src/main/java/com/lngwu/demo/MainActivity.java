package com.lngwu.demo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginContract.View {
    private Context mContext;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(mContext, "其他信息", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mLoginPresenter = new LoginPresenter(this);

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.login(mContext);
            }
        });
    }

    @Override
    public void loginSuccess() {
        mHandler.sendEmptyMessage(1);
    }

    @Override
    public void loginFailed(String errorMessage) {
        mHandler.sendEmptyMessage(0);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }
}
