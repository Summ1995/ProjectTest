package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vcc on 2016/9/7.
 */
public class Procuct_ListAdapter extends BaseAdapter {
    private List<Product_List_Gson.InfoBean.GoodsBean> goods;
    private Context mContext;
    public Procuct_ListAdapter(Context mContext,List<Product_List_Gson.InfoBean.GoodsBean> goods){
        this.mContext=mContext;
        this.goods=goods;
    }

    @Override
    public int getCount() {
        return goods == null ? 0 : (goods.size() / 2);
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
        ViewHolders viewHolder=null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.product_listview, parent, false);
            viewHolder = new ViewHolders(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolders) view.getTag();
        }

        Product_List_Gson.InfoBean.GoodsBean goodsBean = goods.get((position * 2));
        Product_List_Gson.InfoBean.GoodsBean goodsBean2 = goods.get(position * 2 + 1);

        viewHolder.mBrand_tv.setText(goodsBean.getEnglish_name());
        viewHolder.mProductname_tv.setText(goodsBean.getGoods_name());
        viewHolder.mNowprice_tv.setText(goodsBean.getShop_price());
        if (!goodsBean.getCurrency_price().equals(goodsBean.getShop_price())) {
            viewHolder.mOldprice_tv.setText(goodsBean.getCurrency_price());
        }

        viewHolder.mBrand_tv2.setText(goodsBean2.getEnglish_name());
        viewHolder.mProductname_tv2.setText(goodsBean2.getGoods_name());
        viewHolder.mNowprice_tv2.setText(goodsBean2.getShop_price());
        if (!goodsBean2.getCurrency_price().equals(goodsBean2.getShop_price())) {
            viewHolder.mOldprice_tv2.setText(goodsBean2.getCurrency_price());
        }
        String url = goodsBean.getThumb();
        String url2 = goodsBean2.getThumb();
        Picasso.with(mContext).load(url).into(viewHolder.mTitle_img);
        Picasso.with(mContext).load(url2).into(viewHolder.mTitle_img2);
        return view;
    }
}

class ViewHolders {
    public LinearLayout mLeft_ll;
    public LinearLayout mRigth_ll;
    public ImageView mTitle_img, mTitle_img2, mHeart_img, mHeart_img2;
    public TextView mBrand_tv, mProductname_tv, mNowprice_tv, mOldprice_tv,
            mBrand_tv2, mProductname_tv2, mNowprice_tv2, mOldprice_tv2;

    public ViewHolders(View view) {
        mLeft_ll = (LinearLayout) view.findViewById(R.id.left_ll);
        mRigth_ll = (LinearLayout) view.findViewById(R.id.right_ll);
        mTitle_img = (ImageView) view.findViewById(R.id.title_img);
        mTitle_img2 = (ImageView) view.findViewById(R.id.title_img2);

        mBrand_tv = (TextView) view.findViewById(R.id.brand_tv);
        mProductname_tv = (TextView) view.findViewById(R.id.productname_tv);
        mNowprice_tv = (TextView) view.findViewById(R.id.nowprice_tv);
        mOldprice_tv = (TextView) view.findViewById(R.id.oldprice_tv);


        mBrand_tv2 = (TextView) view.findViewById(R.id.brand_tv2);
        mProductname_tv2 = (TextView) view.findViewById(R.id.productname_tv2);
        mNowprice_tv2 = (TextView) view.findViewById(R.id.nowprice_tv2);
        mOldprice_tv2 = (TextView) view.findViewById(R.id.oldprice_tv2);
        mHeart_img2 = (ImageView) view.findViewById(R.id.heart_img2);
    }

}
