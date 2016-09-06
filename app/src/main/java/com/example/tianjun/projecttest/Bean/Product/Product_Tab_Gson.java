package com.example.tianjun.projecttest.Bean.Product;

import java.util.List;

/**
 * Created by vcc on 2016/9/6.
 */
public class Product_Tab_Gson {

    /**
     * result : success
     * msg :
     * info : [{"cat_id":"0","cat_name":"全部"},{"cat_id":"discount","cat_name":"折扣"},{"cat_id":"285","cat_name":"个人护理"},{"cat_id":"261","cat_name":"美妆"},{"cat_id":"307","cat_name":"包包"},{"cat_id":"286","cat_name":"运动"},{"cat_id":"289","cat_name":"小家电"},{"cat_id":"293","cat_name":"衣服"},{"cat_id":"323","cat_name":"靴子"},{"cat_id":"284","cat_name":"美食"},{"cat_id":"334","cat_name":"配饰"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * cat_id : 0
     * cat_name : 全部
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
        private String cat_id;
        private String cat_name;

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }
    }
}
