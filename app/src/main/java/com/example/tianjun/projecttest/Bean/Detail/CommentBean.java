package com.example.tianjun.projecttest.Bean.Detail;

import java.util.List;

/**
 * Created by xx on 2016/9/9.
 */
public class CommentBean {

    /**
     * result : success
     * msg : success
     * info : [{"id":"1567","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"水电费","add_time":"2016-09-09 09:46:11"},{"id":"1566","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"水电费","add_time":"2016-09-09 09:46:10"},{"id":"1565","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"水电费","add_time":"2016-09-09 09:46:09"},{"id":"1564","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"为了联盟","add_time":"2016-09-09 09:46:03"},{"id":"1562","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"666","add_time":"2016-09-09 09:06:24"},{"id":"1561","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"555","add_time":"2016-09-09 09:06:23"},{"id":"1560","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"44","add_time":"2016-09-09 09:06:21"},{"id":"1559","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"333","add_time":"2016-09-09 09:06:19"},{"id":"1558","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"22","add_time":"2016-09-09 09:06:18"},{"id":"1557","topic_id":"1870","user_name":"tjBlis","user_id":"28162","avatar":"http://img.fulishe.com/","content":"111","add_time":"2016-09-09 09:05:28"},{"id":"1556","topic_id":"1870","user_name":"段飞飞","user_id":"28187","avatar":"http://wx.qlogo.cn/mmopen/GvCsdt8hbCJlyekQNktP8IHb05xdibGaicYdia4LIvqwqMUBWwFZ7mPvUYQQWicNURYuYicBmqomXCy3eZBvgRW0FtA/0","content":"啊啦啦啦","add_time":"2016-09-08 10:56:08"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * id : 1567
     * topic_id : 1870
     * user_name : tjBlis
     * user_id : 28162
     * avatar : http://img.fulishe.com/
     * content : 水电费
     * add_time : 2016-09-09 09:46:11
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
        private String id;
        private String topic_id;
        private String user_name;
        private String user_id;
        private String avatar;
        private String content;
        private String add_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTopic_id() {
            return topic_id;
        }

        public void setTopic_id(String topic_id) {
            this.topic_id = topic_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
