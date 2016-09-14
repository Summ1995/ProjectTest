package com.example.tianjun.projecttest.Bean.Show;

import java.util.List;

/**
 * Created by xx on 2016/9/13.
 */
public class CategoryBean {

    /**
     * result : success
     * msg :
     * info : [{"category_name":"这个世界看脸","category_id":"1"},{"category_name":"头发也很重要","category_id":"2"},{"category_name":"时尚女王","category_id":"3"},{"category_name":"鞋还差几双","category_id":"4"},{"category_name":"伐开心买包包","category_id":"5"},{"category_name":"妈咪优选","category_id":"6"},{"category_name":"生活百货","category_id":"7"},{"category_name":"白菜挖宝","category_id":"8"},{"category_name":"我爱折扣","category_id":"10"},{"category_name":"吃货排排坐","category_id":"9"},{"category_name":"海淘资讯站","category_id":"11"},{"category_name":"现货转让区","category_id":"12"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * category_name : 这个世界看脸
     * category_id : 1
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
        private String category_name;
        private String category_id;

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }
    }
}
