package org.corporateforce.server.model;

// Generated 25.12.2014 2:00:33 by Hibernate Tools 4.3.1

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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

/**
 * Contacts generated by hbm2java
 */
@Entity
@Table(name = "contacts", catalog = "corporateforce")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
@Proxy(lazy = false)
public class Contacts implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Avatars avatars;
	private Date created;
	private Date updated;
	private String firstname;
	private String lastname;
	private String nickname;
	private String gender;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private String website;
	private String about;

	public Contacts() {
	}

	public Contacts(Date created, Date updated, String firstname,
			String lastname, String gender, Date birthday) {
		this.created = created;
		this.updated = updated;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthday = birthday;
	}

	public Contacts(Avatars avatars, Date created,
			Date updated, String firstname, String lastname, String nickname,
			String gender, Date birthday, String address, String phone,
			String email, String website, String about) {
		this.avatars = avatars;
		this.created = created;
		this.updated = updated;
		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.website = website;
		this.about = about;
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
	@JoinColumn(name = "IMAGE")
	public Avatars getAvatars() {
		return this.avatars;
	}

	public void setAvatars(Avatars avatars) {
		this.avatars = avatars;
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

	@Column(name = "FIRSTNAME", nullable = false, length = 50)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "LASTNAME", nullable = false, length = 50)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "NICKNAME", length = 50)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "GENDER", nullable = false, length = 6)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = false, length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "PHONE", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "WEBSITE")
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "ABOUT", length = 65535)
	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
}
