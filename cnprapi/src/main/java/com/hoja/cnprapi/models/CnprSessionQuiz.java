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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_cnpr_sesson_quiz", schema = "public")
public class CnprSessionQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "success_count")
	private long successCount;
	
	@Column(name = "question_max")
	private long questionMax;

	@Column(name = "active_status")
	private boolean activeStatus = false;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name = "last_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "candidat", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private CnprUser candidat;

	

	public CnprSessionQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(long successCount) {
		this.successCount = successCount;
	}

	public long getQuestionMax() {
		return questionMax;
	}

	public void setQuestionMax(long questionMax) {
		this.questionMax = questionMax;
	}

	public CnprUser getCandidat() {
		return candidat;
	}

	public void setCandidat(CnprUser candidat) {
		this.candidat = candidat;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

}
