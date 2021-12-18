package com.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.model.Admin;

public interface IAdminRepository extends JpaRepositoryImplementation<Admin, Integer> {

}