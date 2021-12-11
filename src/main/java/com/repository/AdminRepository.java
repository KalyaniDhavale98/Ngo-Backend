package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Admin;
import com.model.Employee;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
