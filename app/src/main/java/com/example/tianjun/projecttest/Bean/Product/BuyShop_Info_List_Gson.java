package com.example.tianjun.projecttest.Bean.Product;

import java.util.List;

/**
 * Created by vcc on 2016/9/13.
 */
public class BuyShop_Info_List_Gson {

    /**
     * result : success
     * msg :
     * info : [{"topic_id":"1221","title":"让妇女瞬间变成少女心的三八节好礼！","topic_img":"http://img.fulishe.com/images/topic/201603/1456906278060067176.jpg","sort_order":"68.00001221","add_time":"2016-03-02","keywords":["三八节","三八","妇女节","妇女","礼物","少女","软妹纸"],"views":"821","intro":"感谢这个能让所有女人用最合理的理由，名正言顺买买买的伟大节日！","isNew":"0","goods_list":[{"image_path":"http://img.fulishe.com/images/topic/201603/1456904173661227327.jpg","height":"439","width":"500","currency_price":"￥398","rank_price":"￥0","is_promote":"0","goods_id":"9707","goods_name":"Vigene 第三代蛇毒眼膜60片"},{"image_path":"http://img.fulishe.com/images/topic/201603/1456904858541555072.jpg","height":"240","width":"267","currency_price":"￥498","rank_price":"￥0","is_promote":"0","goods_id":"10366","goods_name":"Fissler 菲仕乐 保龄球胡椒研磨器套装"},{"image_path":"http://img.fulishe.com/images/topic/201603/1456904902461267905.jpg","height":"800","width":"800","currency_price":"￥119","rank_price":"￥0","is_promote":"0","goods_id":"10760","goods_name":"整理生活 德国压蒜器"},{"image_path":"http://img.fulishe.com/images/topic/201603/1456904908454794839.jpg","height":"800","width":"800","currency_price":"￥99","rank_price":"￥0","is_promote":"0","goods_id":"10752","goods_name":"整理生活 果蔬滤水盆 清洗沥干二合一"}],"share_url":"http://m.fulishe.com/topic/1221"},{"topic_id":"616","title":"不是主妇怎么会懂！这些生活小物可管用了","topic_img":"http://img.fulishe.com/images/topic/201509/1441868654081244894.jpg","sort_order":"1.00000616","add_time":"2015-09-11","keywords":["福丽社"],"views":"1287","intro":"买这些乱七八糟的小东西干嘛？听到这些话，主妇们就容易动怒！你懂什么？这些东西可管用了，不做家务的人，少说话！","isNew":"0","goods_list":[{"image_path":"http://img.fulishe.com/images/topic/201509/1441868639584075925.jpg","height":"500","width":"500","currency_price":"￥79","rank_price":"￥0","is_promote":"0","goods_id":"7500","goods_name":"整理生活 折叠环保购物袋"}],"share_url":"http://m.fulishe.com/topic/616"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * topic_id : 1221
     * title : 让妇女瞬间变成少女心的三八节好礼！
     * topic_img : http://img.fulishe.com/images/topic/201603/1456906278060067176.jpg
     * sort_order : 68.00001221
     * add_time : 2016-03-02
     * keywords : ["三八节","三八","妇女节","妇女","礼物","少女","软妹纸"]
     * views : 821
     * intro : 感谢这个能让所有女人用最合理的理由，名正言顺买买买的伟大节日！
     * isNew : 0
     * goods_list : [{"image_path":"http://img.fulishe.com/images/topic/201603/1456904173661227327.jpg","height":"439","width":"500","currency_price":"￥398","rank_price":"￥0","is_promote":"0","goods_id":"9707","goods_name":"Vigene 第三代蛇毒眼膜60片"},{"image_path":"http://img.fulishe.com/images/topic/201603/1456904858541555072.jpg","height":"240","width":"267","currency_price":"￥498","rank_price":"￥0","is_promote":"0","goods_id":"10366","goods_name":"Fissler 菲仕乐 保龄球胡椒研磨器套装"},{"image_path":"http://img.fulishe.com/images/topic/201603/1456904902461267905.jpg","height":"800","width":"800","currency_price":"￥119","rank_price":"￥0","is_promote":"0","goods_id":"10760","goods_name":"整理生活 德国压蒜器"},{"image_path":"http://img.fulishe.com/images/topic/201603/1456904908454794839.jpg","height":"800","width":"800","currency_price":"￥99","rank_price":"￥0","is_promote":"0","goods_id":"10752","goods_name":"整理生活 果蔬滤水盆 清洗沥干二合一"}]
     * share_url : http://m.fulishe.com/topic/1221
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
        private String sort_order;
        private String add_time;
        private String views;
        private String intro;
        private String isNew;
        private String share_url;
        private List<String> keywords;
        /**
         * image_path : http://img.fulishe.com/images/topic/201603/1456904173661227327.jpg
         * height : 439
         * width : 500
         * currency_price : ￥398
         * rank_price : ￥0
         * is_promote : 0
         * goods_id : 9707
         * goods_name : Vigene 第三代蛇毒眼膜60片
         */

        private List<GoodsListBean> goods_list;

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

        public String getSort_order() {
            return sort_order;
        }

        public void setSort_order(String sort_order) {
            this.sort_order = sort_order;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public List<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class GoodsListBean {
            private String image_path;
            private String height;
            private String width;
            private String currency_price;
            private String rank_price;
            private String is_promote;
            private String goods_id;
            private String goods_name;

            public String getImage_path() {
                return image_path;
            }

            public void setImage_path(String image_path) {
                this.image_path = image_path;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getCurrency_price() {
                return currency_price;
            }

            public void setCurrency_price(String currency_price) {
                this.currency_price = currency_price;
            }

            public String getRank_price() {
                return rank_price;
            }

            public void setRank_price(String rank_price) {
                this.rank_price = rank_price;
            }

            public String getIs_promote() {
                return is_promote;
            }

            public void setIs_promote(String is_promote) {
                this.is_promote = is_promote;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }
        }
    }
}
