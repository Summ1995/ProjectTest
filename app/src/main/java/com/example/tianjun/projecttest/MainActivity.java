package com.example.tianjun.projecttest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.tianjun.projecttest.Adapter.MainPagerAdapter;
import com.example.tianjun.projecttest.CustomerView.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> mFragmentList;
    private ViewPager mMainPager;
    private RadioGroup mMainSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        loadData();
        initView();
    }

    private void loadData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(OtherFragment.newInstance("首页"));
        mFragmentList.add(OtherFragment.newInstance("单品"));
        mFragmentList.add(OtherFragment.newInstance("晒吧"));
        mFragmentList.add(OtherFragment.newInstance("我"));
    }

    private void initView() {
        mMainPager = (ViewPager) findViewById(R.id.main_pager);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),mFragmentList);
        mMainPager.setAdapter(mainPagerAdapter);
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.main_bottom_selector_home:
                mMainPager.setCurrentItem(0);
                break;
            case R.id.main_bottom_selector_goods:
                mMainPager.setCurrentItem(1);
                break;
            case R.id.main_bottom_selector_show:
                mMainPager.setCurrentItem(2);
                break;
            case R.id.main_bottom_selector_mine:
                mMainPager.setCurrentItem(3);
                break;
            case R.id.main_bottom_selector_customer_show:
                break;
        }
    }
}
