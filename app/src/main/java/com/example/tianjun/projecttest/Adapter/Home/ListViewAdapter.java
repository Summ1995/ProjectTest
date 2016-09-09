package com.example.tianjun.projecttest.Adapter.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.DetailActivity;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.Util.PublicMethod;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2016/9/6.
 */
public class ListViewAdapter extends BaseAdapter implements View.OnClickListener {

    private List<ListBean.InfoBean> mListData;
    private LayoutInflater mInflater;
    private Context mContext;
    private int screenWidth = 0;
    private int viewWidth = 0;

    public ListViewAdapter(List<ListBean.InfoBean> been, Context context){
        mListData = been;
        mInflater = LayoutInflater.from(context);
        mContext = context;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.home_list_item,parent,false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ListBean.InfoBean item = mListData.get(position);

        Picasso.with(mContext).load(item.getTopic_img()).into(holder.image);
        holder.image.setTag(item.getTopic_id());
        holder.image.setOnClickListener(this);


        holder.title.setText(item.getTitle());
        holder.keyWords.setText(getKeyWords(item.getKeywords()));

        List<ListBean.InfoBean.GoodsListBean> goods_list = item.getGoods_list();
        if (goods_list != null && goods_list.size() > 0){
            holder.splitLayout.setVisibility(View.VISIBLE);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            holder.goods.setLayoutManager(linearLayoutManager);
            ListItemGoodsAdapter listItemGoodsAdapter = new ListItemGoodsAdapter(goods_list, mContext);
            holder.goods.setAdapter(listItemGoodsAdapter);

            setMarginLeftForButton(goods_list.size(),holder.more);
            holder.more.setTag(item.getTopic_id());
            holder.more.setOnClickListener(this);
        }else {
            holder.splitLayout.setVisibility(View.GONE);
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        String topicID = view.getTag().toString();
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(ConstantClz.DETAIL_TOPIC_ID,topicID);
        intent.putExtra(ConstantClz.USER_ID,"");
        mContext.startActivity(intent);
    }

    class ViewHolder{
        @BindView(R.id.home_list_item_img)
        ImageView image;
        @BindView(R.id.home_list_item_share_img)
        ImageView shareImg;
        @BindView(R.id.home_list_item_title)
        TextView title;
        @BindView(R.id.home_list_item_key_words)
        TextView keyWords;
        @BindView(R.id.home_list_item_split)
        RelativeLayout splitLayout;
        @BindView(R.id.home_list_item_goods)
        RecyclerView goods;
        @BindView(R.id.home_list_item_goods_more)
        Button more;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }

    /**
     * 将所有keyWords合成一句话
     * @param keyWords
     * @return
     */
    private String getKeyWords(List<String> keyWords){
        StringBuffer stringBuffer = new StringBuffer();
        if (keyWords != null && keyWords.size() > 0){
            for (int i = 0; i < keyWords.size(); i++) {
                if (keyWords.get(i).length() > 0){
                    stringBuffer.append(keyWords.get(i)).append("·");
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 用于设置查看更多按钮和商品信息的间距
     * @param count
     * @param moreBtn
     */
    private void setMarginLeftForButton(int count,Button moreBtn){
        viewWidth = count * 90 + 40;
        viewWidth = PublicMethod.formatDIP(viewWidth,mContext);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) moreBtn.getLayoutParams();
        int marginLeft = 0;
        if (viewWidth<screenWidth){
            marginLeft = screenWidth - viewWidth;
        }else {
            marginLeft = PublicMethod.formatDIP(10,mContext);
        }
        layoutParams.setMargins(marginLeft,0,0,0);
        moreBtn.setLayoutParams(layoutParams);
    }
}
