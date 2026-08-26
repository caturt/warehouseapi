package com.example.warehouse.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public String CreateEmployee(Employee employee) {
        employeeRepository.save(employee);

        return "Employee " + employee.getName() + " added.";
    }

    public List<Employee> GetEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }
}
