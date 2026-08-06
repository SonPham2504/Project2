package com.javaweb.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponeDTO {
	private String error;
	private List<String> detailsList = new ArrayList<String>();
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getDetailsList() {
		return detailsList;
	}
	public void setDetailsList(List<String> detailsList) {
		this.detailsList = detailsList;
	}
	
}
