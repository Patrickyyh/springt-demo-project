package com.springbootDemo.springbootDemo.service;

import com.springbootDemo.springbootDemo.entity.Department;
import com.springbootDemo.springbootDemo.error.DepartmentNotFoundException;
import com.springbootDemo.springbootDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;


@Service
public class DepartmentServiceImple implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

            Optional<Department> department = departmentRepository.findById(departmentId);
            if(!department.isPresent()){
                throw new DepartmentNotFoundException("Department Not Available");
            }

            return department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
           !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        // checkout spring boot query documentation
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
