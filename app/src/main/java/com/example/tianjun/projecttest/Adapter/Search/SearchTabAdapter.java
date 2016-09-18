package com.example.tianjun.projecttest.Adapter.Search;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.tianjun.projecttest.CustomerView.RefreshFragment;

import java.util.List;

/**
 * Created by xx on 2016/9/18.
 */
public class SearchTabAdapter extends FragmentStatePagerAdapter{
    private final List<RefreshFragment> mFragmentList;
    private final List<String> mTitleList;

    public SearchTabAdapter(FragmentManager fm, List<RefreshFragment> fragmentList,List<String> titleList) {
        super(fm);
        mFragmentList = fragmentList;
        mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
