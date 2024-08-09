package com.buildEase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildEase.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}