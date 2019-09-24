package com.tnt.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.project.controller.form.CreateProjectForm;
import com.tnt.project.domain.Project;
import com.tnt.project.domain.ProjectCost;
import com.tnt.project.domain.ProjectRole;
import com.tnt.project.domain.repository.ProjectCostRepository;
import com.tnt.project.domain.repository.ProjectRepository;
import com.tnt.project.domain.repository.ProjectRoleRepository;
import com.tnt.project.service.OfferService;
import com.tnt.project.vo.Offer;
import com.tnt.project.vo.OfferCost;
import com.tnt.project.vo.OfferRole;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/projects")
@Api(value = "projects", tags = "projects")
public class ProjectController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectRoleRepository projectRoleRepository;

    @Autowired
    ProjectCostRepository projectCostRepository;

    @Autowired
    private OfferService offerService;

    @GetMapping
    @ApiOperation(value = "Fetches all projects", nickname = "getProjects")
    public List<Project> getProjects(@RequestParam(required = false) Integer orgId) {
        LOGGER.info("Fetching projects getProjects() OrgId : " + orgId);
        if (orgId != null && orgId > 0) {
            return projectRepository.findByOrganizationId(orgId);
        }
        return projectRepository.findAll();
    }

    
    @PostMapping
    @ApiOperation(value = "Creates Project", nickname = "createProject")
    public Project createProject(@Valid @RequestBody CreateProjectForm projectForm) {
        LOGGER.info("Creating Proect with Name " + projectForm.getName());
        Project project = new Project();
        BeanUtils.copyProperties(projectForm, project);
        projectRepository.save(project);
        
        if (projectForm.getOfferId() != null && projectForm.getOfferId() > 0) {
            Integer offerId = projectForm.getOfferId();
            Offer offer = offerService.getOffer(offerId);
            
            if (offer != null) {
                project.setOrganizationId(offer.getOrganizationId());
                project.setStartDate(new Date());
                project.setOpen(true);
                
                List<OfferRole> roles = offerService.getRoles(offerId);
                List<OfferCost> costs = offerService.getCosts(offerId);
                List<ProjectCost> projectCosts = new ArrayList<ProjectCost>();
                List<ProjectRole> projectRoles = new ArrayList<ProjectRole>();
                
                for (OfferRole role : roles) {
                    ProjectRole pr = new ProjectRole();
                    pr.setName(role.getName());
                    pr.setCostPerHour(role.getCostPerHour());
                    pr.setExpectedHours(role.getExpectedHours());
                    pr.setProjectId(project.getId());
                    projectRoles.add(pr);
                }
                projectRoleRepository.saveAll(projectRoles);
                LOGGER.info("Saved all project roles from offer");
                for (OfferCost cost : costs) {
                    ProjectCost pc = new ProjectCost();
                    pc.setName(cost.getName());
                    pc.setBillable(cost.isBillable());
                    pc.setCost(cost.getCost());
                    pc.setProjectId(project.getId());
                    projectCosts.add(pc);
                }
                projectCostRepository.saveAll(projectCosts);
                LOGGER.info("Saved all project costs from offer");
                
            }
        }
        
        
        LOGGER.info("Project Created with Id " + project.getId());
        return project;
    }

    @GetMapping(value="/{projectId}/roles")
    @ApiOperation(value="Fetces all roles of the project." , nickname="getRoles")
    public List<ProjectRole> getRoles(@PathVariable Integer projectId) {
        List<ProjectRole> list = projectRoleRepository.findByProjectId(projectId);
        return list;
    }
    
    @PostMapping(value="/{projectId}/roles")
    @ApiOperation(value="Creates a role in project." , nickname="createRole")
    public ProjectRole createRole(@PathVariable Integer projectId,@RequestBody ProjectRole role) {
        role.setProjectId(projectId);
        projectRoleRepository.save(role);
        return role;
    }
    
    
    @GetMapping(value="/{projectId}/costs")
    @ApiOperation(value="Fetces all roles of the project." , nickname="getCosts")
    public List<ProjectCost> getCosts(@PathVariable Integer projectId) {
        List<ProjectCost> list = projectCostRepository.findByProjectId(projectId);
        return list;
    }
    
    @PostMapping(value="/{projectId}/costs")
    @ApiOperation(value="Creates a role in project." , nickname="createCost")
    public ProjectCost createCost(@PathVariable Integer projectId,@RequestBody ProjectCost cost) {
        cost.setProjectId(projectId);
        projectCostRepository.save(cost);
        return cost;
    }
    
}
