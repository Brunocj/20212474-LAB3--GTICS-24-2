package com.example.lab3_gtics_20212474.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id",nullable = false)
    private Integer employee_id;

    @Column(name="first_name", nullable = false,length = 20)
    private String first_name;

    @Column(name="last_name",length = 25)
    private String last_name;

    @Column(name="email",length = 25)
    private String email;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name="phone_number",length = 20)
    private String phone_number;

    @Column(name="salary",length = 9)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private Integer enabled = 1;

}
