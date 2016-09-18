package com.example.tianjun.projecttest.Bean.Me;

import java.util.List;

/**
 * Created by vcc on 2016/9/14.
 */
public class Me_Ranking_Gson {

    /**
     * result : success
     * msg :
     * info : [{"invite_name":"JAMES.LI","invite_info":"邀请了659位好友","invite_level":"No.1"},{"invite_name":"Roxanol.","invite_info":"邀请了593位好友","invite_level":"No.2"},{"invite_name":"蛋蛋","invite_info":"邀请了539位好友","invite_level":"No.3"}]
     * jf_tip :
     */

    private String result;
    private String msg;
    private String jf_tip;
    /**
     * invite_name : JAMES.LI
     * invite_info : 邀请了659位好友
     * invite_level : No.1
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
        private String invite_name;
        private String invite_info;
        private String invite_level;

        public String getInvite_name() {
            return invite_name;
        }

        public void setInvite_name(String invite_name) {
            this.invite_name = invite_name;
        }

        public String getInvite_info() {
            return invite_info;
        }

        public void setInvite_info(String invite_info) {
            this.invite_info = invite_info;
        }

        public String getInvite_level() {
            return invite_level;
        }

        public void setInvite_level(String invite_level) {
            this.invite_level = invite_level;
        }
    }
}
