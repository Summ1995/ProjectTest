package com.example.tianjun.projecttest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tianjun.projecttest.Adapter.Detail.CommentItemAdapter;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.CustomerView.CustomerAppCompatActivity;
import com.example.tianjun.projecttest.Present.Detail.DetailPresent;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Detail.IDetailView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends CustomerAppCompatActivity implements IDetailView,PullToRefreshBase.OnRefreshListener2 {
    private String mTopicId;
    private PullToRefreshListView mCommentList;
    private DetailPresent mDetailPresent;
    private int mCurrentCount = 10;
    private List<CommentBean.InfoBean> mCommentData;
    private CommentItemAdapter mCommentItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        init();
    }

    private void init() {
        loadData();
        mCommentList = (PullToRefreshListView) findViewById(R.id.comment_list);
        mCommentList.setMode(PullToRefreshBase.Mode.BOTH);
        mCommentList.setOnRefreshListener(this);
        mCommentItemAdapter = new CommentItemAdapter(mCommentData, this);
        mCommentList.setAdapter(mCommentItemAdapter);

        mDetailPresent.RequestCommentData(mTopicId,String.valueOf(mCurrentCount), ConstantClz.COMMENTS_REQUEST_CODE);
    }

    private void loadData() {
        mCommentData = new ArrayList<>();
        mDetailPresent = new DetailPresent(this);
        mTopicId = getIntent().getStringExtra(ConstantClz.DETAIL_TOPIC_ID);
    }

    @Override
    public void getRequestDetailsBean(DetailsBean.InfoBean bean) {

    }

    @Override
    public void getRequestCommentsBean(List<CommentBean.InfoBean> bean) {
        mCommentData.clear();
        mCommentData.addAll(bean);
        refreshHandler.sendEmptyMessage(1);
    }

    @Override
    public void getRequestRelativeTopicBean(List<RelativeTopicBean.InfoBean> bean) {

    }

    private Handler refreshHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mCommentItemAdapter.notifyDataSetChanged();
            mCommentList.onRefreshComplete();
        }
    };

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        mCurrentCount = 10;
        mDetailPresent.RequestCommentData(mTopicId,String.valueOf(mCurrentCount), ConstantClz.COMMENTS_REQUEST_CODE);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        mCurrentCount += 10;
        mDetailPresent.RequestCommentData(mTopicId,String.valueOf(mCurrentCount), ConstantClz.COMMENTS_REQUEST_CODE);
    }
}
