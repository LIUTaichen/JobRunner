package com.dw.jobrunner.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Project_Cost_Archive")
public class ProjectCostArchive {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "cost_code_fk")
    private Integer costCodeFk;

    @Column(name = "plant_fk")
    private Integer plantFk;

    @Column(name = "unit_cost")
    private Double unitCost;

    @Column(name = "units")
    private Integer units;


    @Column(name = "active")
    private Boolean active;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;

    @Column(name = "reporting_week")
    private Date reportingWeek;

    @Column(name = "units_used")
    private Double unitsUsed;

    @Column(name = "project_id")
    private Integer projectId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getCostCodeFk() {
        return costCodeFk;
    }

    public void setCostCodeFk(Integer costCodeFk) {
        this.costCodeFk = costCodeFk;
    }

    public Integer getPlantFk() {
        return plantFk;
    }

    public void setPlantFk(Integer plantFk) {
        this.plantFk = plantFk;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getReportingWeek() {
        return reportingWeek;
    }

    public void setReportingWeek(Date reportingWeek) {
        this.reportingWeek = reportingWeek;
    }

    public Double getUnitsUsed() {
        return unitsUsed;
    }

    public void setUnitsUsed(Double unitsUsed) {
        this.unitsUsed = unitsUsed;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    @Override
    public String toString() {
        return "ProjectCostArchive{" +
                "id=" + id +
                ", reportDate=" + reportDate +
                ", costCodeFk=" + costCodeFk +
                ", plantFk=" + plantFk +
                ", unitCost=" + unitCost +
                ", units=" + units +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", reportingWeek=" + reportingWeek +
                ", unitsUsed=" + unitsUsed +
                ", projectId=" + projectId +
                '}';
    }
}

