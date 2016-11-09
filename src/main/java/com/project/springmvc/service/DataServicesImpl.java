package com.project.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springmvc.dao.DataDao;
import com.project.springmvc.model.Admin;



public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	public DataServicesImpl() {
		System.out.println("Data Service");
	}

	public boolean addEntity(Admin admin) throws Exception {
		return dataDao.addEntity(admin);
	}


	public Admin getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}


	public List<Admin> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}


	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
