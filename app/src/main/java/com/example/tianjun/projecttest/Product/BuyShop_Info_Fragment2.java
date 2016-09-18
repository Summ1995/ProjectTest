package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianjun.projecttest.R;

/**
 * Created by vcc on 2016/9/13.
 */
public class BuyShop_Info_Fragment2 extends Fragment {

    private Fragment[] fragments;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.buyshop_info_fragment2,container,false);
        tabLayout= (TabLayout) view.findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("单品").setTag("product"));
        tabLayout.addTab(tabLayout.newTab().setText("专题").setTag("topic"));
        initFragments();
        return view;
    }

    private void initFragments() {
        fragments = new Fragment[2];
        fragmentManager = getChildFragmentManager();
        fragments[0] = fragmentManager.findFragmentById(R.id.info_goods_fragment);
        fragments[1] = fragmentManager.findFragmentById(R.id.info_topic_fragment);
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragments[0]).hide(fragments[1]);
        fragmentTransaction.show(fragments[0]).commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentTransaction = fragmentManager.beginTransaction().hide(fragments[0]).hide(fragments[1]);
                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        fragmentTransaction.show(fragments[0]).commit();
                        break;
                    case 1:
                        fragmentTransaction.show(fragments[1]).commit();
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
