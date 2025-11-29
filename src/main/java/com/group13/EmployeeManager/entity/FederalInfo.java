package com.group13.EmployeeManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

public class FederalInfo {

    private double tax;
    private double medical;
    private double socialSecurtiy;

    public FederalInfo() {}
    public FederalInfo(double tax, double medical, double socialSecurtiy) {
        this.tax = tax;
        this.medical = medical;
        this.socialSecurtiy = socialSecurtiy;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getMedical() {
        return medical;
    }

    public void setMedical(double medical) {
        this.medical = medical;
    }

    public double getSocialSecurtiy() {
        return socialSecurtiy;
    }

    public void setSocialSecurtiy(double socialSecurtiy) {
        this.socialSecurtiy = socialSecurtiy;
    }
}