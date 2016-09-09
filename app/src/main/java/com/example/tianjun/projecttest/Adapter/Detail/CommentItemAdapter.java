package com.example.tianjun.projecttest.Adapter.Detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xx on 2016/9/9.
 */
public class CommentItemAdapter extends BaseAdapter{
    private final List<CommentBean.InfoBean> mCommentItemData;
    private final LayoutInflater mInflater;
    private final Context mContext;

    public CommentItemAdapter(List<CommentBean.InfoBean> bean, Context context){
        mCommentItemData = bean;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCommentItemData == null ? 0 : mCommentItemData.size();
    }

    @Override
    public Object getItem(int position) {
        return mCommentItemData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null){
            view = mInflater.inflate(R.layout.comment_item, parent, false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        CommentBean.InfoBean itemData = mCommentItemData.get(position);

        if (!itemData.getAvatar().equals(ConstantClz.DEFAULT_HTTP_IMAGE_URL)){
            Picasso.with(mContext).load(itemData.getAvatar()).into(holder.userImg);
        }
        holder.userName.setText(itemData.getUser_name());
        holder.detail.setText(itemData.getContent());
        holder.addTime.setText(itemData.getAdd_time());
        return view;
    }

    class ViewHolder{
        @BindView(R.id.comment_user_img)
        CircleImageView userImg;
        @BindView(R.id.comment_user_name)
        TextView userName;
        @BindView(R.id.comment_detail)
        TextView detail;
        @BindView(R.id.comment_add_time)
        TextView addTime;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
