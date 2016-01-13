package com.sz.weizy.passport.base.dao;

import com.sz.weizy.passport.base.SpringTransactionalTestCase;
import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.dao.entities.SnsUserExample;
import com.sz.weizy.passport.dao.mapper.SnsUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/26 0026.
 */
public class SnsUserMapperTest extends SpringTransactionalTestCase {
    @Autowired
    private SnsUserMapper snsUserMapper;

    public void test(){
        SnsUserExample snsUserExample = new SnsUserExample();
        snsUserExample.createCriteria().andIdGreaterThan(1);
        List<SnsUser> snsUsers = snsUserMapper.selectByExample(snsUserExample);
        System.out.println("====================");
        System.out.println(snsUsers);
    }
}
