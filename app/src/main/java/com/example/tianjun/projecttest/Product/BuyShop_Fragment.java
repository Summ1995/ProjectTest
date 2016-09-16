package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianjun.projecttest.Adapter.Product.BuyShop_ListViewAdapter;
import com.example.tianjun.projecttest.Bean.Product.BuyShop_Gson;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vcc on 2016/9/12.
 */
public class BuyShop_Fragment extends Fragment {
    private int windowWidth;
    private PullToRefreshListView pullToRefreshListView;
    private BuyShop_Gson mBody;
    private Context mContext;
    private BuyShop_ListViewAdapter buyShop_listViewAdapter;

    public static BuyShop_Fragment newInstance(int width) {
        BuyShop_Fragment buyShop_Fragment = new BuyShop_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("windowWidth", width);
        buyShop_Fragment.setArguments(bundle);
        return buyShop_Fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.buyshop_fragment,container,false);
        Bundle bundle=getArguments();
        windowWidth=bundle.getInt("windowWidth");
        pullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.buyshop_listview);
        initDatas();
        return view;
    }

    private void initDatas() {
        HttpRequest.getHttpService().openBuyShopGsonCall().enqueue(new Callback<BuyShop_Gson>() {

            @Override
            public void onResponse(Call<BuyShop_Gson> call, Response<BuyShop_Gson> response) {
                mBody = response.body();
                buyShop_listViewAdapter = new BuyShop_ListViewAdapter(mContext,mBody,windowWidth);
                pullToRefreshListView.setAdapter(buyShop_listViewAdapter);
            }

            @Override
            public void onFailure(Call<BuyShop_Gson> call, Throwable t) {

            }
        });
    }




}
