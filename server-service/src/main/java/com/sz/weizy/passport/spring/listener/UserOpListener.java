package com.sz.weizy.passport.spring.listener;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 */

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.pojo.UserBrowserInfo;
import com.sz.weizy.passport.service.UserService;
import com.sz.weizy.passport.spring.event.UserOpEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 用户登录事件监听程序
 */
@Component
public class UserOpListener implements ApplicationListener<UserOpEvent> {

    @Autowired
    private UserService userService;


    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(UserOpEvent event) {
        SnsUser snsUser = event.getSnsUser();
        UserBrowserInfo userBrowserInfo = event.getUserBrowserInfo();
        String action = event.getAction();
        userService.addUserEventLog(snsUser,action,userBrowserInfo);
    }
}
