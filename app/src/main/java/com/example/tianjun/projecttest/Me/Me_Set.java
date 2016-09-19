package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Set extends AppCompatActivity {
    @BindView(R.id.set_back_img)
    ImageView mSet_back_img;
    @BindView(R.id.set_password_rl)
    RelativeLayout mSet_password_rl;
    @BindView(R.id.clean_info_rl)
    RelativeLayout mClean_info_rl;
    @BindView(R.id.size_tv)
    TextView mSize_tv;
    @BindView(R.id.outLog_rl)
    RelativeLayout mOutLog_rl;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__set);
        ButterKnife.bind(this);
        mContext=this;

        //获取文件缓存
        try {
            long folderSize =CleanManager.getFolderSize(this.getCacheDir()) ;
            String size= CleanManager.getFormatSize(folderSize);
            if (folderSize==0){
                mSize_tv.setText("缓存已清空");
            }else {
                mSize_tv.setText(size);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        mClean_info_rl.setOnClickListener(clickListener);
        mSet_password_rl.setOnClickListener(clickListener);
        mSet_back_img.setOnClickListener(clickListener);
        mOutLog_rl.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.set_back_img:
                    finish();
                    break;
                case R.id.set_password_rl:
                    Intent intent=new Intent();
                    intent.setClass(mContext,Me_SetPssWord.class);
                    startActivity(intent);
                    break;
                case R.id.clean_info_rl:
                    CleanManager.cleanInternalCache(mContext);
                    CleanManager.cleanExternalCache(mContext);
                    mSize_tv.setText("缓存已清空");
                    break;
                case R.id.outLog_rl:
                    finish();
                    break;
            }
        }
    };
}
