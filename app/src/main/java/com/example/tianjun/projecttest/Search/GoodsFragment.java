package com.example.tianjun.projecttest.Search;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianjun.projecttest.Adapter.Product.GridInfo_GridViewAdapter;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Product.Product_GridInfo_Gson;
import com.example.tianjun.projecttest.CustomerView.RefreshFragment;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xx on 2016/9/18.
 */
public class GoodsFragment extends RefreshFragment implements PullToRefreshBase.OnRefreshListener2 {
    private PullToRefreshGridView mSearchGoods;
    private String mKey;
    private Context mContext;
    private List<Product_GridInfo_Gson.InfoBean.GoodsBean> mGoodsList;
    private GridInfo_GridViewAdapter mSearchGoodsAdapter;
    private int mPage = 1;

    public static GoodsFragment newInstance(String key){
        return new GoodsFragment(key);
    }

    private GoodsFragment(String key){
        mKey = key;
    }

    public GoodsFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mGoodsList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_goods, container, false);
        mSearchGoods = (PullToRefreshGridView)view.findViewById(R.id.search_goods_grid);
        initView();
        return view;
    }

    private void initView() {
        mSearchGoodsAdapter = new GridInfo_GridViewAdapter(mContext,mGoodsList);
        mSearchGoods.setAdapter(mSearchGoodsAdapter);
        mSearchGoods.setMode(PullToRefreshBase.Mode.BOTH);
        mSearchGoods.setOnRefreshListener(this);

        mPage = 1;
        if (mGoodsList == null || mGoodsList.size() == 0){
            requestData(true);
        }
    }

    private void requestData(final Boolean isRefresh){
        String strPage = String.valueOf(mPage);
        HttpRequest.getHttpService().querySearchGoods(strPage,mKey).enqueue(new Callback<Product_GridInfo_Gson>() {
            @Override
            public void onResponse(Call<Product_GridInfo_Gson> call, Response<Product_GridInfo_Gson> response) {
                if (isRefresh){
                    mGoodsList.clear();
                    mGoodsList.addAll(response.body().getInfo().getGoods());
                }else {
                    mGoodsList.addAll(response.body().getInfo().getGoods());
                }
                updateGridData.sendEmptyMessage(1);
            }

            @Override
            public void onFailure(Call<Product_GridInfo_Gson> call, Throwable t) {

            }
        });

    }

    private Handler updateGridData = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mSearchGoodsAdapter.notifyDataSetChanged();
            mSearchGoods.onRefreshComplete();
        }
    };

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        mPage = 1;
        requestData(true);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        mPage++;
        requestData(false);
    }

    @Override
    public void refreshView(String key) {
        mKey = key;
        mPage = 1;
        requestData(true);
    }
}
