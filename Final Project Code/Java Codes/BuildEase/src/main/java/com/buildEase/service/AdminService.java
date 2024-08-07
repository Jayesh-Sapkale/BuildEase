package com.buildEase.service;

import java.util.List;

import com.buildEase.dtos.AdminDto;
import com.buildEase.dtos.ApiResponse;

public interface AdminService {
	
	public AdminDto addNewAdmin(AdminDto AdminDto);
	public AdminDto getAdminById(Integer id);
	public List<AdminDto> getAllAdmin();
	public AdminDto updateAdmin(AdminDto AdminDto);
	public ApiResponse removeAdmin(Integer id);
	public ApiResponse removeAllAdmins();

}
