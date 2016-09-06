package com.example.tianjun.projecttest.Present.Home;

import com.example.tianjun.projecttest.Bean.Home.TabBean;
import com.example.tianjun.projecttest.Model.Home.HomeModel;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Home.IHomeView;

/**
 * Created by xx on 2016/9/5.
 */
public class HomePresent implements IHomePresent{
    private HomeModel mHomeModel;
    private IHomeView mHomeView;

    public HomePresent(IHomeView view){
        mHomeView = view;
        mHomeModel = new HomeModel();
    }

    @Override
    public void requestTabData(int requestCode) {
        mHomeModel.RequestTabData(this,requestCode);
    }

    @Override
    public void httpRequestSuccess(Object object, int requestCode) {
        if (object != null){
            switch (requestCode){
                case ConstantClz.HOME_TAB_REQUEST_CODE:
                    TabBean tabBean = (TabBean) object;
                    mHomeView.getRequestTabBean(tabBean.getInfo());
                    break;
            }
        }
    }
}
