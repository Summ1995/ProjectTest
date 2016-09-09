package com.example.tianjun.projecttest.Adapter.Detail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.DetailActivity;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xx on 2016/9/9.
 */
public class RelativeTopicItemAdapter extends BaseAdapter implements View.OnClickListener {
    private final List<RelativeTopicBean.InfoBean> mItemData;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public RelativeTopicItemAdapter(List<RelativeTopicBean.InfoBean> bean, Context context){
        mItemData = bean;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItemData == null ? 0 : mItemData.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.relative_topic,parent,false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        RelativeTopicBean.InfoBean itemData = mItemData.get(position);

        Picasso.with(mContext).load(itemData.getTopic_img()).into(holder.image);
        holder.image.setTag(itemData.getTopic_id());
        holder.image.setOnClickListener(this);
        holder.topicName.setText(itemData.getTitle());
        return view;
    }

    @Override
    public void onClick(View v) {
        String topicID = v.getTag().toString();
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(ConstantClz.DETAIL_TOPIC_ID,topicID);
        mContext.startActivity(intent);
    }

    class ViewHolder{
        ImageView image;
        TextView topicName;
        public ViewHolder(View view){
            image = (ImageView) view.findViewById(R.id.topic_img);
            topicName = (TextView) view.findViewById(R.id.topic_name);
            view.setTag(this);
        }
    }
}
