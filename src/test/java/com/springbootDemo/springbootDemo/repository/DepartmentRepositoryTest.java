package com.springbootDemo.springbootDemo.repository;

import com.springbootDemo.springbootDemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentAddress("400 Nagle Dr")
                .departmentName("Mechnical Engineering")
                .departmentCode("Me - 011")
                .build() ;

        entityManager.persist(department);

    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1l).get();
        assertEquals(department.getDepartmentName() , "Mechnical Engineering");
    }
}