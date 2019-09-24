package com.tnt.project.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.project.domain.ProjectCost;

public interface ProjectCostRepository extends JpaRepository<ProjectCost, Integer> {
    
    List<ProjectCost> findByProjectId(Integer projectId);
}
