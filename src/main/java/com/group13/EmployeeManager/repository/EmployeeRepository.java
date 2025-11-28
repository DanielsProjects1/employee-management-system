package com.group13.EmployeeManager.repository;

import com.group13.EmployeeManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
