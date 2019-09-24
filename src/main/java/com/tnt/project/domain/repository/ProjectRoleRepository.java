package com.tnt.project.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.project.domain.ProjectRole;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Integer> {
    
    List<ProjectRole> findByProjectId(Integer projectId);
}
