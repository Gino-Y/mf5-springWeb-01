package cn.mf5.controller;
/*
Controller目标：处理用户的请求参数

1、简单参数，处理简单参数只需要方法的形参名与请求参数名一致即可自动封装

 */

import cn.mf5.module.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class ParamController {
    // 简单参数，处理简单参数只需要方法的形参名与请求参数名一致即可自动封装
    // @RequestParam注解表示该参数是一个请求参数，required表示该参数是否必须，默认为true
    // @RequestParam("name1") String name表示请求参数name1的值会被封装到name变量中
    // @RequestParam("age1") Integer age表示请求参数age1的值会被封装到age变量中
    @GetMapping("/simpleParam") // @GetMapping注解表示该方法只处理get请求
    public String simpleParam(@RequestParam("name1") String name, @RequestParam("age1") Integer age) {
        System.out.println(("姓名：" + name + " 年龄：" + age));
        return "Success!";
    }

    // 请求参数是一个实体对象，只需要将实体类作为方法的形参即可，就会自动封装
    @GetMapping("/pojoParam")
    public String pojoParam(User user) {
        System.out.println("用户的对象是：" + user);
        return "Success!";
    }

    // 处理请求参数是多个值的情况，处理手段有两种

    // 1、使用数组接收
    @GetMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println("接受到的数组对象：" + Arrays.toString(hobby));
        return "Success!";
    }

    // 2、使用List集合接收:
    //    形参必须添加@RequestParam注解，否则会报错
    @GetMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println("接受到的集合对象：" + hobby);
        return "Success!";
    }

    // 处理请求参数是日期类型的情况
    // 1、使用@DateTimeFormat注解，指定日期格式
    // 2、使用LocalDate接收
    @GetMapping("/birthday")
    public String birthDay(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday) {
        System.out.println("老钟的生日是：" + birthday);
        return "Success!";
    }

    // 处理请求参数是Json类型的情况
    // 1、使用@RequestBody注解，将请求体中的Json字符串转换为Java对象
    @PostMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println("用户对象是：" + user);
        return "Success!";
    }

    // 路径参数传递
    // 1、在路径中使用占位符，占位符的名称必须与形参名称一致
    // 2、使用@PathVariable注解，将占位符中的值赋值给形参
    @GetMapping("/pathParam/{id}")
    public String pathParam(@PathVariable("id") Integer id) {
        System.out.println("用户的id是：" + id);
        return "Success!";
    }

}
