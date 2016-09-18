package com.example.tianjun.projecttest.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Integral extends AppCompatActivity {
    @BindView(R.id.info_wb)
    WebView mInfo_wb;
    @BindView(R.id.integral_back_img)
    ImageView integral_back_img;
    private final static String phpUrl="http://www.fulishe.com/integral_rule.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__integral);
        ButterKnife.bind(this);
        mInfo_wb.loadUrl(phpUrl);
        WebSettings settings = mInfo_wb.getSettings();
        settings.setJavaScriptEnabled(true);
        mInfo_wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
        integral_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
