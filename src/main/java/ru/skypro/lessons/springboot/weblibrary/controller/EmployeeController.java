package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }

    @GetMapping("list")
    public List<Employee> showCounter() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/max")
    public int showeMaxSalary(){
        return employeeService.getEmployeeMaxSalary();
    }
    @GetMapping("/sum")
    public int showeSumSalary(){
        return employeeService.getAllEmployeeSumSalary();
    }
    @GetMapping("/min")
    public int showeMinSalary(){
        return employeeService.getEmployeeMinSalary();
    }
    @GetMapping("/high-salary")
    public int showeHighSalarySalary(){
        return employeeService.getEmployeeHighSalarySalary();
    }
}
