package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.dao.employeeserv.EmployeeDao;
import com.paypal.bfs.dao.employeeserv.impl.EmployeeDaoImpl;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	
//	@Autowired
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
//	public EmployeeDao getEmployeeDao() {
//		return employeeDao;
//	}

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        Employee employee = employeeDao.employeeGetById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<Integer> createEmployee(Employee employee) {
		Integer id = employeeDao.createEmployee(employee);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
