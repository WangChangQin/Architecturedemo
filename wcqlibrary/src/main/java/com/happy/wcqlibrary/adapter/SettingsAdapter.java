package com.happy.wcqlibrary.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.happy.wcqlibrary.R;
import com.happy.wcqlibrary.bean.SettingTemplate;
import com.happy.wcqlibrary.bean.SettingType;

import java.util.List;

/**
 * Created by ChangQin on 2017/8/19 0019.
 */

public class SettingsAdapter extends BaseAdapter {
    protected List<SettingTemplate> items;
    protected Context context;
    private int layoutId;
    protected int itemHeight;
    private CheckBox.OnCheckedChangeListener onchangeListener;
    private SwitchChangeListener switchChangeListener;

    public interface SwitchChangeListener {
        void onSwitchChange(SettingTemplate item, boolean checkState);
    }
    public SettingsAdapter(Context context, SwitchChangeListener switchChangeListener, List<SettingTemplate> items) {
        this(context, switchChangeListener, items, R.layout.setting_item);
    }

    public SettingsAdapter(Context context, SwitchChangeListener switchChangeListener, List<SettingTemplate> items, int layoutID) {
        this.context = context;
        this.switchChangeListener = switchChangeListener;
        this.items = items;
        this.layoutId = layoutID;
        itemHeight = context.getResources().getDimensionPixelSize(R.dimen.isetting_item_height);
    }

    @Override
    public int getCount() {
        return items==null?0:items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert viewHolder != null;
        hideAllItem(viewHolder);
        final SettingTemplate s = items.get(position);
        switch (s.getType()){
            case SettingType.TYPE_DEFAULE:
                handleDefault(viewHolder,s,position);
                break;
            case SettingType.TYPE_HEAD:
                break;
            case SettingType.TYPE_LINE:
                handleLine(viewHolder,s,position);
                break;
            case SettingType.TYPE_SEPERATOR:
                handleSeperator(viewHolder,s,position);
                break;
            case SettingType.TYPE_TOGGLE:
                handleToggle(viewHolder,s,position);
                break;
        }
        //initCheckListener
        if (viewHolder.cbk.getVisibility()!=View.GONE){
            viewHolder.cbk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (switchChangeListener!=null){
                        switchChangeListener.onSwitchChange(s,isChecked);
                    }
                }
            });
        }
        return convertView;
    }

    private void handleLine(ViewHolder viewHolder, SettingTemplate s, int position) {
        viewHolder.container.setVisibility(View.GONE);
        viewHolder.line.setVisibility(View.VISIBLE);
    }

    private void handleSeperator(ViewHolder viewHolder, SettingTemplate s, int position) {
        ViewGroup.LayoutParams lp = viewHolder.root.getLayoutParams();
        if (lp!=null){
            lp.height = 50;
            viewHolder.root.setLayoutParams(lp);
            viewHolder.root.setBackgroundColor(Color.TRANSPARENT);
        }
        viewHolder.blank.setVisibility(View.VISIBLE);
    }

    private void handleToggle(ViewHolder viewHolder, SettingTemplate s, int position) {
        ViewGroup.LayoutParams lp = viewHolder.root.getLayoutParams();
        if(lp != null) {
            lp.height = itemHeight;
            viewHolder.root.setLayoutParams(lp);
        }
        viewHolder.iv_left_icon.setVisibility(View.VISIBLE);
        viewHolder.tv_left.setVisibility(View.VISIBLE);
        viewHolder.cbk.setVisibility(View.VISIBLE);

        viewHolder.iv_left_icon.setImageResource(s.getIcon());
        viewHolder.tv_left.setText(s.getTitle());

    }

    private void handleDefault(ViewHolder viewHolder, SettingTemplate s, int position) {
        ViewGroup.LayoutParams lp = viewHolder.root.getLayoutParams();
        if(lp != null) {
            lp.height = itemHeight;
            viewHolder.root.setLayoutParams(lp);
        }
        viewHolder.iv_left_icon.setVisibility(View.VISIBLE);
        viewHolder.tv_left.setVisibility(View.VISIBLE);
        viewHolder.iv_right_icon.setVisibility(View.VISIBLE);

        viewHolder.iv_left_icon.setImageResource(s.getIcon());
        viewHolder.tv_left.setText(s.getTitle());
    }

    private void hideAllItem(ViewHolder viewHolder) {
        viewHolder.cbk.setVisibility(View.GONE);
        viewHolder.iv_left_icon.setVisibility(View.GONE);
        viewHolder.iv_right_icon.setVisibility(View.GONE);
        viewHolder.tv_left.setVisibility(View.GONE);
        viewHolder.tv_right.setVisibility(View.GONE);
        viewHolder.line.setVisibility(View.GONE);
        viewHolder.blank.setVisibility(View.GONE);
    }

    private static class ViewHolder{
        TextView tv_left,tv_right;
        ImageView iv_left_icon,iv_right_icon;
        CheckBox cbk;
        View line,blank,root,container;
        public ViewHolder(View v) {
            root= v;
            tv_left = (TextView) v.findViewById(R.id.left_text);
            tv_right = (TextView) v.findViewById(R.id.right_text);
            iv_left_icon = (ImageView) v.findViewById(R.id.left_icon);
            iv_right_icon = (ImageView) v.findViewById(R.id.right_icon);
            cbk = (CheckBox) v.findViewById(R.id.checkbox);
            line = v.findViewById(R.id.line);
            blank = v.findViewById(R.id.blank);
            container =v.findViewById(R.id.container);
        }
    }
}
