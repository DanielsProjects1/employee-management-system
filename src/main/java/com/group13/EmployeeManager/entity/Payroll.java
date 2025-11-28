package com.group13.EmployeeManager.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payId;
    private LocalDate payDate;
    private double earnings;
    private double stateTax;
    private double retire401k;
    private double healthCare;
    @OneToOne(cascade = CascadeType.ALL)
    private FederalInfo fedInfo;

    public Payroll() {}

    public Payroll(LocalDate payDate, double earnings, double stateTax, double retire401k, double healthCare, FederalInfo fedInfo) {
        this.payDate = payDate;
        this.earnings = earnings;
        this.stateTax = stateTax;
        this.retire401k = retire401k;
        this.healthCare = healthCare;
        this.fedInfo = fedInfo;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public double getStateTax() {
        return stateTax;
    }

    public void setStateTax(double stateTax) {
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

    public FederalInfo getFedInfo() {
        return fedInfo;
    }

    public void setFedInfo(FederalInfo fedInfo) {
        this.fedInfo = fedInfo;
    }
}
