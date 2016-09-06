package com.example.tianjun.projecttest.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.tianjun.projecttest.Adapter.Home.ListViewPager;
import com.example.tianjun.projecttest.Adapter.Home.TabAdapter;
import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Present.Home.HomePresent;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Home.IHomeView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2016/9/6.
 */
public class HomeMainFragment extends Fragment implements IHomeView {
    @BindView(R.id.home_tab)
    RecyclerView mHomeTab;
    @BindView(R.id.home_list)
    PullToRefreshListView mHomeList;

    private static List<TabBean.InfoBean> mTabBean;
    private Context mContext;
    private HomePresent mHomePresent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mHomePresent = new HomePresent(this);
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
        if (mTabBean == null){
            mHomePresent.requestTabData(ConstantClz.HOME_TAB_REQUEST_CODE);
        }else {
            setHomeTab();
        }
    }

    /**
     * 给tab复制
     */
    private void setHomeTab(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mHomeTab.setLayoutManager(linearLayoutManager);
        TabAdapter tabAdapter = new TabAdapter(mTabBean,mContext,this);
        mHomeTab.setAdapter(tabAdapter);
    }


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
            case "0":
                break;
            case ConstantClz.HOME_TAB_CATEGORY_CODE:
                break;
            default:
                initListView(catId);
                break;
        }
    }

    private void initListView(String catId){
        ListViewPager listViewPager = new ListViewPager();
        mHomeList.setAdapter(listViewPager);
    }
}
