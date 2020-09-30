package com.paypal.bfs.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
public class EmployeeRowMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int row) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setDateOfBirth(rs.getString("date_of_birth"));
		Address address = new Address();
		address.setId(rs.getInt("address"));
		employee.setAddress(address);
		return employee;
	}
}
