package com.example.tianjun.projecttest.Adapter.Show;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xx on 2016/9/13.
 */
public class ListItemImagePagerAdapter extends PagerAdapter{
    private final List<String> mImages;
    private final Context mContext;

    public ListItemImagePagerAdapter(List<String> images, Context context){
        mImages = images;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImages == null ? 0 : mImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String imgUrl = mImages.get(position);
        Picasso.with(mContext).load(imgUrl).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
