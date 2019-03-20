package com.fate.login.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Date;

/**
 * @Author: fate
 * @Date: 2019/3/13 23:29
 * @Version 1.0
 */
@Data
public class BaseBean {
    @JsonView(PersonBean.SimpleView.class)
    @JsonFormat(with={JsonFormat.Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS},pattern = "YYYY")
    private Date date = new Date();
    @JsonView(PersonBean.SimpleView.class)
    private String tag = "加油";
}
