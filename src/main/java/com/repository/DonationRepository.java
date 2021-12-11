package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Donation;

public interface DonationRepository extends JpaRepository<Donation,Integer> {

}