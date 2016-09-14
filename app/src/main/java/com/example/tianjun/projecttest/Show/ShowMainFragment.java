package com.example.tianjun.projecttest.Show;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tianjun.projecttest.Adapter.Show.CategoryItemAdapter;
import com.example.tianjun.projecttest.Adapter.Show.ListItemAdapter;
import com.example.tianjun.projecttest.Bean.Show.CategoryBean;
import com.example.tianjun.projecttest.Bean.Show.ListBean;
import com.example.tianjun.projecttest.MainActivity;
import com.example.tianjun.projecttest.Present.Show.ShowPresent;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Show.IShowView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xx on 2016/9/12.
 */
public class ShowMainFragment extends Fragment implements IShowView,AdapterView.OnItemClickListener {
    private Context mContext;
    private FragmentActivity mActivity;
    private View mContentView;
    private View mMenuView;
    private ShowPresent mShowPresent;
    private List<CategoryBean.InfoBean> mCategoryListData;
    private CategoryItemAdapter mCategoryItemAdapter;
    private int mCount = 10;
    private PullToRefreshListView mMainList;
    private List<ListBean.InfoBean> mMainListData;
    private ListItemAdapter mListItemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mActivity = getActivity();
        mCategoryListData = new ArrayList<>();
        mMainListData = new ArrayList<>();
        mShowPresent = new ShowPresent(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.show_fragment,null);
        mMenuView = ((MainActivity)mContext).mMenuDrawer.getMenuView();
        initView();
        return mContentView;
    }

    private void initView() {
        initContentView();
        initMenuView();
    }

    /**
     * 初始化滑出分类菜单
     */
    private void initMenuView() {
        ListView categoryListView = (ListView) mMenuView.findViewById(R.id.show_category);
        mCategoryItemAdapter = new CategoryItemAdapter(mCategoryListData, mContext);
        categoryListView.setAdapter(mCategoryItemAdapter);
        categoryListView.setOnItemClickListener(this);
        if (mCategoryListData.size() == 0){
            mShowPresent.requestCategoryData(ConstantClz.SHOW_CATEGORY_REQUEST_CODE);
        }
    }

    /**
     * 返回网络请求的分类信息
     * @param beanList
     */
    @Override
    public void getCategoryData(List<CategoryBean.InfoBean> beanList) {
        mCategoryListData.clear();
        CategoryBean.InfoBean infoBean = new CategoryBean.InfoBean();
        infoBean.setCategory_id("");
        infoBean.setCategory_name("全部");
        mCategoryListData.add(infoBean);
        mCategoryListData.addAll(beanList);
        mCategoryItemAdapter.notifyDataSetChanged();
    }


    /**
     * 分类子项的点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (i == position){
                view.findViewById(R.id.show_category_item_img).setVisibility(View.VISIBLE);
                view.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
            }else {
                parent.getChildAt(i).findViewById(R.id.show_category_item_img).setVisibility(View.GONE);
                parent.getChildAt(i).setBackgroundColor(mContext.getResources().getColor(R.color.coloree));
            }
        }

        String categoryId = mCategoryListData.get(position).getCategory_id();
        mShowPresent.requestListData(categoryId,mCount,ConstantClz.SHOW_LIST_REQUEST_CODE);

    }


    /**
     * 初始化主界面
     */
    private void initContentView() {
        mMainList = (PullToRefreshListView)mContentView.findViewById(R.id.show_main);
        mListItemAdapter = new ListItemAdapter(mMainListData,mContext);
        mMainList.setAdapter(mListItemAdapter);
        if (mMainListData.size() == 0){

        }
        mShowPresent.requestListData("",mCount,ConstantClz.SHOW_LIST_REQUEST_CODE);
    }

    /**
     * 返回网络请求的列表信息
     * @param beanList
     */
    @Override
    public void getListData(List<ListBean.InfoBean> beanList) {
        mMainListData.clear();
        mMainListData.addAll(beanList);
        updateHandler.sendEmptyMessage(1);
    }

    private Handler updateHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mListItemAdapter.notifyDataSetChanged();
            mMainList.onRefreshComplete();
        }
    };
}
