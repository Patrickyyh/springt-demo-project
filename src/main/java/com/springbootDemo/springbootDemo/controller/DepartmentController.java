package com.springbootDemo.springbootDemo.controller;

import com.springbootDemo.springbootDemo.entity.Department;
import com.springbootDemo.springbootDemo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);



    // fetch all the data
    @GetMapping("/departments")
    public List <Department> fetchDepartment(){
        LOGGER.info(" Inside fetchDepartment of DepartmentController ");
        return departmentService.fetchDepartment();

    }

//    Fetch data by specific Id
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentbyId(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
         departmentService.deleteDepartmentById(departmentId);
         return "Department deleted Successfully!!";
    }

    // create department record
    // When controller receive json from front-end. the Valid annotation will
    // start the validation with the rule we set up inside the department entity.
    @PostMapping("/departments")   // spring will convert the json to department object for us by using this annotation
    public Department saveDepartment(@Valid  @RequestBody Department department){
        LOGGER.info(" Inside saveDepartment of DepartmentController ");
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department )
    {
        return departmentService.updateDepartment(departmentId , department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }


}

