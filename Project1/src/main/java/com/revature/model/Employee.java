package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity

@Table(name = "Employee")
public class Employee {
@Id
@Column(name ="employee_id")
@GeneratedValue(generator = "employee_id_seq", strategy = GenerationType.AUTO)
@SequenceGenerator(allocationSize = 1, name = "employee_id_seq")

private int empID;
@Column(name ="employee_username")
private String username;
@Column(name = "employee_password")
private String password;
@Column
private boolean isManager;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
//public Employee(int iD, String username, String password) {
//	super();
//	empID = iD;
//	this.username = username;
//	this.password = password;
//}

public Employee(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
@Transient
public int getID() {
	return empID;
}
public void setID(int iD) {
	empID = iD;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public int hashCode() {
	return Objects.hash(empID, password, username);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return empID == other.empID && Objects.equals(password, other.password) && Objects.equals(username, other.username);
}
@Override
public String toString() {
	return "Employee [ID=" + empID + ", username=" + username + ", password=" + password + "]";
}

}
