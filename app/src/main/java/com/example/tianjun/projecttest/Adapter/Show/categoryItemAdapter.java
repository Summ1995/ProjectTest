package com.example.tianjun.projecttest.Adapter.Show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Show.CategoryBean;
import com.example.tianjun.projecttest.R;

import java.util.List;

/**
 * Created by xx on 2016/9/13.
 */
public class CategoryItemAdapter extends BaseAdapter{
    private final List<CategoryBean.InfoBean> mItemList;
    private final LayoutInflater mInflater;
    private final Context mContext;

    public CategoryItemAdapter(List<CategoryBean.InfoBean> beanList, Context context){
        mItemList = beanList;
        mInflater = LayoutInflater.from(context);
        mContext = context;
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
            view = mInflater.inflate(R.layout.show_category_item, parent, false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.itemName.setText(mItemList.get(position).getCategory_name());
        if (position == 0){
            view.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
        }
        return view;
    }

    class ViewHolder{
        TextView itemName;
        public ViewHolder(View view){
            itemName = (TextView) view.findViewById(R.id.show_category_item_name);
            view.setTag(this);
        }
    }
}
