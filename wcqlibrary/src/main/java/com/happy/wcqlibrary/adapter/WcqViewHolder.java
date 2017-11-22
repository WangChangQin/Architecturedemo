package com.happy.wcqlibrary.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ChangQin on 2017/7/26 0026.
 */

public class WcqViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> mViews;
    private View mContentView;
    public WcqViewHolder(View itemView) {
        super(itemView);
        mContentView = itemView;
        mViews = new SparseArray<>();
    }
    public static WcqViewHolder get(ViewGroup parent,int layoutId){
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new WcqViewHolder(view);
    }
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view==null){
            view = mContentView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }
    public void setText(int viewId,String text){
        TextView tv =  getView(viewId);
        tv.setText(text);
    }
}
