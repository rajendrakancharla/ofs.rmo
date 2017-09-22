package ofs.rmo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ofs.rmo.dao.EmployeeDao;
import ofs.rmo.model.Employee;
import ofs.rmo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void register(Employee user) {
		
		employeeDao.register(user);
	}

}
