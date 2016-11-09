package com.project.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "admin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "admin_id")
	private long id;

	@Column(name = "admin_email_id")
	private String adminEmail;

	@Column(name = "admin_password")
	private String adminPassword;

	@Column(name = "admin_name")
	private String adminName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getadminEmail() {
		return adminEmail;
	}

	public void setadminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getadminPassword() {
		return adminPassword;
	}

	public void setadminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getadminName() {
		return adminName;
	}

	public void setadminName(String adminName) {
		this.adminName = adminName;
	}

	
}
