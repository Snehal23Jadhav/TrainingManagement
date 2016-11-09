package com.project.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.springmvc.model.Admin;



public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	
	public boolean addEntity(Admin admin) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(admin);
		tx.commit();
		session.close();

		return false;
	}


	public Admin getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Admin admin = (Admin) session.load(Admin.class,new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return admin;
	}


	public List<Admin> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Admin> adminList = session.createCriteria(Admin.class).list();
		tx.commit();
		session.close();
		return adminList;
	}

	public boolean deleteEntity(long id)throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Admin.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
