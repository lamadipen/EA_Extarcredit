package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Project {
	@Id
	@GeneratedValue
	private int proj_id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String description;
	private String status;
	private String location;
	
	@OneToMany
	@JoinColumn(name="proj_id")
	private List<Task> listTasks= new ArrayList<>();
	
	@ElementCollection
	@JoinTable(name="Beneficiary",joinColumns=@JoinColumn(name="proj_id"))
	private List<Beneficiary> listBenificiaries = new ArrayList<>();
	
	public List<Beneficiary> getListBenificiaries() {
		return listBenificiaries;
	}

	public void setListBenificiaries(List<Beneficiary> listBenificiaries) {
		this.listBenificiaries = listBenificiaries;
	}

	public Project() {
		
	}

	private int getProj_id() {
		return proj_id;
	}

	private void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Task> getListTasks() {
		return listTasks;
	}

	public void setListTasks(List<Task> listTasks) {
		this.listTasks = listTasks;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
