package com.group13.EmployeeManager.repository;

import com.group13.EmployeeManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByName(String name);

    Employee findEmployeeBySocialSecurityNumber(String socialSecurityNumber);
}
