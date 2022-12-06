package com.springbootDemo.springbootDemo.controller;

import com.springbootDemo.springbootDemo.entity.Department;
import com.springbootDemo.springbootDemo.error.DepartmentNotFoundException;
import com.springbootDemo.springbootDemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentService service;

    private Department department;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentAddress("400 Nagle Dr")
                .departmentName("IT")
                .departmentCode("IT-06")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inDepartment = Department.builder()
                .departmentId(1L)
                .departmentAddress("400 Nagle Dr")
                .departmentName("IT")
                .departmentCode("IT-06")
                .build();
        Mockito.when(service.saveDepartment(inDepartment))
                .thenReturn(department);

        mvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IT\",\n" +
                        "    \"departmentAddress\":\"400 Nagle Dr\",\n" +
                        "    \"departmentCode\":\"IT-06\" \n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void fetchDepartmentbyId() throws Exception {

        Mockito.when(service.fetchDepartmentById(1l))
                .thenReturn(department);
        mvc.perform(get("/departments/1")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}

