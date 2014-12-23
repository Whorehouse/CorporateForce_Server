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
 * Results generated by hbm2java
 */
@Entity
@Table(name = "results", catalog = "corporateforce")
public class Results implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Trainings trainings;
	private Users users;
	private Date created;
	private int duration;
	private short answered;
	private short wrong;

	public Results() {
	}

	public Results(Trainings trainings, Users users, Date created,
			int duration, short answered, short wrong) {
		this.trainings = trainings;
		this.users = users;
		this.created = created;
		this.duration = duration;
		this.answered = answered;
		this.wrong = wrong;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "DURATION", nullable = false)
	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Column(name = "ANSWERED", nullable = false)
	public short getAnswered() {
		return this.answered;
	}

	public void setAnswered(short answered) {
		this.answered = answered;
	}

	@Column(name = "WRONG", nullable = false)
	public short getWrong() {
		return this.wrong;
	}

	public void setWrong(short wrong) {
		this.wrong = wrong;
	}

}
