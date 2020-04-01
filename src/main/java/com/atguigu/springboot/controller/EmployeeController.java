package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //查出所有的部门
        return "emp/add";
    }


    //员工添加
    //spring mvc 自动将请求参数和入参对象属性一一进行绑定；
    // 要求请求参数和名字javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //来到员工列表页面
        //redirect 重定向    /代表当前项目路径
        //forward  转发到一个地址
        //System.out.println("保存的员工信息:   " +employee.toString());
        //保存员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    //来到修改目录，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);


        //页面要显示所有部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面（add是修改添加二合一的页面）
        return "emp/add";
    }

    //员工修改；需要提高员工id
    @PutMapping("/emp")
    public String updataEmployee(Employee employee) {
        //System.out.println("修改的员工数据  "+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
