package com.example.springbootdemo.employeeController;

import com.example.springbootdemo.employeeService.EmployeeService;
import com.example.springbootdemo.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/emp")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void saveEmployeeData(@RequestBody Employee employee) {
        employeeService.saveEmployeeData(employee);

    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmplooyeeById(@PathVariable UUID employeeId) {
        Employee emp = employeeService.getEmployeeData(employeeId);

        return ResponseEntity.ok().body(emp);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployeeData() {

        List<Employee> getAllEmp = employeeService.getAllEmployee();
        return ResponseEntity.ok().body(getAllEmp);

    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeRecord(@PathVariable UUID employeeId, @RequestBody Employee updatedEmployee) {
        Employee updatedEmployeeValue = employeeService.udpateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok().body(updatedEmployeeValue);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeRecord(@PathVariable UUID employeeId) {
        System.out.println("Delete the employee Record");
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();

    }


}
