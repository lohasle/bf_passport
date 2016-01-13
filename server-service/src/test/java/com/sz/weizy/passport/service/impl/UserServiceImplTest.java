package com.sz.weizy.passport.service.impl;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.service.SpringTransactionalTestCase;
import com.sz.weizy.passport.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 */
public class UserServiceImplTest extends SpringTransactionalTestCase {
    @Autowired
    private UserService userService;

    @Test
    public void testqrySnsUserByNameOrPhone(){
        String name = "admin";
        SnsUser snsUser = userService.getSnsUserByNameOrPhone(name);
        System.out.println(snsUser);
    }
}
