package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Login_details", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Login_det {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	@Id
	private String empid;
	private String email;
	private String password;
	private String role;
	private String fullname;
	
	public Login_det() {
		super();
	}

	public Login_det(String empid,String email, String password, String role, String fullname) {
		this.empid=empid;
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
	

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Login_det orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	

}
