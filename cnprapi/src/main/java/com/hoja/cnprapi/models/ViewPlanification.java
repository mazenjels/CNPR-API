package com.hoja.cnprapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "vw_planification",schema = "public")
public class ViewPlanification {

	@Id
	@Column(name="id")
	private long id;
	
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="current_status")
	private String currentStatus;
	
	@Column(name="date_debut")
	private String dateDebut;

	
	@Column(name = "active_status")
	private boolean activeStatus=false;
	
	
	
	@Column(name="commune_designation")
	private String communeDesignation;
	
	@Column(name="commune_id")
	private long communeId;
	
	@Column(name="district_designation")
	private String districtDesignation;
	
	@Column(name="district_id")
	private long districtId;

	@Column(name="province_designation")
	private String provinceDesignation;
	
	@Column(name="province_id")
	private long provinceId;

	
	public ViewPlanification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCommuneDesignation() {
		return communeDesignation;
	}

	public void setCommuneDesignation(String communeDesignation) {
		this.communeDesignation = communeDesignation;
	}

	public long getCommuneId() {
		return communeId;
	}

	public void setCommuneId(long communeId) {
		this.communeId = communeId;
	}

	public String getDistrictDesignation() {
		return districtDesignation;
	}

	public void setDistrictDesignation(String districtDesignation) {
		this.districtDesignation = districtDesignation;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getProvinceDesignation() {
		return provinceDesignation;
	}

	public void setProvinceDesignation(String provinceDesignation) {
		this.provinceDesignation = provinceDesignation;
	}

	public long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	
	
}
