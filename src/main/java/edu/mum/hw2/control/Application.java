package edu.mum.hw2.control;

import java.nio.file.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.ex.dao.UserDaoImpl;
import edu.mum.hw2.domain.Project;
import edu.mum.hw2.domain.Task;
import edu.mum.hw2.domain.User;


public class Application {

	public static void main(String[] args) {
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		userDaoImpl.create(new User());
		
		User user =userDaoImpl.readById(1);
		System.out.println(user.toString());
	
	}
}
