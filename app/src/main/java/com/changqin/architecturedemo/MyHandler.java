package com.changqin.architecturedemo;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.changqin.architecturedemo.bean.Student;

/**
 * Created by wangchangqin on 2017/11/1.
 */

public class MyHandler {
    public void onClickStudent(Student student){
        //Toast.makeText(v.getContext(), "123123123", Toast.LENGTH_SHORT).show();
        Log.e("qqq",student.getName());
        student.setName("wcq");
    }
    public void onClickStudentName(View v,Student student){
        Toast.makeText(v.getContext(), student.getName(), Toast.LENGTH_SHORT).show();
    }
}
