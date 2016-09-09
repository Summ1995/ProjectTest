package com.example.tianjun.projecttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Detail.CommentItemAdapter;
import com.example.tianjun.projecttest.Adapter.Detail.DetailsAdapter;
import com.example.tianjun.projecttest.Adapter.Detail.RelativeTopicItemAdapter;
import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.CustomerView.CustomerAppCompatActivity;
import com.example.tianjun.projecttest.CustomerView.CustomerListView;
import com.example.tianjun.projecttest.Present.Detail.DetailPresent;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Detail.IDetailView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends CustomerAppCompatActivity implements IDetailView,View.OnClickListener{
    @BindView(R.id.detail_img)
    ImageView mImage;
    @BindView(R.id.detail_title)
    TextView mTitle;
    @BindView(R.id.detail_author_img)
    CircleImageView mAuthorImg;
    @BindView(R.id.detail_author_title)
    TextView mAuthorTitle;
    @BindView(R.id.detail_add_time)
    TextView mAddTime;
    @BindView(R.id.detail_had_view)
    TextView mHadView;
    @BindView(R.id.detail_support)
    TextView mSupport;
    @BindView(R.id.detail_shared)
    TextView mShared;
    @BindView(R.id.detail_introduce)
    TextView mIntroduce;
    @BindView(R.id.detail_details)
    CustomerListView mDetails;
    @BindView(R.id.detail_comments)
    RelativeLayout mComments;
    @BindView(R.id.detail_send_txt)
    EditText mSendText;
    @BindView(R.id.detail_send_btn)
    Button mSendBtn;
    @BindView(R.id.detail_comment_number)
    TextView mCommentNum;
    @BindView(R.id.detail_comments_more)
    Button mMoreCommentBtn;
    @BindView(R.id.detail_comment)
    CustomerListView mCommentList;
    @BindView(R.id.detail_comment_list_split)
    ImageView mCommentsDetailSplit;
    @BindView(R.id.detail_empty_comment)
    TextView mEmptyComment;
    @BindView(R.id.detail_read)
    CustomerListView mReadList;

    private String mTopicId;
    private String mUserID;
    private DetailPresent mDetailPresent;
    private DetailsBean.InfoBean mDetailData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        loadData();
        mDetailPresent.RequestDetailsData(mTopicId,mUserID,ConstantClz.DETAIL_REQUEST_CODE);
    }

    /**
     * 初始化数据
     */
    private void loadData() {
        mTopicId = getIntent().getStringExtra(ConstantClz.DETAIL_TOPIC_ID);
        mUserID = getIntent().getStringExtra(ConstantClz.USER_ID);
        mDetailPresent = new DetailPresent(this);
    }



    /**
     * 得到详情简介信息
     * @param detailData
     */
    @Override
    public void getRequestDetailsBean(DetailsBean.InfoBean detailData) {
        mDetailData = detailData;
        initIntruduce();
        initDetails();
        initComments();
        initRead();
    }

    /**
     * 初始化详情简介
     */
    private void initIntruduce() {
        Picasso.with(this).load(mDetailData.getTopic_img()).into(mImage);
        mTitle.setText(mDetailData.getTitle());
        Picasso.with(this).load(mDetailData.getAvator()).into(mAuthorImg);
        mAuthorTitle.setText(mDetailData.getAuthor());
        mAddTime.setText("发布于" + mDetailData.getAdd_time());
        mHadView.setText(String.valueOf(mDetailData.getViews()));
        mSupport.setText(String.valueOf(mDetailData.getSupport()));
        mShared.setText(String.valueOf(mDetailData.getShare_count()));
        mIntroduce.setText(mDetailData.getIntro());

        String remarkNum = mDetailData.getRemark();
        mCommentNum.setText("(" + remarkNum + ")");
        if (Integer.parseInt(remarkNum) > 3){
            mMoreCommentBtn.setVisibility(View.VISIBLE);
            mCommentsDetailSplit.setVisibility(View.VISIBLE);
            mMoreCommentBtn.setTag(mDetailData.getTopic_id());
            mMoreCommentBtn.setOnClickListener(this);
        }else {
            mMoreCommentBtn.setVisibility(View.GONE);
            mCommentsDetailSplit.setVisibility(View.GONE);
        }



        if (remarkNum.equals("0")){
            mCommentList.setVisibility(View.GONE);
            mEmptyComment.setVisibility(View.VISIBLE);
        }else {
            mCommentList.setVisibility(View.VISIBLE);
            mEmptyComment.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化详情简介详细介绍
     */
    private void initDetails() {
        DetailsAdapter detailsAdapter = new DetailsAdapter(mDetailData.getDetail(), this);
        mDetails.setAdapter(detailsAdapter);
    }

    /**
     * 初始化评论
     */
    private void initComments() {
        mDetailPresent.RequestCommentData(mTopicId,"3",ConstantClz.COMMENTS_REQUEST_CODE);
    }

    /**
     * 得到评论信息
     * @param bean
     */
    @Override
    public void getRequestCommentsBean(List<CommentBean.InfoBean> bean) {
        CommentItemAdapter commentItemAdapter = new CommentItemAdapter(bean, this);
        mCommentList.setAdapter(commentItemAdapter);
    }

    /**
     * 初始化'读我'模块
     */
    private void initRead() {
        mDetailPresent.RequestRelativeTopicData(mTopicId,ConstantClz.RELATIVE_TOPIC_REQUEST_CODE);
    }

    /**
     * 得到'读我'模块信息
     * @param bean
     */
    @Override
    public void getRequestRelativeTopicBean(List<RelativeTopicBean.InfoBean> bean) {
        RelativeTopicItemAdapter relativeTopicItemAdapter = new RelativeTopicItemAdapter(bean, this);
        mReadList.setAdapter(relativeTopicItemAdapter);
    }

    @Override
    public void onClick(View view) {
        String topicID = view.getTag().toString();
        Intent intent = new Intent(this, CommentActivity.class);
        intent.putExtra(ConstantClz.DETAIL_TOPIC_ID,topicID);
        startActivity(intent);
    }
}
