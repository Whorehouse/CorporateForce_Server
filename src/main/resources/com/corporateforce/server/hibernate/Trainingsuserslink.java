package com.corporateforce.server.hibernate;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Trainingsuserslink generated by hbm2java
 */
@Entity
@Table(name = "trainingsuserslink", catalog = "corporateforce")
public class Trainingsuserslink implements java.io.Serializable {

	private Integer id;
	private Trainings trainings;
	private Users users;

	public Trainingsuserslink() {
	}

	public Trainingsuserslink(Trainings trainings, Users users) {
		this.trainings = trainings;
		this.users = users;
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
	@JoinColumn(name = "TRAINING", nullable = false)
	public Trainings getTrainings() {
		return this.trainings;
	}

	public void setTrainings(Trainings trainings) {
		this.trainings = trainings;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
