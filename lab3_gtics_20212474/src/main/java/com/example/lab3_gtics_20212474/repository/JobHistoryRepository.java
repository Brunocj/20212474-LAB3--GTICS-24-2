package com.example.lab3_gtics_20212474.repository;

import com.example.lab3_gtics_20212474.entity.Employee;
import com.example.lab3_gtics_20212474.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory,Integer>{
}
