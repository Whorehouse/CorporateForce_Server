package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Projects generated by hbm2java
 */
@Entity
@Table(name = "projects", catalog = "corporateforce")
public class Projects implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Users usersByCreator;
	private Users usersByLead;
	private Date created;
	private Date updated;
	private String status;
	private String name;
	private String description;

	public Projects() {
	}

	public Projects(Date created, Date updated, String status, String name) {
		this.created = created;
		this.updated = updated;
		this.status = status;
		this.name = name;
	}

	public Projects(Users usersByCreator, Users usersByLead, Date created,
			Date updated, String status, String name, String description) {
		this.usersByCreator = usersByCreator;
		this.usersByLead = usersByLead;
		this.created = created;
		this.updated = updated;
		this.status = status;
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATOR")
	public Users getUsersByCreator() {
		return this.usersByCreator;
	}

	public void setUsersByCreator(Users usersByCreator) {
		this.usersByCreator = usersByCreator;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEAD")
	public Users getUsersByLead() {
		return this.usersByLead;
	}

	public void setUsersByLead(Users usersByLead) {
		this.usersByLead = usersByLead;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED", nullable = false, length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Column(name = "STATUS", nullable = false, length = 9)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
