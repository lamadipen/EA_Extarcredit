package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id @GeneratedValue
	private int user_id;
	private String name;
	private String phone;
	private String city;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Task> listTask = new ArrayList<>();
	
	public List<Task> getListTask() {
		return listTask;
	}


	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+name+" phone: "+phone+" City:"+city+" Role: "+role;
	}
}
