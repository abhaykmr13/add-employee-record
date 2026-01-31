package com.example.springbootdemo.employeeService;


import com.example.springbootdemo.employeeRepo.EmployeeRepository;
import com.example.springbootdemo.entity.Employee;
import com.example.springbootdemo.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void saveEmployeeData(Employee employee) {
        employeeRepository.save(employee);

    }


    public Employee getEmployeeData(UUID employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with id " + employeeId));
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee udpateEmployee(UUID employeeId, Employee updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with given Id " + employeeId));
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setId(updatedEmployee.getId());
        employee.setName(updatedEmployee.getName());
        employee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("The employee with given id is not there in database  " + employeeId));

        employeeRepository.delete(employee);
        //employeeRepository.deleteById(employeeId);
    }


}
