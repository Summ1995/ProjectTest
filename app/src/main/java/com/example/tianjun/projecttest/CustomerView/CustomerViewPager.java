package com.example.tianjun.projecttest.CustomerView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by xx on 2016/9/14.
 */
public class CustomerViewPager extends ViewPager{
    private int mCurrentItem;
    private float startX;

    public CustomerViewPager(Context context) {
        super(context);
    }

    public CustomerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mCurrentItem = getCurrentItem();
                startX = getX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (mCurrentItem != 0){
                    float distanceX = getX() - startX;
                    if (distanceX > 0){
                        setCurrentItem(mCurrentItem - 1);
                        return true;
                    }
                }
                break;
        }
        return super.onTouchEvent(ev);
    }
}
