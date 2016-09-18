package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Me.Me_Ranking_Gson;
import com.example.tianjun.projecttest.CustomerView.MyListView;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Me_Recommend_Info extends AppCompatActivity {

    @BindView(R.id.wechat)
    ImageView mWechat;
    @BindView(R.id.wechat_timeline)
    ImageView mWechat_timeline;
    @BindView(R.id.weibo)
    ImageView mWeibo;
    @BindView(R.id.qq)
    ImageView mQQ;
    @BindView(R.id.qqzone)
    ImageView mQQzone;
    @BindView(R.id.ranking_list)
    MyListView mRanking_list;
    @BindView(R.id.people_ll)
    LinearLayout mPeople_ll;

    private List<Me_Ranking_Gson.InfoBean> info;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__recommend__info);
        ButterKnife.bind(this);
        mContext=this;
        initData();
    }

    private void initData() {
        HttpRequest.getHttpService().openMeRankingGsonCall().enqueue(new Callback<Me_Ranking_Gson>() {


            @Override
            public void onResponse(Call<Me_Ranking_Gson> call, Response<Me_Ranking_Gson> response) {
                info = response.body().getInfo();
                MylistViewAdapter mylistViewAdapter = new MylistViewAdapter();
                mRanking_list.setAdapter(mylistViewAdapter);
                mPeople_ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.setClass(mContext,Me_Invite_details.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Me_Ranking_Gson> call, Throwable t) {

            }
        });
    }

    class MylistViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return info==null?0:info.size();
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
            View view= LayoutInflater.from(mContext).inflate(R.layout.me_ranking_listview,parent,false);
            TextView name_tv = (TextView) view.findViewById(R.id.name_tv);
            TextView ranking_tv= (TextView) view.findViewById(R.id.ranking_tv);
            TextView number= (TextView) view.findViewById(R.id.number);
            name_tv.setText(info.get(position).getInvite_name());
            ranking_tv.setText(info.get(position).getInvite_info());
            number.setText(info.get(position).getInvite_level());
            return view;
        }
    }

}
