package cn.mf5.dao.impl;

import cn.mf5.controller.EmpController;
import cn.mf5.dao.EmpDao;
import cn.mf5.module.Emp;
import cn.mf5.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 1、读取xml文件的数据，封装到List集合中
        String file = EmpController.class.getResource("/emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
