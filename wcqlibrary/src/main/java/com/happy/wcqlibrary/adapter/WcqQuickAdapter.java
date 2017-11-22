package com.happy.wcqlibrary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ChangQin on 2017/7/26 0026.
 */

public abstract class WcqQuickAdapter<T> extends RecyclerView.Adapter<WcqViewHolder>{
    List<T>mDatas;

    public WcqQuickAdapter(List<T> datas) {
        mDatas = datas;
    }

    protected abstract int getLayoutId();
    protected abstract void bindView(WcqViewHolder holder,T t, int position);
    @Override
    public WcqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WcqViewHolder.get(parent,getLayoutId());
    }

    @Override
    public void onBindViewHolder(WcqViewHolder holder, int position) {
        bindView(holder,mDatas.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void clear(){
        mDatas.clear();
    }
}
