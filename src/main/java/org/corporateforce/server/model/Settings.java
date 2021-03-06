package org.corporateforce.server.model;

// Generated 25.12.2014 2:00:33 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

/**
 * Settings generated by hbm2java
 */
@Entity
@Table(name = "settings", catalog = "corporateforce", uniqueConstraints = @UniqueConstraint(columnNames = "PNAME"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
@Proxy(lazy = false)
public class Settings implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pname;
	private String pvalue;

	public Settings() {
	}

	public Settings(String pname, String pvalue) {
		this.pname = pname;
		this.pvalue = pvalue;
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

	@Column(name = "PNAME", unique = true, nullable = false, length = 255)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name = "PVALUE", length = 255)
	public String getPvalue() {
		return this.pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
	
}
