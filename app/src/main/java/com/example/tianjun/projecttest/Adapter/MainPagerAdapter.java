package com.example.tianjun.projecttest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xx on 2016/9/5.
 */
public class MainPagerAdapter extends FragmentPagerAdapter{
    private final List<Fragment> mFragmentList;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> FragmentList) {
        super(fm);
        mFragmentList = FragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }
}
