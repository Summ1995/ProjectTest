package com.example.tianjun.projecttest.View.Product;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.Product_Tab_Gson;
import com.example.tianjun.projecttest.CustomerView.DontMoveViewPager;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;

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
    @BindView(R.id.fragment_viewpager)
    DontMoveViewPager mDontMoveViewPager;

    private Context mContext;
    private List<Product_Tab_Gson.InfoBean> title = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();
    private PopularityAdapter popularityAdapter;
    private ProductViewPagerAdapter productViewPagerAdapter;
    private List<Fragment> listFragment=new ArrayList<>();

    public static Product_Fragment newInstance() {
        Product_Fragment product_fragment = new Product_Fragment();
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
        ButterKnife.bind(this, view);
        initTab();
        initFragment();
        initDatas();
        return view;
    }

    private void initFragment() {
        listFragment.add(Product_All_Fragment.newInstance());
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
        HttpRequest.getHttpService().openProductTabGsonCall().enqueue(new Callback<Product_Tab_Gson>() {
            @Override
            public void onResponse(Call<Product_Tab_Gson> call, Response<Product_Tab_Gson> response) {
                resultTab(response.body());
            }

            @Override
            public void onFailure(Call<Product_Tab_Gson> call, Throwable t) {

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
        productViewPagerAdapter = new ProductViewPagerAdapter(getChildFragmentManager());
        mDontMoveViewPager.setAdapter(productViewPagerAdapter);
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
    /**
     * 单品viewpager的主体适配器
     */
    class ProductViewPagerAdapter extends FragmentPagerAdapter{
        public ProductViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment==null?0:listFragment.size();
        }

//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
    }
}
