package com.example.tianjun.projecttest.Show;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Show.CategoryItemAdapter;
import com.example.tianjun.projecttest.Adapter.Show.ListItemAdapter;
import com.example.tianjun.projecttest.Bean.Show.CategoryBean;
import com.example.tianjun.projecttest.Bean.Show.ListBean;
import com.example.tianjun.projecttest.MainActivity;
import com.example.tianjun.projecttest.Present.Show.ShowPresent;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Show.IShowView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xx on 2016/9/12.
 */
public class ShowMainFragment extends Fragment implements IShowView,AdapterView.OnItemClickListener,PullToRefreshBase.OnRefreshListener2,AbsListView.OnScrollListener {
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
    private MenuDrawer mMenuDrawer;
    private EditText mSearchText;
    private Boolean isBottom = false;
    private String mCategoryId = "";
    private String mSearchKey = "";

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
        mMenuDrawer = ((MainActivity)mContext).mMenuDrawer;
        mMenuView = mMenuDrawer.getMenuView();
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
        mSearchText = (EditText) mMenuView.findViewById(R.id.detail_send_txt);
        mSearchText.setOnEditorActionListener(onEditorActionListener);
        mCategoryItemAdapter = new CategoryItemAdapter(mCategoryListData, mContext);
        categoryListView.setAdapter(mCategoryItemAdapter);
        categoryListView.setOnItemClickListener(this);
        if (mCategoryListData.size() == 0){
            mShowPresent.requestCategoryData(ConstantClz.SHOW_CATEGORY_REQUEST_CODE);
        }
    }

    private TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener(){
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId== EditorInfo.IME_ACTION_SEND ||(event!=null&&event.getKeyCode()== KeyEvent.KEYCODE_ENTER)){
                InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mContentView.getWindowToken(), 0);
                mCount = 10;
                mCategoryId = "";
                mSearchKey = mSearchText.getText().toString();
                mShowPresent.requestListData(mCategoryId,mCount,mSearchKey,ConstantClz.SHOW_LIST_REQUEST_CODE);
                mMenuDrawer.closeMenu();
                return true;
            }
            return false;
        }
    };

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

        mCount = 10;
        mCategoryId = mCategoryListData.get(position).getCategory_id();
        mSearchKey = "";
        mShowPresent.requestListData(mCategoryId,mCount,mSearchKey,ConstantClz.SHOW_LIST_REQUEST_CODE);

    }


    /**
     * 初始化主界面
     */
    private void initContentView() {
        mMainList = (PullToRefreshListView)mContentView.findViewById(R.id.show_main);
        mMainList.setOnRefreshListener(this);
        mMainList.setOnScrollListener(this);
        mListItemAdapter = new ListItemAdapter(mMainListData,mContext);
        mMainList.setAdapter(mListItemAdapter);
        if (mMainListData.size() == 0){

        }
        mCount = 10;
        mCategoryId = "";
        mSearchKey = "";
        mShowPresent.requestListData(mCategoryId,mCount,mSearchKey,ConstantClz.SHOW_LIST_REQUEST_CODE);
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

    /**
     * 控制listview的下拉刷新
     * @param refreshView
     */
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        mCount = 10;
        mShowPresent.requestListData(mCategoryId,mCount,mSearchKey,ConstantClz.SHOW_LIST_REQUEST_CODE);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == 0 && isBottom == true){
            mCount += 10;
            mShowPresent.requestListData(mCategoryId,mCount,mSearchKey,ConstantClz.SHOW_LIST_REQUEST_CODE);
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
}
