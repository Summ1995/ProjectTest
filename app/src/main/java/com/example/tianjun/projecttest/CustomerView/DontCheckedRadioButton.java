package com.example.tianjun.projecttest.CustomerView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RadioButton;

/**
 * Created by xx on 2016/9/5.
 */
public class DontCheckedRadioButton extends RadioButton {
    private static boolean isCanChecked = false;

    public DontCheckedRadioButton(Context context) {
        this(context,null);
    }

    public DontCheckedRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DontCheckedRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isCanChecked){
            return super.onTouchEvent(ev);
        }else{
            return  false;
        }
    }
}
