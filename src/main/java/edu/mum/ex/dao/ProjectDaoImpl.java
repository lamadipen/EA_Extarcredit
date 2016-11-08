package edu.mum.ex.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import edu.mum.ex.util.HibernetUtil;
import edu.mum.hw2.domain.Beneficiary;
import edu.mum.hw2.domain.Project;
import edu.mum.hw2.domain.Role;
import edu.mum.hw2.domain.Task;
import edu.mum.hw2.domain.User;

public class ProjectDaoImpl implements GenericDao {

	public ProjectDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Object obj) {
		
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			em.persist(obj);
			
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void readAll() {
		// TODO Auto-generated method stub
		EntityManager em =HibernetUtil.getEntityManager();
		em.createQuery("from Project");
	}

	@Override
	public Project readById(int id) {
		// TODO Auto-generated method stub
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Project project=null;
		try {
			tx.begin();
			project =em.find(Project.class, 1);
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return project;	
	}
	
	public void readProjectsBeneficiaries()
	{
	
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		try {
			tx.begin();
			
			Query query = em.createQuery("from Project");
			List<Project> plist= query.getResultList();
			System.out.println("List of project and beneficiaries");
			for (Iterator iterator = plist.iterator(); iterator.hasNext();) {
				Project project = (Project) iterator.next();
				List<Beneficiary> listBen = project.getListBenificiaries();
				
				for (Beneficiary beneficiary : listBen) {
					System.out.println("Projct: " +project.getName()+" Start Date: " + project.getStartDate()+" Beneficeary: "+beneficiary.getName()+" Phone:"+beneficiary.getPhone());
				}
			}
			
			
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
	
	public void readProjectsByStatus()
	{
	
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		try {
			tx.begin();
			
			Query query = em.createQuery("from Project p where p.status ='Pending'");
			List<Project> plist= query.getResultList();
			
			System.out.println("List of project by status");
			for (Iterator iterator = plist.iterator(); iterator.hasNext();) {
				Project project = (Project) iterator.next();

					System.out.println("Projct: " +project.getName()+" Start Date: " + project.getStartDate()+" Status: "+project.getStatus());
				
			}
			
			
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
	
	
	public void readProjectTask()
	{
	
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Project project = readById(1);
	
		try {
			tx.begin();
			List<Task> listTask = project.getListTasks();
			System.out.println("List of task for " + project.getName());
			for (Task task : listTask) {
				System.out.println("Task: "+task.getName()+" Duration: "+task.getDuration());
			}

			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
	
	
	public void searchProjects(String Key)
	{
	
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		try {
			tx.begin();
			
			Query query = em.createQuery("from Project p where p.name like :searchStr OR p.location like :searchStr");
			query.setParameter("searchStr", "%"+Key+"%");
			List<Project> plist= query.getResultList();
			
			System.out.println("Search project result");
			for (Iterator iterator = plist.iterator(); iterator.hasNext();) {
				Project project = (Project) iterator.next();

					System.out.println("Projct: " +project.getName()+" Start Date: " + project.getStartDate()+" Status: "+project.getStatus()+"Location: "+project.getLocation());
				
			}
			
			
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
	
	
	public void getProjectServiceOffered()
	{
	
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		try {
			tx.begin();
			
			Query query = em.createQuery("from Project p join p.task t join t.user u order by p.endDate");

			List<Project> plist= query.getResultList();
			
			System.out.println("List of project by service offered");
			for (Iterator iterator = plist.iterator(); iterator.hasNext();) {
				Project project = (Project) iterator.next();

					System.out.println("Projct: " +project.getName()+" Start Date: " + project.getStartDate()+" Status: "+project.getStatus()+"Location: "+project.getLocation());
				
			}
			
			
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
	
	

}
