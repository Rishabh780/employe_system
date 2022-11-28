package com.rishabh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee , Integer> {

}
