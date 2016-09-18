package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianjun.projecttest.Adapter.Product.BuyShop_Info_GridAdapter;
import com.example.tianjun.projecttest.Adapter.Product.BuyShop_Info_ListAdapter;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_Grid_Gson;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_Title_Gson;
import com.example.tianjun.projecttest.CustomerView.MyGridView;
import com.example.tianjun.projecttest.CustomerView.MyListView;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.example.tianjun.projecttest.Util.HttpService;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyShop_Info extends AppCompatActivity {
    private String shop_id;
    private String shop_name;
    private BuyShop_Info_Title_Gson.InfoBean mInfo;
    private List<BuyShop_Info_Grid_Gson.InfoBean.GoodsBean> mGridgoods;
    private Context mContext;
    private Fragment[] fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private WindowManager windowManager;

    private List<BuyShop_Info_List_Gson.InfoBean> mListinfo;

    //fragment1部分的部件初始化
    @BindView(R.id.fragment1_gridview)
    MyGridView mFragment1_gridview;

    //fragment2部分的部件初始化
    @BindView(R.id.topic_list)
    MyListView mTopic_list;
    @BindView(R.id.fragment2_gridview)
    MyGridView mFragment2_gridview;

    //主体标题部分的初始化
    @BindView(R.id.bar_title_tv)
    TextView mBar_title_tv;
    @BindView(R.id.bar)
    Toolbar mBar;
    @BindView(R.id.shop_img)
    ImageView mShop_img;
    @BindView(R.id.title_tv)
    TextView mTitle_tv;
    @BindView(R.id.title_info)
    TextView mTitle_info;
    @BindView(R.id.focus_tv)
    TextView mFocus_tv;
    @BindView(R.id.shop_Info_tv)
    TextView mShop_Info_tv;
    private int width;
    private BuyShop_Info_GridAdapter buyShop_info_gridAdapter;
    private BuyShop_Info_ListAdapter buyShop_info_listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_shop__info);
        ButterKnife.bind(this);
        mContext = this;
        initFragment();
        initDatas();
        mFocus_tv.setTag("0");
        mFocus_tv.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mFocus_tv.getTag().equals("0")){
                mFocus_tv.setText("已关注");
                mFocus_tv.setBackgroundColor(getResources().getColor(R.color.colorGrad));
                mFocus_tv.setTag("1");
            }else if (mFocus_tv.getTag().equals("1")){
                mFocus_tv.setText("关注");
                mFocus_tv.setBackgroundColor(getResources().getColor(R.color.colorTheme));
                mFocus_tv.setTag("0");
            }

        }
    };
    private void initFragment() {
        fragment = new Fragment[2];
        fragmentManager = getSupportFragmentManager();
        fragment[0] = fragmentManager.findFragmentById(R.id.fragment1);
        fragment[1] = fragmentManager.findFragmentById(R.id.fragment2);
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
    }

    /**
     * 网络请求获取数据
     */
    private void initDatas() {
        shop_id = getIntent().getStringExtra("shop_id");
        shop_name = getIntent().getStringExtra("shop_name");
        mBar_title_tv.setText(shop_name);
        windowManager = getWindowManager();
        width = windowManager.getDefaultDisplay().getWidth();

        //标题部分的数据
        HttpRequest.getHttpService().openBuyShopInfoTitleGsonCall(shop_id).enqueue(new Callback<BuyShop_Info_Title_Gson>() {

            @Override
            public void onResponse(Call<BuyShop_Info_Title_Gson> call, Response<BuyShop_Info_Title_Gson> response) {
                mInfo = response.body().getInfo();
                resultTitle();
                initListDatas();
            }

            @Override
            public void onFailure(Call<BuyShop_Info_Title_Gson> call, Throwable t) {

            }
        });
    }

    private void initListDatas() {
        //Gridview 的数据
        HttpRequest.getHttpService().openBuyShopInfoGridGsonCall(shop_id).enqueue(new Callback<BuyShop_Info_Grid_Gson>() {
            @Override
            public void onResponse(Call<BuyShop_Info_Grid_Gson> call, Response<BuyShop_Info_Grid_Gson> response) {
                mGridgoods = response.body().getInfo().getGoods();
                gridInfoResult();
            }

            @Override
            public void onFailure(Call<BuyShop_Info_Grid_Gson> call, Throwable t) {
                Toast.makeText(BuyShop_Info.this, "加载失败", Toast.LENGTH_SHORT).show();
            }
        });

        //ListView 的数据
        HttpRequest.getHttpService().openBuyShopInfoListGsonCall(shop_id).enqueue(new Callback<BuyShop_Info_List_Gson>() {


            @Override
            public void onResponse(Call<BuyShop_Info_List_Gson> call, Response<BuyShop_Info_List_Gson> response) {
                mListinfo = response.body().getInfo();
                listInfoResult();
            }
            @Override
            public void onFailure(Call<BuyShop_Info_List_Gson> call, Throwable t) {

            }
        });
    }

    private void listInfoResult() {
        buyShop_info_listAdapter = new BuyShop_Info_ListAdapter(mListinfo,mContext);
        mTopic_list.setAdapter(buyShop_info_listAdapter);
    }


    private void gridInfoResult() {
        buyShop_info_gridAdapter = new BuyShop_Info_GridAdapter(mContext, mGridgoods, width);
        mFragment1_gridview.setAdapter(buyShop_info_gridAdapter);
        mFragment2_gridview.setAdapter(buyShop_info_gridAdapter);
    }

    private void resultTitle() {
        Picasso.with(mContext).load(mInfo.getAvatar()).into(mShop_img);
        mTitle_tv.setText(mInfo.getShop_name());
        mTitle_info.setText(mInfo.getGoods_count() + "个单品" + mInfo.getTopic_count() + "个专题");
        mShop_Info_tv.setText(mInfo.getDescription());
        if (mInfo.getTopic_count().equals("0")) {
            fragmentTransaction.show(fragment[0]).commit();
        } else {
            fragmentTransaction.show(fragment[1]).commit();
        }
    }
}
