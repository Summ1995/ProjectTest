package com.example.tianjun.projecttest.Me;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.SQLite.Product.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vcc on 2016/9/17.
 */
public class Me_Collect_Product_Fragment extends Fragment {

    GridView mGridView;
    private Context mContext;
    private List<Product> productList = new ArrayList<>();
    private int windowWidth;

    public static Me_Collect_Product_Fragment newInstance(int width) {
        Me_Collect_Product_Fragment me_collect_product_fragment = new Me_Collect_Product_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("windowWidth", width);
        me_collect_product_fragment.setArguments(bundle);
        return me_collect_product_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        Bundle bundle = getArguments();
        windowWidth = bundle.getInt(("windowWidth"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collect_prodcut_fragment, container, false);
        mGridView = (GridView) view.findViewById(R.id.collect_product_grid);
        GridViewAdapter gridViewAdapter = new GridViewAdapter();
        mGridView.setAdapter(gridViewAdapter);
        return view;
    }

    class GridViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return productList == null ? 0 : productList.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            Collect_ViewHolders collect_viewHolders = null;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.collect_product_fragment_grid, parent, false);
                collect_viewHolders = new Collect_ViewHolders(view);
                view.setTag(collect_viewHolders);
            } else {
                collect_viewHolders = (Collect_ViewHolders) view.getTag();
            }
            Product product = productList.get(position);
            collect_viewHolders.mBrand_tv.setText(product.getGoods_english_name());
            collect_viewHolders.mProductname_tv.setText(product.getGoods_name());

            collect_viewHolders.mNowprice_tv.setText(product.getShop_price());

            String url = product.getThumb();

            collect_viewHolders.mHeart_check.setOnCheckedChangeListener(onCheckedChangeListener);


            ViewGroup.LayoutParams layoutParams = collect_viewHolders.mTitle_img.getLayoutParams();
            layoutParams.height = windowWidth / 2;
            collect_viewHolders.mTitle_img.setLayoutParams(layoutParams);

            Picasso.with(mContext).load(url).into(collect_viewHolders.mTitle_img);

            return view;
        }


        private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(mContext, "+5积分", Toast.LENGTH_SHORT).show();
                } else if (!isChecked) {
                    Toast.makeText(mContext, "取消收藏成功", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    class Collect_ViewHolders {
        public ImageView mTitle_img;
        public TextView mBrand_tv, mProductname_tv, mNowprice_tv, mOldprice_tv;
        private CheckBox mHeart_check;

        public Collect_ViewHolders(View view) {
            mTitle_img = (ImageView) view.findViewById(R.id.collect_product_title_img);
            mBrand_tv = (TextView) view.findViewById(R.id.collect_product_brand_tv);
            mProductname_tv = (TextView) view.findViewById(R.id.collect_product_productname_tv);
            mNowprice_tv = (TextView) view.findViewById(R.id.collect_product_nowprice_tv);
            mOldprice_tv = (TextView) view.findViewById(R.id.collect_product_nowprice_tv);
            mHeart_check = (CheckBox) view.findViewById(R.id.collect_product_heart_check);
        }

    }
}
