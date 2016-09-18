package com.example.tianjun.projecttest;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Search.SearchTabAdapter;
import com.example.tianjun.projecttest.CustomerView.OtherFragment;
import com.example.tianjun.projecttest.CustomerView.RefreshFragment;
import com.example.tianjun.projecttest.CustomerView.ViewPagerScroller;
import com.example.tianjun.projecttest.Search.GoodsFragment;
import com.example.tianjun.projecttest.Search.TopicFragment;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.Util.PublicMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,TextView.OnEditorActionListener,ViewPager.OnPageChangeListener {
    @BindView(R.id.search_input)
    EditText mSearchInput;
    @BindView(R.id.search_search_txt)
    TextView mSearch;
    @BindView(R.id.search_cancle_txt)
    TextView mSearchCancle;
    @BindView(R.id.search_tab)
    TabLayout mSearchTab;
    @BindView(R.id.search_pager)
    ViewPager mSearchPager;

    private List<RefreshFragment> mFragmentList;
    private List<String> mTitleList;
    private String mSearchKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        mSearchKey = getIntent().getStringExtra(ConstantClz.SEARCH_KEY);
        initView();
    }

    private void initView() {
        initToolBar();
        loadData();
        initMain();
    }

    private void loadData() {
        mFragmentList = new ArrayList();
        mTitleList = new ArrayList();
        mFragmentList.add(TopicFragment.newInstance(mSearchKey));
        mFragmentList.add(GoodsFragment.newInstance(mSearchKey));
        mTitleList.add("专题");
        mTitleList.add("单品");
    }

    private void initToolBar() {
        mSearchInput.setText(mSearchKey);
        mSearchInput.setOnEditorActionListener(this);
        mSearch.setOnClickListener(this);
        mSearchCancle.setOnClickListener(this);
    }

    private void initMain() {
        SearchTabAdapter searchTabAdapter = new SearchTabAdapter(getSupportFragmentManager(), mFragmentList,mTitleList);
        mSearchPager.setAdapter(searchTabAdapter);
        mSearchPager.setOnPageChangeListener(this);
        ViewPagerScroller scroller = new ViewPagerScroller(this);
        scroller.setScrollDuration(0);
        scroller.initViewPagerScroll(mSearchPager);
        mSearchTab.setTabMode(TabLayout.MODE_FIXED);
        mSearchTab.setTabsFromPagerAdapter(searchTabAdapter);
        mSearchTab.setupWithViewPager(mSearchPager);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_search_txt:
                refreshFragment();
                break;
            case R.id.search_cancle_txt:
                finish();
                break;
        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == R.id.search_txt || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)){
            refreshFragment();
            return  true;
        }
        return false;
    }

    private void refreshFragment(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        int position = mSearchPager.getCurrentItem();
        mSearchKey = mSearchInput.getText().toString();
        mFragmentList.get(position).refreshView(mSearchKey);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        refreshFragment();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
