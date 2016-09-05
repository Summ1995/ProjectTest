package com.example.tianjun.projecttest.CustomerView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by xx on 2016/9/5.
 */
public class OtherFragment extends Fragment{
    private final String mTitle;
    private Context mContext;

    public static OtherFragment newInstance(String title){
        return new OtherFragment(title);
    }

    private OtherFragment(String title){
        mTitle = title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(mContext);
        textView.setText(mTitle);
        return textView;
    }
}
