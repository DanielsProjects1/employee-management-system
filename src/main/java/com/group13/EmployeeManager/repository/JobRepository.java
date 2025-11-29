package com.group13.EmployeeManager.repository;

import com.group13.EmployeeManager.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE j.title = :title")
    Job findJobByTitle(@Param("title") String jobTitle);
}
