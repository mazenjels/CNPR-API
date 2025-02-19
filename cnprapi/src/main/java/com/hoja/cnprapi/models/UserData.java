package com.hoja.cnprapi.models;

import java.util.List;
import java.util.Map;

public class UserData {

	private String codeUnique;
	private Map<String,Long> answers;
	
	public UserData(String codeUnique,Map<String,Long> answers) {
		super();
		this.codeUnique = codeUnique;
		this.answers = answers;
	}

	public String getCodeUnique() {
		return codeUnique;
	}

	public void setCodeUnique(String codeUnique) {
		this.codeUnique = codeUnique;
	}

	public Map<String,Long> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<String,Long> answers) {
		this.answers = answers;
	}
	
	
}
