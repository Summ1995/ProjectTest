package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

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
    private String catId;
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
        gridView.setMode(PullToRefreshBase.Mode.BOTH);
        mContext=this;
        initDaras();

    }

    private void initDaras() {
        catId = getIntent().getStringExtra("catId");
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
        mGoods=goodsBeen;
        mGoodsList.addAll(mGoods);
        gridInfo_gridViewAdapter = new GridInfo_GridViewAdapter(mContext,mGoodsList);
        gridView.setAdapter(gridInfo_gridViewAdapter);
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
