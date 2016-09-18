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

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by vcc on 2016/9/13.
 */
public class Me_Fragment extends Fragment {

    @BindView(R.id.user_head_img)
    CircleImageView mHead_img;
    @BindView(R.id.myrecommend_ll)
    LinearLayout mMyrecommend_ll;
    @BindView(R.id.myindent_ll)
    LinearLayout mMyindent_ll;
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
    public static Me_Fragment newInstance(){
        Me_Fragment me_fragment = new Me_Fragment();
        return me_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.me_fragment,container,false);
        ButterKnife.bind(this,view);
        clickData();

        return view;
    }

    private void clickData() {
        mHead_img.setOnClickListener(clickListener);
        mMyrecommend_ll.setOnClickListener(clickListener);
        mMyindent_ll.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            switch (v.getId()){
                case R.id.user_head_img:
                    intent.setClass(mContext,Me_Info_Config.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.myrecommend_ll:
                    intent.setClass(mContext,Me_Recommend_Info.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.myindent_ll:
                    intent.setClass(mContext,Me_Indent_Info.class);
                    mContext.startActivity(intent);
            }
        }
    };

}
