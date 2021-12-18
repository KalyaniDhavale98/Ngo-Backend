package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Donation;
import com.repository.DonationRepository;

@Service
public class DonationServiceImpl implements IDonationService {
	
	@Autowired
	DonationRepository donationRepo;
	
	@Override
	public Donation addDonation(Donation donation) {
		return donationRepo.save(donation);
	}

	@Override
	public List<Donation> getDonations() {
		return donationRepo.findAll();
	}

	@Override
	public Donation getDonationById(int donationId) {
		return donationRepo.findById(donationId).get();
	}

	@Override
	public void removeDonation(int donationId) {
		donationRepo.deleteById(donationId);
	}

}