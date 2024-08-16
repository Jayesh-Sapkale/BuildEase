package com.buildEase.dtos;

import java.time.LocalDateTime;

public class ApiResponse {

	private String mesg;
	private LocalDateTime timeStamp;

	public ApiResponse(String mesg) {
		this.mesg = mesg;
		this.timeStamp = LocalDateTime.now();
	}

	public ApiResponse() {

	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
