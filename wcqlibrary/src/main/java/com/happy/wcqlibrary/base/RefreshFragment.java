package com.happy.wcqlibrary.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.happy.wcqlibrary.R;
import com.happy.wcqlibrary.adapter.drakeet.Items;
import com.happy.wcqlibrary.adapter.drakeet.MultiTypeAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by wangchangqin on 2017/8/27.
 */

public abstract class RefreshFragment extends BaseFragment implements OnRefreshListener, OnLoadmoreListener {
    // 请求状态 - 下拉刷新 还是 加载更多
    public static final String POST_LOAD_MORE = "load_more";
    public static final String POST_REFRESH = "refresh";

    // 当前状态
    private static final int STATE_NORMAL = 0;      // 正常
    private static final int STATE_NO_MORE = 1;     // 正在
    private static final int STATE_LOADING = 2;     // 加载
    private static final int STATE_REFRESH = 3;     // 刷新
    private int mState = STATE_NORMAL;

    // 分页加载
    protected int mPageIndex = 0;                      // 当面页码
    protected int mPgeCount = 10;                     // 每页个数

    //findview
    RecyclerView mRecyclerView;

    RefreshLayout mRefreshLayout;
    private MultiTypeAdapter mAdapter;
    private Items mDataList;
    // 状态
    private boolean refreshEnable = true;           // 是否允许刷新
    private boolean loadMoreEnable = true;          // 是否允许加载


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_refresh_recycler;
    }

    @Override
    protected void initData() {
        mDataList = new Items();
    }

    @Override
    protected void initView() {
        initRecyclerView();

    }
    private void initRecyclerView() {
        mAdapter = new MultiTypeAdapter(mDataList);
        mRecyclerView.setLayoutManager(getRecyclerViewLayoutManager());
        registerAdapter(mContext,mRecyclerView,mAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }
    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        if (!refreshEnable)return;
        mPageIndex = 0;
        request(mPageIndex*mPgeCount,mPgeCount);
        mState = STATE_REFRESH;
    }
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        if (!loadMoreEnable)return;
        request(mPageIndex*mPgeCount,mPgeCount);
        mState = STATE_LOADING;
    }
    public void setRefreshEnable(boolean refreshEnable) {
        this.refreshEnable = refreshEnable;
        mRefreshLayout.setEnableRefresh(refreshEnable);
    }

    public void setLoadMoreEnable(boolean loadMoreEnable) {
        this.loadMoreEnable = loadMoreEnable;
        mRefreshLayout.setEnableLoadmore(loadMoreEnable);
    }
    public void quickToTop() {
        mRecyclerView.smoothScrollToPosition(0);
    }


    /**对外方法*/
    protected abstract RecyclerView.LayoutManager getRecyclerViewLayoutManager();
    protected abstract void registerAdapter(Context context, RecyclerView recyclerView,MultiTypeAdapter adapter);
    protected abstract void request(int offset,int limit);

}
