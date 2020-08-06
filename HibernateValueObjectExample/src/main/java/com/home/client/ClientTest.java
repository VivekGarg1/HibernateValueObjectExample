package com.home.client;

import java.util.Date;

import org.hibernate.Session;

import com.home.entities.Address;
import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			createEmployee(session);
			//getEmployeeById(session);
			//updateEmployeeById(session);
			//deleteEmployeeById(session);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteEmployeeById(Session session) {
		Employee employee=session.get(Employee.class, 1);
		if(employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		}
	}

	private static void updateEmployeeById(Session session) {
		session.beginTransaction();
		Employee employee=session.get(Employee.class, 1);
		if(employee != null) {
			employee.setEmployeeName("Vivek Garg");
		    employee.setEmail("vivek.garg@gmail.com");
		    employee.setSalary(10000.00);
		    session.update(employee);
		    session.getTransaction().commit();
		}
		else
			System.out.println("Employee does not exist!!!");
		}

	private static void getEmployeeById(Session session) {
		Employee employee=session.get(Employee.class, 1);
		if(employee != null)
			System.out.println(employee);
		else
			System.out.println("Employee does not exist!!!");
		}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Employee employee=new Employee();
		employee.setEmployeeName("Vivek");
		employee.setEmail("vivek@gmail.com");
		employee.setDoj(new Date());
		employee.setSalary(16000.00);
		
		Address homeAddress=new Address();
		homeAddress.setCity("Bulandshahr");
		homeAddress.setState("U.P");
		homeAddress.setStreet("Hanuman Chowck");
		homeAddress.setPin(123456L);
		employee.setHomeAddress(homeAddress);
		
		Address officeAddress=new Address();
		officeAddress.setCity("Hapur");
		officeAddress.setState("U.P");
		officeAddress.setStreet("Pakka bagh");
		officeAddress.setPin(453456L);
		employee.setOfficeAddress(officeAddress);
		
		session.save(employee);
		session.getTransaction().commit();
	}
}
