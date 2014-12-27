package org.corporateforce.server.model;

// Generated 25.12.2014 2:00:33 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * Worklogs generated by hbm2java
 */
@Entity
@Table(name = "worklogs", catalog = "corporateforce")
public class Worklogs implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Tickets tickets;
	private Users users;
	private Date created;
	private Date updated;
	private BigDecimal time;
	private String log;

	public Worklogs() {
	}

	public Worklogs(Tickets tickets, Date created, Date updated,
			BigDecimal time, String log) {
		this.tickets = tickets;
		this.created = created;
		this.updated = updated;
		this.time = time;
		this.log = log;
	}

	public Worklogs(Tickets tickets, Users users, Date created, Date updated,
			BigDecimal time, String log) {
		this.tickets = tickets;
		this.users = users;
		this.created = created;
		this.updated = updated;
		this.time = time;
		this.log = log;
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
	@JoinColumn(name = "TICKET", nullable = false)
	public Tickets getTickets() {
		return this.tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
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

	@Column(name = "TIME", nullable = false, precision = 3, scale = 1)
	public BigDecimal getTime() {
		return this.time;
	}

	public void setTime(BigDecimal time) {
		this.time = time;
	}

	@Column(name = "LOG", nullable = false, length = 65535)
	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

}
