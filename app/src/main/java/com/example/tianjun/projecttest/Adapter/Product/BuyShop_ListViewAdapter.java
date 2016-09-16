package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.BuyShop_Gson;
import com.example.tianjun.projecttest.Product.BuyShop_Info;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

/**
 * Created by vcc on 2016/9/12.
 */
public class BuyShop_ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private BuyShop_Gson mBody;
    private int width;

    public BuyShop_ListViewAdapter(Context mContext, BuyShop_Gson mBody, int width) {
        this.mContext = mContext;
        this.mBody = mBody;
        this.width = width;
    }


    @Override
    public int getCount() {
        return mBody.getInfo() == null ? 0 : mBody.getInfo().size();
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
        BuyShopListViewHolder buyShopListViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.buyshop_fragment_listview, parent, false);
            buyShopListViewHolder = new BuyShopListViewHolder(view);
            view.setTag(buyShopListViewHolder);
        } else {
            buyShopListViewHolder = (BuyShopListViewHolder) view.getTag();
        }
        buyShopListViewHolder.mTitle_tv.setText(mBody.getInfo().get(position).getTitle());
        buyShopListViewHolder.mShop_name_tv.setText(mBody.getInfo().get(position).getShop_name());

        ViewGroup.LayoutParams layoutParams = buyShopListViewHolder.mProduct_background_img.getLayoutParams();
        layoutParams.height = width / 2;
        buyShopListViewHolder.mProduct_background_img.setLayoutParams(layoutParams);
        Picasso.with(mContext).load(mBody.getInfo().get(position).getShop_banner())
                .into(buyShopListViewHolder.mProduct_background_img);

        buyShopListViewHolder.mProduct_background_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String shop_id = mBody.getInfo().get(position).getShop_id();
                String shop_name=mBody.getInfo().get(position).getShop_name();
                intent.putExtra("shop_id",shop_id);
                intent.putExtra("shop_name",shop_name);
                intent.setClass(mContext, BuyShop_Info.class);
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    class BuyShopListViewHolder {
        private ImageView mProduct_background_img;
        private TextView mTitle_tv, mShop_name_tv;

        public BuyShopListViewHolder(View view) {
            mProduct_background_img = (ImageView) view.findViewById(R.id.product_background_img);
            mTitle_tv = (TextView) view.findViewById(R.id.title_tv);
            mShop_name_tv = (TextView) view.findViewById(R.id.shop_name_tv);
        }
    }
}
