package com.example.tianjun.projecttest.CustomerView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 * Created by vcc on 2016/8/29.
 */
public class AlphaTitleScrollView extends ScrollView {
    private int mSlop;
    private Toolbar toolbar;
    private ViewPager mViewPager;

    public AlphaTitleScrollView(Context context, AttributeSet attrs,
                                int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public AlphaTitleScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    public AlphaTitleScrollView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        mSlop = 10;
    }


    public void setTitleAndHead(Toolbar toolbar,  ViewPager headView) {
        this.toolbar=toolbar;
        this.mViewPager = headView;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        float headHeight = mViewPager.getMeasuredHeight()
                - toolbar.getMeasuredHeight();

        int alpha1 = (int) ((((float) t / headHeight) * 255));

        if (alpha1 >= 255)
            alpha1 = 255;
        if (alpha1 <= mSlop)
            alpha1 = 0;
        toolbar.getBackground().setAlpha(alpha1);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
