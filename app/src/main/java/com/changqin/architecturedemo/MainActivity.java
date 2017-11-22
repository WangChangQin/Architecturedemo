package com.changqin.architecturedemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.changqin.architecturedemo.bean.Student;
import com.changqin.architecturedemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  TextView studentName;
    List<String> girls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Student student = new Student("1","qqq","happy-school");
        binding.setStudent(student);
        girls = new ArrayList<>();
        girls.add("girl-0");
        girls.add("girl-1");
        girls.add("girl-2");
        binding.setHandler(new MyHandler());
        binding.setGirlList(girls);
        Log.e("qqq", String.valueOf(studentName == null));
    }
}
