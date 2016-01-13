package com.sz.weizy.passport.service.impl.basic;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.spring.event.UserOpEvent;
import org.springframework.context.ApplicationEvent;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 */
public interface BasicService {

    /**
     * 发送一个订阅事件
     * @param event
     */
    void publishEvent(ApplicationEvent event);

    /**
     * 新建一个用户操作事件
     * @param snsUser
     * @return
     */
    UserOpEvent createUserOpEvent(Object source, SnsUser snsUser, String action);
}
