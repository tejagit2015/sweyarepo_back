package com.example.demo.controllers;

import com.example.demo.Models.Employee;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    EmployeeRepository employeeRepository;

//    List<Employee> employeeList = new ArrayList<>();
    @GetMapping("/")
    public String helloWorld()
    {
        return "Welcome to my world!";
    }
    @GetMapping("/healthCheck")
    public String healthCheck()
    {
        return "I'm Fine!";
    }
    @GetMapping("/callBackendService")
    public String callBackendService()
    {
        return "Hi, I am coming from your back!";
    }
    @CrossOrigin
    @GetMapping("/getEmployees")
    public List<EmployeeEntity> getEmployees()
    {
        System.out.println("get employees");
        return employeeRepository.findAll();
    }
    @PostMapping("/addEmployee")
    @CrossOrigin
    public void addEmployee(@RequestBody EmployeeEntity employee)
    {
        System.out.println("add employees : " );
        System.out.println(employee);
        employeeRepository.save(employee);
    }

    @PostMapping("/editEmployee")
    @CrossOrigin
    public void editEmployee(@RequestBody EmployeeEntity employee)
    {
        System.out.println("edit employees : " );
        System.out.println(employee);
        employeeRepository.save(employee);
    }

    @DeleteMapping("/deleteEmployee/{ids}")
    @CrossOrigin
    public void deleteEmployee(@PathVariable List<Long> ids)
    {
        System.out.println("delete employe : {}"+ ids);
        employeeRepository.deleteAllById(ids);
    }
}
