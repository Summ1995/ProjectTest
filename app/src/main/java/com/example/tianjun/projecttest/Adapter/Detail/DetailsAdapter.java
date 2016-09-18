package com.example.tianjun.projecttest.Adapter.Detail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.Product.Product_Info;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.PublicMethod;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.tianjun.projecttest.Util.PublicMethod.formatDIP;

/**
 * Created by xx on 2016/9/8.
 */
public class DetailsAdapter extends BaseAdapter{
    private final List<DetailsBean.InfoBean.DetailBean> mDetailItemData;
    private final LayoutInflater mInflater;
    private final Context mContext;
    private int mCurrentGoodsID = 1;

    public DetailsAdapter(List<DetailsBean.InfoBean.DetailBean> Detail, Context context){
        mDetailItemData = Detail;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        mCurrentGoodsID = 1;
        return mDetailItemData == null ? 0 : mDetailItemData.size();
    }

    @Override
    public Object getItem(int position) {
        return mDetailItemData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.detail_details_item,parent,false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        final DetailsBean.InfoBean.DetailBean itemData = mDetailItemData.get(position);

        if (itemData.getGoods_id().equals("0")){
            holder.nameRL.setVisibility(View.GONE);
        }else {
            if (holder.nameNum.getText().equals("")){
                holder.nameRL.setVisibility(View.VISIBLE);
                holder.nameNum.setText(String.valueOf(mCurrentGoodsID));
                mCurrentGoodsID++;
                holder.nameTxt.setText(itemData.getGoods_name());
            }
        }

        holder.introduce.setText(itemData.getIntro());


        float Scale = PublicMethod.getScaleByScreenWidth(mContext,itemData.getWidth());
        int width = (int) (Integer.parseInt(itemData.getWidth()) * Scale);
        int height = (int) (Integer.parseInt(itemData.getHeight()) * Scale);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(formatDIP(width,mContext), formatDIP(height,mContext));
        layoutParams.addRule(RelativeLayout.BELOW,R.id.details_item_intro);
        layoutParams.setMargins(0,5,0,0);
        holder.image.setLayoutParams(layoutParams);

        Picasso.with(mContext).load(itemData.getImage_path()).into(holder.image);

        if (itemData.getIs_on_sale() == null){
            holder.purchaseRL.setVisibility(View.GONE);
        }else {
            holder.purchaseRL.setVisibility(View.VISIBLE);
            holder.price.setText("价格 ：" + itemData.getCurrency_price());
            if (itemData.getIs_on_sale().equals("0")){
                holder.puchaseBtn.setVisibility(View.GONE);
                holder.shelvesBtn.setVisibility(View.VISIBLE);
            }else {
                holder.puchaseBtn.setVisibility(View.VISIBLE);
                holder.puchaseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, Product_Info.class);
                        intent.putExtra("goods_id",itemData.getGoods_id());
                        mContext.startActivity(intent);
                    }
                });
                holder.shelvesBtn.setVisibility(View.GONE);
            }
        }
        return view;
    }

    class ViewHolder{
        @BindView(R.id.details_item_name_RL)
        RelativeLayout nameRL;
        @BindView(R.id.details_item_name_num)
        TextView nameNum;
        @BindView(R.id.details_item_name_txt)
        TextView nameTxt;
        @BindView(R.id.details_item_intro)
        TextView introduce;
        @BindView(R.id.details_item_img)
        ImageView image;
        @BindView(R.id.details_item_purchase_RL)
        RelativeLayout purchaseRL;
        @BindView(R.id.details_item_price)
        TextView price;
        @BindView(R.id.details_item_purchase_btn)
        TextView puchaseBtn;
        @BindView(R.id.details_item_shelves_btn)
        TextView shelvesBtn;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
