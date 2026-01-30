package com.example.springbootdemo.employeeService;


import com.example.springbootdemo.employeeRepo.EmployeeRepository;
import com.example.springbootdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void saveEmployeeData(Employee employee) {
        employeeRepository.save(employee);

    }


    public Employee getEmployeeData(UUID employeeId) {
        return employeeRepository.getReferenceById(employeeId);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee udpateEmployee(UUID employeeId, Employee updatedEmployee) {

       Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setId(updatedEmployee.getId());
        employee.setName(updatedEmployee.getName());
        employee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID employeeId){
        employeeRepository.deleteById(employeeId);
    }


}
