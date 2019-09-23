package com.tnt.project.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projectcost")
public class ProjectCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // NOT NULL AUTO_INCREMENT,
    @Column(name = "projectid")
    private Integer projectId; // INT(11) NOT NULL,
    @Column(name = "name")
    private String name; // VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
    @Column(name = "cost")
    private BigDecimal cost; // DECIMAL(10,2) NOT NULL,
    @Column(name = "billable", columnDefinition = "TINYINT", length = 1)
    private boolean billable; // TINYINT(1) NOT NULL DEFAULT '1',
    @Column(name = "ownerid")
    private Integer ownerId; // INT(11) NULL DEFAULT NULL,
    @Column(name = "departmentid")
    private Integer departmentId; // INT(10) UNSIGNED NULL DEFAULT NULL,
    @Column(name = "insertdate")
    private Date insertDate; // DATETIME NULL DEFAULT NULL,
    @Column(name = "updatedate")
    private Date updateDate; // DATETIME NULL DEFAULT NULL,
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the projectId
     */
    public Integer getProjectId() {
        return projectId;
    }
    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the cost
     */
    public BigDecimal getCost() {
        return cost;
    }
    /**
     * @param cost the cost to set
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    /**
     * @return the billable
     */
    public boolean isBillable() {
        return billable;
    }
    /**
     * @param billable the billable to set
     */
    public void setBillable(boolean billable) {
        this.billable = billable;
    }
    /**
     * @return the ownerId
     */
    public Integer getOwnerId() {
        return ownerId;
    }
    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * @return the departmentId
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    /**
     * @return the insertDate
     */
    public Date getInsertDate() {
        return insertDate;
    }
    /**
     * @param insertDate the insertDate to set
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
    /**
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }
    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProjectCost [id=" + id + ", projectId=" + projectId + ", name=" + name + ", cost=" + cost
                + ", billable=" + billable + ", ownerId=" + ownerId + ", departmentId=" + departmentId + ", insertDate="
                + insertDate + ", updateDate=" + updateDate + "]";
    }

    
}
