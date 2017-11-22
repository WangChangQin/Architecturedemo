package com.changqin.architecturedemo.app;

import android.app.Application;
import android.content.Context;

import com.happy.wcqlibrary.utilplus.Utils;

/**
 * Created by wangchangqin on 2017/11/22.
 */

public class App extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Utils.init(this);
    }
}
