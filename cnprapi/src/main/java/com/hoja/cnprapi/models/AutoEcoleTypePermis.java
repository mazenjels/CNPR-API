package com.hoja.cnprapi.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="tb_cnpr_auto_ecole_type_permis",schema = "public")
public class AutoEcoleTypePermis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	
	@Column(name = "active_status")
	private boolean activeStatus=false;
	
	
	@Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "last_updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cnprAutoEcole", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CnprAutoEcole cnprAutoEcole;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "typePermis", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TypePermis typePermis;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "createdBy", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private TypePermis typePermis;


	public AutoEcoleTypePermis() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TypePermis getTypePermis() {
		return typePermis;
	}


	public void setTypePermis(TypePermis typePermis) {
		this.typePermis = typePermis;
	}


	public CnprAutoEcole getCnprAutoEcole() {
		return cnprAutoEcole;
	}


	public void setCnprAutoEcole(CnprAutoEcole cnprAutoEcole) {
		this.cnprAutoEcole = cnprAutoEcole;
	}

//
//	public TypePermis getTypePermis() {
//		return typePermis;
//	}
//
//
//	public void setTypePermis(TypePermis typePermis) {
//		this.typePermis = typePermis;
//	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	

	
	
}
