package com.group13.EmployeeManager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payId;
    private LocalDate payDate;
    private BigDecimal earnings;
    private BigDecimal stateTax;
    private double retire401k;
    private double healthCare;
    private double fedTax;
    private double fedMedical;
    private double fedSocialSecurity;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Payroll() {}

    public Payroll(LocalDate payDate, BigDecimal earnings, BigDecimal stateTax, double retire401k, double healthCare, FederalInfo fedInfo) {
        this.payDate = payDate;
        this.earnings = earnings;
        this.stateTax = stateTax;
        this.retire401k = retire401k;
        this.healthCare = healthCare;
        this.fedTax = fedInfo.getTax();
        this.fedMedical = fedInfo.getMedical();
        this.fedSocialSecurity = fedInfo.getSocialSecurtiy();
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }

    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }

    public BigDecimal getStateTax() {
        return stateTax;
    }

    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }

    public double getRetire401k() {
        return retire401k;
    }

    public void setRetire401k(double retire401k) {
        this.retire401k = retire401k;
    }

    public double getHealthCare() {
        return healthCare;
    }

    public void setHealthCare(double healthCare) {
        this.healthCare = healthCare;
    }

    public double getFedTax() {
        return fedTax;
    }

    public double getFedMedical() {
        return fedMedical;
    }

    public double getFedSocialSecurity() {
        return fedSocialSecurity;
    }

    @Override
    public String toString() {
        return "Payroll" +
                "\npayId: " + payId +
                "\npayDate: " + payDate +
                "\nearnings: " + earnings +
                "\nstateTax: " + stateTax +
                "\nretire401k: " + retire401k +
                "\nhealthCare: " + healthCare +
                "\nfedTax: " + fedTax +
                "\nfedMedical: " + fedMedical +
                "\nfedSocialSecurity: " + fedSocialSecurity;
    }
}
