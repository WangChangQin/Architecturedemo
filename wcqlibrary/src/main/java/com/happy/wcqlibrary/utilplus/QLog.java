package com.happy.wcqlibrary.utilplus;

import android.util.Log;

/**
 * Created by ChangQin on 2017/8/18 0018.
 */

public class QLog {
    private static  boolean debug  = true;

    public static void v(String msg) {
        if (debug){
            Log.v("aaaaa",msg);
        }
    }
    public static void d(String msg) {
        if (debug){
            Log.d("aaaaa",msg);
        }
    }
    public static void i(String msg) {
        if (debug){
            Log.i("aaaaa",msg);
        }
    }
    public static void w(String msg) {
        if (debug){
            Log.w("aaaaa",msg);
        }
    }
    public static void e(String msg) {
        if (debug){
            Log.e("aaaaa",msg);
        }
    }
    public static void e(Object o) {
        if (debug){
            Log.e("aaaaa",o.toString());
            Log.e("aaaaa",o.toString());
        }
    }
}
