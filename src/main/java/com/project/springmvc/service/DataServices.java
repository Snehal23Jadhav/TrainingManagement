package com.project.springmvc.service;

import java.util.List;

import com.project.springmvc.model.Admin;


public interface DataServices {
	public boolean addEntity(Admin admin) throws Exception;
	public Admin getEntityById(long id) throws Exception;
	public List<Admin> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
