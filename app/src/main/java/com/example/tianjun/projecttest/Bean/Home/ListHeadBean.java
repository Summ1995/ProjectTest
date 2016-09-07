package com.example.tianjun.projecttest.Bean.Home;

import java.util.List;

/**
 * Created by xx on 2016/9/7.
 */
public class ListHeadBean {

    /**
     * result : success
     * msg :
     * info : {"items":[{"title":"除甲醛 福丽社这次来真的","banner_id":"40","target_id":"40","target_type":"11","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201608/1471489722025354655.jpg"},{"title":"福丽社面膜大赏","banner_id":"39","target_id":"39","target_type":"11","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201608/1471345996075787047.jpg"},{"title":"食器的生活美学","banner_id":"31","target_id":"38","target_type":"11","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201606/1467026614513872242.jpg"}]}
     * jf_tip :
     */

    private String result;
    private String msg;
    private InfoBean info;
    private String jf_tip;

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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public String getJf_tip() {
        return jf_tip;
    }

    public void setJf_tip(String jf_tip) {
        this.jf_tip = jf_tip;
    }

    public static class InfoBean {
        /**
         * title : 除甲醛 福丽社这次来真的
         * banner_id : 40
         * target_id : 40
         * target_type : 11
         * url :
         * banner_image : http://img.fulishe.com/images/topic_banner/201608/1471489722025354655.jpg
         */

        private List<ItemsBean> items;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private String title;
            private String banner_id;
            private String target_id;
            private String target_type;
            private String url;
            private String banner_image;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBanner_id() {
                return banner_id;
            }

            public void setBanner_id(String banner_id) {
                this.banner_id = banner_id;
            }

            public String getTarget_id() {
                return target_id;
            }

            public void setTarget_id(String target_id) {
                this.target_id = target_id;
            }

            public String getTarget_type() {
                return target_type;
            }

            public void setTarget_type(String target_type) {
                this.target_type = target_type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getBanner_image() {
                return banner_image;
            }

            public void setBanner_image(String banner_image) {
                this.banner_image = banner_image;
            }
        }
    }
}
