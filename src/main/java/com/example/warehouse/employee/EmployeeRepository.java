package com.example.warehouse.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findById(long id);

    List<Employee> findByName(String name);

}
