package com.sz.weizy.passport.pojo;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 * 用户浏览器 信息
 */
public class UserBrowserInfo {
    /**
     * ip
     */
    private String ip;
    /**
     * 来源 v.weizy.cn book.weizy.cn app
     */
    private String origin;
    /**
     * 浏览器标示
     */
    private String userAgent;
    /**
     * 登录附加的版本信息
     * 如
     * {"client":"android","version":"1.0.0"}
     */
    private String vInfo;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getvInfo() {
        return vInfo;
    }

    public void setvInfo(String vInfo) {
        this.vInfo = vInfo;
    }
}
