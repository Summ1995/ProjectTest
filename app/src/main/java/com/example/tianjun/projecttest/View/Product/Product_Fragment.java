package com.example.tianjun.projecttest.View.Product;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Product.Procuct_ListAdapter;
import com.example.tianjun.projecttest.Adapter.Product.Product_HeadViewPager;
import com.example.tianjun.projecttest.Bean.Product.Product_Head_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Tab_Gson;
import com.example.tianjun.projecttest.CustomerView.DontMoveViewPager;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vcc on 2016/9/6.
 */
public class Product_Fragment extends Fragment {

    @BindView(R.id.product_tab_menu)
    RecyclerView mRecyclerView;
    @BindView(R.id.product_resfreshlistview)
    PullToRefreshListView mPullToRefreshListView;

    ViewPager mHead_ViewPager;
    ImageView mSeckill_img;
    ImageView mHot_img;
    ImageView mRecommend_img;
    RecyclerView mPopularity_view;

    private int page_num = 20;
    private int page = 1;

    private View mHeadView;
    private List<Product_Head_Gson.InfoBean.ItemsBean> mViewPager_List;
    private List<Product_List_Gson.InfoBean.GoodsBean> goods;
    private List<Product_List_Gson.InfoBean.GoodsBean> listGoods=new ArrayList<>();
    private List<Product_Head_Gson.InfoBean.RecommendBean> mRecommend;
    private Product_HeadViewPager mProduct_headViewPager;
    private Procuct_ListAdapter mProcuct_listAdapter;
    private ImageView mPrefecture_img;
    private List<Product_Head_Gson.InfoBean.GoodsListBean> mGoods_list;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    private Context mContext;
    private List<Product_Tab_Gson.InfoBean> title = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();
    private PopularityAdapter popularityAdapter;
    private List<Fragment> listFragment=new ArrayList<>();

    public static Product_Fragment newInstance() {
        Product_Fragment product_fragment = new Product_Fragment();
        return product_fragment;
    }

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mPullToRefreshListView.onRefreshComplete();
            mProcuct_listAdapter.notifyDataSetChanged();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_fragment, container, false);
        ButterKnife.bind(this, view);
        initTab();
        addHead();
        initDatas();
        return view;
    }

    private void initTab() {
        //recylceView 的布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * 获取数据
     */
    private void initDatas() {
        //头部tab数据获取
        HttpRequest.getHttpService().openProductTabGsonCall().enqueue(new Callback<Product_Tab_Gson>() {
            @Override
            public void onResponse(Call<Product_Tab_Gson> call, Response<Product_Tab_Gson> response) {
                resultTab(response.body());
            }

            @Override
            public void onFailure(Call<Product_Tab_Gson> call, Throwable t) {

            }
        });
        //头部数据获取
        HttpRequest.getHttpService().openProductHeadGsonCall().enqueue(new Callback<Product_Head_Gson>() {
            @Override
            public void onResponse(Call<Product_Head_Gson> call, Response<Product_Head_Gson> response) {
                headResult(response.body());
            }

            @Override
            public void onFailure(Call<Product_Head_Gson> call, Throwable t) {

            }
        });
        //主体list数据获取
        HttpRequest.getHttpService().openProductListGsonCall( page_num, page).enqueue(new Callback<Product_List_Gson>() {
            @Override
            public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                listResult(response.body());
            }

            @Override
            public void onFailure(Call<Product_List_Gson> call, Throwable t) {

            }
        });
    }

    public void resultTab(Product_Tab_Gson product_tab_gson) {
        title = product_tab_gson.getInfo();
        for (int i = 0; i < title.size(); i++) {
            listTitle.add(title.get(i).getCat_name());
        }
        listTitle.add("▼");
        popularityAdapter = new PopularityAdapter();
        mRecyclerView.setAdapter(popularityAdapter);

    }

    /**
     * 为PullrefreshGridView添加头部视图
     */
    public void addHead() {
        mHeadView = LayoutInflater.from(mContext).inflate(R.layout.product_head, null);
        initHeadView(mHeadView);
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshListView.getRefreshableView().addHeaderView(mHeadView);
    }

    /**
     * 头部视图的初始化操作
     * @param headView
     */
    private void initHeadView(View headView) {
        mHead_ViewPager = (ViewPager) headView.findViewById(R.id.head_viewpager);
        mSeckill_img = (ImageView) headView.findViewById(R.id.seckill_img);
        mPrefecture_img = (ImageView) headView.findViewById(R.id.prefecture_img);
        mHot_img = (ImageView) headView.findViewById(R.id.hot_img);
        mRecommend_img = (ImageView) headView.findViewById(R.id.recommend_img);

        mPopularity_view = (RecyclerView) headView.findViewById(R.id.popularity_view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mPopularity_view.setLayoutManager(linearLayoutManager);
    }


    public void listResult(Product_List_Gson product_list_gson) {
        goods = product_list_gson.getInfo().getGoods();
        listGoods.addAll(goods);
        mProcuct_listAdapter = new Procuct_ListAdapter(mContext,listGoods);
        mPullToRefreshListView.setAdapter(mProcuct_listAdapter);
        //上下拉刷新视图
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                HttpRequest.getHttpService().openProductListGsonCall( page_num, page).enqueue(new Callback<Product_List_Gson>() {
                    @Override
                    public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                        goods= response.body().getInfo().getGoods();
                        listGoods.clear();
                        listGoods.addAll(goods);
                        if (listGoods!=null){
                            handler.sendEmptyMessage(1);
                        }
                    }
                    @Override
                    public void onFailure(Call<Product_List_Gson> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                HttpRequest.getHttpService().openProductListGsonCall( page_num, page).enqueue(new Callback<Product_List_Gson>() {
                    @Override
                    public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                        goods = response.body().getInfo().getGoods();
                        listGoods.addAll(goods);
                        if (goods!=null){
                            handler.sendEmptyMessage(1);
                        }
                    }

                    @Override
                    public void onFailure(Call<Product_List_Gson> call, Throwable t) {

                    }
                });
            }
        });
    }

    /**
     * 对主体数据的接受处理
     * @param product_head_gson
     */
    public void headResult(Product_Head_Gson product_head_gson) {
        mViewPager_List = product_head_gson.getInfo().getItems();
        mRecommend = product_head_gson.getInfo().getRecommend();
        mGoods_list = product_head_gson.getInfo().getGoods_list();

        Picasso.with(mContext).load(mRecommend.get(0).getCat_image()).into(mSeckill_img);
        Picasso.with(mContext).load(mRecommend.get(1).getCat_image()).into(mPrefecture_img);
        Picasso.with(mContext).load(mRecommend.get(2).getCat_image()).into(mHot_img);
        Picasso.with(mContext).load(mRecommend.get(3).getCat_image()).into(mRecommend_img);

        mProduct_headViewPager = new Product_HeadViewPager(mContext,mViewPager_List);
        mHead_ViewPager.setAdapter(mProduct_headViewPager);

        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mPopularity_view.setAdapter(mRecyclerViewAdapter);
    }


    class RecyclerViewViewHolder extends RecyclerView.ViewHolder{
        public ImageView mRecylerview_title_img;
        public TextView mTitle_img_num,mGoods_english_name_tv,mGoods_name_tv,mCurrency_price_tv;
        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            mRecylerview_title_img= (ImageView) itemView.findViewById(R.id.recylerview_title_img);
            mTitle_img_num= (TextView) itemView.findViewById(R.id.title_img_num);
            mGoods_english_name_tv= (TextView) itemView.findViewById(R.id.goods_english_name_tv);
            mCurrency_price_tv= (TextView) itemView.findViewById(R.id.currency_price_tv);
        }
    }

    /**
     * 人气推荐的RecyclerView适配器
     */
    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder>{

        @Override
        public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(mContext).inflate(R.layout.prodduct_head_recylerview,parent,false);
            RecyclerViewViewHolder recyclerViewViewHolder=new RecyclerViewViewHolder(view);
            return recyclerViewViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
            holder.mGoods_english_name_tv.setText(mGoods_list.get(position).getGoods_english_name()+" "+mGoods_list.get(position).getGoods_name());
            holder.mCurrency_price_tv.setText(mGoods_list.get(position).getCurrency_price());
            holder.mTitle_img_num.setText(position+"");

            String url=mGoods_list.get(position).getGoods_thumb();
            Picasso.with(mContext).load(url).into(holder.mRecylerview_title_img);

        }

        @Override
        public int getItemCount() {
            return mGoods_list==null?0:mGoods_list.size();
        }
    }
    /**
     * 头部tab 的适配器
     */
    class PopularityAdapter extends RecyclerView.Adapter<PopularityViewHolder> {
        @Override
        public PopularityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_tab_recylerview, parent, false);
            PopularityViewHolder popularityViewHolder = new PopularityViewHolder(view);
            return popularityViewHolder;
        }

        @Override
        public void onBindViewHolder(PopularityViewHolder holder, int position) {
            String type = listTitle.get(position);
            holder.textView.setText(type);
        }

        @Override
        public int getItemCount() {
            return listTitle == null ? 0 : listTitle.size();
        }
    }


    class PopularityViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        public PopularityViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tab_tv);
        }
    }
}
