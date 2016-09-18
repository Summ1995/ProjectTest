package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_StampsInfo extends AppCompatActivity {
    @BindView(R.id.stamps_tab)
    TabLayout mStamps_tab;
    @BindView(R.id.stamps_back_img)
    ImageView mStamps_back_img;
    @BindView(R.id.stamps_recommend_ll)
    LinearLayout mStamps_recommend_ll;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__stamps_info);
        ButterKnife.bind(this);
        mContext=this;

        mStamps_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mStamps_recommend_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(mContext,Me_Recommend_Info.class);
                startActivity(intent);
            }
        });
        initTabLayout();
    }

    private void initTabLayout() {
        mStamps_tab.addTab(mStamps_tab.newTab().setText("可使用"));
        mStamps_tab.addTab(mStamps_tab.newTab().setText("已使用"));
        mStamps_tab.addTab(mStamps_tab.newTab().setText("已过期"));

    }
}
