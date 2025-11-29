package com.group13.EmployeeManager.service;

import com.group13.EmployeeManager.entity.Employee;
import com.group13.EmployeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return Optional.of(employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found.")));
    }

    public Employee findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public Employee findEmployeeBySocialSecurityNumber(String socialSecurityNumber) {
        return employeeRepository.findEmployeeBySocialSecurityNumber(socialSecurityNumber);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployeeName(Employee employee, String newName) {

        employee.setName(newName);

        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeEmail(Employee employee, String newEmail) {

        employee.setEmail(newEmail);

        return employeeRepository.save(employee);
    }

    public Employee assignHireDate(Employee employee, LocalDate date) {

        employee.setHireDate(date);

        return employeeRepository.save(employee);
    }

    public Employee updateSalary(Employee employee) {
        double salary = employee.getSalary();

        if (salary < 105000 && salary >= 58000) {
            employee.setSalary(salary + (salary * 0.032));
        } else if (salary < 58000) {
            employee.setSalary(salary + (salary * 0.08));
        } else if (salary > 105000) {
            employee.setSalary(salary + (salary * 0.025));
        }

        return employeeRepository.save(employee);
    }

    public List<Employee> updateSalariesForEmployeesLessThanAmount(List<Employee> employees, double amount) {

        for (Employee employee : employees) {
            if (employee.getSalary() < amount) {
                updateSalary(employee);
            }
        }

        return employeeRepository.saveAll(employees);
    }






}
