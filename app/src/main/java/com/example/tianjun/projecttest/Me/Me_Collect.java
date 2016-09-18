package com.example.tianjun.projecttest.Me;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.tianjun.projecttest.R;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Collect extends AppCompatActivity {
    @BindView(R.id.collect_bar)
    Toolbar mCollect_bar;
    @BindView(R.id.collect_tab)
    TabLayout mCollect_tab;
    @BindView(R.id.collect_back_img)
    ImageView mCollect_back_img;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__collect);
        ButterKnife.bind(this);
        WindowManager windowManager = getWindowManager();
        width = windowManager.getDefaultDisplay().getWidth();

        mCollect_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initFragment();
        initTab();
    }

    private void initFragment() {
        fragmentList.add(Me_Collect_Product_Fragment.newInstance(width));
        fragmentList.add(Me_Collect_Choiceness_Fragment.newInstance(width));
        fragmentList.add(Me_Collect_Show_Fragment.newInstance(width));

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragmentList.get(0)).hide(fragmentList.get(1)).hide(fragmentList.get(2));
        fragmentTransaction.replace(R.id.goods_fl,fragmentList.get(0));
        fragmentTransaction.replace(R.id.choiceness_fl,fragmentList.get(1));
        fragmentTransaction.replace(R.id.show_fl,fragmentList.get(2));

        fragmentTransaction.show(fragmentList.get(0)).commit();
    }

    private void initTab() {
        mCollect_tab.addTab(mCollect_tab.newTab().setText("单品"));
        mCollect_tab.addTab(mCollect_tab.newTab().setText("精选"));
        mCollect_tab.addTab(mCollect_tab.newTab().setText("晒吧"));
        mCollect_tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            int i = mCollect_tab.getSelectedTabPosition();
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentTransaction = fragmentManager.beginTransaction().hide(fragmentList.get(0))
                        .hide(fragmentList.get(1)).hide(fragmentList.get(2));
                switch (i) {
                    case 0:
                        fragmentTransaction.show(fragmentList.get(0)).commit();
                        break;
                    case 1:
                        fragmentTransaction.show(fragmentList.get(1)).commit();
                        break;
                    case 2:
                        fragmentTransaction.show(fragmentList.get(2)).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }
}
