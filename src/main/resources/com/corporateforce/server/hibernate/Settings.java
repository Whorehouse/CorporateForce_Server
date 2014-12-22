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
import javax.persistence.UniqueConstraint;

/**
 * Settings generated by hbm2java
 */
@Entity
@Table(name = "settings", catalog = "corporateforce", uniqueConstraints = @UniqueConstraint(columnNames = "USER"))
public class Settings implements java.io.Serializable {

	private Integer id;
	private Languages languages;
	private Users users;

	public Settings() {
	}

	public Settings(Users users) {
		this.users = users;
	}

	public Settings(Languages languages, Users users) {
		this.languages = languages;
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
	@JoinColumn(name = "LANGUAGE")
	public Languages getLanguages() {
		return this.languages;
	}

	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER", unique = true, nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
