package com.example.tianjun.projecttest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tianjun.projecttest.Bean.Welcome.WelcomeBean;
import com.example.tianjun.projecttest.CustomerView.CustomerAppCompatActivity;
import com.example.tianjun.projecttest.Present.Welcome.IWelcomePresent;
import com.example.tianjun.projecttest.Present.Welcome.WelcomePresent;
import com.example.tianjun.projecttest.View.Welcome.IWelcomeView;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends CustomerAppCompatActivity implements IWelcomeView{
    @BindView(R.id.welcome_img)
    ImageView mWelcomeImg;
    @BindView(R.id.welcome_jump_btn)
    Button mJumpBtn;

    private int jumpNumber = 3;
    private int time = 0;
    private Bitmap mBitmap;
    private boolean isHelp = true;
    private boolean isJump = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    private void init() {
        IWelcomePresent iWelcomePresent = new WelcomePresent(this);
        ButterKnife.bind(this);
        iWelcomePresent.requestWelcomeData();
    }

    @Override
    public void getWelComeData(final WelcomeBean.InfoBean infoBean) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mBitmap = Picasso.with(WelcomeActivity.this).load(infoBean.getBanner_image().getImg_1()).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        helpHandler.sendEmptyMessageDelayed(2,1000);
    }

    private Handler jumpHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (!isJump){
                if (jumpNumber == 1){
                    jumpAcrivity();
                    return;
                }
                jumpNumber--;
                mJumpBtn.setText("跳过(" + String.valueOf(jumpNumber) + ")");
                jumpHandler.sendEmptyMessageDelayed(1,1000);
            }
        }
    };

    private void jumpAcrivity(){
        isJump = true;
        jumpHandler.removeMessages(1);
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    private Handler helpHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (isHelp){
                if (time >=2 && mBitmap != null){
                    isHelp = false;
                    mWelcomeImg.setImageBitmap(mBitmap);
                    mJumpBtn.setVisibility(View.VISIBLE);
                    mJumpBtn.setText("跳过(" + String.valueOf(jumpNumber) + ")");
                    mJumpBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            jumpAcrivity();
                        }
                    });
                    jumpHandler.sendEmptyMessageDelayed(1,1000);
                }
                time++;
                helpHandler.sendEmptyMessageDelayed(2,1000);

            }
        }
    };
}
