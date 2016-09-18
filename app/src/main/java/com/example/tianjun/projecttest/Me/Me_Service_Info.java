package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.SQLite.Custom_serviceInfo.Custom_serviceInfo;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Me_Service_Info extends AppCompatActivity {

    @BindView(R.id.service_Info_list)
    PullToRefreshListView pullToRefreshListView;
    @BindView(R.id.service_back_img)
    ImageView mService_back_img;
    private List<Custom_serviceInfo> custom_serviceInfos=new ArrayList<>();
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__service__info);
        ButterKnife.bind(this);
        mContext=this;

        ServiceListAdapter serviceListAdapter = new ServiceListAdapter();
        pullToRefreshListView.setAdapter(serviceListAdapter);
        mService_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    class ServiceListAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return custom_serviceInfos==null?0:custom_serviceInfos.size();
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
            View view= LayoutInflater.from(mContext).inflate(R.layout.activity_service_info_listview,parent,false);
            CircleImageView service_user_heat_img= (CircleImageView) view.findViewById(R.id.service_user_heat_img);
            TextView service_user_name_tv= (TextView) view.findViewById(R.id.service_user_name_tv);
            TextView service_deta_tv= (TextView) view.findViewById(R.id.service_deta_tv);
            TextView msg_content= (TextView) view.findViewById(R.id.msg_content);
            Custom_serviceInfo custom_serviceInfo = custom_serviceInfos.get(position);
            service_user_name_tv.setText(custom_serviceInfo.getUser_name());
            service_deta_tv.setText(custom_serviceInfo.getMsg_time());
            msg_content.setText(custom_serviceInfo.getMsg_content());
            Picasso.with(mContext).load(custom_serviceInfo.getAvatar()).into(service_user_heat_img);
            return view;
        }
    }

}
