package com.example.tianjun.projecttest.Adapter.Product;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.BuyShop_Info_List_Gson;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vcc on 2016/9/13.
 */
public class BuyShop_Info_Goods_Adapter extends RecyclerView.Adapter<BuyShop_Info_Goods_Adapter.ViewHolder>{
    private final List<BuyShop_Info_List_Gson.InfoBean.GoodsListBean> mGoodsList;
    private final LayoutInflater mInflater;
    private final Context mContext;

    public BuyShop_Info_Goods_Adapter(List<BuyShop_Info_List_Gson.InfoBean.GoodsListBean> bean, Context context){
        mGoodsList = bean;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_list_item_goods, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BuyShop_Info_List_Gson.InfoBean.GoodsListBean goodData = mGoodsList.get(position);
        Picasso.with(mContext).load(goodData.getImage_path()).resize(100,100).into(holder.image);
        holder.name.setText(goodData.getGoods_name());
        holder.currentPrice.setText(goodData.getCurrency_price());

        if (goodData.getIs_promote().equals("1")){
            holder.currentPrice.setText(goodData.getRank_price());
            holder.rankPrice.setText(goodData.getCurrency_price());
        }
    }

    @Override
    public int getItemCount() {
        return mGoodsList == null ? 0 : mGoodsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.home_list_item_goods_img)
        ImageView image;
        @BindView(R.id.home_list_item_goods_name)
        TextView name;
        @BindView(R.id.home_list_item_goods_current_price)
        TextView currentPrice;
        @BindView(R.id.home_list_item_goods_rank_price)
        TextView rankPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
