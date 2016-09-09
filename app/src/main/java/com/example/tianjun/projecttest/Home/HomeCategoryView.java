package com.example.tianjun.projecttest.Home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.HomeDetailActivity;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.Util.PublicMethod;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.tianjun.projecttest.Util.PublicMethod.formatDIP;

/**
 * Created by xx on 2016/9/7.
 */
public class HomeCategoryView{
    private static Context mContext;
    private static float mScale;

    public static void initCategory(RelativeLayout categoryView, CategoryBean.InfoBean categoryData, Context context){
        mContext = context;
        mScale = PublicMethod.getScaleByScreenWidth(context,categoryData.getWidth());
        List<CategoryBean.InfoBean.ItemsBean> items = categoryData.getItems();
        for (int i = 0; i < items.size(); i++) {
            categoryView.addView(getImageView(items.get(i)));
        }
    }

    private static ImageView getImageView(CategoryBean.InfoBean.ItemsBean categoryData){
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        int width = (int) (categoryData.getWidth() * mScale);
        int marginLeft = (int) (categoryData.getLeft() * mScale);
        int height = (int) (categoryData.getHeight() * mScale);
        int marginTop = (int) (categoryData.getTop() * mScale);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(formatDIP(width,mContext), formatDIP(height,mContext));
        layoutParams.setMargins(formatDIP(marginLeft,mContext),formatDIP(marginTop,mContext),0,0);
        imageView.setLayoutParams(layoutParams);
        Picasso.with(mContext).load(categoryData.getCat_image()).into(imageView);
        final String cat_id = categoryData.getCat_id();
        if (!cat_id.equals("0")){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, HomeDetailActivity.class);
                    intent.putExtra(ConstantClz.DETAIL_CAT_ID,cat_id);
                    mContext.startActivity(intent);

                }
            });

        }
        return imageView;
    }

}
