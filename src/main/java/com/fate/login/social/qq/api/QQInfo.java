package com.fate.login.social.qq.api;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: fate
 * @Date: 2019/3/20 10:18
 * @Version 1.0
 */
@NoArgsConstructor
@Data
public class QQInfo {

    /**
     ret	返回码
     msg	如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
     nickname	用户在QQ空间的昵称。
     figureurl	大小为30×30像素的QQ空间头像URL。
     figureurl_1	大小为50×50像素的QQ空间头像URL。
     figureurl_2	大小为100×100像素的QQ空间头像URL。
     figureurl_qq_1	大小为40×40像素的QQ头像URL。
     figureurl_qq_2	大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
     gender	性别。 如果获取不到则默认返回"男"
     */

    private String openId; //此处画问号
    private int ret;
    private String msg;
    private String nickname;
    private String figureurl;
    private String figureurl_1;
    private String figureurl_2;
    private String figureurl_qq_1;
    private String figureurl_qq_2;
    private String gender;
    private String is_yellow_vip;
    private String vip;
    private String yellow_vip_level;
    private String level;
    private String is_yellow_year_vip;
}
