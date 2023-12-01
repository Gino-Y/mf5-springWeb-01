package cn.mf5.controller;

import cn.mf5.module.Emp;
import cn.mf5.module.Result;
import cn.mf5.service.EmpService;
import cn.mf5.service.impl.EmpServiceA;
import cn.mf5.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 如何实现解耦？
 * 1、面向接口编程
 * 2、使用接口去声明变量的时候也不要去new对象，而是使用Spring容器去创建对象

 * IOC：控制反转，将对象的创建交给Spring容器去创建   存
 * DI：依赖注入，从Spring容器中查找合适的对象，注入到当前对象中   取


 * IOC涉及到的注解：
 *      @Repository：           标注持久层 mapper
 *      @Service：              标注业务层 service
 *      @RestController：       标注控制层 controller
 *      @Component：            标注其他层 其他层（工具类）
 * 注意：以上注解都是创建指定类的对象，并且将对象存储到Spring容器中

 * DI涉及到的注解：
 *     @Autowired：            根据类型从Spring容器中查找合适的对象，注入到当前对象中
 */
@RestController
public class EmpController {

    // 当前Controller是依赖于EmpServiceA的实现类的，如果实现类发生变化，那么当前Controller也需要发生变化
    // 高耦合不利于我们去动态的切换实现类
    @Autowired
    private EmpService empService ;//= new EmpServiceA(); // 多态，面向接口编程

    @GetMapping("/listEmp")
    public Result listEmp() {
        // 1、调用service得到员工列表的数据
        List<Emp> empList = empService.listEmp();


        // 4、返回数据
        return Result.success(empList);
    }
}
