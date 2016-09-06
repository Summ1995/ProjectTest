package com.example.tianjun.projecttest.Bean.Product;

import java.util.List;

/**
 * Created by vcc on 2016/9/6.
 */
public class Product_Head_Gson {

    /**
     * result : success
     * msg :
     * info : {"items":[{"title":"Dr arrivo 美容仪器THE VEGAS","banner_id":"41","target_id":"10734","target_type":"1","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201609/1473148608732818572.jpg"},{"title":"大食品 陆家村有机稻米 2.5kg","banner_id":"38","target_id":"13173","target_type":"1","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201608/1471246308431092063.jpg"},{"title":"Le Mandalay缦狄雅蓝 回忆床品四件套220x240cm","banner_id":"37","target_id":"12872","target_type":"1","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201608/1471246067850965139.jpg"},{"title":"无锡阳山 水蜜桃/湖景桃 礼盒","banner_id":"36","target_id":"13111","target_type":"1","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201608/1471245940156266609.jpg"},{"title":"DAFNI健康直发梳","banner_id":"35","target_id":"13227","target_type":"1","url":"","banner_image":"http://img.fulishe.com/images/topic_banner/201608/1470215179575153648.jpg"}],"recommend":[{"cat_id":"361","cat_image":"http://img.fulishe.com/images/c_5.png","cat_name":"现货秒杀"},{"cat_id":"189","cat_image":"http://img.fulishe.com/images/c_6.png","cat_name":"海淘专区"},{"cat_id":"hot_week_goods_list","cat_image":"http://img.fulishe.com/images/c_7.png","cat_name":"最近热门"},{"cat_id":"348","cat_image":"http://img.fulishe.com/images/c_8.png","cat_name":"为您推荐"}],"crowd_list":[],"goods_list":[{"goods_id":"13401","goods_name":"鲜芡实鸡头米礼盒","goods_english_name":"家有芡实","rank_price":"￥0","add_time":"1472813256","currency_price":"￥570","goods_thumb":"http://img.fulishe.com/images/201609/thumb_img/13401_thumb_G_1472813256003.jpg","service_price":"0.00","is_recommended":"0","is_on_sale":"1","is_promote":"0","isNew":"0"},{"goods_id":"13389","goods_name":"Evita 3D泡沫玫瑰抗衰老洗面奶","goods_english_name":"[预定] Kanebo 嘉娜宝","rank_price":"￥0","add_time":"1472634571","currency_price":"￥185","goods_thumb":"http://img.fulishe.com/images/201608/thumb_img/13389_thumb_G_1472634571804.png","service_price":"0.00","is_recommended":"0","is_on_sale":"1","is_promote":"0","isNew":"0"},{"goods_id":"13390","goods_name":"手工台湾凤梨酥小礼盒 8个入","goods_english_name":"若芸妈","rank_price":"￥0","add_time":"1472636996","currency_price":"￥138","goods_thumb":"http://img.fulishe.com/images/201608/thumb_img/13390_thumb_G_1472636996406.jpg","service_price":"0.00","is_recommended":"0","is_on_sale":"1","is_promote":"0","isNew":"0"},{"goods_id":"13391","goods_name":"手工台湾凤梨酥小礼盒 12个入","goods_english_name":"若芸妈","rank_price":"￥0","add_time":"1472637291","currency_price":"￥168","goods_thumb":"http://img.fulishe.com/images/201608/thumb_img/13391_thumb_G_1472637291666.jpg","service_price":"0.00","is_recommended":"0","is_on_sale":"1","is_promote":"0","isNew":"0"},{"goods_id":"13403","goods_name":"鲜芡实鸡头米 200g","goods_english_name":"家有芡实","rank_price":"￥0","add_time":"1472814116","currency_price":"￥88","goods_thumb":"http://img.fulishe.com/images/201609/thumb_img/13403_thumb_G_1472814116338.jpg","service_price":"0.00","is_recommended":"0","is_on_sale":"1","is_promote":"0","isNew":"0"},{"goods_id":"13402","goods_name":"鲜芡实鸡头米 400g","goods_english_name":"家有芡实","rank_price":"￥0","add_time":"1472813664","currency_price":"￥138","goods_thumb":"http://img.fulishe.com/images/201609/thumb_img/13402_thumb_G_1472813664587.jpg","service_price":"0.00","is_recommended":"0","is_on_sale":"1","is_promote":"0","isNew":"0"}]}
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
         * title : Dr arrivo 美容仪器THE VEGAS
         * banner_id : 41
         * target_id : 10734
         * target_type : 1
         * url :
         * banner_image : http://img.fulishe.com/images/topic_banner/201609/1473148608732818572.jpg
         */

        private List<ItemsBean> items;
        /**
         * cat_id : 361
         * cat_image : http://img.fulishe.com/images/c_5.png
         * cat_name : 现货秒杀
         */

        private List<RecommendBean> recommend;
        private List<?> crowd_list;
        /**
         * goods_id : 13401
         * goods_name : 鲜芡实鸡头米礼盒
         * goods_english_name : 家有芡实
         * rank_price : ￥0
         * add_time : 1472813256
         * currency_price : ￥570
         * goods_thumb : http://img.fulishe.com/images/201609/thumb_img/13401_thumb_G_1472813256003.jpg
         * service_price : 0.00
         * is_recommended : 0
         * is_on_sale : 1
         * is_promote : 0
         * isNew : 0
         */

        private List<GoodsListBean> goods_list;

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<?> getCrowd_list() {
            return crowd_list;
        }

        public void setCrowd_list(List<?> crowd_list) {
            this.crowd_list = crowd_list;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
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

        public static class RecommendBean {
            private String cat_id;
            private String cat_image;
            private String cat_name;

            public String getCat_id() {
                return cat_id;
            }

            public void setCat_id(String cat_id) {
                this.cat_id = cat_id;
            }

            public String getCat_image() {
                return cat_image;
            }

            public void setCat_image(String cat_image) {
                this.cat_image = cat_image;
            }

            public String getCat_name() {
                return cat_name;
            }

            public void setCat_name(String cat_name) {
                this.cat_name = cat_name;
            }
        }

        public static class GoodsListBean {
            private String goods_id;
            private String goods_name;
            private String goods_english_name;
            private String rank_price;
            private String add_time;
            private String currency_price;
            private String goods_thumb;
            private String service_price;
            private String is_recommended;
            private String is_on_sale;
            private String is_promote;
            private String isNew;

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

            public String getGoods_english_name() {
                return goods_english_name;
            }

            public void setGoods_english_name(String goods_english_name) {
                this.goods_english_name = goods_english_name;
            }

            public String getRank_price() {
                return rank_price;
            }

            public void setRank_price(String rank_price) {
                this.rank_price = rank_price;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getCurrency_price() {
                return currency_price;
            }

            public void setCurrency_price(String currency_price) {
                this.currency_price = currency_price;
            }

            public String getGoods_thumb() {
                return goods_thumb;
            }

            public void setGoods_thumb(String goods_thumb) {
                this.goods_thumb = goods_thumb;
            }

            public String getService_price() {
                return service_price;
            }

            public void setService_price(String service_price) {
                this.service_price = service_price;
            }

            public String getIs_recommended() {
                return is_recommended;
            }

            public void setIs_recommended(String is_recommended) {
                this.is_recommended = is_recommended;
            }

            public String getIs_on_sale() {
                return is_on_sale;
            }

            public void setIs_on_sale(String is_on_sale) {
                this.is_on_sale = is_on_sale;
            }

            public String getIs_promote() {
                return is_promote;
            }

            public void setIs_promote(String is_promote) {
                this.is_promote = is_promote;
            }

            public String getIsNew() {
                return isNew;
            }

            public void setIsNew(String isNew) {
                this.isNew = isNew;
            }
        }
    }
}
