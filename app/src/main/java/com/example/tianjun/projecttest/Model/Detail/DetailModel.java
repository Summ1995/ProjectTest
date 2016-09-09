package com.example.tianjun.projecttest.Model.Detail;

import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.Present.Detail.IDetailPresent;
import com.example.tianjun.projecttest.Util.HttpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xx on 2016/9/8.
 */
public class DetailModel  implements IDetailModel{
    @Override
    public void GetDetailByHttpRequest(final IDetailPresent callBack, String topicID, String userID,final int requestCode) {
        HttpRequest.getHttpService().queryDetailsData(topicID,userID).enqueue(new Callback<DetailsBean>() {
            @Override
            public void onResponse(Call<DetailsBean> call, Response<DetailsBean> response) {
                callBack.Success(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<DetailsBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void GetCommentByHttpRequest(final IDetailPresent callBack, String topicID, String count,final int requestCode) {
        HttpRequest.getHttpService().queryCommentData(topicID,count).enqueue(new Callback<CommentBean>() {
            @Override
            public void onResponse(Call<CommentBean> call, Response<CommentBean> response) {
                callBack.Success(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<CommentBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void GetRelativeTopicByHttpRequest(final IDetailPresent callBack, String topicID,final int requestCode) {
        HttpRequest.getHttpService().queryRalativeTopicData(topicID).enqueue(new Callback<RelativeTopicBean>() {
            @Override
            public void onResponse(Call<RelativeTopicBean> call, Response<RelativeTopicBean> response) {
                callBack.Success(response.body(),requestCode);
            }

            @Override
            public void onFailure(Call<RelativeTopicBean> call, Throwable t) {

            }
        });
    }
}
