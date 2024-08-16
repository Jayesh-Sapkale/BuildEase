package com.construction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("select a from Admin a where a.userName=:userName and a.password=:password")
	Optional<Admin> findAdmin(String userName, String password);

	
	@Query("select a.userName from Admin a where a.userName=:userName")
	Optional<String> validateUsername(String userName);

	@Query("select a.password from Admin a where a.password=:password")
	Optional<String> validatePassword(String password);
}
