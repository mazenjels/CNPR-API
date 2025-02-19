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
@Table(name = "vw_result",schema = "public")
public class ViewResult {

	@Id
	@Column(name="id")
	private long id;
	
	
	@Column(name="question_answer_id")
	private long questionAnswerId;
	
	@Column(name="candidat_code")
	private String codeUnique;
	
	@Column(name="question_id")
	private long questionId;
	
	@Column(name="question_response_id")
	private long questionResponseId;
	
	@Column(name="is_correct")
	private boolean correct;
	
	@Column(name="user_response")
	private String userResponse;
	
	@Column(name="question_title")
	private String questionTitle;
	
	@Column(name="question_reponse")
	private String questionReponse;
	
	
	
	public ViewResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getQuestionAnswerId() {
		return questionAnswerId;
	}



	public void setQuestionAnswerId(long questionAnswerId) {
		this.questionAnswerId = questionAnswerId;
	}



	public String getCodeUnique() {
		return codeUnique;
	}



	public void setCodeUnique(String codeUnique) {
		this.codeUnique = codeUnique;
	}



	public long getQuestionId() {
		return questionId;
	}



	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}



	public long getQuestionResponseId() {
		return questionResponseId;
	}



	public void setQuestionResponseId(long questionResponseId) {
		this.questionResponseId = questionResponseId;
	}



	public boolean isCorrect() {
		return correct;
	}



	public void setCorrect(boolean correct) {
		this.correct = correct;
	}



	public String getUserResponse() {
		return userResponse;
	}



	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}



	public String getQuestionTitle() {
		return questionTitle;
	}



	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}



	public String getQuestionReponse() {
		return questionReponse;
	}



	public void setQuestionReponse(String questionReponse) {
		this.questionReponse = questionReponse;
	}

	
	

	
	
}
