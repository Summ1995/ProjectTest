package com.example.tianjun.projecttest.Adapter.Show;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Show.ListBean;
import com.example.tianjun.projecttest.CustomerView.CustomerViewPager;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.PublicMethod;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2016/9/13.
 */
public class ListItemAdapter extends BaseAdapter implements ViewPager.OnPageChangeListener,View.OnClickListener {
    private final List<ListBean.InfoBean> mItemList;
    private final Context mContext;
    private final LayoutInflater mInflater;
    private LinearLayout mSignLayout;

    public ListItemAdapter(List<ListBean.InfoBean> list, Context context){
        mItemList = list;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.show_list_item,parent,false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ListBean.InfoBean itemData = mItemList.get(position);

        Picasso.with(mContext).load(itemData.getAvatar()).into(holder.authorImg);
        holder.authorName.setText(itemData.getNick_name());
        holder.authorName2.setText(" | " + itemData.getNick_name());
        holder.goodsName.setText(itemData.getShare_goods_name());
        holder.collectionCheckBox.setChecked(false);

        if (itemData.getContent() == null || itemData.getContent().length() == 0){
            holder.content.setVisibility(View.GONE);
        }else {
            holder.content.setVisibility(View.VISIBLE);
            holder.content.setText(itemData.getContent());
        }

        if (itemData.getTags() == null || itemData.getTags().size() == 0){
            holder.tags.setVisibility(View.GONE);
        }else {
            holder.tags.setVisibility(View.VISIBLE);
            holder.tags.setText(getGoodsTags(itemData.getTags()));
        }


        holder.remarkNum.setText(itemData.getRemark());
        holder.favoriteNum.setText(itemData.getFavorite());

        ListItemImagePagerAdapter listItemImagePagerAdapter = new ListItemImagePagerAdapter(itemData.getImages(), mContext);
        holder.imagesPager.setAdapter(listItemImagePagerAdapter);
        holder.signLayout.removeAllViews();
        mSignLayout = holder.signLayout;
        if (itemData.getImages().size() > 1){
            initHeadSign(holder.signLayout,itemData.getImages().size());
            setSignLightByIndex(0);
            holder.imagesPager.setOnPageChangeListener(this);
        }

        return view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setSignLightByIndex(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setSignLightByIndex(int position){
        for (int i = 0; i < mSignLayout.getChildCount(); i++) {
            if (position == i){
                mSignLayout.getChildAt(i).setEnabled(true);
            }else {
                mSignLayout.getChildAt(i).setEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.show_item_favorite_btn:
                Button favoriteBtn = (Button) view;
                Drawable drawable = mContext.getResources().getDrawable(R.drawable.share_favorited);
                favoriteBtn.setCompoundDrawables(drawable,drawable,drawable,drawable);
                break;
        }
    }

    class ViewHolder{
        @BindView(R.id.show_item_author_img)
        ImageView authorImg;
        @BindView(R.id.show_item_author_name)
        TextView authorName;
        @BindView(R.id.show_item_image_pager)
        CustomerViewPager imagesPager;
        @BindView(R.id.show_item_collection_img)
        CheckBox collectionCheckBox;
        @BindView(R.id.show_item_image_sign)
        LinearLayout signLayout;
        @BindView(R.id.show_item_goods_name)
        TextView goodsName;
        @BindView(R.id.show_item_author_name2)
        TextView authorName2;
        @BindView(R.id.show_item_content)
        TextView content;
        @BindView(R.id.show_item_tags)
        TextView tags;
        @BindView(R.id.show_item_favorite_btn)
        Button favoriteNum;
        @BindView(R.id.show_item_remark_btn)
        Button remarkNum;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }

    /**
     * 将多个tag合成一段话
     * @param tags
     * @return
     */
    private String getGoodsTags(List<ListBean.InfoBean.TagsBean> tags) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tags.size(); i++) {
            builder.append("#").append(tags.get(i).getTag_name());
        }
        return builder.toString();
    }


    /**
     * 初始化head的指示器
     */
    private void initHeadSign(LinearLayout headSign,int number){
        headSign.removeAllViews();
        for (int i = 0; i < number; i++) {
            headSign.addView(PublicMethod.getSignImageView(mContext));
        }
    }

}
