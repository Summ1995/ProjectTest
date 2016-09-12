package com.example.tianjun.projecttest.Home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.tianjun.projecttest.Adapter.Home.ListHeadAdapter;
import com.example.tianjun.projecttest.Adapter.Home.ListViewAdapter;
import com.example.tianjun.projecttest.Bean.Home.CategoryBean;
import com.example.tianjun.projecttest.Bean.Home.ListBean;
import com.example.tianjun.projecttest.Bean.Home.ListHeadBean;
import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Present.Home.HomePresent;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Home.IHomeView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2016/9/6.
 */
public class HomeMainFragment extends Fragment implements IHomeView,PullToRefreshBase.OnRefreshListener2,AbsListView.OnScrollListener,ViewPager.OnPageChangeListener {
    @BindView(R.id.home_tab)
    TabLayout mHomeTab;
    @BindView(R.id.home_list)
    PullToRefreshListView mHomeList;
    @BindView(R.id.home_category)
    RelativeLayout mCategoryRL;
    @BindView(R.id.home_category_scroll)
    ScrollView mCategorySV;

    private static List<TabBean.InfoBean> mTabBean;
    private Context mContext;
    private HomePresent mHomePresent;
    private int count = 10;
    private String mCurrentCatId = "0";
    private List<ListBean.InfoBean> mListData;
    private ListViewAdapter mListViewAdapter;
    private List<ListHeadBean.InfoBean.ItemsBean> mListHeadData;
    private ListHeadAdapter mListHeadAdapter;
    private View mListHeadView;
    private LinearLayout headSign;
    private ViewPager mHeadPager;
    private boolean hadHead = false;
    private boolean isBottom = false;
    private int mTabScrollX;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mHomePresent = new HomePresent(this);
        mListHeadData = new ArrayList<>();
        mListData = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    /**
     * 初始化首页界面
     */
    private void initView() {
        hadHead = false;
        mListHeadView = LayoutInflater.from(mContext).inflate(R.layout.home_list_head, null);
        mHeadPager = (ViewPager) mListHeadView.findViewById(R.id.home_list_head_pager);
        if (mTabBean == null){
            mHomePresent.requestTabData(ConstantClz.HOME_TAB_REQUEST_CODE);
        }else {
            setHomeTab();
        }
    }

    /**
     * 给tab赋值,初始化listview
     */
    private void setHomeTab(){
        initTab();
        mListViewAdapter = new ListViewAdapter(mListData,mContext);
        mHomeList.setAdapter(mListViewAdapter);
        mHomeList.setOnRefreshListener(this);
        mHomeList.setOnScrollListener(this);
        initListView(mCurrentCatId);
    }

    private void initTab(){
        int position = 0;
        for (int i = 0; i < mTabBean.size() + 1; i++) {
            TabLayout.Tab tab = mHomeTab.newTab();
            if (i == mTabBean.size()){
                tab.setIcon(R.drawable.arrow_index_down);
                tab.setTag(ConstantClz.HOME_TAB_CATEGORY_CODE);
            }else {
                tab.setText(mTabBean.get(i).getCat_name());
                tab.setTag(mTabBean.get(i).getCat_id());
                if (mCurrentCatId.equals(mTabBean.get(i).getCat_id())){
                    position = i;
                }
            }
            mHomeTab.addTab(tab);
        }
        mHomeTab.getTabAt(position).select();
        mHomeTab.setOnTabSelectedListener(tabsClickListener);
    }

    private TabLayout.OnTabSelectedListener tabsClickListener = new TabLayout.OnTabSelectedListener() {


        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            String catId = tab.getTag().toString();
            if (catId.equals(ConstantClz.HOME_TAB_CATEGORY_CODE) && mCategorySV.getVisibility() == View.VISIBLE){
                tab.setIcon(R.drawable.arrow_index_down);
            }else if (catId.equals(ConstantClz.HOME_TAB_CATEGORY_CODE)){
                tab.setIcon(R.drawable.arrow_red_up);
            }
            mTabScrollX = mHomeTab.getScrollX();
            initList(catId);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            String catId = tab.getTag().toString();
            if (catId.equals(ConstantClz.HOME_TAB_CATEGORY_CODE)){
                tab.setIcon(R.drawable.arrow_index_down);
            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            String catId = tab.getTag().toString();
            if (catId.equals(ConstantClz.HOME_TAB_CATEGORY_CODE)){
                if (mCategorySV.getVisibility() == View.VISIBLE){
                    mCategorySV.setVisibility(View.GONE);
                    mHomeList.setVisibility(View.VISIBLE);
                    tab.setIcon(R.drawable.arrow_index_down);
                }else {
                    tab.setIcon(R.drawable.arrow_red_up);
                    initList(catId);
                }
            }else{
                initList(catId);
            }
        }
    };


    /**
     * 返回Tab的数据
     * @param bean
     */
    @Override
    public void getRequestTabBean(List<TabBean.InfoBean> bean) {
        mTabBean = bean;
        setHomeTab();
    }

    /**
     * 显示listview
     * @param catId
     */
    public void initList(String catId){
        switch (catId){
            case ConstantClz.HOME_TAB_CATEGORY_CODE:
                mCategorySV.setVisibility(View.VISIBLE);
                mHomeList.setVisibility(View.GONE);
                initategory();
                break;
            default:
                mCategorySV.setVisibility(View.GONE);
                mHomeList.setVisibility(View.VISIBLE);
                initListView(catId);
                break;
        }
    }

    private void initategory(){
        mHomePresent.requestCategoryData(ConstantClz.HOME_CATEGORY_REQUEST_CODE);
    }

    /**
     *请求更新listview的数据
     * @param catId
     */
    private void initListView(String catId){
        mCurrentCatId = catId;
        count = 10;
        if (mCurrentCatId.equals("0")){
            mHomePresent.requestListHeadData(ConstantClz.HOME_LIST_HEAD_REQUEST_CODE);
        }else {
            mHomeList.getRefreshableView().removeHeaderView(mListHeadView);
            hadHead = false;
            mHomePresent.requestListData(count,Integer.parseInt(mCurrentCatId),ConstantClz.HOME_LIST_REQUEST_CODE);
        }
    }

    /**
     * 更新list的数据
     * @param bean
     */
    @Override
    public void getRequestListBean(List<ListBean.InfoBean> bean) {
        mListData.clear();
        mListData.addAll(bean);
        updateListData.sendEmptyMessage(1);
    }

    private Handler updateListData = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mListViewAdapter.notifyDataSetChanged();
            mHomeList.onRefreshComplete();
            if (count == 10){
                mHomeList.getRefreshableView().setSelectionAfterHeaderView();
            }
            mHomeTab.scrollTo(mTabScrollX,0);
        }
    };

    /**
     * 返回list的头部视图数据
     * @param bean
     */
    @Override
    public void getRequestListHeadBean(List<ListHeadBean.InfoBean.ItemsBean> bean) {
        mListHeadData.clear();
        mListHeadData.addAll(bean);
        initListHead();
        mHomePresent.requestListData(count,0,ConstantClz.HOME_LIST_REQUEST_CODE);
        initHeadSign();
        setSignLightByIndex(0);
    }

    /**
     * 返回分类信息
     * @param bean
     */
    @Override
    public void getRequestCategoryBean(CategoryBean.InfoBean bean) {
        HomeCategoryView.initCategory(mCategoryRL,bean,mContext);
    }

    /**
     * 初始化list的头部视图
     */
    private void initListHead(){
        mListHeadAdapter = new ListHeadAdapter(mListHeadData, mContext);
        mHeadPager.setAdapter(mListHeadAdapter);
        mHeadPager.addOnPageChangeListener(this);

        if (!hadHead){
            mHomeList.getRefreshableView().addHeaderView(mListHeadView);
            hadHead = true;
        }
        mHeadPager.setCurrentItem(0);
    }

    /**
     * 初始化head的指示器
     */
    private void initHeadSign(){
        headSign = (LinearLayout) mListHeadView.findViewById(R.id.home_list_head_sign);
        headSign.removeAllViews();
        for (int i = 0; i < mListHeadData.size(); i++) {
            headSign.addView(getSignImageView());
        }
    }

    /**
     * 动态添加head的指示小球
     * @return
     */
    private ImageView getSignImageView(){
        ImageView imageView = new ImageView(mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20,20);
        layoutParams.setMargins(10,0,0,0);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.viewpager_changed_selector);
        return imageView;
    }

    /**
     * 控制listview的下拉刷新
     * @param refreshView
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        count = 10;
        mHomePresent.requestListData(count,Integer.parseInt(mCurrentCatId),ConstantClz.HOME_LIST_REQUEST_CODE);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == 0 && isBottom == true){
            count += 10;
            mHomePresent.requestListData(count,Integer.parseInt(mCurrentCatId),ConstantClz.HOME_LIST_REQUEST_CODE);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if ((firstVisibleItem + visibleItemCount) == totalItemCount){
            isBottom = true;
        }else {
            isBottom = false;
        }
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
        for (int i = 0; i < headSign.getChildCount(); i++) {
            if (position == i){
                headSign.getChildAt(i).setEnabled(true);
            }else {
                headSign.getChildAt(i).setEnabled(false);
            }
        }
    }
}
