package com.tnt.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // NOT NULL AUTO_INCREMENT,
    @Column(name = "userid")
    private Integer userId; // INT(11) NOT NULL,
    @Column(name = "startdate")
    private Date startDate; // DATETIME NULL DEFAULT '0000-00-00 00:00:00',
    @Column(name = "duration")
    private Integer duration; // INT(11) NOT NULL COMMENT 'Duración en minutos',
    @Column(name = "description")
    private String description; // VARCHAR(2048) CHARACTER SET 'utf8' NULL DEFAULT NULL,
    @Column(name = "billable", columnDefinition = "TINYINT", length = 1)
    private String billable; // TINYINT(1) NOT NULL DEFAULT '1',
    @Column(name = "roleid")
    private Integer roleId; // INT(11) NULL DEFAULT NULL,
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
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }
    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
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
     * @return the billable
     */
    public String getBillable() {
        return billable;
    }
    /**
     * @param billable the billable to set
     */
    public void setBillable(String billable) {
        this.billable = billable;
    }
    /**
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }
    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        return "Activity [id=" + id + ", userId=" + userId + ", startDate=" + startDate + ", duration=" + duration
                + ", description=" + description + ", billable=" + billable + ", roleId=" + roleId + ", departmentId="
                + departmentId + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
    }
    
    
}
