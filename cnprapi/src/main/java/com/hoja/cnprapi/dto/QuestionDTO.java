package com.hoja.cnprapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionDTO {

	
	@JsonProperty("id")
	private long id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("videoUrl")
	private String videoUrl;

	@JsonProperty("reponse")
	private String reponse;
	
	@JsonProperty("lesson")
	private String lesson;
	
	@JsonProperty("lessonModule")
	private String lessonModule;
	
	@JsonProperty("typeBrevet")
	private String typeBrevet;

	public QuestionDTO(long id, String title, String videoUrl, String reponse, String lesson,
			String lessonModule, String typeBrevet) {
		super();
		this.id = id;
		this.title = title;
		this.videoUrl = videoUrl;
		this.reponse = reponse;
		this.lesson = lesson;
		this.lessonModule = lessonModule;
		this.typeBrevet = typeBrevet;
	}

	public QuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getLessonModule() {
		return lessonModule;
	}

	public void setLessonModule(String lessonModule) {
		this.lessonModule = lessonModule;
	}

	public String getTypeBrevet() {
		return typeBrevet;
	}

	public void setTypeBrevet(String typeBrevet) {
		this.typeBrevet = typeBrevet;
	}

	@Override
	public String toString() {
		return title ;
	}
	
	
}
