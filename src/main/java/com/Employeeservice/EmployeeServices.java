package com.Employeeservice;

import java.util.List;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

public class EmployeeServices {

	public Employee saveEmployee(Employee employee){
		EmployeeDao dao = new EmployeeDao();
		return dao.saveEmployee(employee);
	}
	public Employee getEmployeeById(int id){
		EmployeeDao dao= new EmployeeDao();
		return dao.getEmployeeById(id);
	}
	public List<Employee> getAllEmployee(){
		EmployeeDao dao= new EmployeeDao();
	List employees=dao.getAllEmployee();
	return employees;
	}
	public Employee validateEmployee(int id,String name){
		EmployeeDao dao = new EmployeeDao();
		return dao.validateEmployee(id, name);
	}
	public boolean deleteEmployeeByID(int id){
		EmployeeDao dao = new EmployeeDao();
		return dao.deleteEmployeeByID(id);
	}
}
