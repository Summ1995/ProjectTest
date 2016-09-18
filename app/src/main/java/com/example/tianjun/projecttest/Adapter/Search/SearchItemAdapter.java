package com.example.tianjun.projecttest.Adapter.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.PublicMethod;

import java.util.List;

/**
 * Created by xx on 2016/9/18.
 */
public class SearchItemAdapter extends BaseAdapter implements View.OnClickListener {
    private final List<String> mItemData;
    private final LayoutInflater mInflater;
    private final Context mContext;

    public SearchItemAdapter(List<String> liatData, Context context){
        mItemData = liatData;
        mContext = context;
        mInflater = LayoutInflater.from(context);
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
            view = mInflater.inflate(R.layout.search_list_item,parent,false);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.searchName.setText(mItemData.get(position));
        holder.searchName.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String key = ((TextView) view).getText().toString();
        PublicMethod.goToSearch(mContext,key);
    }

    class ViewHolder{
        TextView searchName;
        public ViewHolder(View view){
            searchName = (TextView) view.findViewById(R.id.serach_list_item_name);
            view.setTag(this);
        }
    }


}
