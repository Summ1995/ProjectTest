package com.example.tianjun.projecttest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;

import com.example.tianjun.projecttest.Adapter.Home.ListViewAdapter;
import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Present.Home.HomePresent;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Home.IHomeView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailActivity extends AppCompatActivity implements IHomeView,PullToRefreshBase.OnRefreshListener2,AbsListView.OnScrollListener {

    private PullToRefreshListView mHomeDetailList;
    private String mCatID;
    private int mCurrentCount = 10;
    private List<ListBean.InfoBean> mListData;
    private ListViewAdapter mListViewAdapter;
    private HomePresent mHomePresent;
    private Boolean isBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        init();
    }

    private void init() {
        loadData();
        mHomeDetailList = (PullToRefreshListView) findViewById(R.id.home_detail);
        mListViewAdapter = new ListViewAdapter(mListData,this);
        mHomeDetailList.setAdapter(mListViewAdapter);
        mHomeDetailList.setOnRefreshListener(this);
        mHomeDetailList.setOnScrollListener(this);

        mHomePresent.requestListData(mCurrentCount,Integer.parseInt(mCatID),ConstantClz.HOME_LIST_REQUEST_CODE);
    }

    private void loadData() {
        mListData = new ArrayList<>();
        mHomePresent = new HomePresent(this);
        mCatID = getIntent().getStringExtra(ConstantClz.DETAIL_CAT_ID);
    }

    @Override
    public void getRequestListBean(List<ListBean.InfoBean> bean) {
        mListData.clear();
        mListData.addAll(bean);
        updateListData.sendEmptyMessage(1);
    }

    private Handler updateListData = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mListViewAdapter.notifyDataSetChanged();
            mHomeDetailList.onRefreshComplete();
        }
    };

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        mCurrentCount = 10;
        mHomePresent.requestListData(mCurrentCount,Integer.parseInt(mCatID),ConstantClz.HOME_LIST_REQUEST_CODE);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == 0 && isBottom == true){
            mCurrentCount += 10;
            mHomePresent.requestListData(mCurrentCount,Integer.parseInt(mCatID),ConstantClz.HOME_LIST_REQUEST_CODE);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if ((firstVisibleItem + visibleItemCount) == totalItemCount){
            isBottom = true;
        }else {
            isBottom = false;
        }
    }






    @Override
    public void getRequestTabBean(List<TabBean.InfoBean> bean) {

    }

    @Override
    public void getRequestListHeadBean(List<ListHeadBean.InfoBean.ItemsBean> bean) {

    }

    @Override
    public void getRequestCategoryBean(CategoryBean.InfoBean bean) {

    }
}
