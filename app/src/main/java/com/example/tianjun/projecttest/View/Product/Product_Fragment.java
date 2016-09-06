package com.example.tianjun.projecttest.View.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.View.Product.Gson.Product_Head_Gson;
import com.example.tianjun.projecttest.View.Product.Gson.Product_Tab_Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vcc on 2016/9/6.
 */
public class Product_Fragment extends Fragment {

    @BindView(R.id.product_tab_menu)
    RecyclerView mRecyclerView;
    @BindView(R.id.product_resfreshlistview)
    PullToRefreshGridView mPullToRefreshGridView;

    @BindView(R.id.head_viewpager)
    ViewPager mHead_ViewPager;
    @BindView(R.id.seckill_img)
    ImageView mSeckill_img;
    @BindView(R.id.hot_img)
    ImageView mHot_img;
    @BindView(R.id.recommend_img)
    ImageView mRecommend_img;
    @BindView(R.id.popularity_view)
    RecyclerView mPopularity_view;


    private Context mContext;
    private View mHeadView;
    private List<Product_Tab_Gson.InfoBean> title=new ArrayList<>();
    private List<String> listTitle=new ArrayList<>();
    private PopularityAdapter popularityAdapter;
    private List<Product_Head_Gson.InfoBean.ItemsBean> mViewPager_List;

    public static Product_Fragment newInstance(){
        Product_Fragment product_fragment=new Product_Fragment();
        return product_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_fragment, container, false);
        ButterKnife.bind(mContext, view);
//        initDatas();
        addHead(view);
        initTab();
        return view;
    }
//
//    private void initDatas() {
//        HttpRequest.getHttpService().openProductTabGsonCall().enqueue(new Callback<Product_Tab_Gson>() {
//            @Override
//            public void onResponse(Call<Product_Tab_Gson> call, Response<Product_Tab_Gson> response) {
//                resultTab(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Product_Tab_Gson> call, Throwable t) {
//
//            }
//        });
//        HttpRequest.getHttpService().openProductHeadGsonCall().enqueue(new Callback<Product_Head_Gson>() {
//            @Override
//            public void onResponse(Call<Product_Head_Gson> call, Response<Product_Head_Gson> response) {
//                headResult(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Product_Head_Gson> call, Throwable t) {
//
//            }
//        });
//    }

    public void headResult(Product_Head_Gson product_head_gson){
        mViewPager_List = product_head_gson.getInfo().getItems();
    }

    public void resultTab(Product_Tab_Gson product_tab_gson){
        title=product_tab_gson.getInfo();
        if (listTitle==null){
            for (int i = 0; i <title.size() ; i++) {
                listTitle.add(title.get(i).getCat_name());
            }
            listTitle.add("▼");
        }
        popularityAdapter = new PopularityAdapter();
        mRecyclerView.setAdapter(popularityAdapter);
    }

    /**
     * 为PullrefreshGridView添加头部视图
     * @param view
     */
    public void addHead(View view) {
        mHeadView = LayoutInflater.from(mContext).inflate(R.layout.product_head, null);
        initHeadView(mHeadView);
        mPullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshGridView.getRefreshableView().addView(mHeadView);
    }

    /**
     * 头部视图的初始化操作
     * @param headView
     */
    private void initHeadView(View headView) {
        ButterKnife.bind(mContext,headView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPopularity_view.setLayoutManager(linearLayoutManager);
    }
    private void initTab() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

    }

    /**
     * 头部tab 的适配器
     */
    class PopularityAdapter extends RecyclerView.Adapter<PopularityViewHolder>{


        @Override
        public PopularityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view=LayoutInflater.from(mContext).inflate(R.layout.product_tab_recylerview,parent,false);
            PopularityViewHolder popularityViewHolder=new PopularityViewHolder(view);
            return popularityViewHolder;
        }

        @Override
        public void onBindViewHolder(PopularityViewHolder holder, int position) {
            String type=listTitle.get(position);
            holder.textView.setText(type);
        }

        @Override
        public int getItemCount() {
            return listTitle==null?0:listTitle.size();
        }
    }
    class PopularityViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public PopularityViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tab_tv);
        }
    }
}
