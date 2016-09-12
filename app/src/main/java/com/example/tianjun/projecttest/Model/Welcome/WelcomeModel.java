package com.example.tianjun.projecttest.Model.Welcome;

import com.example.tianjun.projecttest.Bean.Welcome.WelcomeBean;
import com.example.tianjun.projecttest.Present.Welcome.IWelcomePresent;
import com.example.tianjun.projecttest.Util.HttpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xx on 2016/9/12.
 */
public class WelcomeModel implements IWelcomeModel{
    @Override
    public void getWelcomeDataByHttpRequest(final IWelcomePresent presnt) {
        HttpRequest.getHttpService().queryWelcomeData().enqueue(new Callback<WelcomeBean>() {
            @Override
            public void onResponse(Call<WelcomeBean> call, Response<WelcomeBean> response) {
                presnt.Success(response.body());
            }

            @Override
            public void onFailure(Call<WelcomeBean> call, Throwable t) {

            }
        });
    }
}
