package com.example.springbootdemo.employeeRepo;

import com.example.springbootdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> getAllByDepartment(String department);
}
