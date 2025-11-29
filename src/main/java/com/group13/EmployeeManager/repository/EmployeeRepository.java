package com.group13.EmployeeManager.repository;

import com.group13.EmployeeManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    Employee findEmployeeByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.socialSecurityNumber = :ssn")
    Employee findEmployeeBySocialSecurityNumber(@Param("ssn") String socialSecurityNumber);

    @Query("SELECT e FROM Employee e WHERE e.jobTitle.id = :id")
    List<Employee> findEmployeesByJobId(Long id);

    @Query("SELECT e FROM Employee e WHERE e.division.id = : id")
    List<Employee> findEmployeesByDivisionId(Long id);
}
