package com.example.lab3_gtics_20212474.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="job_history")
public class JobHistory {


    @Id
    @Column(name="job_history_id",nullable = false)
    private Integer job_history_id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name="start_date",nullable = false)
    private Date startDate;



    @Column(name="end_date",nullable = false)
    private Date endDate;

}
