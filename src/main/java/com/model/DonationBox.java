package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class DonationBox {
	// fields
	private String ngoName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String registrationNumber;
	@NotNull
	private String accountNumber;
	private double totalCollection;

	// getters and setters
	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}

	// to string
	@Override
	public String toString() {
		return "DonationBox [ngoName=" + ngoName + ", registrationNumber=" + registrationNumber + ", accountNumber="
				+ accountNumber + ", totalCollection=" + totalCollection + "]";
	}

}