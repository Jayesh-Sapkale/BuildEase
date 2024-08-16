package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.UserDto;
import com.buildEase.entities.User;
import com.buildEase.repositories.UserRepository;
import com.buildEase.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user = userRepository.findById(userDto.getId())
				.orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userDto.getId()));
		modelMapper.map(userDto, user);
		User updatedUser = userRepository.save(user);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public ApiResponse removeUser(Integer id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found with ID: " + id);
		}
		userRepository.deleteById(id);
		return new ApiResponse("User removed successfully");
	}

	@Override
	public ApiResponse removeAllUsers() {
		userRepository.deleteAll();
		return new ApiResponse("All users removed successfully");
	}

}
