package com.example.tianjun.projecttest.Present.Show;

import com.example.tianjun.projecttest.Bean.Show.CategoryBean;
import com.example.tianjun.projecttest.Bean.Show.ListBean;
import com.example.tianjun.projecttest.Model.Show.ShowModel;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Show.IShowView;

/**
 * Created by xx on 2016/9/13.
 */
public class ShowPresent implements IShowPresent{
    private ShowModel mShowModel;
    private IShowView mShowView;

    public ShowPresent(IShowView showView){
        mShowModel = new ShowModel();
        mShowView = showView;
    }

    @Override
    public void requestCategoryData(int requestCode) {
        mShowModel.getCategoryDataByHttpRequest(this,requestCode);
    }

    @Override
    public void requestListData(String categoryID, int count,String key, int requestCode) {
        mShowModel.getListDataByHttpRequest(categoryID,count,key,this,requestCode);
    }

    @Override
    public void requestSuccess(Object object, int requestCode) {
        if (object != null){
            switch (requestCode){
                case ConstantClz.SHOW_CATEGORY_REQUEST_CODE:
                    CategoryBean categoryBean = (CategoryBean) object;
                    mShowView.getCategoryData(categoryBean.getInfo());
                    break;
                case ConstantClz.SHOW_LIST_REQUEST_CODE:
                    ListBean listBean = (ListBean) object;
                    mShowView.getListData(listBean.getInfo());
                    break;
            }
        }
    }
}
