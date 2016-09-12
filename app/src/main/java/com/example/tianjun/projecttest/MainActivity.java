package com.example.tianjun.projecttest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.tianjun.projecttest.Adapter.MainPagerAdapter;
import com.example.tianjun.projecttest.CustomerView.CustomerAppCompatActivity;
import com.example.tianjun.projecttest.CustomerView.DontMoveViewPager;
import com.example.tianjun.projecttest.CustomerView.OtherFragment;
import com.example.tianjun.projecttest.CustomerView.ViewPagerScroller;
import com.example.tianjun.projecttest.Home.HomeMainFragment;
import com.example.tianjun.projecttest.SQLite.Product.Product;
import com.example.tianjun.projecttest.View.Product.Product_Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends CustomerAppCompatActivity {
    private List<Fragment> mFragmentList;
    @BindView(R.id.main_pager)
    DontMoveViewPager mMainPager;
    @BindView(R.id.main_bottom_selector_home)
    RadioButton mHomeSelector;
    @BindView(R.id.main_bottom_selector_goods)
    RadioButton mGoodsSelector;
    @BindView(R.id.main_bottom_selector_show)
    RadioButton mShowSelector;
    @BindView(R.id.main_bottom_selector_mine)
    RadioButton mMineSelecotr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mMainPager= (DontMoveViewPager) findViewById(R.id.main_pager);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        loadData();
        initView();
    }

    private void loadData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeMainFragment());
        mFragmentList.add(Product_Fragment.newInstance());
        mFragmentList.add(OtherFragment.newInstance("晒吧"));
        mFragmentList.add(OtherFragment.newInstance("我"));
    }

    private void initView() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),mFragmentList);
        ViewPagerScroller scroller = new ViewPagerScroller(this);
        scroller.setScrollDuration(0);
        scroller.initViewPagerScroll(mMainPager);
        mMainPager.setAdapter(mainPagerAdapter);
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.main_bottom_selector_home:
                setSelectorUnChecked();
                mHomeSelector.setChecked(true);
                mMainPager.setCurrentItem(0);
                break;
            case R.id.main_bottom_selector_goods:
                setSelectorUnChecked();
                mGoodsSelector.setChecked(true);
                mMainPager.setCurrentItem(1);
                break;
            case R.id.main_bottom_selector_show:
                setSelectorUnChecked();
                mShowSelector.setChecked(true);
                mMainPager.setCurrentItem(2);
                break;
            case R.id.main_bottom_selector_mine:
                setSelectorUnChecked();
                mMineSelecotr.setChecked(true);
                mMainPager.setCurrentItem(3);
                break;
            case R.id.main_bottom_selector_customer_show:
                break;
        }
    }

    private void setSelectorUnChecked(){
        mHomeSelector.setChecked(false);
        mGoodsSelector.setChecked(false);
        mShowSelector.setChecked(false);
        mMineSelecotr.setChecked(false);
    }

}
