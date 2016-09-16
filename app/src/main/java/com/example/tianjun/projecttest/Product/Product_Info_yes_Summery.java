package com.example.tianjun.projecttest.Product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.Product_Info_Gson;
import com.example.tianjun.projecttest.R;

/**
 * Created by vcc on 2016/9/9.
 */
public class Product_Info_yes_Summery extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.product_info_yes_summary,container,false);
        textView = (TextView) view.findViewById(R.id.model_description);
        return view;
    }
}
