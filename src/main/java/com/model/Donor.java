package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Donor {
	// fields
	@Id
	@GeneratedValue
	private int donorId;
	@NotNull
	@Size(min = 3, message = "First Name should have atleast 3 characters")
	private String donorName;
	@NotNull
	@Email
	private String donorEmail;
	@NotNull
	private String donorPhone;
	@NotNull
	private String donorUsername;
	@NotNull
	@Size(min = 8, message = "password should have atleast 8 characters")
	private String donorPassword;

	/*
	 * adding a new column to store a random token key which is used to protect the
	 * reset password update the corresponding entity class, by declaring a new
	 * field named resetPasswordToken
	 */
	// private String resetPasswordToken;

	// one to one mapping unidireactional
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	// no_arg constructor
	public Donor() {
	}

	// parameterised constructor
	public Donor(String donorUsername, String donorPassword) {
		super();
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
	}

	// getter and setters
	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getDonorPhone() {
		return donorPhone;
	}

	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}

	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	/*
	 * public String getResetPasswordToken() { return resetPasswordToken; } public
	 * void setResetPasswordToken(String resetPasswordToken) {
	 * this.resetPasswordToken = resetPasswordToken; }
	 */

	// to string
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorEmail=" + donorEmail + ", donorPhone="
				+ donorPhone + ", donorUsername=" + donorUsername + ", donorPassword=" + donorPassword + ", address="
				+ address + "]";
	}

}
