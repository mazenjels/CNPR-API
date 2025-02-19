package com.hoja.cnprapi.models;

import javax.persistence.Column;

public class AutoEoleDTO {

	private long id;
	
	
	private String designation;


	public AutoEoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AutoEoleDTO(long id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
