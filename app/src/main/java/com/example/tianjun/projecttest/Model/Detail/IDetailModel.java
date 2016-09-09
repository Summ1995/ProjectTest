package com.example.tianjun.projecttest.Model.Detail;

import com.example.tianjun.projecttest.Present.Detail.IDetailPresent;

/**
 * Created by xx on 2016/9/8.
 */
public interface IDetailModel {
    void GetDetailByHttpRequest(IDetailPresent callBack,String topicID,String userID,int requestCode);

    void GetCommentByHttpRequest(IDetailPresent callBack,String topicID,String count,int requestCode);

    void GetRelativeTopicByHttpRequest(IDetailPresent callBack,String topicID,int requestCode);
}
