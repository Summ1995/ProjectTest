package com.example.tianjun.projecttest.Adapter.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.HomeDetailActivity;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 首页 '全部'选项卡中的头部视图
 * Created by xx on 2016/9/7.
 */
public class ListHeadAdapter extends PagerAdapter implements View.OnClickListener{
    private final List<ListHeadBean.InfoBean.ItemsBean> mHeadData;
    private final Context mContext;

    public ListHeadAdapter(List<ListHeadBean.InfoBean.ItemsBean> headData, Context context){
        mHeadData = headData;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mHeadData == null ? 0 : mHeadData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String imgUrl = mHeadData.get(position).getBanner_image();
        Picasso.with(mContext).load(imgUrl).into(imageView);
        imageView.setTag(mHeadData.get(position).getTarget_id());
        imageView.setOnClickListener(this);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public void onClick(View view) {
        String catID = view.getTag().toString();
        Intent intent = new Intent(mContext, HomeDetailActivity.class);
        intent.putExtra(ConstantClz.DETAIL_CAT_ID,catID);
        mContext.startActivity(intent);
    }
}
