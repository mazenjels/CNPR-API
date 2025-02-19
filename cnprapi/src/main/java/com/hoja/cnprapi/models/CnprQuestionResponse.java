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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_cnpr_question_response",schema = "public")
public class CnprQuestionResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
		

	
	
	@Column(columnDefinition = "TEXT")
	private String value;
	
	@Column(name = "is_correct")
	private boolean correct=false;
	
	
	@Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name = "last_updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "question", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CnprQuestion question;
	
	

	public CnprQuestionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public CnprQuestionResponse(long id, String value, boolean correct, CnprQuestion question) {
		super();
		this.id = id;
		this.value = value;
		this.correct = correct;
		this.question = question;
	}
	
	public CnprQuestionResponse(long id, String value, boolean correct) {
		super();
		this.id = id;
		this.value = value;
		this.correct = correct;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
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

	

	public CnprQuestion getQuestion() {
		return question;
	}

	public void setQuestion(CnprQuestion question) {
		this.question = question;
	}

	

	
}
