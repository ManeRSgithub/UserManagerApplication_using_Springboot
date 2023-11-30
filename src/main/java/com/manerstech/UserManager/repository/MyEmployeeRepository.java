package com.manerstech.UserManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manerstech.UserManager.entities.myEmployeeList;

@Repository
public interface MyEmployeeRepository extends JpaRepository<myEmployeeList, Integer>{

}
