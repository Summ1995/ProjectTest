package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tianjun.projecttest.Bean.Product.Product_Head_Gson;
import com.example.tianjun.projecttest.Product.Product_Info;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vcc on 2016/9/7.
 */
public class Product_HeadViewPager extends PagerAdapter{
    private Context mContext;
    private List<Product_Head_Gson.InfoBean.ItemsBean> mViewPager_List;
    private int windowWidth;

 public Product_HeadViewPager(Context mContext,List<Product_Head_Gson.InfoBean.ItemsBean> mViewPager_List,int windowWidth){
     this.mContext=mContext;
     this.mViewPager_List=mViewPager_List;
     this.windowWidth=windowWidth;
 }

    @Override
    public int getCount() {
        return mViewPager_List == null ? 0 : mViewPager_List.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        String url = mViewPager_List.get(position).getBanner_image();
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_head_viewpager, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.viewpager_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(mContext,Product_Info.class);
                String target_id = mViewPager_List.get(position).getTarget_id();
                intent.putExtra("goods_id",target_id);
                mContext.startActivity(intent);
            }
        });
        Picasso.with(mContext).load(url).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
