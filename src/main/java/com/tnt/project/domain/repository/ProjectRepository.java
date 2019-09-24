package com.tnt.project.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.project.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
    List<Project> findByOrganizationId(Integer organizationId);
}
