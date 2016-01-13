package com.sz.weizy.passport.service.impl.basic;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.pojo.UserBrowserInfo;
import com.sz.weizy.passport.spring.event.UserOpEvent;
import com.sz.weizy.passport.utils.WebUtils;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 */
public class BasicServiceImpl implements BasicService, ApplicationEventPublisherAware {


    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    /**
     * 发送一个订阅事件(异步)
     *
     * @param event
     */
    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 新建一个用户操作事件
     *
     * @param snsUser
     * @return
     */
    @Override
    public UserOpEvent createUserOpEvent(Object source, SnsUser snsUser, String action) {
        HttpServletRequest request = WebUtils.getHttpServletRequest();
        UserBrowserInfo userBrowserInfo = new UserBrowserInfo();
        userBrowserInfo.setIp(WebUtils.getRealIp());
//        userBrowserInfo.setOrigin();
//        userBrowserInfo.setvInfo();
        userBrowserInfo.setUserAgent(request.getHeader("User-Agent"));
        UserOpEvent userOpEvent = new UserOpEvent(source,snsUser,action,userBrowserInfo);
        return userOpEvent;
    }
}
