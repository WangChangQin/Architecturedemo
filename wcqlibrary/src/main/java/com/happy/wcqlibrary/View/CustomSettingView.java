package com.happy.wcqlibrary.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.wcqlibrary.R;

/**
 * Created by ChangQin on 2017/8/20 0020.
 */

public class CustomSettingView{
    View mView;
    TextView tv_left,tv_right;
    ImageView iv_left_icon,iv_right_icon;
    CheckBox cbk;
    View line;

    /***
     * 默认显示左侧文字,icon，和右侧icon
     * @param parent
     */
    public CustomSettingView(ViewGroup parent) {
        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_item, parent, false);
        tv_left = (TextView) mView.findViewById(R.id.left_text);
        tv_right = (TextView) mView.findViewById(R.id.right_text);
        iv_left_icon = (ImageView) mView.findViewById(R.id.left_icon);
        iv_right_icon = (ImageView) mView.findViewById(R.id.right_icon);
        cbk = (CheckBox) mView.findViewById(R.id.checkbox);
        line = mView.findViewById(R.id.line);
    }
    public CustomSettingView height(int height){
        ViewGroup.LayoutParams lp = mView.getLayoutParams();
        lp.height = height;
        return this;
    }
    public CustomSettingView leftIcon(int resId){
        iv_left_icon.setImageResource(resId);
        return this;
    }
    public CustomSettingView rightIcon(int resId){
        iv_right_icon.setImageResource(resId);
        return this;
    }
    public CustomSettingView leftText(String text){
        tv_left.setText(text);
        return this;
    }
    public CustomSettingView rightText(String text){
        tv_right.setText(text);
        return this;
    }
    public CustomSettingView hideLine(){
        line.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideCbk(){
        cbk.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideLeftAll(){
        iv_left_icon.setVisibility(View.GONE);
        tv_left.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideLeftTv(){
        tv_left.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideLeftIv(){
        iv_left_icon.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideRightAll(){
        iv_right_icon.setVisibility(View.GONE);
        tv_right.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideRightTv(){
        tv_right.setVisibility(View.GONE);
        return this;
    }
    public CustomSettingView hideRightIv(){
        iv_right_icon.setVisibility(View.GONE);
        return this;
    }
    public void setRightText(String msg){
        rightText(msg);
    }
    public View build(){
        return mView;
    }

    public CustomSettingView bindClick(View.OnClickListener listener){
        mView.setOnClickListener(listener);
        return this;
    }

}
