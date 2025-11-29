package com.group13.EmployeeManager.service;

import com.group13.EmployeeManager.entity.Division;
import com.group13.EmployeeManager.repository.DivisionRepository;
import com.group13.EmployeeManager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    private final DivisionRepository divisionRepository;


    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division findByName(String divisionName) {
        return divisionRepository.findByDivisionName(divisionName);
    }

    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    public Division addDivision(Division division) {
        return divisionRepository.save(division);
    }
}
