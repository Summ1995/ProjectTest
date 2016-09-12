package com.example.tianjun.projecttest.Bean.Welcome;

/**
 * Created by xx on 2016/9/12.
 */
public class WelcomeBean {

    /**
     * result : success
     * msg :
     * info : {"title":"全场免运费","banner_id":"12","target_id":"0","target_type":"2","url":"","banner_image":{"img_1":"http://img.fulishe.com/images/appinit/init_iphone4_6.jpg","img_2":"http://img.fulishe.com/images/appinit/init_iphone5s_6.jpg","img_3":"http://img.fulishe.com/images/appinit/init_iphone6_6.jpg","img_4":"http://img.fulishe.com/images/appinit/init_iphone6plus_6.jpg"},"duration":"3","button_title":""}
     * jf_tip :
     */

    private String result;
    private String msg;
    /**
     * title : 全场免运费
     * banner_id : 12
     * target_id : 0
     * target_type : 2
     * url :
     * banner_image : {"img_1":"http://img.fulishe.com/images/appinit/init_iphone4_6.jpg","img_2":"http://img.fulishe.com/images/appinit/init_iphone5s_6.jpg","img_3":"http://img.fulishe.com/images/appinit/init_iphone6_6.jpg","img_4":"http://img.fulishe.com/images/appinit/init_iphone6plus_6.jpg"}
     * duration : 3
     * button_title :
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
        private String title;
        private String banner_id;
        private String target_id;
        private String target_type;
        private String url;
        /**
         * img_1 : http://img.fulishe.com/images/appinit/init_iphone4_6.jpg
         * img_2 : http://img.fulishe.com/images/appinit/init_iphone5s_6.jpg
         * img_3 : http://img.fulishe.com/images/appinit/init_iphone6_6.jpg
         * img_4 : http://img.fulishe.com/images/appinit/init_iphone6plus_6.jpg
         */

        private BannerImageBean banner_image;
        private String duration;
        private String button_title;

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

        public BannerImageBean getBanner_image() {
            return banner_image;
        }

        public void setBanner_image(BannerImageBean banner_image) {
            this.banner_image = banner_image;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getButton_title() {
            return button_title;
        }

        public void setButton_title(String button_title) {
            this.button_title = button_title;
        }

        public static class BannerImageBean {
            private String img_1;
            private String img_2;
            private String img_3;
            private String img_4;

            public String getImg_1() {
                return img_1;
            }

            public void setImg_1(String img_1) {
                this.img_1 = img_1;
            }

            public String getImg_2() {
                return img_2;
            }

            public void setImg_2(String img_2) {
                this.img_2 = img_2;
            }

            public String getImg_3() {
                return img_3;
            }

            public void setImg_3(String img_3) {
                this.img_3 = img_3;
            }

            public String getImg_4() {
                return img_4;
            }

            public void setImg_4(String img_4) {
                this.img_4 = img_4;
            }
        }
    }
}
