package com.corporateforce.server.hibernate;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Trainings generated by hbm2java
 */
@Entity
@Table(name = "trainings", catalog = "corporateforce")
public class Trainings implements java.io.Serializable {

	private Integer id;
	private Resources resources;
	private Users users;
	private Date created;
	private Date updated;
	private String name;
	private boolean tutorial;

	public Trainings() {
	}

	public Trainings(Date created, Date updated, String name, boolean tutorial) {
		this.created = created;
		this.updated = updated;
		this.name = name;
		this.tutorial = tutorial;
	}

	public Trainings(Resources resources, Users users, Date created,
			Date updated, String name, boolean tutorial) {
		this.resources = resources;
		this.users = users;
		this.created = created;
		this.updated = updated;
		this.name = name;
		this.tutorial = tutorial;
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
	@JoinColumn(name = "ATTACHMENT")
	public Resources getResources() {
		return this.resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATOR")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
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

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TUTORIAL", nullable = false)
	public boolean isTutorial() {
		return this.tutorial;
	}

	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
}
