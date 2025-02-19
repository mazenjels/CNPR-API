package com.hoja.cnprapi.models;

public class QuestionAnswer {

	private Long questionId;
	private Long answerId;
	private String candidateCode;
	private boolean correct;
	
	private String questionTitle;
	private String answerValue;
	
	public QuestionAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public QuestionAnswer(Long questionId, Long answerId, String candidateCode) {
		super();
		this.questionId = questionId;
		this.answerId = answerId;
		this.candidateCode = candidateCode;
	}


	public boolean isCorrect() {
		return correct;
	}


	public void setCorrect(boolean correct) {
		this.correct = correct;
	}


	public String getQuestionTitle() {
		return questionTitle;
	}


	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}


	public String getAnswerValue() {
		return answerValue;
	}


	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}


	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getCandidateCode() {
		return candidateCode;
	}
	public void setCandidateCode(String candidateCode) {
		this.candidateCode = candidateCode;
	}
	
	
}
