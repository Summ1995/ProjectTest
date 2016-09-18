package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.SQLite.Baskbar.Baskbar;
import com.example.tianjun.projecttest.SQLite.Product.Product;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vcc on 2016/9/17.
 */
public class Me_Collect_Show_Fragment extends Fragment {
    PullToRefreshGridView mPullToRefreshGridView;
    private Context mContext;
    private List<Baskbar> baskbars = new ArrayList<>();
    private int windowWidth;

    public static Me_Collect_Show_Fragment newInstance(int width) {
        Me_Collect_Show_Fragment me_collect_show_fragment = new Me_Collect_Show_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("windowWidth", width);
        me_collect_show_fragment.setArguments(bundle);
        return me_collect_show_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        Bundle bundle = getArguments();
        windowWidth = bundle.getInt(("windowWidth"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collect_show_fragment, container, false);
        mPullToRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.collect_show_grid);
        PullGridViewAdapter pullGridViewAdapter = new PullGridViewAdapter();
        mPullToRefreshGridView.setAdapter(pullGridViewAdapter);
        return view;
    }

    class PullGridViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return baskbars == null ? 0 : baskbars.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            Show_GridViewHolders show_GridViewHolders = null;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.collect_show_fragment_gridview, parent, false);
                show_GridViewHolders = new Show_GridViewHolders(view);
                view.setTag(show_GridViewHolders);
            } else {
                show_GridViewHolders = (Show_GridViewHolders) view.getTag();
            }
            Baskbar baskbar = baskbars.get(position);
            show_GridViewHolders.mBrand_tv.setText(baskbar.getContent());
            show_GridViewHolders.mProductname_tv.setText(baskbar.getNick_name());

            String url = baskbar.getImages();

            ViewGroup.LayoutParams layoutParams = show_GridViewHolders.mTitle_img.getLayoutParams();
            layoutParams.height = windowWidth / 2;
            show_GridViewHolders.mTitle_img.setLayoutParams(layoutParams);

            Picasso.with(mContext).load(url).into(show_GridViewHolders.mTitle_img);

            return view;
        }
    }

    class Show_GridViewHolders {
        public ImageView mTitle_img;
        public TextView mBrand_tv, mProductname_tv;

        public Show_GridViewHolders(View view) {
            mTitle_img = (ImageView) view.findViewById(R.id.show_title_img);
            mBrand_tv = (TextView) view.findViewById(R.id.show_info_tv);
            mProductname_tv = (TextView) view.findViewById(R.id.show_title_tv);
        }

    }
}
