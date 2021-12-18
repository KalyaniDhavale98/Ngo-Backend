package com.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class DonationDistribution {
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int distributionId;
	private double amountDistributed;
	private Date dateOfDistribution;
	@NotNull
	private Date approvalOrRejectedDate;

	

	// one to one mapping unidireactional
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "needy_person_id")
	private NeedyPeople person;

	// one to one mapping unidireactional
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	// one to one mapping unidireactional
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private DonationItem item;

	public int getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public NeedyPeople getPerson() {
		return person;
	}

	public void setPerson(NeedyPeople person) {
		this.person = person;
	}

	public DonationItem getItem() {
		return item;
	}

	public void setItem(DonationItem item) {
		this.item = item;
	}

	public Employee getDistributedBy() {
		return employee;
	}

	public void setDistributedBy(Employee employee) {
		this.employee = employee;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public Date getDateOfDistribution() {
		return dateOfDistribution;
	}

	public void setDateOfDistribution(Date dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public Date getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	@Override
	public String toString() {
		return "DonationDistribution [distributionId=" + distributionId + ", amountDistributed=" + amountDistributed
				+ ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate=" + approvalOrRejectedDate
				+ ", person=" + person + ", employee=" + employee + ", item=" + item + "]";
	}

	

}