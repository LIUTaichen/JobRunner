package com.dw.jobrunner.model;


import javax.persistence.Column;
import java.io.Serializable;

public class CostCodeSummaryId implements Serializable {

    private Integer costCodePk;


    private Integer projectPk;


    private Integer plantPk;

    public Integer getCostCodePk() {
        return costCodePk;
    }

    public void setCostCodePk(Integer costCodePk) {
        this.costCodePk = costCodePk;
    }

    public Integer getProjectPk() {
        return projectPk;
    }

    public void setProjectPk(Integer projectPk) {
        this.projectPk = projectPk;
    }

    public Integer getPlantPk() {
        return plantPk;
    }

    public void setPlantPk(Integer plantPk) {
        this.plantPk = plantPk;
    }
}
