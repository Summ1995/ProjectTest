package com.example.tianjun.projecttest;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;

import com.example.tianjun.projecttest.Adapter.MainPagerAdapter;
import com.example.tianjun.projecttest.CustomerView.CustomerAppCompatActivity;
import com.example.tianjun.projecttest.CustomerView.DontMoveViewPager;
import com.example.tianjun.projecttest.CustomerView.OtherFragment;
import com.example.tianjun.projecttest.CustomerView.ViewPagerScroller;
import com.example.tianjun.projecttest.Home.HomeMainFragment;
import com.example.tianjun.projecttest.Me.Me_Fragment;
import com.example.tianjun.projecttest.Product.Product_Main_Fragment;
import com.example.tianjun.projecttest.SQLite.Product.Product;
import com.example.tianjun.projecttest.Show.ShowMainFragment;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

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
    private Context mContext;
    public MenuDrawer mMenuDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mMainPager = (DontMoveViewPager) findViewById(R.id.main_pager);
        mContext = this;
        mMenuDrawer = MenuDrawer.attach(this, null, Position.LEFT, MenuDrawer.MENU_DRAG_WINDOW);
        mMenuDrawer.setContentView(R.layout.activity_main);
        mMenuDrawer.setMenuView(R.layout.show_category);
        mMenuDrawer.setMenuSize(360);
        mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        loadData();
        initView();
    }

    private void loadData() {
        WindowManager windowManager=getWindowManager();
        int width=windowManager.getDefaultDisplay().getWidth();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeMainFragment());
        mFragmentList.add(Product_Main_Fragment.newInstance(width));
        mFragmentList.add(new ShowMainFragment());
        mFragmentList.add(Me_Fragment.newInstance());


    }

    private void initView() {
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragmentList);
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
                mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
                break;
            case R.id.main_bottom_selector_goods:
                setSelectorUnChecked();
                mGoodsSelector.setChecked(true);
                mMainPager.setCurrentItem(1);
                mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
                break;
            case R.id.main_bottom_selector_show:
                setSelectorUnChecked();
                mShowSelector.setChecked(true);
                mMainPager.setCurrentItem(2);
                mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_FULLSCREEN);
                break;
            case R.id.main_bottom_selector_mine:
                setSelectorUnChecked();
                mMineSelecotr.setChecked(true);
                mMainPager.setCurrentItem(3);
                mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
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
