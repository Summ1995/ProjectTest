package com.example.tianjun.projecttest.Bean.Home;

import java.util.List;

/**
 * Created by xx on 2016/9/6.
 */
public class TabBean {

    /**
     * result : success
     * msg :
     * info : [{"cat_id":"0","cat_name":"全部"},{"cat_id":"14","cat_name":"节日"},{"cat_id":"23","cat_name":"明星"},{"cat_id":"22","cat_name":"日韩"},{"cat_id":"4","cat_name":"包包"},{"cat_id":"9","cat_name":"美妆"},{"cat_id":"30","cat_name":"母婴"},{"cat_id":"7","cat_name":"家居"},{"cat_id":"12","cat_name":"运动"},{"cat_id":"20","cat_name":"吃货"},{"cat_id":"13","cat_name":"职场"}]
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
