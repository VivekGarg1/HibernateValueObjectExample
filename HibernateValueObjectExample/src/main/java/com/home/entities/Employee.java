package com.home.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="employee_table")
@DynamicUpdate
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name",length = 100, nullable = false)
	private String employeeName;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "date_of_joining")
	private Date doj;
	
	@Column(name = "salary")
	private double salary;
	
	@Embedded
	@AttributeOverrides(value = { 
			@AttributeOverride(column = @Column(name="home_street_name"), name = "street"),
			@AttributeOverride(column = @Column(name="home_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name="home_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name="home_pin_code"), name = "pin")
			})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides(value = { 
			@AttributeOverride(column = @Column(name="office_street_name"), name = "street"),
			@AttributeOverride(column = @Column(name="office_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name="office_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name="office_pin_code"), name = "pin")
			})
	private Address officeAddress;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + "]";
	}

}
