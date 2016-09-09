package com.example.tianjun.projecttest.Present.Detail;

import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;
import com.example.tianjun.projecttest.Model.Detail.DetailModel;
import com.example.tianjun.projecttest.Util.ConstantClz;
import com.example.tianjun.projecttest.View.Detail.IDetailView;

/**
 * Created by xx on 2016/9/8.
 */
public class DetailPresent implements IDetailPresent {
    private IDetailView mDetailView;
    private DetailModel mDetailModel;

    public DetailPresent(IDetailView detailView){
        mDetailView = detailView;
        mDetailModel = new DetailModel();
    }

    @Override
    public void RequestDetailsData(String topicID, String userID, int requestCode) {
        mDetailModel.GetDetailByHttpRequest(this,topicID,userID,requestCode);
    }

    @Override
    public void RequestCommentData(String topicID, String count, int requestCode) {
        mDetailModel.GetCommentByHttpRequest(this,topicID,count,requestCode);
    }

    @Override
    public void RequestRelativeTopicData(String topicID, int requestCode) {
        mDetailModel.GetRelativeTopicByHttpRequest(this,topicID,requestCode);
    }

    @Override
    public void Success(Object object, int requestCode) {
        if (object != null){
            switch (requestCode){
                case ConstantClz.DETAIL_REQUEST_CODE:
                    DetailsBean detailsBean = (DetailsBean) object;
                    mDetailView.getRequestDetailsBean(detailsBean.getInfo());
                    break;
                case ConstantClz.COMMENTS_REQUEST_CODE:
                    CommentBean commentBean = (CommentBean) object;
                    mDetailView.getRequestCommentsBean(commentBean.getInfo());
                    break;
                case ConstantClz.RELATIVE_TOPIC_REQUEST_CODE:
                    RelativeTopicBean relativeTopicBean = (RelativeTopicBean) object;
                    mDetailView.getRequestRelativeTopicBean(relativeTopicBean.getInfo());
                    break;
            }
        }
    }
}
