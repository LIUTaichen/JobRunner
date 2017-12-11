package com.dw.jobrunner.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the qCostCodeSummary database table.
 * 
 */
@Entity
@IdClass(CostCodeSummaryId.class)
@Table(name="qcostcodesummary")
@NamedQuery(name="CostCodeSummary.findAll", query="SELECT q FROM CostCodeSummary q")
public class CostCodeSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cost_code_pk")
	private Integer costCodePk;

	@Id
	@Column(name="project_pk")
	private Integer projectPk;

	@Column(name="Unit_Cost")
	private Double unitCost;

	@Column(name="Units")
	private Integer units;

	@Id
	@Column(name="plant_pk")
	private Integer plantPk;





	public CostCodeSummary() {
	}

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

	public Integer getPlantPk() {
		return plantPk;
	}

	public void setPlantPk(Integer plantPk) {
		this.plantPk = plantPk;
	}

	@Override
	public String toString() {
		return "CostCodeSummary{" +
				"costCodePk=" + costCodePk +
				", projectPk=" + projectPk +
				", unitCost=" + unitCost +
				", units=" + units +
				", plantPk=" + plantPk +
				'}';
	}
}