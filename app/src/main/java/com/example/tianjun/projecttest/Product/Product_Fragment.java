package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Product.Procuct_ListAdapter;
import com.example.tianjun.projecttest.Adapter.Product.Product_HeadViewPager;
import com.example.tianjun.projecttest.Bean.Product.Product_Head_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Tab_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Type_Gson;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import q.rorbin.verticaltablayout.TabAdapter;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.QTabView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vcc on 2016/9/8.
 */
public class Product_Fragment extends Fragment {
    @BindView(R.id.product_tab_menu)
    TabLayout mTabLayout;
    @BindView(R.id.product_resfreshlistview)
    PullToRefreshListView mPullToRefreshListView;
    @BindView(R.id.choosetype_rg)
    RadioGroup mChoosetype_rg;
    @BindView(R.id.type_gridview)
    GridView mType_gridview;
    private TypeGridView typeGridView;


    ViewPager mHead_ViewPager;
    ImageView mSeckill_img;
    ImageView mHot_img;
    ImageView mRecommend_img;
    RecyclerView mPopularity_view;

    private int page_num = 20;
    private int page = 1;
    private String c_id = "0";

    private int num = 0;

    private View mHeadView;
    private List<Product_Head_Gson.InfoBean.ItemsBean> mViewPager_List;
    private List<Product_List_Gson.InfoBean.GoodsBean> goods;
    private List<Product_List_Gson.InfoBean.GoodsBean> listGoods = new ArrayList<>();
    private List<Product_Head_Gson.InfoBean.RecommendBean> mRecommend=new ArrayList<>();
    private Product_HeadViewPager mProduct_headViewPager;
    private Procuct_ListAdapter mProcuct_listAdapter;
    private ImageView mPrefecture_img;
    private List<Product_Head_Gson.InfoBean.GoodsListBean> mGoods_list=new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private Product_Type_Gson.InfoBean infoBean=new Product_Type_Gson.InfoBean();

    private Context mContext;
    private int windowWidth;
    private List<Product_Tab_Gson.InfoBean> title = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();
    private List<Product_Type_Gson.InfoBean> mInfo = new ArrayList<>();
    private Fragment[] fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public static Product_Fragment newInstance(int width) {
        Product_Fragment product_fragment = new Product_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("windowWidth", width);
        product_fragment.setArguments(bundle);
        return product_fragment;
    }

    Handler handler = new Handler() {
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
        Bundle bundle = getArguments();
        infoBean = new Product_Type_Gson.InfoBean();
        if (bundle != null) {
            windowWidth = bundle.getInt("windowWidth");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_fragment, container, false);
        ButterKnife.bind(this, view);
        initFragment();
        addHead();
        initDatas();
        listTyoeData();
        return view;
    }

    private void initFragment() {
        fragment = new Fragment[2];
        fragmentManager = getChildFragmentManager();
        fragment[0] = fragmentManager.findFragmentById(R.id.body_fragment);
        fragment[1] = fragmentManager.findFragmentById(R.id.type_fragment);
        fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
        fragmentTransaction.show(fragment[0]).commit();
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
        HttpRequest.getHttpService().openProductListGsonCall(c_id, page_num, page).enqueue(new Callback<Product_List_Gson>() {
            @Override
            public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                listResult(response.body());
            }

            @Override
            public void onFailure(Call<Product_List_Gson> call, Throwable t) {

            }
        });
    }

    //点击TAB获得相应的主体list数据
    public void listData() {
        HttpRequest.getHttpService().openProductListGsonCall(c_id, page_num, page).enqueue(new Callback<Product_List_Gson>() {
            @Override
            public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                goods = response.body().getInfo().getGoods();
                listGoods.clear();
                listGoods.addAll(goods);
                mProcuct_listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Product_List_Gson> call, Throwable t) {

            }
        });
    }

    /**
     * 获取头部type详细分类的数据
     */
    public void listTyoeData() {
        HttpRequest.getHttpService().openProductTypeGsonCall().enqueue(new Callback<Product_Type_Gson>() {

            @Override
            public void onResponse(Call<Product_Type_Gson> call, Response<Product_Type_Gson> response) {
                mInfo = response.body().getInfo();

                typeGridView = new TypeGridView();
                mChoosetype_rg.setOnCheckedChangeListener(onCheckedChangeListener);
                mChoosetype_rg.check(R.id.rb1);
                mType_gridview.setAdapter(typeGridView);
                mType_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent();
                        intent.setClass(mContext,Product_GridInfo.class);
                        intent.putExtra("catId",infoBean.getCat_id().get(position).getId());
                        intent.putExtra("name",infoBean.getCat_id().get(position).getName());
                        mContext.startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Product_Type_Gson> call, Throwable t) {

            }
        });
    }

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb1:
                    num = 0;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb2:
                    num = 1;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb3:
                    num = 2;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb4:
                    num = 3;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb5:
                    num = 4;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb6:
                    num = 5;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb7:
                    num = 6;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
                case R.id.rb8:
                    num = 7;
                    infoBean = mInfo.get(num);
                    typeGridView.notifyDataSetChanged();
                    break;
            }
        }
    };


    /**
     * 头部tab数据的处理
     *
     * @param product_tab_gson
     */
    public void resultTab(Product_Tab_Gson product_tab_gson) {
        title = product_tab_gson.getInfo();
        for (int i = 0; i < title.size(); i++) {
            listTitle.add(title.get(i).getCat_name());
        }
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i <= listTitle.size(); i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            if (i == listTitle.size()) {
                tab.setIcon(R.drawable.arrow_index_down);
                tab.setTag(ConstantClz.HOME_TAB_CATEGORY_CODE);
            } else {
                tab.setText(listTitle.get(i));
                tab.setTag(title.get(i).getCat_id());
            }
            mTabLayout.addTab(tab);
        }

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String catId = tab.getTag().toString();
                c_id = catId;
                if (catId.equals(ConstantClz.HOME_TAB_CATEGORY_CODE)) {
                    tab.setIcon(R.drawable.arrow_red_up);
                    fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
                    fragmentTransaction.show(fragment[1]).commit();
                    tab.setTag("up");
                } else {
                    fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
                    fragmentTransaction.show(fragment[0]).commit();
                    listData();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                String catId = tab.getTag().toString();
                if (catId.equals("up")) {
                    tab.setIcon(R.drawable.arrow_index_down);
                    tab.setTag(ConstantClz.HOME_TAB_CATEGORY_CODE);
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                String catId = tab.getTag().toString();
                c_id = catId;
                if (catId.equals(ConstantClz.HOME_TAB_CATEGORY_CODE)) {
                    tab.setIcon(R.drawable.arrow_red_up);
                    fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
                    fragmentTransaction.show(fragment[1]).commit();
                    tab.setTag("up");

                } else if (catId.equals("up")) {
                    tab.setIcon(R.drawable.arrow_index_down);
                    tab.setTag(ConstantClz.HOME_TAB_CATEGORY_CODE);
                    fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]);
                    fragmentTransaction.show(fragment[0]).commit();
                } else {
                    listData();
                }

            }
        });
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
     *
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


    /**
     * 主体数据的处理
     *
     * @param product_list_gson
     */
    public void listResult(Product_List_Gson product_list_gson) {
        goods = product_list_gson.getInfo().getGoods();
        listGoods.addAll(goods);

        mProcuct_listAdapter = new Procuct_ListAdapter(mContext, listGoods, windowWidth);
        mPullToRefreshListView.setAdapter(mProcuct_listAdapter);
        mProcuct_listAdapter.notifyDataSetChanged();
        //上下拉刷新视图
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                HttpRequest.getHttpService().openProductListGsonCall(c_id, page_num, page).enqueue(new Callback<Product_List_Gson>() {
                    @Override
                    public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                        goods = response.body().getInfo().getGoods();
                        listGoods.clear();
                        listGoods.addAll(goods);
                        if (listGoods != null) {
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
                HttpRequest.getHttpService().openProductListGsonCall(c_id, page_num, page).enqueue(new Callback<Product_List_Gson>() {
                    @Override
                    public void onResponse(Call<Product_List_Gson> call, Response<Product_List_Gson> response) {
                        goods = response.body().getInfo().getGoods();
                        listGoods.addAll(goods);
                        if (goods != null) {
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
     *
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

        mSeckill_img.setOnClickListener(gridClickListener);
        mPrefecture_img.setOnClickListener(gridClickListener);
        mHot_img.setOnClickListener(gridClickListener);
        mRecommend_img.setOnClickListener(gridClickListener);


        mProduct_headViewPager = new Product_HeadViewPager(mContext, mViewPager_List, windowWidth);
        mHead_ViewPager.setAdapter(mProduct_headViewPager);

        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mPopularity_view.setAdapter(mRecyclerViewAdapter);
    }

    private View.OnClickListener gridClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.seckill_img:
                    String catId = mRecommend.get(0).getCat_id();
                    String name=mRecommend.get(0).getCat_name();
                    intent.putExtra("catId", catId);
                    intent.putExtra("name",name);
                    break;
                case R.id.prefecture_img:
                    String catId2 = mRecommend.get(1).getCat_id();
                    String name2=mRecommend.get(1).getCat_name();
                    intent.putExtra("catId", catId2);
                    intent.putExtra("name",name2);
                    break;
                case R.id.hot_img:
                    String catId3 = mRecommend.get(2).getCat_id();
                    String name3=mRecommend.get(2).getCat_name();
                    intent.putExtra("catId", catId3);
                    intent.putExtra("name",name3);
                    break;
                case R.id.recommend_img:
                    String catId4 = mRecommend.get(3).getCat_id();
                    String name4=mRecommend.get(3).getCat_name();
                    intent.putExtra("catId", catId4);
                    intent.putExtra("name",name4);
                    break;
            }
            intent.setClass(mContext, Product_GridInfo.class);
            startActivity(intent);

        }
    };





    //以下全是适配器部分
    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public ImageView mRecylerview_title_img;
        public TextView mTitle_img_num, mGoods_english_name_tv, mGoods_name_tv, mCurrency_price_tv;

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            mRecylerview_title_img = (ImageView) itemView.findViewById(R.id.recylerview_title_img);
            mTitle_img_num = (TextView) itemView.findViewById(R.id.title_img_num);
            mGoods_english_name_tv = (TextView) itemView.findViewById(R.id.goods_english_name_tv);
            mCurrency_price_tv = (TextView) itemView.findViewById(R.id.currency_price_tv);
        }
    }

    /**
     * 人气推荐的RecyclerView适配器
     */
    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {

        @Override
        public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.prodduct_head_recylerview, parent, false);
            RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
            return recyclerViewViewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewViewHolder holder, final int position) {
            holder.mGoods_english_name_tv.setText(mGoods_list.get(position).getGoods_english_name() + " " + mGoods_list.get(position).getGoods_name());
            holder.mCurrency_price_tv.setText(mGoods_list.get(position).getCurrency_price());
            holder.mTitle_img_num.setText((position +1)+ "");

            String url = mGoods_list.get(position).getGoods_thumb();
            Picasso.with(mContext).load(url).into(holder.mRecylerview_title_img);
            holder.mRecylerview_title_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(mContext,Product_Info.class);
                    intent.putExtra("goods_id",mGoods_list.get(position).getGoods_id());
                    mContext.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mGoods_list == null ? 0 : mGoods_list.size();
        }
    }


    class TypeGridView extends BaseAdapter {

        @Override
        public int getCount() {
            return infoBean.getCat_id() == null ? 0 : infoBean.getCat_id().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            GridViewHolder gridViewHolder = null;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.product_tpyelist_gridview, parent, false);
                gridViewHolder = new GridViewHolder(view);
                view.setTag(gridViewHolder);
            } else {
                gridViewHolder = (GridViewHolder) view.getTag();
            }
            gridViewHolder.mTextView.setText(infoBean.getCat_id().get(position).getName());
            Picasso.with(mContext).load(infoBean.getCat_id().get(position).getImageurl()).into(gridViewHolder.mImageView);

            return view;
        }
    }

    class GridViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public GridViewHolder(View view) {
            mImageView = (ImageView) view.findViewById(R.id.title_img);
            mTextView = (TextView) view.findViewById(R.id.title_tv);
        }
    }
}
