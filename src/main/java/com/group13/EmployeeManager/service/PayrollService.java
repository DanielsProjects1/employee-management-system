package com.group13.EmployeeManager.service;

import com.group13.EmployeeManager.entity.Payroll;
import com.group13.EmployeeManager.repository.PayrollRepository;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;

    public PayrollService(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    public Payroll findPayrollById(long id) {
        return payrollRepository.findById(id);
    }

    public Payroll updatePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }
}
