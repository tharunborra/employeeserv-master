package com.paypal.bfs.dao.employeeserv.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.paypal.bfs.dao.employeeserv.EmployeeDao;
import com.paypal.bfs.dao.rowmapper.AddressRowMapper;
import com.paypal.bfs.dao.rowmapper.EmployeeRowMapper;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public Employee employeeGetById(String id) {
		Employee employee = (Employee) jdbcTemplate.queryForObject("select * from employee where id = ?",
				new Object[] { id }, new EmployeeRowMapper());
		Address address = (Address) jdbcTemplate.queryForObject("select * from address where id = ?",
				new Object[] { employee.getAddress().getId() }, new AddressRowMapper());
		employee.setAddress(address);
		return employee;
	}

	@Transactional
	@Override
	public int createEmployee(Employee employee) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("employee").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("first_name", employee.getFirstName());
		parameters.put("last_name", employee.getLastName());
		parameters.put("date_of_birth", employee.getDateOfBirth());
		parameters.put("address", createAddress(employee.getAddress()));
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	private int createAddress(Address address) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("address").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("line1", address.getLine1());
		parameters.put("line2", address.getLine2());
		parameters.put("city", address.getCity());
		parameters.put("state", address.getState());
		parameters.put("country", address.getCountry());
		parameters.put("zip_code", address.getZipCode());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

}
