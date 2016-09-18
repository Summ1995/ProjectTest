package com.example.tianjun.projecttest.Me;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Indent_Info extends AppCompatActivity {
    @BindView(R.id.indent_bar)
    Toolbar mIndent_bar;
    @BindView(R.id.indent_back_img)
    ImageView mindent_back_img;
    @BindView(R.id.indent_tablayout)
    TabLayout mIndent_tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__indent__info);
        ButterKnife.bind(this);
        mindent_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initTabLayout();
    }

    private void initTabLayout() {
        mIndent_tablayout.addTab(mIndent_tablayout.newTab().setText("全部"));
        mIndent_tablayout.addTab(mIndent_tablayout.newTab().setText("待付款"));
        mIndent_tablayout.addTab(mIndent_tablayout.newTab().setText("待发货"));
        mIndent_tablayout.addTab(mIndent_tablayout.newTab().setText("待收货"));
        mIndent_tablayout.addTab(mIndent_tablayout.newTab().setText("带评价"));
    }
}
