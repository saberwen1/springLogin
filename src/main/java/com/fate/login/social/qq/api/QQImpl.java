package com.fate.login.social.qq.api;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @Author: fate
 * @Date: 2019/3/20 10:20
 * @Version 1.0
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private ObjectMapper objectMapper = new ObjectMapper();
    private String appId;
    private String openId;

    private static final String QQ_USER_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String QQ_USER_INFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

     public QQImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
         String url = String.format(QQ_USER_OPENID,accessToken);
         String result = getRestTemplate().getForObject(url, String.class);
         this.appId = appId;
         this.openId = StringUtils.subString(result, "\"openid\":", "} )");
     }


    @Override
    public QQInfo getQQInfo() {
        String url = String.format(QQ_USER_INFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        QQInfo qqInfo = null;
        try {
            qqInfo = objectMapper.readValue(result, QQInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取用户信息出错", e);
        }
        return qqInfo;
    }

}
