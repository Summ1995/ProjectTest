package com.example.tianjun.projecttest.Adapter.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2016/9/6.
 */
public class ListItemGoodsAdapter extends RecyclerView.Adapter<ListItemGoodsAdapter.ViewHolder>{
    private final List<ListBean.InfoBean.GoodsListBean> mGoodsList;
    private final LayoutInflater mInflater;
    private final Context mContext;

    public ListItemGoodsAdapter(List<ListBean.InfoBean.GoodsListBean> bean, Context context){
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
        ListBean.InfoBean.GoodsListBean goodData = mGoodsList.get(position);
        Picasso.with(mContext).load(goodData.getImage_path()).into(holder.image);
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
