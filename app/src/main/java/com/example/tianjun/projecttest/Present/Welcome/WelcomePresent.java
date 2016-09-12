package com.example.tianjun.projecttest.Present.Welcome;

import com.example.tianjun.projecttest.Bean.Welcome.WelcomeBean;
import com.example.tianjun.projecttest.Model.Welcome.IWelcomeModel;
import com.example.tianjun.projecttest.Model.Welcome.WelcomeModel;
import com.example.tianjun.projecttest.View.Welcome.IWelcomeView;

/**
 * Created by xx on 2016/9/12.
 */
public class WelcomePresent implements IWelcomePresent{
    private WelcomeModel mWelcomeModel;
    private IWelcomeView mWelcomeView;

    public WelcomePresent(IWelcomeView view){
        mWelcomeView = view;
        mWelcomeModel = new WelcomeModel();
    }

    @Override
    public void requestWelcomeData() {
        mWelcomeModel.getWelcomeDataByHttpRequest(this);
    }

    @Override
    public void Success(Object object) {
        if (object != null){
            WelcomeBean welcomeBean = (WelcomeBean) object;
            mWelcomeView.getWelComeData(welcomeBean.getInfo());
        }
    }
}
