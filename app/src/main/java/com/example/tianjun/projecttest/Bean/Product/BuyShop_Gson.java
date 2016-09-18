package com.example.tianjun.projecttest.Bean.Product;

import java.util.List;

/**
 * Created by vcc on 2016/9/11.
 */
public class BuyShop_Gson {

    /**
     * result : success
     * msg :
     * info : [{"shop_name":"缦狄·雅蓝","title":"原创 高端 时尚 家纺","avatar":"http://img.fulishe.com/images/shop/201606/1466763867936695802.jpg","shop_id":"16","user_name":"缦狄·雅蓝","shop_banner":"http://img.fulishe.com/images/shop/201606/1466763867347086371.jpg","from_id":"16"},{"shop_name":"stosto整理生活","title":"中国家居整理领导品牌","avatar":"http://img.fulishe.com/images/shop/201508/1440483918008556737.jpg","shop_id":"8","user_name":"整理生活","shop_banner":"http://img.fulishe.com/images/shop/201603/1457084610049150171.jpg","from_id":"15"},{"shop_name":"HIMIKO小店","title":"日本美国 热销单品 享品质 惠生活","avatar":"http://img.fulishe.com/images/shop/201502/1417144523579205725.jpg","shop_id":"1","user_name":"HIMIKO","shop_banner":"http://img.fulishe.com/images/shop/201601/1451905893826884915.jpg","from_id":"13"},{"shop_name":"Onebite","title":"精致的不像零食","avatar":"http://img.fulishe.com/images/shop/201602/1456743821424506645.png","shop_id":"15","user_name":"Onebite","shop_banner":"http://img.fulishe.com/images/shop/201602/1456743821510418996.png","from_id":"12"},{"shop_name":"Revolve专场","title":"美国时尚潮流购物网站","avatar":"http://img.fulishe.com/images/shop/201502/1423975958644063218.png","shop_id":"4","user_name":"Revolve专场","shop_banner":"http://img.fulishe.com/images/shop/201601/1451906064725441181.jpg","from_id":"10"},{"shop_name":"牛尔专场","title":"NAROKO美容教主牛尔亲研","avatar":"http://img.fulishe.com/images/shop/201502/1423976011865163078.png","shop_id":"5","user_name":"牛尔专场","shop_banner":"http://img.fulishe.com/images/shop/201502/n-bg.png","from_id":"9"},{"shop_name":"AlmaWin","title":"有机·源自绿色的安全","avatar":"http://img.fulishe.com/images/shop/201511/1448355559552672738.png","shop_id":"11","user_name":"AlmaWin","shop_banner":"http://img.fulishe.com/images/shop/201511/1448520827332332501.jpg","from_id":"6"},{"shop_name":"KriKri小店","title":"好用的母婴产品尽在这儿","avatar":"http://img.fulishe.com/images/shop/201502/1418808057366463693.jpg","shop_id":"2","user_name":"KriKri","shop_banner":"http://img.fulishe.com/images/shop/201502/KK.png","from_id":"4"},{"shop_name":"NEIWAI内外","title":"专注女性极致舒适体验 高端内衣设计品牌","avatar":"http://img.fulishe.com/images/shop/201503/1426221093346594116.png","shop_id":"7","user_name":"NEIWAI内外","shop_banner":"http://img.fulishe.com/images/shop/201503/1426221093987109778.jpg","from_id":"3"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * shop_name : 缦狄·雅蓝
     * title : 原创 高端 时尚 家纺
     * avatar : http://img.fulishe.com/images/shop/201606/1466763867936695802.jpg
     * shop_id : 16
     * user_name : 缦狄·雅蓝
     * shop_banner : http://img.fulishe.com/images/shop/201606/1466763867347086371.jpg
     * from_id : 16
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
        private String shop_name;
        private String title;
        private String avatar;
        private String shop_id;
        private String user_name;
        private String shop_banner;
        private String from_id;

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getShop_banner() {
            return shop_banner;
        }

        public void setShop_banner(String shop_banner) {
            this.shop_banner = shop_banner;
        }

        public String getFrom_id() {
            return from_id;
        }

        public void setFrom_id(String from_id) {
            this.from_id = from_id;
        }
    }
}
