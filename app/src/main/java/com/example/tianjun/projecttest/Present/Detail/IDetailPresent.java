package com.example.tianjun.projecttest.Present.Detail;

/**
 * Created by xx on 2016/9/8.
 */
public interface IDetailPresent {
    void RequestDetailsData(String topicID,String userID,int requestCode);

    void RequestCommentData(String topicID,String count,int requestCode);

    void RequestRelativeTopicData(String topicID,int requestCode);

    void Success(Object object,int requestCode);
}
