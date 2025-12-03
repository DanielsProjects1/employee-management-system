package com.group13.EmployeeManager.service;

import com.group13.EmployeeManager.entity.Division;
import com.group13.EmployeeManager.entity.Employee;
import com.group13.EmployeeManager.entity.Job;
import com.group13.EmployeeManager.entity.Payroll;
import com.group13.EmployeeManager.repository.DivisionRepository;
import com.group13.EmployeeManager.repository.EmployeeRepository;
import com.group13.EmployeeManager.repository.JobRepository;
import com.group13.EmployeeManager.repository.PayrollRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final DivisionRepository divisionRepository;
    private final PayrollRepository payrollRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, JobRepository jobRepository, DivisionRepository divisionRepository, PayrollRepository payrollRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.divisionRepository = divisionRepository;
        this.payrollRepository = payrollRepository;
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found."));
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

    public Employee updateEmployeeSalary(Employee employee) {
        updateSalary(employee);

        return employeeRepository.save(employee);
    }

    private void updateSalary(Employee employee) {
        BigDecimal salary = employee.getSalary();

        BigDecimal min = new BigDecimal("58000");
        BigDecimal max = new BigDecimal("105000");

        if (salary.compareTo(max) < 0 && salary.compareTo(min) >= 0) {
            BigDecimal increase = salary.multiply(new BigDecimal("0.032"));
            employee.setSalary(salary.add(increase));
        } else if (salary.compareTo(min) < 0) {
            BigDecimal increase = salary.multiply(new BigDecimal("0.08"));
            employee.setSalary(salary.add(increase));
        } else if (salary.compareTo(max) > 0) {
            BigDecimal increase = salary.multiply(new BigDecimal("0.025"));
            employee.setSalary(salary.add(increase));
        }

    }

    public List<Employee> updateSalariesForEmployeesLessThanAmount(List<Employee> employees, BigDecimal amount) {

        for (Employee employee : employees) {
            if (employee.getSalary().compareTo(amount) < 0) {
                updateSalary(employee);
            }
        }

        return employeeRepository.saveAll(employees);
    }

    public List<Employee> findEmployeeByJobTitle(String jobTitle) {
        Job job = jobRepository.findJobByTitle(jobTitle);
        return employeeRepository.findEmployeesByJobId(job.getId());
    }

    public List<Employee> findEmployeeByDivisionName(String divisionName) {
        Division division = divisionRepository.findByDivisionName(divisionName);
        List<Employee> employees = employeeRepository.findEmployeesByDivisionId(division.getId());
        return employees;
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void assignJobToEmployee(Employee employee, String jobTitle) {
        Job job = jobRepository.findJobByTitle(jobTitle);

        employee.setJobTitle(job);
        employee.setHireDate(LocalDate.now());
        employeeRepository.save(employee);
    }

    @Transactional
    public void assignDivisionToEmployee(Employee employee, String divisionName) {
        Division division = divisionRepository.findByDivisionName(divisionName);
        employee.setDivision(division);
        employeeRepository.save(employee);
    }

    @Transactional
    public void assignPayrollToEmployee(Employee employee, Long payId) {
        Payroll payroll = payrollRepository.findById(payId).get();
        employee.setPayroll(payroll);
        employeeRepository.save(employee);
    }
}
