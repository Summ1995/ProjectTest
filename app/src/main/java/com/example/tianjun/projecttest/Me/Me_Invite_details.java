package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class Me_Invite_details extends AppCompatActivity {
    private PullToRefreshListView mInvite_details_pull;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__invite_details);
        mContext=this;
        initView();
    }

    private void initView() {
        mInvite_details_pull= (PullToRefreshListView) findViewById(R.id.Invite_details_pull);
        mInvite_details_pull.setMode(PullToRefreshBase.Mode.BOTH);
        View view= LayoutInflater.from(mContext).inflate(R.layout.activity_me_invite_details_head,null);
        mInvite_details_pull.getRefreshableView().addHeaderView(view);
    }
}
