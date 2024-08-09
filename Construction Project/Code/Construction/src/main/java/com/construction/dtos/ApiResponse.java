package com.construction.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String mesg;
	private LocalDateTime timeStamp;

	public ApiResponse(String mesg) {
		this.mesg = mesg;
		this.timeStamp = LocalDateTime.now();
	}


	

}
