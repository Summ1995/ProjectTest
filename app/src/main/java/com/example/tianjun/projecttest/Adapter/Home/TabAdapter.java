package com.example.tianjun.projecttest.Adapter.Home;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Home.HomeMainFragment;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2016/9/6.
 */
public class TabAdapter extends RecyclerView.Adapter<TabAdapter.ViewHolder> {
    private final List<TabBean.InfoBean> mTabData;
    private final LayoutInflater mInflater;
    private final Resources mResources;
    private final HomeMainFragment mHomeFragment;

    public TabAdapter(List<TabBean.InfoBean> tabData, Context context,HomeMainFragment homeFragment){
        mTabData = tabData;
        mInflater = LayoutInflater.from(context);
        mResources = context.getResources();
        mHomeFragment = homeFragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_tab, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == getItemCount() - 1){
            holder.tebImg.setVisibility(View.VISIBLE);
            holder.tebName.setVisibility(View.GONE);
        }else {
            holder.tebImg.setVisibility(View.GONE);
            holder.tebName.setVisibility(View.VISIBLE);
            holder.tebName.setText(mTabData.get(position).getCat_name());
        }
    }


    @Override
    public int getItemCount() {
        return (mTabData == null ? 0 : mTabData.size()) + 1;
    }


    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        @BindView(R.id.home_tab_txt)
        TextView tebName;
        @BindView(R.id.home_tab_img)
        ImageView tebImg;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getPosition();
            String catId;
            if (position == mTabData.size()){
                catId = ConstantClz.HOME_TAB_CATEGORY_CODE;
            }else {
                catId = mTabData.get(position).getCat_id();
            }
            mHomeFragment.initList(catId);
        }
    }
}
