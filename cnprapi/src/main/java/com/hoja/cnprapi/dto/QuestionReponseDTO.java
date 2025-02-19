package com.hoja.cnprapi.dto;

import javax.persistence.Column;

public class QuestionReponseDTO {

	private long id;

	private long questionId;
	
	private String questionTitle;

	private String value;
	
	private boolean correct=false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
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

	public QuestionReponseDTO(long id, long questionId, String questionTitle, String value, boolean correct) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.value = value;
		this.correct = correct;
	}

	public QuestionReponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
