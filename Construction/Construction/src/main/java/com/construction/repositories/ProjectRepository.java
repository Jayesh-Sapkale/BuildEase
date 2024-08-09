package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
