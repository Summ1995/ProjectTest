package com.example.tianjun.projecttest;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tianjun.projecttest.Adapter.Search.SearchItemAdapter;
import com.example.tianjun.projecttest.Bean.SearchItemBean;
import com.example.tianjun.projecttest.CustomerView.CustomerAppCompatActivity;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.example.tianjun.projecttest.Util.PublicMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchHomeActivity extends CustomerAppCompatActivity implements View.OnClickListener,TextView.OnEditorActionListener {
    @BindView(R.id.search_txt)
    EditText mSearchInput;
    @BindView(R.id.search_search)
    TextView mSearch;
    @BindView(R.id.search_cancle)
    TextView mSearchCancle;
    @BindView(R.id.search_hot_search)
    TextView mHotSearch;
    @BindView(R.id.serach_list)
    ListView mSearchList;
    private List<String> mSearchItemData;
    private SearchItemAdapter mSearchItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_home);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        loadData();
        initView();
    }

    private void loadData() {
        mSearchItemData = new ArrayList<>();
    }

    private void initView() {
        initToolBar();
        initList();
    }

    private void initToolBar() {
        mSearchInput.setOnEditorActionListener(this);
        mSearch.setOnClickListener(this);
        mSearchCancle.setOnClickListener(this);
    }

    private void initList() {
        mSearchItemAdapter = new SearchItemAdapter(mSearchItemData,this);
        mSearchList.setAdapter(mSearchItemAdapter);

        HttpRequest.getHttpService().querySearchItem().enqueue(new Callback<SearchItemBean>() {


            @Override
            public void onResponse(Call<SearchItemBean> call, Response<SearchItemBean> response) {
                mSearchItemData.clear();
                mSearchItemData.addAll(response.body().getInfo());
                mSearchItemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SearchItemBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_search:
                PublicMethod.goToSearch(this,mSearchInput.getText().toString());
                break;
            case R.id.search_cancle:
                finish();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == R.id.search_txt || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)){
            PublicMethod.goToSearch(this,mSearchInput.getText().toString());
            return  true;
        }
        return false;
    }
}
