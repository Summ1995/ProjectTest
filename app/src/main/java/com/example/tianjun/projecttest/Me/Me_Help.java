package com.example.tianjun.projecttest.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_Help extends AppCompatActivity {

    @BindView(R.id.help_back_img)
    ImageView mHelp_back_img;
    @BindView(R.id.help_et)
    EditText mHelp_et;
    @BindView(R.id.put_button)
    Button mPut_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__help);
        ButterKnife.bind(this);
        mHelp_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.help_back_img:
                    finish();
                    break;
                case R.id.put_button:
                    String info=mHelp_et.getText().toString();
                    break;
            }
        }
    };
}
