package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.model.NeedyPeople;

@Service
public interface IEmployeeService {

	public Employee login(Employee employee) throws NoSuchEmployeeException, SQLException;

	public NeedyPeople addNeedyPerson(NeedyPeople person);

	public void removeNeedyPerson(int id);
	
	public NeedyPeople modifyNeedyPerson(int id, NeedyPeople person);

	public NeedyPeople findNeedyPeopleById(int id);

	public List<NeedyPeople> findAllNeedyPeople();

	public String helpNeedyPerson(DonationDistribution distribute);

}