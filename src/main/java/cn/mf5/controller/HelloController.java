package cn.mf5.controller;

// 用来处理浏览器发过来的请求与响应
// 1、在类上添加@RestController注解，表示这是一个控制器类
// 2、编写一个任意的方法，设置访问路径，返回数据
// 3、在方法上添加@RequestMapping注解，设置访问路径

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {

        return "Hello Request!";
    }

    @PostMapping("/login")
    public String login(String name, String password) {
        System.out.println(("用户名：" + name + " 密码：" + password));
        return "Login Success!";
    }
}
