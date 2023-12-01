package cn.mf5.controller;

import cn.mf5.module.Address;
import cn.mf5.module.Result;
import cn.mf5.module.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// 用来处理浏览器发过来的请求与响应
// 1、在类上添加@RestController注解，表示这是一个控制器类。
// 或者使用@Controller但是方法上必须添加@ResponseBody注解，不然会报错。
// @RestController注解相当于@Controller和@ResponseBody注解的结合。
@RestController
public class ResponseController {
    @GetMapping("/hello")
    public Result hello() {

        return Result.success("Hello Response!");
    }

    // 返回一个对象，SpringBoot会自动将对象转换为json格式的字符串
    @GetMapping("/getUser")
    public Result getUser() {
        Address address = new Address("广东省", "深圳市");
        User user = new User("狗剩", 88, address);
        return Result.success(user);
    }

    // 行营集合数据
    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> list = new ArrayList<>();
        list.add(new Address("广东省", "深圳市"));
        list.add(new Address("广东省", "广州市"));
        list.add(new Address("广东省", "珠海市"));
        return Result.success(list);
    }
}
