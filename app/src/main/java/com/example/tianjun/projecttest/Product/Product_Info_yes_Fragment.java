package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.tianjun.projecttest.CustomerView.DontMoveViewPager;
import com.example.tianjun.projecttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vcc on 2016/9/9.
 */
public class Product_Info_yes_Fragment extends Fragment {
    private TabLayout tabLayout;
    private Fragment[] fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.product_info_yes_fragment,container,false);
        tabLayout= (TabLayout) view.findViewById(R.id.info_tablayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("产品概述"));
        tabLayout.addTab(tabLayout.newTab().setText("尺码指南"));
        initFragment();
        return view;
    }

    private void initFragment() {
        fragment = new Fragment[2];
        fragmentManager = getChildFragmentManager();
        fragment[0]=fragmentManager.findFragmentById(R.id.no_fragment);
        fragment[1]=fragmentManager.findFragmentById(R.id.yes_fragment);
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
        fragmentTransaction.show(fragment[0]).commit();
        setFragmentIndicator();
    }

    private void setFragmentIndicator() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        fragmentTransaction.show(fragment[0]).commit();
                        break;
                    case 1:
                        fragmentTransaction.show(fragment[1]).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
