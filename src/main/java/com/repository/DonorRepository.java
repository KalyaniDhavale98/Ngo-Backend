package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.model.Donor;

public interface DonorRepository extends JpaRepository<Donor,Integer> {

	//@Query(value="select count(donor_email)from donor having count(donor_email)<=1",nativeQuery=true)
	@Query(value="select count(d.donor_email)from donor d having count(d.donor_email)<=1",nativeQuery=true)
	// @Query(value="Select donor_email from donor",nativeQuery = true)
	String checkIfUserAlreadyExists(String donorEmail);
	
	/*@Query("SELECT d FROM donar d WHERE d.donor_email = ?1")
    
    public Donor findByEmail(String email); 
     
    public Donor findByResetPasswordToken(String token);*/
}
