package com.happy.wcqlibrary.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ChangQin on 2017/7/26 0026.
 */

public abstract class WcqQuickBaseAdapter<T> extends BaseAdapter{
    private List<T>mDatas;
    private SparseArray<View>mViews = new SparseArray<>();
    private int mLayoutId;
    private Context mContext;
    private View mRootView;
    public WcqQuickBaseAdapter(List<T> datas,Context context) {
        this.mDatas = datas;
        this.mContext = context;
        this.mLayoutId = getLayoutId();
    }

    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId,parent,false);
        }
        mRootView = convertView;
        bindView(mDatas.get(position));
        return mRootView;
    }
    protected <V extends View> V getView(int viewId){
        View view = mViews.get(viewId);
        if (view==null){
            view =  mRootView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (V) view;
    }

    protected abstract void bindView(T t);

    protected abstract int getLayoutId();
}
