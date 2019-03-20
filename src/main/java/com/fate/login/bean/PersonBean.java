package com.fate.login.bean;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: fate
 * @Date: 2019/3/13 23:28
 * @Version 1.0
 */
@Data
public class PersonBean extends BaseBean {

     public interface SimpleView {

    }

    public interface DetailView extends SimpleView {

    }

    @JsonView(SimpleView.class)
    @ApiModelProperty("姓名")
    private String name = "fate";
    @JsonView(DetailView.class)
    @ApiModelProperty("年龄")
    private Integer age = 26;
}
