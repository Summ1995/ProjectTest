package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.ButterKnife;

public class Me_Invite_details extends AppCompatActivity {
    private PullToRefreshListView mInvite_details_pull;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__invite_details);
        mContext = this;
        initView();
    }

    private void initView() {
        mInvite_details_pull = (PullToRefreshListView) findViewById(R.id.Invite_details_pull);

        mInvite_details_pull.setMode(PullToRefreshBase.Mode.BOTH);
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_me_invite_details_head, null);
        mInvite_details_pull.getRefreshableView().addHeaderView(view);
        mInvite_details_pullAdapter mInvite_details_pullAdapter = new mInvite_details_pullAdapter();
        mInvite_details_pull.setAdapter(mInvite_details_pullAdapter);
    }

    class mInvite_details_pullAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
