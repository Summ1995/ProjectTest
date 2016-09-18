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
import com.example.tianjun.projecttest.SQLite.Choiceness.Choiceness;
import com.example.tianjun.projecttest.SQLite.Product.Product;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vcc on 2016/9/17.
 */
public class Me_Collect_Choiceness_Fragment extends Fragment {
    PullToRefreshListView pullToRefreshListView;
    private Context mContext;
    private List<Choiceness> choicenesses = new ArrayList<>();
    private int windowWidth;

    public static Me_Collect_Choiceness_Fragment newInstance(int width) {
        Me_Collect_Choiceness_Fragment me_collect_choiceness_fragment = new Me_Collect_Choiceness_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("windowWidth", width);
        me_collect_choiceness_fragment.setArguments(bundle);
        return me_collect_choiceness_fragment;
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
        View view = inflater.inflate(R.layout.collect_choiceness_fragment, container, false);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.collect_choiceness_listview);
        ListViewAdapter listViewAdapter = new ListViewAdapter();
        pullToRefreshListView.setAdapter(listViewAdapter);
        return view;
    }

    class ListViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return choicenesses == null ? 0 : choicenesses.size();
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
            Collect_ListViewHolders collect_listviewHolders = null;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.collect_choiceness_fragment_listview, parent, false);
                collect_listviewHolders = new Collect_ListViewHolders(view);
                view.setTag(collect_listviewHolders);
            } else {
                collect_listviewHolders = (Collect_ListViewHolders) view.getTag();
            }
            Choiceness choiceness = choicenesses.get(position);
            collect_listviewHolders.mBrand_tv.setText(choiceness.getTopic_img());

            String url = choiceness.getTopic_img();
            ViewGroup.LayoutParams layoutParams = collect_listviewHolders.mTitle_img.getLayoutParams();
            layoutParams.height = (int) (windowWidth *0.7);
            collect_listviewHolders.mTitle_img.setLayoutParams(layoutParams);

            Picasso.with(mContext).load(url).into(collect_listviewHolders.mTitle_img);

            return view;
        }
    }

    class Collect_ListViewHolders {
        public ImageView mTitle_img;
        public TextView mBrand_tv;

        public Collect_ListViewHolders(View view) {
            mTitle_img = (ImageView) view.findViewById(R.id.collect_choiceness_img);
            mBrand_tv = (TextView) view.findViewById(R.id.collect_choiceness_tv);
        }

    }
}
