package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.Product_Info_Gson;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vcc on 2016/9/9.
 */
public class Product_Info_no_Fragment extends Fragment {
    private TextView textView;

    public static Product_Info_no_Fragment newInstance(){
        Product_Info_no_Fragment product_info_no_fragment=new Product_Info_no_Fragment();
        return product_info_no_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_info_no_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.model_description);
        return view;
    }


}
