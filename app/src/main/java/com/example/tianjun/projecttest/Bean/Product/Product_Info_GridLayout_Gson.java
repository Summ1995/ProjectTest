package com.example.tianjun.projecttest.Bean.Product;

import java.util.List;

/**
 * Created by vcc on 2016/9/11.
 */
public class Product_Info_GridLayout_Gson {

    /**
     * result : success
     * msg :
     * info : [{"goods_id":"11999","goods_name":"细带颈环 2件装","goods_english_name":"Zara","goods_thumb":"http://img.fulishe.com//images/201605/thumb_img/11999_thumb_G_1462346554124.png","shop_price":"￥169","currency_price":"￥199","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"11128","goods_name":"3段波浪形金色一字夹 30枚入（NO.806）","goods_english_name":"Y.S./PARK","goods_thumb":"http://img.fulishe.com//images/201603/thumb_img/11128_thumb_G_1458812972410.jpg","shop_price":"￥56","currency_price":"￥56","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"13246","goods_name":"Engaged爱心手镯","goods_english_name":"SWAROVSKI施华洛世奇","goods_thumb":"http://img.fulishe.com//images/201608/thumb_img/13246_thumb_G_1470294919745.jpg","shop_price":"￥1500","currency_price":"￥1500","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"13247","goods_name":"Dear Medium双心形项链","goods_english_name":"SWAROVSKI施华洛世奇","goods_thumb":"http://img.fulishe.com//images/201608/thumb_img/13247_thumb_G_1470295659153.jpg","shop_price":"￥1500","currency_price":"￥1500","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"12001","goods_name":"Barred for Life 18k玫瑰金短项链圈","goods_english_name":"Anita K","goods_thumb":"http://img.fulishe.com//images/201605/thumb_img/12001_thumb_G_1462346943953.png","shop_price":"￥60","currency_price":"￥520","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"12002","goods_name":"金属项圈式链条拼接短项链","goods_english_name":"StyleNanda","goods_thumb":"http://img.fulishe.com//images/201605/thumb_img/12002_thumb_G_1462347098964.png","shop_price":"￥19","currency_price":"￥233","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"12680","goods_name":"水晶珍宝繁花雅致发圈发绳","goods_english_name":"日本","goods_thumb":"http://img.fulishe.com//images/201606/thumb_img/12680_thumb_G_1465801013162.jpg","shop_price":"￥133","currency_price":"￥133","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"11129","goods_name":"三角形金属发夹（2色入）","goods_english_name":"Joudai","goods_thumb":"http://img.fulishe.com//images/201603/thumb_img/11129_thumb_G_1458813177714.png","shop_price":"￥1300","currency_price":"￥135","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"},{"goods_id":"12000","goods_name":"LA FEMME 短项链","goods_english_name":"Natalie B Jewelry","goods_thumb":"http://img.fulishe.com//images/201605/thumb_img/12000_thumb_G_1462346716164.png","shop_price":"￥37","currency_price":"￥359","service_price":"￥0","shipping_price":"￥0","rank_price":"￥0","promote_price":"￥0","is_promote":"0"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * goods_id : 11999
     * goods_name : 细带颈环 2件装
     * goods_english_name : Zara
     * goods_thumb : http://img.fulishe.com//images/201605/thumb_img/11999_thumb_G_1462346554124.png
     * shop_price : ￥169
     * currency_price : ￥199
     * service_price : ￥0
     * shipping_price : ￥0
     * rank_price : ￥0
     * promote_price : ￥0
     * is_promote : 0
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
        private String goods_id;
        private String goods_name;
        private String goods_english_name;
        private String goods_thumb;
        private String shop_price;
        private String currency_price;
        private String service_price;
        private String shipping_price;
        private String rank_price;
        private String promote_price;
        private String is_promote;

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

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }

        public String getService_price() {
            return service_price;
        }

        public void setService_price(String service_price) {
            this.service_price = service_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public String getRank_price() {
            return rank_price;
        }

        public void setRank_price(String rank_price) {
            this.rank_price = rank_price;
        }

        public String getPromote_price() {
            return promote_price;
        }

        public void setPromote_price(String promote_price) {
            this.promote_price = promote_price;
        }

        public String getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(String is_promote) {
            this.is_promote = is_promote;
        }
    }
}
