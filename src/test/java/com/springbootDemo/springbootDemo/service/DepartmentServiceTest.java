package com.springbootDemo.springbootDemo.service;

import com.springbootDemo.springbootDemo.entity.Department;
import com.springbootDemo.springbootDemo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    // Mock the repository
    @MockBean
    private DepartmentRepository departmentRepository;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentAddress("400 Nagle Dr")
                .departmentName("IT")
                .departmentCode("IT-06")
                .build() ;

        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid department ")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){

        String departName = "IT";
        Department found = departmentService.fetchDepartmentByName(departName);
        assertEquals(departName , found.getDepartmentName());

    }
}