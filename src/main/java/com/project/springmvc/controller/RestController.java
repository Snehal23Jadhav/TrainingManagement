package com.project.springmvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springmvc.model.Admin;
import com.project.springmvc.model.Status;
import com.project.springmvc.service.DataServices;
@Controller
@RequestMapping("/admin")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addadmin(@RequestBody Admin admin) {
		try {
			dataServices.addEntity(admin);
			return new Status(1, "admin added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Admin getadmin(@PathVariable("id") long id) {
		Admin admin = null;
		try {
			admin = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Admin> getadmin() {

		List<Admin> adminList = null;
		try {
			adminList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return adminList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteadmin(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "admin deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
