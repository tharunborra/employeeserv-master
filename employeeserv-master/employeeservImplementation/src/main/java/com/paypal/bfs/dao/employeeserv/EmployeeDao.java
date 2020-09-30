package com.paypal.bfs.dao.employeeserv;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeDao {
	public Employee employeeGetById(String id);
	public int createEmployee(Employee employee);
}
