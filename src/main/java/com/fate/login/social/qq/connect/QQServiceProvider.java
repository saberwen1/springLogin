package com.fate.login.social.qq.connect;

import com.fate.login.social.qq.api.QQ;
import com.fate.login.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @Author: fate
 * @Date: 2019/3/20 11:55
 * @Version 1.0
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;
    private static final String authorizeUrl = "https://graph.qq.com/oauth2.0/authorize";
    private static final String accessTokenUrl = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId,String appSecret) {
        super(new OAuth2Template(appId, appSecret, authorizeUrl, accessTokenUrl));
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }
}
