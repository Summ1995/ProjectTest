package com.example.tianjun.projecttest.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tianjun.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Me_SetPssWord extends AppCompatActivity {

   @BindView(R.id.setpassword_back_img)
    ImageView mSetpassword_back_img;
    @BindView(R.id.set_put_button)
    Button set_put_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me__set_pss_word);
        ButterKnife.bind(this);
        mSetpassword_back_img.setOnClickListener(clickListener);
        set_put_button.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.setpassword_back_img:
                    finish();
                    break;
                case R.id.set_put_button:
                    Toast.makeText(Me_SetPssWord.this, "修改完成", Toast.LENGTH_SHORT).show();
                    finish();
            }
           finish();
        }
    };
}
