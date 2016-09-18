package com.example.tianjun.projecttest.Search;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianjun.projecttest.Adapter.Home.ListViewAdapter;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.CustomerView.RefreshFragment;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xx on 2016/9/18.
 */
public class TopicFragment extends RefreshFragment implements PullToRefreshBase.OnRefreshListener2 {
    private String mKey;
    private PullToRefreshListView mTopicList;
    private int mCount = 10;
    private ListViewAdapter mListViewAdapter;
    private List<ListBean.InfoBean> mListData;
    private Context mContext;


    public static TopicFragment newInstance(String key){
        return new TopicFragment(key);
    }

    private TopicFragment(String key){
        mKey = key;
    }

    public TopicFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListData = new ArrayList<>();
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_topic, container, false);
        mTopicList = (PullToRefreshListView)view.findViewById(R.id.search_topic_list);
        initView();
        return view;
    }

    private void initView() {
        mListViewAdapter = new ListViewAdapter(mListData,mContext);
        mTopicList.setAdapter(mListViewAdapter);
        mTopicList.setMode(PullToRefreshBase.Mode.BOTH);
        mTopicList.setOnRefreshListener(this);

        mCount = 10;
        if (mListData == null || mListData.size() == 0){
            requestData();
        }
    }

    /**
     * 控制listview的下拉刷新
     * @param refreshView
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        mCount = 10;
        requestData();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        mCount += 10;
        requestData();
    }

    private void requestData(){
        HttpRequest.getHttpService().queryHomeListData(mCount,"",mKey).enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                mListData.clear();
                mListData.addAll(response.body().getInfo());
                updateListData.sendEmptyMessage(1);
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {

            }
        });

    }


    private Handler updateListData = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mListViewAdapter.notifyDataSetChanged();
            mTopicList.onRefreshComplete();
        }
    };

    @Override
    public void refreshView(String key) {
        mKey = key;
        mCount = 10;
        requestData();
    }
}
