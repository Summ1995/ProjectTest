package com.example.tianjun.projecttest.Product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianjun.projecttest.R;

/**
 * Created by vcc on 2016/9/12.
 */
public class Product_TypeList_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.product_typelist_fragment,container,false);
        return view;
    }
}
