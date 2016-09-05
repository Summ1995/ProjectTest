package com.example.tianjun.projecttest.CustomerView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by xx on 2016/9/5.
 */
public class DontMoveViewPager extends  android.support.v4.view.ViewPager{
    private static boolean isCanScroll = false;

    public DontMoveViewPager(Context context) {
        super(context);
    }

    public DontMoveViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isCanScroll){
            return super.onTouchEvent(ev);
        }else{
            return  false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isCanScroll) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }
    }
}
