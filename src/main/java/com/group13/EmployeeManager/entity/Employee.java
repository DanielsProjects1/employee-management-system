package com.group13.EmployeeManager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.math.RoundingMode;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String socialSecurityNumber;
    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private Job jobTitle;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @OneToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;

    public Employee() {}
    public Employee(Long id, String name, String email, LocalDate hireDate,BigDecimal salary, String socialSecurityNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Job getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Job jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Transient
    public BigDecimal getPayForMonth() {
        if (salary == null) return BigDecimal.ZERO;
        return salary.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Employee Information and Pay Statement History: \n" +
                "\nid: " + id +
                "\nname: " + name +
                "\nemail: " + email +
                "\nhireDate: " + hireDate +
                "\nsalary: " + salary +
                "\nsocialSecurityNumber: " + socialSecurityNumber +
                "\njobTitle: " + jobTitle +
                "\ndivision: " + division +
                "\npayroll: " + payroll;
    }
}
