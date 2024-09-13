package com.example.lab3_gtics_20212474.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="jobs")
public class Job {

    @Id
    @Column(name="job_id",nullable = false, length = 10)
    private String job_id;

    @Column(name="job_title",nullable = false,length = 35)
    private String job_title;
    @Column(name = "min_salary", nullable = true)
    private Integer min_salary;
    @Column(name = "max_salary", nullable = true)
    private Integer max_salary;

}

