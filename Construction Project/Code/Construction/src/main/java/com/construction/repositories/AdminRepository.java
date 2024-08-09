package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
