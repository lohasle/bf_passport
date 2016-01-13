package com.sz.weizy.passport.spring.event;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.pojo.UserBrowserInfo;
import org.springframework.context.ApplicationEvent;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 * 用户行为事件
 *
 */
public class UserOpEvent extends ApplicationEvent {

    // 登入
    public final static String ACTION_LOGIN = "login";

    // 登出
    public final static String ACTION_LOGOUT = "logout";

    private SnsUser snsUser;
    private String action;
    private UserBrowserInfo userBrowserInfo;
    public UserOpEvent(Object source, SnsUser snsUser, String action, UserBrowserInfo userBrowserInfo) {
        super(source);
        this.snsUser = snsUser;
        this.action= action;
        this.userBrowserInfo = userBrowserInfo;
    }

    public SnsUser getSnsUser() {
        return snsUser;
    }

    public void setSnsUser(SnsUser snsUser) {
        this.snsUser = snsUser;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public UserBrowserInfo getUserBrowserInfo() {
        return userBrowserInfo;
    }

    public void setUserBrowserInfo(UserBrowserInfo userBrowserInfo) {
        this.userBrowserInfo = userBrowserInfo;
    }
}
