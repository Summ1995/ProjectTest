package com.example.tianjun.projecttest.Bean.Product;

import java.util.List;

/**
 * Created by vcc on 2016/9/10.
 */
public class Product_Info_ReadMe_Gson {

    /**
     * result : success
     * msg :
     * info : [{"topic_id":"1414","title":"一杯不倒 | 清新好味当然Mojito！","topic_img":"http://img.fulishe.com/images/topic/201604/1461729190781073609.jpg","add_time":"2016-04-27"},{"topic_id":"660","title":"这些孩子在Instagram上已经火的不要不要的！","topic_img":"http://img.fulishe.com/images/topic/201509/1442992312128666683.jpg","add_time":"2015-09-23"},{"topic_id":"1454","title":"家有二宝 高级玩具应对脑洞大开的娃","topic_img":"http://img.fulishe.com/images/topic/201605/1462516292464240878.jpg","add_time":"2016-05-07"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * topic_id : 1414
     * title : 一杯不倒 | 清新好味当然Mojito！
     * topic_img : http://img.fulishe.com/images/topic/201604/1461729190781073609.jpg
     * add_time : 2016-04-27
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
