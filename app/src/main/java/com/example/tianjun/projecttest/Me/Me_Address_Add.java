package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Address_Add extends AppCompatActivity {

    @BindView(R.id.address_add_bar)
    Toolbar mAddress_add_bar;
    @BindView(R.id.add_address_back_img)
    ImageView mAdd_address_back_img;

    @BindView(R.id.save_address_tv)
    TextView mSave_address_tv;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__address__add);
        ButterKnife.bind(this);
        mAdd_address_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSave_address_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
