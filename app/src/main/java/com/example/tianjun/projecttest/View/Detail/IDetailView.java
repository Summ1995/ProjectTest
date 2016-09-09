package com.example.tianjun.projecttest.View.Detail;

import com.example.tianjun.projecttest.Bean.Detail.RelativeTopicBean;
import com.example.tianjun.projecttest.Bean.Detail.CommentBean;
import com.example.tianjun.projecttest.Bean.Detail.DetailsBean;

import java.util.List;

/**
 * Created by xx on 2016/9/8.
 */
public interface IDetailView {
    void getRequestDetailsBean(DetailsBean.InfoBean bean);

    void getRequestCommentsBean(List<CommentBean.InfoBean> bean);

    void getRequestRelativeTopicBean(List<RelativeTopicBean.InfoBean> bean);
}
