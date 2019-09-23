package com.tnt.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // NOT NULL AUTO_INCREMENT,

    @Column(name = "organizationid")
    private Integer organizationId; // INT(11) NOT NULL,
    @Column(name = "startdate")
    private Date startDate; // DATE NOT NULL,
    @Column(name = "enddate")
    private Date endDate; // DATE NULL DEFAULT NULL,
    @Column(name = "open", columnDefinition = "TINYINT", length = 1)
    private boolean open; // TINYINT(1) NULL DEFAULT '0',
    @Column(name = "name")
    private String name; // VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
    @Column(name = "description")
    private String description; // VARCHAR(2048) CHARACTER SET 'utf8' NULL DEFAULT NULL,
    @Column(name = "ownerid")
    private Integer ownerId; // INT(11) NULL DEFAULT NULL,
    @Column(name = "departmentid")
    private Integer departmentId; // INT(10) UNSIGNED NULL DEFAULT NULL,
    @Column(name = "insertdate")
    private Date insertDate; // DATETIME NULL DEFAULT NULL,
    @Column(name = "updatedate")
    private Date updateDate; // DATETIME NULL DEFAULT NULL,
    @Column(name = "billable", columnDefinition = "TINYINT", length = 1)
    private boolean billable; // TINYINT(1) NOT NULL DEFAULT '1',

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
     * @return the organizationId
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId the organizationId to set
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(boolean open) {
        this.open = open;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Project [id=" + id + ", organizationId=" + organizationId + ", startDate=" + startDate + ", endDate="
                + endDate + ", open=" + open + ", name=" + name + ", description=" + description + ", ownerId="
                + ownerId + ", departmentId=" + departmentId + ", insertDate=" + insertDate + ", updateDate="
                + updateDate + ", billable=" + billable + "]";
    }

}
