package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Product.GridInfo_GridViewAdapter;
import com.example.tianjun.projecttest.Bean.Product.Product_GridInfo_Gson;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product_GridInfo extends AppCompatActivity {
    private PullToRefreshGridView gridView;
    private ImageView gridInfo_back_img;
    private TextView GridInfo_title_tv;
    private String catId;
    private String name;
    private int page = 1;
    private Context mContext;
    private GridInfo_GridViewAdapter gridInfo_gridViewAdapter;
    private List<Product_GridInfo_Gson.InfoBean.GoodsBean> mGoodsList=new ArrayList<>();
    private List<Product_GridInfo_Gson.InfoBean.GoodsBean> mGoods=new ArrayList<>();


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            gridView.onRefreshComplete();
            gridInfo_gridViewAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product__grid_info);
        gridView= (PullToRefreshGridView) findViewById(R.id.grid_info);
        gridInfo_back_img= (ImageView) findViewById(R.id.gridInfo_back_img);
        gridInfo_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        GridInfo_title_tv= (TextView) findViewById(R.id.GridInfo_title_tv);
        gridView.setMode(PullToRefreshBase.Mode.BOTH);
        mContext=this;
        initDaras();

    }

    private void initDaras() {
        catId = getIntent().getStringExtra("catId");
        name=getIntent().getStringExtra("name");
        GridInfo_title_tv.setText(name);
        HttpRequest.getHttpService().openProductGridInfoGsonCall(catId, page).enqueue(new Callback<Product_GridInfo_Gson>() {
            @Override
            public void onResponse(Call<Product_GridInfo_Gson> call, Response<Product_GridInfo_Gson> response) {
                result(response.body().getInfo().getGoods());
            }

            @Override
            public void onFailure(Call<Product_GridInfo_Gson> call, Throwable t) {

            }
        });
    }
    public void result(List<Product_GridInfo_Gson.InfoBean.GoodsBean> goodsBeen){
        WindowManager windowManager=getWindowManager();
        int width=windowManager.getDefaultDisplay().getWidth();
        mGoods=goodsBeen;
        mGoodsList.addAll(mGoods);
        gridInfo_gridViewAdapter = new GridInfo_GridViewAdapter(mContext,mGoodsList,width);
        gridView.setAdapter(gridInfo_gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String goods_id = mGoods.get(position).getGoods_id();
                Intent intent=new Intent();
                intent.putExtra("goods_id",goods_id);
                intent.setClass(mContext,Product_Info.class);
                startActivity(intent);
            }
        });

        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                page=1;
                HttpRequest.getHttpService().openProductGridInfoGsonCall(catId, page).enqueue(new Callback<Product_GridInfo_Gson>() {
                    @Override
                    public void onResponse(Call<Product_GridInfo_Gson> call, Response<Product_GridInfo_Gson> response) {
                        mGoods=response.body().getInfo().getGoods();
                        mGoodsList.clear();
                        mGoodsList.addAll(mGoods);
                        if (mGoodsList!=null){
                            handler.sendEmptyMessage(1);
                        }
                    }

                    @Override
                    public void onFailure(Call<Product_GridInfo_Gson> call, Throwable t) {

                    }
                });
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                page++;
                HttpRequest.getHttpService().openProductGridInfoGsonCall(catId, page).enqueue(new Callback<Product_GridInfo_Gson>() {

                    @Override
                    public void onResponse(Call<Product_GridInfo_Gson> call, Response<Product_GridInfo_Gson> response) {
                        mGoods=response.body().getInfo().getGoods();
                        mGoodsList.addAll(mGoods);
                        if (mGoods!=null){
                            handler.sendEmptyMessage(1);
                        }
                    }

                    @Override
                    public void onFailure(Call<Product_GridInfo_Gson> call, Throwable t) {

                    }
                });
            }
        });
    }

}
