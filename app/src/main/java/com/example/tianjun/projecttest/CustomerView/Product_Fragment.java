package com.example.tianjun.projecttest.CustomerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianjun.projecttest.R;

/**
 * Created by vcc on 2016/9/5.
 */
public class Product_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.product_fragment,container,false);

        return view;
    }
}
