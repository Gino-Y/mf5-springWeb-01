package cn.mf5.service.impl;

import cn.mf5.dao.EmpDao;
import cn.mf5.module.Emp;
import cn.mf5.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceB implements EmpService {

    @Autowired
    private EmpDao empDao ;//= new EmpDaoA(); // 多态，面向接口编程
    @Override
    public List<Emp> listEmp() {
        // 1、访问dao层，得到员工列表的数据
        List<Emp> empList = empDao.listEmp();

        // 2、处理性别，将性别转换为：男、女
        for (Emp emp : empList){
            if("1".equals(emp.getGender())){
                emp.setGender("suberman");
            }else{
                emp.setGender("superwoman");
            }
        }

        // 3、处理岗位信息，将岗位信息转换为：讲师、班主任、就业指导
        for (Emp emp : empList){
            if("1".equals(emp.getJob())){
                emp.setJob("Java讲师");
            }else if("2".equals(emp.getJob())){
                emp.setJob("Web黑客");
            }else{
                emp.setJob("Android逆向工程师");
            }
        }
        return empList;
    }
}
