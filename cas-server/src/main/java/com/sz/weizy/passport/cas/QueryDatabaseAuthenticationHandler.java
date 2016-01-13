package com.sz.weizy.passport.cas;

import com.sz.weizy.passport.pojo.Message;
import com.sz.weizy.passport.service.UserService;
import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;

/**
 * Created by lohas on 2015/11/21 0021.
 * 身份认证
 */
public class QueryDatabaseAuthenticationHandler extends AbstractJdbcUsernamePasswordAuthenticationHandler {


    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    @Override
    protected final HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential credential)
            throws GeneralSecurityException, PreventedException {

        final String inputVal = credential.getUsername(); // input val (userName or email or phone)
        final String password = credential.getPassword();


        try {
            Message message = userService.login(inputVal, password);
            if (!message.isSuccess()) {
                // 账户名或者密码错误
                throw new FailedLoginException("Password does not match value on record.");
            }
        } catch (final DataAccessException e) {
            throw new PreventedException("SQL exception while executing query for " + inputVal, e);

        }
        return createHandlerResult(credential, new SimplePrincipal(inputVal), null);
    }
}
