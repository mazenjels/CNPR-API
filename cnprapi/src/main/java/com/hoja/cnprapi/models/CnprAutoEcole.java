package com.hoja.cnprapi.models;

import java.io.Serializable;
import java.sql.Timestamp;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_cnpr_auto_ecole",schema = "public")
public class CnprAutoEcole implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name = "is_headquarter")
	private boolean headquarter=false;
	
	@Column(name = "adresse_headquarter")
	private String adresseHeadquarter="na";
	
	@Column(name="photo_ecole")
	private String photoEcole;
	
	@Column(name="documents")
	private String documents;
	
	@Column(name="type_document")
	private String typeDocuments="na";
	
	@Column(name="directeur_gerant")
	private String directeurGerant;

	

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "commune", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Commune commune;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "district", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private District district;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "province", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Province province;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "planification", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Planification planification;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "createdBy", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CnprUser createdBy;
	
	public CnprAutoEcole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTypeDocuments() {
		return typeDocuments;
	}

	public boolean isHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(boolean headquarter) {
		this.headquarter = headquarter;
	}

	public String getAdresseHeadquarter() {
		return adresseHeadquarter;
	}

	public void setAdresseHeadquarter(String adresseHeadquarter) {
		this.adresseHeadquarter = adresseHeadquarter;
	}

	public void setTypeDocuments(String typeDocuments) {
		this.typeDocuments = typeDocuments;
	}

	public Planification getPlanification() {
		return planification;
	}

	public void setPlanification(Planification planification) {
		this.planification = planification;
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

	public CnprUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CnprUser createdBy) {
		this.createdBy = createdBy;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getDirecteurGerant() {
		return directeurGerant;
	}

	public void setDirecteurGerant(String directeurGerant) {
		this.directeurGerant = directeurGerant;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getCodeUnique() {
		return codeUnique;
	}

	public void setCodeUnique(String codeUnique) {
		this.codeUnique = codeUnique;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public District getVille() {
		return district;
	}

	public void setVille(District district) {
		this.district = district;
	}
	
	
	
}
