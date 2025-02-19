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
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Immutable
@Table(name = "vw_auto_ecole",schema = "public")
public class ViewAutoEcole {

	@Id
	@Column(name="id")
	private long id;
	
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="code_unique")
	private String codeUnique;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="lattitude")
	private String lattitude;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="phone2")
	private String phone2;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="adresse_number")
	private String adresseNumber;
	
	@Column(name="adresse_avenue")
	private String adresseAvenue;
	

	@Column(name="photo_ecole")
	private String photoEcole;
	
	@Column(name="documents")
	private String documents;
	
	@Column(name="directeur_gerant")
	private String directeurGerant;
	
	@Column(name="planification_name")
	private String planificationName;
	
	@Column(name="province_name")
	private String provinceName;
	
	@Column(name="district_name")
	private String districtName;
	
	@Column(name="commune_name")
	private String communeName;


	@Column(name="capacite_salle")
	private int capaciteSalle;
	
	@Column(name="nb_instructeur")
	private int nbInstructeur;
	
	
	@Column(name = "active_status")
	private boolean activeStatus=false;
	
	
	@Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "last_updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;

	private long commune;
	

	private long district;
	

	private long province;
	

	private long planification;
	

	private long createdBy;
	
	public ViewAutoEcole() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getPhone2() {
		return phone2;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail() {
		return email;
	}

	
	
	public String getAdresseNumber() {
		return adresseNumber;
	}

	public void setAdresseNumber(String adresseNumber) {
		this.adresseNumber = adresseNumber;
	}

	public String getAdresseAvenue() {
		return adresseAvenue;
	}

	public void setAdresseAvenue(String adresseAvenue) {
		this.adresseAvenue = adresseAvenue;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhotoEcole() {
		return photoEcole;
	}

	public void setPhotoEcole(String photoEcole) {
		this.photoEcole = photoEcole;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public int getCapaciteSalle() {
		return capaciteSalle;
	}

	public void setCapaciteSalle(int capaciteSalle) {
		this.capaciteSalle = capaciteSalle;
	}

	public int getNbInstructeur() {
		return nbInstructeur;
	}

	public void setNbInstructeur(int nbInstructeur) {
		this.nbInstructeur = nbInstructeur;
	}

	
	public String getDirecteurGerant() {
		return directeurGerant;
	}

	public void setDirecteurGerant(String directeurGerant) {
		this.directeurGerant = directeurGerant;
	}



	public String getCodeUnique() {
		return codeUnique;
	}

	public void setCodeUnique(String codeUnique) {
		this.codeUnique = codeUnique;
	}


	public String getPlanificationName() {
		return planificationName;
	}


	public void setPlanificationName(String planificationName) {
		this.planificationName = planificationName;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}


	public String getDistrictName() {
		return districtName;
	}


	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


	public String getCommuneName() {
		return communeName;
	}


	public void setCommuneName(String communeName) {
		this.communeName = communeName;
	}


	public long getCommune() {
		return commune;
	}


	public void setCommune(long commune) {
		this.commune = commune;
	}


	public long getDistrict() {
		return district;
	}


	public void setDistrict(long district) {
		this.district = district;
	}


	public long getProvince() {
		return province;
	}


	public void setProvince(long province) {
		this.province = province;
	}


	public long getPlanification() {
		return planification;
	}


	public void setPlanification(long planification) {
		this.planification = planification;
	}


	public long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}


	public String getVille() {
		return ville;
	}


	
	
}
