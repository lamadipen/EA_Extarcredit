package edu.mum.ex.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.mum.ex.util.HibernetUtil;
import edu.mum.hw2.domain.Project;
import edu.mum.hw2.domain.Role;
import edu.mum.hw2.domain.User;

public class UserDaoImpl implements GenericDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Object obj) {
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			User user = new User();
			user.setName("Dipen");
			user.setPhone("9849261881");
			user.setCity("Fairfield");
			user.setRole(Role.ADMINISTRATOR);
			em.persist(user);
			
			User user2 = new User();
			user2.setName("Suman");
			user2.setPhone("9849261881");
			user2.setCity("Fairfield");
			user2.setRole(Role.VOLUNTEER);
			em.persist(user2);

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

	}

	@Override
	public User readById(int id) {
		EntityManager em =HibernetUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		User user=null;
		try {
			tx.begin();
			user =em.find(User.class, 1);
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return user;	

	}

}
