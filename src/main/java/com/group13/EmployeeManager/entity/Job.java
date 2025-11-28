package com.group13.EmployeeManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Job {

    @Id
    private int id;
    private String title;

    public Job() {}

    public Job(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
