package edu.mum.ex.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import edu.mum.hw2.domain.Beneficiary;
import edu.mum.hw2.domain.Project;
import edu.mum.hw2.domain.Task;
import edu.mum.hw2.domain.User;

public class ProjectDaoImplTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void create() throws ParseException, IOException {
		ProjectDaoImpl prjDaoImpl = new ProjectDaoImpl();
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		BeneficiaryDaoImpl benDaoImpl = new BeneficiaryDaoImpl();
		
		userDaoImpl.create(new User());
		
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setCity("Kathmandu");
		beneficiary.setName("Peter");
		beneficiary.setPhone("984926118");
		Path p = FileSystems.getDefault().getPath("", "myFile");         
		byte [] fileData = Files.readAllBytes(p);
		beneficiary.setPic(fileData);	
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Project project = new Project();
		project.setDescription("This is Hibernet project");
		project.setName("Hibernet");
		project.setStartDate(formatter.parse("2015-12-1"));
		project.setEndDate(formatter.parse("2016-8-21"));
		project.setStatus("Pending");
		project.getListBenificiaries().add(beneficiary);
		prjDaoImpl.create(project);
		

		 
		
		Task task = new Task();
		task.setName("Hibernet Task");
		task.setDuration("2 hrs");
		task.setStatus("Pending");
		
		
		
		User user =userDaoImpl.readById(1);
		task.setUser(user);
		taskDaoImpl.create(task);
		//get by id
		Project resultProject= prjDaoImpl.readById(1);
		//list of project and beneficiaries
		prjDaoImpl.readProjectsBeneficiaries();
		//getting project by status
		prjDaoImpl.readProjectsByStatus();
		//search project by key
		prjDaoImpl.searchProjects("Hibernet");
		//where a volunteer have offered services
		prjDaoImpl.getProjectServiceOffered();
		
		System.out.println(user.toString());
		
		assertEquals("Hibernet", resultProject.getName());
		
	}
	
	

}
