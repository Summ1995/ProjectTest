package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_Grid_Gson;
import com.example.tianjun.projecttest.Product.Product_Info;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vcc on 2016/9/13.
 */
public class BuyShop_Info_GridAdapter extends BaseAdapter {
    private Context mContext;
    private List<BuyShop_Info_Grid_Gson.InfoBean.GoodsBean> mGridgoods;
    private int windowWidth;
    public BuyShop_Info_GridAdapter(Context mContext, List<BuyShop_Info_Grid_Gson.InfoBean.GoodsBean> mGridgoods, int windowWidth){
        this.mContext=mContext;
        this.mGridgoods=mGridgoods;
        this.windowWidth=windowWidth;
    }
    @Override
    public int getCount() {
        return mGridgoods==null?0:mGridgoods.size();
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
        GridViewHolders gridViewHolders=null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.buyshop_info_fragment1_gridview, parent, false);
            gridViewHolders = new GridViewHolders(view);
            view.setTag(gridViewHolders);
        } else {
            gridViewHolders = (GridViewHolders) view.getTag();
        }

        gridViewHolders.mBrand_tv.setText(mGridgoods.get(position).getEnglish_name());
        gridViewHolders.mProductname_tv.setText(mGridgoods.get(position).getGoods_name());

        if (mGridgoods.get(position).getIs_promote()==0) {
            gridViewHolders.mNowprice_tv.setText(mGridgoods.get(position).getShop_price());
        }else if (mGridgoods.get(position).getIs_promote()==1){
            gridViewHolders.mOldprice_tv.setText(mGridgoods.get(position).getShop_price());
            gridViewHolders.mNowprice_tv.setText(mGridgoods.get(position).getPromote_price());
        }

        gridViewHolders.mClick_layou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String goodId=mGridgoods.get(position).getGoods_id();
                Intent intent=new Intent();
                intent.putExtra("goods_id",goodId);
                intent.setClass(mContext, Product_Info.class);
                mContext.startActivity(intent);
            }
        });

        String url = mGridgoods.get(position).getThumb();
        gridViewHolders.mHeart_cheak.setOnCheckedChangeListener(onCheckedChangeListener);


        ViewGroup.LayoutParams layoutParams = gridViewHolders.mTitle_img.getLayoutParams();
        layoutParams.height=windowWidth/2;
        gridViewHolders.mTitle_img.setLayoutParams(layoutParams);

        Picasso.with(mContext).load(url).into(gridViewHolders.mTitle_img);
        return view;
    }


    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                Toast.makeText(mContext, "+5积分", Toast.LENGTH_SHORT).show();
            }else if(!isChecked){
                Toast.makeText(mContext, "取消收藏成功", Toast.LENGTH_SHORT).show();
            }
        }
    };
    class GridViewHolders {

        public LinearLayout mClick_layou;
        public ImageView mTitle_img;
        public CheckBox mHeart_cheak;
        public TextView mBrand_tv, mProductname_tv, mNowprice_tv, mOldprice_tv;

        public GridViewHolders(View view) {
            mTitle_img = (ImageView) view.findViewById(R.id.title_img);
            mBrand_tv = (TextView) view.findViewById(R.id.brand_tv);
            mProductname_tv = (TextView) view.findViewById(R.id.productname_tv);
            mNowprice_tv = (TextView) view.findViewById(R.id.buyshop_nowprice_tv);
            mOldprice_tv = (TextView) view.findViewById(R.id.buyshop_oldprice_tv);
            mHeart_cheak= (CheckBox) view.findViewById(R.id.heart_check);
            mClick_layou= (LinearLayout) view.findViewById(R.id.click_layou);
        }

    }
}
