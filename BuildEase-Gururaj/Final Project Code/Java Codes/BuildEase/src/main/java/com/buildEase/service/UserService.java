package com.buildEase.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.UserDto;
import com.buildEase.repositories.UserRepository;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);
	public UserDto getUserById(Integer id);
	public List<UserDto> getAllUsers();
	public UserDto updateUser(UserDto user);
	public ApiResponse removeUser(Integer id);
	public ApiResponse removeAllUsers();

}
