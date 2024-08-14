package com.construction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.Builder;

public interface BuilderRepository extends JpaRepository<Builder, Integer> {

	@Query("select b from Builder b where b.userName=:userName and b.password=:password")
	Optional<Builder> findBuilderByUser(String userName, String password);

	@Query("select b.userName from Builder b where b.userName=:userName")
	Optional<String> validateUsername(String userName);

	@Query("select b.password from Builder b where b.password=:password")
	Optional<String> validatePassword(String password);

}
