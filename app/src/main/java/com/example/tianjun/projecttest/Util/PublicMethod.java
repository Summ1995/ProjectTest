package com.example.tianjun.projecttest.Util;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.SearchActivity;

/**
 * Created by xx on 2016/9/7.
 */
public class PublicMethod {
    public static int formatDIP(int num, Context context){
       return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, num, context.getResources().getDisplayMetrics());
    }

    public static float getScaleByScreenWidth(Context context,String width){
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels / 2;
        float mScale = screenWidth/Float.parseFloat(width);
        return mScale;
    }


    /**
     * 动态添加head的指示小球
     * @return
     */
    public static ImageView getSignImageView(Context context){
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15,15);
        layoutParams.setMargins(10,0,0,0);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.viewpager_changed_selector);
        return imageView;
    }

    public static  void goToSearch(Context context,String strKey){
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra(ConstantClz.SEARCH_KEY,strKey);
        context.startActivity(intent);
    }
}
