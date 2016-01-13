package com.sz.weizy.passport.service;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.pojo.Message;
import com.sz.weizy.passport.pojo.UserBrowserInfo;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 */
public interface UserService {

    /**
     * 登录接口
     * <pre>
     * </pre>
     * @param str 用户名或者电话号码
     * @param password  密码 base64 or 明文密码
     * @return
     */
    Message login(String str, String password);


    /**
     * 验证密码
     * @param snsUser
     * @param pwd
     * @return
     */
    boolean validateUserPwd(SnsUser snsUser,String pwd);


    /**
     * 根据用户名或者电话号码 得到用户
     * @param string
     * @return
     */
    SnsUser getSnsUserByNameOrPhone(String string);


    /**
     * 添加用户行为日志
     * @param snsUser
     * @param action
     * @param userBrowserInfo
     */
    void addUserEventLog(SnsUser snsUser,String action,UserBrowserInfo userBrowserInfo);


}
