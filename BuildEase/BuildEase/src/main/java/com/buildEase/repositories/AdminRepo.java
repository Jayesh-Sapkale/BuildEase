package com.buildEase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildEase.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
