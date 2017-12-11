package com.dw.jobrunner.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * The persistent class for the ActionLog database table.
 * 
 */
@Entity
@NamedQuery(name="ActionLog.findAll", query="SELECT a FROM ActionLog a")
public class ActionLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	private String action;

	@Column(name="date_created")
	private Date dateCreated;

	private String entity;

	@Column(name="run_date")
	private Date runDate;

	public ActionLog() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	@Override
	public String toString() {
		return "ActionLog{" +
				"id=" + id +
				", action='" + action + '\'' +
				", dateCreated=" + dateCreated +
				", entity='" + entity + '\'' +
				", runDate=" + runDate +
				'}';
	}
}