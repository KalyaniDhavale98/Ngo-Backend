package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Donation {

	@Id
	@GeneratedValue
	private int donationId;
	private double donationAmount;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date donationDate;
	@NotNull
	private String donationType;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	@PrePersist
	protected void onCreate() {
		donationDate = new Date();
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donationAmount=" + donationAmount + ", donationDate="
				+ donationDate + ", donationType=" + donationType + "]";
	}

}