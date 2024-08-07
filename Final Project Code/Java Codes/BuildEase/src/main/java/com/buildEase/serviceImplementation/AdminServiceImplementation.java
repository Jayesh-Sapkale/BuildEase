package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.AdminDto;
import com.buildEase.dtos.ApiResponse;
import com.buildEase.entities.Admin;
import com.buildEase.repositories.AdminRepository;
import com.buildEase.service.AdminService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdminDto addNewAdmin(AdminDto adminDto) {
		Admin admin = modelMapper.map(adminDto, Admin.class);
		Admin savedAdmin = adminRepo.save(admin); // This persists the entity and returns the managed entity
		return modelMapper.map(savedAdmin, AdminDto.class); // Convert the saved entity back to DTO and return
	}

	@Override
	public AdminDto getAdminById(Integer id) {
		Admin admin = adminRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + id));
		return modelMapper.map(admin, AdminDto.class);
	}

	@Override
	public List<AdminDto> getAllAdmin() {
		List<Admin> admins = adminRepo.findAll();
		return admins.stream().map(admin -> modelMapper.map(admin, AdminDto.class)).collect(Collectors.toList());
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto) {
		Admin admin = adminRepo.findById(adminDto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + adminDto.getId()));
		modelMapper.map(adminDto, admin);
		Admin updatedAdmin = adminRepo.save(admin);
		return modelMapper.map(updatedAdmin, AdminDto.class);
	}

	@Override
	public ApiResponse removeAdmin(Integer id) {
		 if (!adminRepo.existsById(id)) {
		        throw new EntityNotFoundException("Admin not found with ID: " + id); //replace this exception with our custom exceptions
		    }
		    adminRepo.deleteById(id);
		    return new ApiResponse("Admin removed successfully");
	}

	@Override
	public ApiResponse removeAllAdmins() {
		adminRepo.deleteAll();
	    return new ApiResponse("All admins removed successfully");
	}

}
