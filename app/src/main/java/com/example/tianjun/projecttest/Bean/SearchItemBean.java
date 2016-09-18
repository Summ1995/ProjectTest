package com.example.tianjun.projecttest.Bean;

import java.util.List;

/**
 * Created by xx on 2016/9/18.
 */
public class SearchItemBean {
    /**
     * result : success
     * msg :
     * info : ["防晒","减肥","面膜","咖啡","眼药水","口罩","鞋","洗发水","太阳镜","日本"]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    private List<String> info;

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

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }
}
