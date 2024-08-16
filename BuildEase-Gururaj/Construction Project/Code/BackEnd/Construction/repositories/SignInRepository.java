package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.SignIn;

public interface SignInRepository extends JpaRepository<SignIn, Integer> {

}
