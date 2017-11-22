package com.happy.wcqlibrary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wangchangqin on 2017/8/27.
 */

public class CommonFragmentPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private  List<String> mFragmentTitle;
    public CommonFragmentPageAdapter(FragmentManager fm, List<Fragment> list,List<String> fragmentTitle) {
        super(fm);
        mFragmentList = list;
        mFragmentTitle = fragmentTitle;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
