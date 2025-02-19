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
@Table(name = "tb_cnpr_question", schema = "public")
public class CnprQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "title")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "TEXT")
	private String videoUrl;

	@Column(columnDefinition = "TEXT")
	private String audioUrl;

	@Column(columnDefinition = "TEXT")
	private String imageUrl;

	@Column(columnDefinition = "TEXT")
	private String reponse;

	@Column(name = "active_status")
	private boolean activeStatus = false;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name = "last_updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = true, nullable = false)
	@UpdateTimestamp
	private Timestamp lastUpdate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "type_permis", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private TypePermis typePermis;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lesson", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	// @JsonIgnore
	private CnprLesson lesson;
//	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lessonModule", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	// @JsonIgnore
	private CnprLessonModule lessonModule;

	public CnprQuestion(long id, String title, String videoUrl, String reponse, CnprLesson lesson,
			CnprLessonModule lessonModule, TypePermis typePermis) {
		super();
		this.id = id;
		this.title = title;
		this.videoUrl = videoUrl;
		this.reponse = reponse;
		this.lesson = lesson;
		this.lessonModule = lessonModule;
		this.typePermis = typePermis;

	}

	public CnprQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public TypePermis getTypePermis() {
		return typePermis;
	}

	public void setTypePermis(TypePermis typePermis) {
		this.typePermis = typePermis;
	}

	public CnprLesson getLesson() {
		return lesson;
	}

	public void setLesson(CnprLesson lesson) {
		this.lesson = lesson;
	}

	public CnprLessonModule getLessonModule() {
		return lessonModule;
	}

	public void setLessonModule(CnprLessonModule lessonModule) {
		this.lessonModule = lessonModule;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
