package com.sz.weizy.passport.cas;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.service.UserService;
import org.jasig.services.persondir.IPersonAttributes;
import org.jasig.services.persondir.support.AttributeNamedPersonImpl;
import org.jasig.services.persondir.support.StubPersonAttributeDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lohas on 2015/11/21 0021.
 * 身份认证信息 返回
 */
public class SnsStubPersonAttributeDao extends StubPersonAttributeDao {

    @Autowired
    private UserService userService;

    @Override
    public IPersonAttributes getPerson(String uid) {
        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();

        SnsUser snsUser = userService.getSnsUserByNameOrPhone(uid);

        Integer id = snsUser.getId();
        String userName = snsUser.getUserName();
        String avatar = snsUser.getAvatar();
        String ucToken = snsUser.getUcToken();

        attributes.put("userId", Collections.singletonList((Object) id));
        attributes.put("userName", Collections.singletonList((Object) userName));
        attributes.put("avatar", Collections.singletonList((Object) avatar));
        attributes.put("ucToken", Collections.singletonList((Object) ucToken));
        return new AttributeNamedPersonImpl(attributes);
    }

}
