package com.buildEase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildEase.entities.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
