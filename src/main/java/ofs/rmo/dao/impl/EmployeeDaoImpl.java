package ofs.rmo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import ofs.rmo.dao.EmployeeDao;
import ofs.rmo.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(Employee employee) {
		
		String sql = "insert into users values(?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { employee.getUsername(), employee.getPassword(), employee.getFirstname(),
	    		employee.getLastname(), employee.getEmail(), employee.getAddress(), employee.getPhone() });
	}

}
