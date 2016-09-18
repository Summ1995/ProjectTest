package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.SQLite.AddressInfo.AddressInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Address_Info extends AppCompatActivity {
    @BindView(R.id.address_bar)
    Toolbar mAddress_bar;
    @BindView(R.id.address_back_img)
    ImageView mAddress_back_img;
    @BindView(R.id.add_address_tv)
    TextView mAdd_Address_tv;

    @BindView(R.id.address_list)
    ListView address_list;

    private Context mContext;
    private List<AddressInfo> addressInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__address__info);
        ButterKnife.bind(this);
        mContext = this;
        mAddress_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAdd_Address_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext, Me_Address_Add.class);
                mContext.startActivity(intent);
            }
        });

        AddressListAdapter addressListAdapter = new AddressListAdapter();
        address_list.setAdapter(addressListAdapter);
    }

    class AddressListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return addressInfos == null ? 0 : addressInfos.size();
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
            View view = convertView;
            AddressViewHolder addressViewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.activity_me_address_list, parent, false);
                addressViewHolder = new AddressViewHolder(view);
                view.setTag(addressViewHolder);
            } else {
                addressViewHolder = (AddressViewHolder) view.getTag();
            }
            AddressInfo addressInfo = addressInfos.get(position);
            addressViewHolder.user_name.setText(addressInfo.getUserNamne());
            addressViewHolder.city_info.setText(addressInfo.getCityInfo());
            addressViewHolder.address_info.setText(addressInfo.getAddress());
            addressViewHolder.phoneNum_tv.setText(addressInfo.getPhoneNum());
            addressViewHolder.postcode_tv.setText(addressInfo.getPostalcode());
            TextView textView = new TextView(mContext);
            if (addressInfo.getDefault() == true) {
                textView.setText("默认地址");
                textView.setTextColor(getResources().getColor(R.color.colorTheme));
            } else {
                textView.setText("设为默认");
                textView.setTextColor(getResources().getColor(R.color.colorWhite));
                addressViewHolder.default_ll.setBackgroundColor(getResources().getColor(R.color.colorTheme));
            }
            return view;
        }
    }

    class AddressViewHolder {
        private TextView user_name, city_info, address_info, phoneNum_tv, postcode_tv;
        private LinearLayout default_ll;


        public AddressViewHolder(View view) {
            user_name = (TextView) view.findViewById(R.id.user_name);
            city_info = (TextView) view.findViewById(R.id.city_info);
            address_info = (TextView) view.findViewById(R.id.address_info);
            phoneNum_tv = (TextView) view.findViewById(R.id.phoneNum_tv);
            postcode_tv = (TextView) view.findViewById(R.id.postcode_tv);
            default_ll = (LinearLayout) view.findViewById(R.id.default_ll);
        }
    }
}
