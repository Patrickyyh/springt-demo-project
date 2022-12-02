package com.springbootDemo.springbootDemo.controller;

import com.springbootDemo.springbootDemo.entity.Department;
import com.springbootDemo.springbootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;


    // fetch all the data
    @GetMapping("/departments")
    public List <Department> fetchDepartment(){
        return departmentService.fetchDepartment();

    }

//    Fetch data by specific Id
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentbyId(@PathVariable("id") Long departmentId){

        return departmentService.fetchDepartmentById(departmentId);
    }

    // create department record
    @PostMapping("/departments")   // spring will convert the json to department object for us by using this annotation
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }




}

