package com.fate.login.social.qq.connect;

import com.fate.login.social.qq.api.QQ;
import com.fate.login.social.qq.api.QQInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @Author: fate
 * @Date: 2019/3/20 12:26
 * @Version 1.0
 */
public class QQAdapter implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQInfo qqInfo = api.getQQInfo();
        values.setDisplayName(qqInfo.getNickname());
        values.setImageUrl(qqInfo.getFigureurl_1());
        values.setProviderUserId(qqInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {

    }
}
