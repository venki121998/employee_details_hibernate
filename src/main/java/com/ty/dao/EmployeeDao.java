package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Employee;


public class EmployeeDao {

	public Employee saveEmployee(Employee employee){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
		
	}
	public Employee getEmployeeById(int id){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		 Employee employee=entityManager.find(Employee.class, id);
		 System.out.println("id is "+employee.getId());
		 System.out.println("name is "+employee.getName());
		 System.out.println("salary is "+employee.getSal());
		return employee;
		}
	public List<Employee> getAllEmployee(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		String sql="SELECT s FROM EMPLOYEE s";
		Query query= entityManager.createQuery(sql);
		List<Employee> employees= query.getResultList();
		return employees;
		
	}
	public Employee validateEmployee( m){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		String sql="SELECT u FROM EMPOYEE u WHERE u.id=?1 AND u.name=?2";
		Query query= entityManager.createQuery(sql);
		      query.setParameter(1, name);
		      query.setParameter(2, name);
		      List<Employee>employees= query.getResultList();
		      if(employees.size()>0)
		      {
					Employee employee= employees.get(0);
					return employee;
				}
		      else
				{
					System.out.println("no return");
					return null;
				}
			
		      
		
		
	}
	public boolean deleteEmployeeByID(int id){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
	Employee	employee=entityManager.find(Employee.class, id);
	entityTransaction.begin();
	if(employee!=null){
		entityManager.persist(employee);
		entityTransaction.commit();
		return true;
	}
	else
	{
		System.out.println("no element is deleted");
		return false;
	}
		
	}

}
