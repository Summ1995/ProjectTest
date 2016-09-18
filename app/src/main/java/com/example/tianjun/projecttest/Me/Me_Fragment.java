package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by vcc on 2016/9/13.
 */
public class Me_Fragment extends Fragment {

    @BindView(R.id.me_user_head_img)
    CircleImageView mHead_img;
    @BindView(R.id.myrecommend_ll)
    LinearLayout mMyrecommend_ll;
    @BindView(R.id.myindent_ll)
    LinearLayout mMyindent_ll;
    @BindView(R.id.me_jifen_rl)
    RelativeLayout mJifen_rl;
    @BindView(R.id.me_fuliquan_rl)
    RelativeLayout mMe_fuliquan_rl;
    @BindView(R.id.shoucang_rl)
    RelativeLayout mShoucang_rl;

    @BindView(R.id.info_set_rl)
    RelativeLayout mInfo_set_rl;
    @BindView(R.id.address_rl)
    RelativeLayout mAddress_rl;
    @BindView(R.id.service_info_rl)
    RelativeLayout mService_info_rl;
//
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;
//    @BindView(R.id.user_head_img)
//    ImageView mHead_img;


    private Context mContext;

    public static Me_Fragment newInstance() {
        Me_Fragment me_fragment = new Me_Fragment();
        return me_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment, container, false);
        ButterKnife.bind(this, view);
        clickData();
        return view;
    }

    private void clickData() {
        mHead_img.setOnClickListener(clickListener);
        mMyrecommend_ll.setOnClickListener(clickListener);
        mMyindent_ll.setOnClickListener(clickListener);
        mJifen_rl.setOnClickListener(clickListener);
        mMe_fuliquan_rl.setOnClickListener(clickListener);
        mShoucang_rl.setOnClickListener(clickListener);
        mInfo_set_rl.setOnClickListener(clickListener);
        mAddress_rl.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.me_user_head_img:
                    intent.setClass(mContext, Me_Info_Config.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.myrecommend_ll:
                    intent.setClass(mContext, Me_Recommend_Info.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.myindent_ll:
                    intent.setClass(mContext, Me_Indent_Info.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.me_jifen_rl:
                    intent.setClass(mContext, Me_Integral.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.me_fuliquan_rl:
                    intent.setClass(mContext, Me_StampsInfo.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.shoucang_rl:
                    intent.setClass(mContext, Me_Collect.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.info_set_rl:
                    intent.setClass(mContext, Me_Info_Config.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.address_rl:
                    intent.setClass(mContext, Me_Address_Info.class);
                    mContext.startActivity(intent);
                    break;
            }
        }
    };

}
