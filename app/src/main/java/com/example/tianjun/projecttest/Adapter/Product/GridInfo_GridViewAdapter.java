package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.Product_GridInfo_Gson;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vcc on 2016/9/8.
 */
public class GridInfo_GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Product_GridInfo_Gson.InfoBean.GoodsBean> mGoods;
    private int width;

    public GridInfo_GridViewAdapter(Context mContext, List<Product_GridInfo_Gson.InfoBean.GoodsBean> mGoods,int width) {
        this.mContext = mContext;
        this.mGoods = mGoods;
        this.width=width;
    }

    @Override
    public int getCount() {
        return mGoods == null ? 0 : mGoods.size();
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
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.product_gridinfo_gridview, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mEnglish_name_tv.setText(mGoods.get(position).getEnglish_name());
        viewHolder.mGoods_name_tv.setText(mGoods.get(position).getGoods_name());
        viewHolder.mShop_price_tv.setText(mGoods.get(position).getShop_price());

        ViewGroup.LayoutParams layoutParams = viewHolder.mTitle_img.getLayoutParams();

        layoutParams.height=width/2;
        viewHolder.mTitle_img.setLayoutParams(layoutParams);

        String url = mGoods.get(position).getThumb();
        Picasso.with(mContext).load(url).into(viewHolder.mTitle_img);
        return view;
    }


    class ViewHolder {
        private ImageView mTitle_img;
        private TextView mEnglish_name_tv, mGoods_name_tv, mShop_price_tv;

        public ViewHolder(View view) {
            mTitle_img = (ImageView) view.findViewById(R.id.title_img);
            mEnglish_name_tv= (TextView) view.findViewById(R.id.english_name_tv);
            mGoods_name_tv= (TextView) view.findViewById(R.id.goods_name_tv);
            mShop_price_tv= (TextView) view.findViewById(R.id.shop_price_tv);
        }

    }
}
