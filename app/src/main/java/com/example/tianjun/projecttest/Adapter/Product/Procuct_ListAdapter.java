package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianjun.projecttest.Bean.Product.Product_List_Gson;
import com.example.tianjun.projecttest.Product.Product_Info;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vcc on 2016/9/7.
 */
public class Procuct_ListAdapter extends BaseAdapter {
    private List<Product_List_Gson.InfoBean.GoodsBean> goods;
    private Context mContext;
    private  int windowWidth;
    public Procuct_ListAdapter(Context mContext,List<Product_List_Gson.InfoBean.GoodsBean> goods ,int windowWidth){
        this.mContext=mContext;
        this.goods=goods;
        this.windowWidth=windowWidth;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
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

        if (goodsBean.getIs_promote()==0) {
            viewHolder.mNowprice_tv.setText(goodsBean.getShop_price());
        }else if (goodsBean.getIs_promote()==1){
            viewHolder.mOldprice_tv.setText(goodsBean.getShop_price());
            viewHolder.mNowprice_tv.setText(goodsBean.getPromote_price());
        }

        viewHolder.mLeft_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product_List_Gson.InfoBean.GoodsBean goodsBean = goods.get((position * 2));
                String goodId=goodsBean.getGoods_id();
                Intent intent=new Intent();
                intent.putExtra("goods_id",goodId);
                intent.setClass(mContext, Product_Info.class);
                mContext.startActivity(intent);
            }
        });

        viewHolder.mRigth_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product_List_Gson.InfoBean.GoodsBean goodsBean2 = goods.get(position * 2 + 1);
                String goodId=goodsBean2.getGoods_id();
                Intent intent=new Intent();
                intent.putExtra("goods_id",goodId);
                intent.setClass(mContext, Product_Info.class);
                mContext.startActivity(intent);
            }
        });

        viewHolder.mBrand_tv2.setText(goodsBean2.getEnglish_name());
        viewHolder.mProductname_tv2.setText(goodsBean2.getGoods_name());
        viewHolder.mNowprice_tv2.setText(goodsBean2.getShop_price());
        if (goodsBean2.getIs_promote()==0) {
            viewHolder.mNowprice_tv2.setText(goodsBean2.getShop_price());
        }else if (goodsBean2.getIs_promote()==1){
            viewHolder.mOldprice_tv2.setText(goodsBean2.getShop_price());
            viewHolder.mNowprice_tv2.setText(goodsBean2.getPromote_price());
        }
        String url = goodsBean.getThumb();
        String url2 = goodsBean2.getThumb();

        viewHolder.mHeart_cheak.setOnCheckedChangeListener(onCheckedChangeListener);
        viewHolder.mHeart_cheak2.setOnCheckedChangeListener(onCheckedChangeListener);


        ViewGroup.LayoutParams layoutParams = viewHolder.mTitle_img.getLayoutParams();
        layoutParams.height=windowWidth/2;
        viewHolder.mTitle_img.setLayoutParams(layoutParams);
        viewHolder.mTitle_img2.setLayoutParams(layoutParams);

        Picasso.with(mContext).load(url).into(viewHolder.mTitle_img);
        Picasso.with(mContext).load(url2).into(viewHolder.mTitle_img2);

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

    class ViewHolders {
        public LinearLayout mLeft_ll;
        public LinearLayout mRigth_ll;
        public ImageView mTitle_img, mTitle_img2;
        public CheckBox mHeart_cheak, mHeart_cheak2;
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
            mHeart_cheak2 = (CheckBox) view.findViewById(R.id.heart_check2);
            mHeart_cheak= (CheckBox) view.findViewById(R.id.heart_check);
        }

    }
}
