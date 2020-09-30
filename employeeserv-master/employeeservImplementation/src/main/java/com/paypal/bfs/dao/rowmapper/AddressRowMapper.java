package com.paypal.bfs.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
public class AddressRowMapper implements RowMapper<Address> {
	public Address mapRow(ResultSet rs, int row) throws SQLException {
		Address address = new Address();
		address.setId(rs.getInt("id"));
		address.setLine1(rs.getString("line1"));
		address.setLine2(rs.getString("line2"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setCountry(rs.getString("country"));
		address.setZipCode(rs.getInt("zip_code"));
		return address;
	}
}
