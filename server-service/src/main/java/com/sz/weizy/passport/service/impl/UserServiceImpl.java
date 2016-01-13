package com.sz.weizy.passport.service.impl;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.dao.entities.SnsUserEventLog;
import com.sz.weizy.passport.dao.mapper.SnsUserEventLogMapper;
import com.sz.weizy.passport.dao.mapper.SnsUserMapper;
import com.sz.weizy.passport.pojo.Message;
import com.sz.weizy.passport.pojo.MessageErrorCode;
import com.sz.weizy.passport.pojo.UserBrowserInfo;
import com.sz.weizy.passport.service.UserService;
import com.sz.weizy.passport.service.impl.basic.BasicService;
import com.sz.weizy.passport.service.impl.basic.BasicServiceImpl;
import com.sz.weizy.passport.spring.event.UserOpEvent;
import com.sz.weizy.passport.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/27 0027.
 * 用户业务类
 */
@Service
public class UserServiceImpl extends BasicServiceImpl implements UserService,BasicService {



    @Autowired
    private SnsUserMapper snsUserMapper;


    @Autowired
    private SnsUserEventLogMapper snsUserEventLogMapper;

    /**
     * 登录接口
     * <pre>
     * </pre>
     *
     * @param str      用户名或者电话号码
     * @param password 密码 base64 or 明文密码
     * @return
     */
    @Override
    public Message login(String str, String password) {

        // 错误提示
        MessageErrorCode messageErrorCode = StringUtils.isNumeric(str) ? MessageErrorCode.SYS_LOGIN_ERROR : MessageErrorCode.SYS_LOGIN_ERROR1;

        // check
        if (StringUtils.isBlank(str) || StringUtils.isBlank(password)) {
            return new Message(Message.STATE_FALSE, messageErrorCode);
        }

        // 1
        SnsUser snsUser = snsUserMapper.qrySnsUserByNameOrPhone(str);


        if (snsUser != null && validateUserPwd(snsUser, password)) {
            // 登录成功

            // 记录用户行为通知
            publishEvent(createUserOpEvent(this,snsUser,UserOpEvent.ACTION_LOGIN));

            return new Message(Message.STATE_TRUE, snsUser);
        } else {
            return new Message(Message.STATE_FALSE, messageErrorCode);
        }

    }

    /**
     * 验证密码
     *
     * @param snsUser
     * @param pwd
     * @return
     */
    @Override
    public boolean validateUserPwd(SnsUser snsUser, String pwd) {
        String salt = snsUser.getSalt();
        String pwdHash = MD5Utils.encode(pwd, salt);
        return pwdHash.equals(snsUser.getPwdHash());
    }

    /**
     * 根据用户名或者电话号码 得到用户
     *
     * @param string
     * @return
     */
    @Override
    public SnsUser getSnsUserByNameOrPhone(String string) {
        SnsUser snsUser = snsUserMapper.qrySnsUserByNameOrPhone(string);
        return snsUser;
    }

    /**
     * 添加用户行为日志
     *
     * @param snsUser
     * @param action
     * @param userBrowserInfo
     */
    @Override
    public void addUserEventLog(SnsUser snsUser, String action, UserBrowserInfo userBrowserInfo) {
        SnsUserEventLog snsUserEventLog = new SnsUserEventLog();

        snsUserEventLog.setIp(userBrowserInfo.getIp());
        snsUserEventLog.setUserAgent(userBrowserInfo.getUserAgent());
        snsUserEventLog.setvInfo(userBrowserInfo.getvInfo());
        snsUserEventLog.setOrigin(userBrowserInfo.getOrigin());

        snsUserEventLog.setAction(action);

        snsUserEventLog.setUserId(snsUser.getId());

        snsUserEventLogMapper.insertSelective(snsUserEventLog);
    }

}
