package com.fate.login.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fate.login.bean.PersonBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @Author: fate
 * @Date: 2019/3/13 21:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("{name:\\d+}")
    @JsonView(PersonBean.SimpleView.class)
    public PersonBean hello(@PathVariable String name) {
        return new PersonBean();
    }
    @JsonView(PersonBean.DetailView.class)
    @GetMapping("detail")
    @ApiOperation("查询详细信息")
    public Callable<PersonBean> hello2() throws Exception{
        System.out.println("主开始");
        Callable<PersonBean> callable = new Callable<PersonBean>() {
            @Override
            public PersonBean call() throws Exception {
                System.out.println("负开始");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("负结束");
                return new PersonBean();
            }
        };
        System.out.println("主结束");
        return callable;
    }

    @GetMapping("simple")
    @JsonView(PersonBean.SimpleView.class)
    public PersonBean simple() {
        return new PersonBean();
    }
}
