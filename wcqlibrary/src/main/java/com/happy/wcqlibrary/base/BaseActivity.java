package com.happy.wcqlibrary.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.wcqlibrary.R;
import com.happy.wcqlibrary.utilplus.QLog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ChangQin on 2017/8/2 0002.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    private ImageView mLeftIv,mRightIv;
    private TextView mLeftTv;

    protected abstract int getLayoutId();
    protected abstract void initData();
    protected abstract void initView();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);

        //initStateBar();
        initData();
        initView();

        initToolbar();
    }

    private void initToolbar() {
        mLeftIv = (ImageView) findViewById(R.id.left_iv);
        mRightIv = (ImageView) findViewById(R.id.right_iv);
        mLeftTv = (TextView) findViewById(R.id.left_tv);

        if (mLeftIv!=null){
            mLeftIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    private void initStateBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
    protected void baseError(Throwable e) {
        e.printStackTrace();
        QLog.e(e.getMessage());
    }
}
