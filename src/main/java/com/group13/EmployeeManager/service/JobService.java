package com.group13.EmployeeManager.service;

import com.group13.EmployeeManager.entity.Job;
import com.group13.EmployeeManager.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final JobRepository jobRepository;
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job findJobById(Long id) {
        return jobRepository.findById(id).get();
    }

    public Job updateJob()
}
