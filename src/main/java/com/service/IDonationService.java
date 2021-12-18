package com.service;

import java.util.List;

import com.model.Donation;

public interface IDonationService {
	
	public Donation addDonation(Donation donation);
//	public Donation updateDonation(int donationId, Donation donation) throws Exception ;
	public void removeDonation(int donationId) ;
	public List<Donation> getDonations();
	public Donation getDonationById(int donationId);

}