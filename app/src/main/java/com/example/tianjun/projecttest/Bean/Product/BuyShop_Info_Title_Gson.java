package com.example.tianjun.projecttest.Bean.Product;

/**
 * Created by vcc on 2016/9/13.
 */
public class BuyShop_Info_Title_Gson {

    /**
     * result : success
     * msg :
     * info : {"shop_id":"4","title":"美国时尚潮流购物网站","shop_name":"Revolve专场","user_name":"Revolve专场","avatar":"http://img.fulishe.com/images/shop/201502/1423975958644063218.png","description":"美国时尚潮流购物网站。提供高端设计师品牌服装，配饰和精挑细选的各种生活用品。可直邮中国，现已成为全球领先的时尚服饰零售商之一。","shop_banner":"http://img.fulishe.com/images/shop/201601/1451906064725441181.jpg","user_id":"2687","attention":"0","goods_count":"0","topic_count":"0"}
     * jf_tip :
     */

    private String result;
    private String msg;
    /**
     * shop_id : 4
     * title : 美国时尚潮流购物网站
     * shop_name : Revolve专场
     * user_name : Revolve专场
     * avatar : http://img.fulishe.com/images/shop/201502/1423975958644063218.png
     * description : 美国时尚潮流购物网站。提供高端设计师品牌服装，配饰和精挑细选的各种生活用品。可直邮中国，现已成为全球领先的时尚服饰零售商之一。
     * shop_banner : http://img.fulishe.com/images/shop/201601/1451906064725441181.jpg
     * user_id : 2687
     * attention : 0
     * goods_count : 0
     * topic_count : 0
     */

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
        private String shop_id;
        private String title;
        private String shop_name;
        private String user_name;
        private String avatar;
        private String description;
        private String shop_banner;
        private String user_id;
        private String attention;
        private String goods_count;
        private String topic_count;

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getShop_banner() {
            return shop_banner;
        }

        public void setShop_banner(String shop_banner) {
            this.shop_banner = shop_banner;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getAttention() {
            return attention;
        }

        public void setAttention(String attention) {
            this.attention = attention;
        }

        public String getGoods_count() {
            return goods_count;
        }

        public void setGoods_count(String goods_count) {
            this.goods_count = goods_count;
        }

        public String getTopic_count() {
            return topic_count;
        }

        public void setTopic_count(String topic_count) {
            this.topic_count = topic_count;
        }
    }
}
