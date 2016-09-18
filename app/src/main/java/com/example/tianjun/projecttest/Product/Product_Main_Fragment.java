package com.example.tianjun.projecttest.Product;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vcc on 2016/9/12.
 */
public class Product_Main_Fragment extends Fragment {
    private int width;
    private List<Fragment> fragments=new ArrayList<>();
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @BindView(R.id.bar)
    Toolbar mBar;
    @BindView(R.id.main_tab)
    TabLayout mMain_tab;

    public static Product_Main_Fragment newInstance(int width) {
        Product_Main_Fragment product_main_fragment = new Product_Main_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("windowWidth", width);
        product_main_fragment.setArguments(bundle);
        return product_main_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_main_fragment, container, false);
        Bundle bundle = getArguments();
        width = bundle.getInt("windowWidth");
        ButterKnife.bind(this, view);
        initFragment();
        initTabLayout();
        return view;
    }

    private void initFragment() {
        fragments.add(Product_Fragment.newInstance(width));
        fragments.add(BuyShop_Fragment.newInstance(width));
        fragmentManager = getChildFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction().hide(fragments.get(0)).hide(fragments.get(1));
        fragmentTransaction.replace(R.id.product_fra, fragments.get(0));
        fragmentTransaction.replace(R.id.buyshop_fra, fragments.get(1));
        fragmentTransaction.show(fragments.get(0)).commit();
    }

    private void initTabLayout() {
        mMain_tab.addTab(mMain_tab.newTab().setText("单品").setTag("product"));
        mMain_tab.addTab(mMain_tab.newTab().setText("买手店").setTag("buyshop"));
        mMain_tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentTransaction = fragmentManager.beginTransaction().hide(fragments.get(0)).hide(fragments.get(1));
                if (tab.getTag().equals("product")) {
                    fragmentTransaction.show(fragments.get(0)).commit();
                }else{
                    fragmentTransaction.show(fragments.get(1)).commit();
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
