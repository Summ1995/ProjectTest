package com.example.tianjun.projecttest.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Info_Config extends AppCompatActivity {

    @BindView(R.id.me_info_back_img)
    ImageView me_info_back_img;
    @BindView(R.id.add_info_tv)
    TextView add_info_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__info__config);
        ButterKnife.bind(this);
        me_info_back_img.setOnClickListener(clickListener);
        add_info_tv.setOnClickListener(clickListener);

    }
   private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add_info_tv:
                    break;
                case R.id.me_info_back_img:
                    finish();
                    break;
            }
        }
    };
}
