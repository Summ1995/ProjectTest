package com.example.tianjun.projecttest.Bean.Detail;

import java.util.List;

/**
 * Created by xx on 2016/9/9.
 */
public class RelativeTopicBean {

    /**
     * result : success
     * msg :
     * info : [{"topic_id":"1441","title":"跑过恐龙，Sam Edelman 貌美平价很任性！","topic_img":"http://img.fulishe.com/images/topic/201605/1462261641115424640.jpg","add_time":"2016-05-03"},{"topic_id":"378","title":"日本制造 最好用的玻璃制品你家有吗？","topic_img":"http://img.fulishe.com/images/topic/201507/1437277451950833484.jpg","add_time":"2015-07-19"},{"topic_id":"51","title":"一夜之间 大家都开始跑步了！","topic_img":"http://img.fulishe.com/images/topic/201505/1431078589372902262.jpg","add_time":"2015-05-08"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * topic_id : 1441
     * title : 跑过恐龙，Sam Edelman 貌美平价很任性！
     * topic_img : http://img.fulishe.com/images/topic/201605/1462261641115424640.jpg
     * add_time : 2016-05-03
     */

    private List<InfoBean> info;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJf_tip() {
        return jf_tip;
    }

    public void setJf_tip(String jf_tip) {
        this.jf_tip = jf_tip;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        private String topic_id;
        private String title;
        private String topic_img;
        private String add_time;

        public String getTopic_id() {
            return topic_id;
        }

        public void setTopic_id(String topic_id) {
            this.topic_id = topic_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopic_img() {
            return topic_img;
        }

        public void setTopic_img(String topic_img) {
            this.topic_img = topic_img;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
