package com.click.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author vipul
 */
@Entity
@Table(name = "KD_QUICK_HELP")
public class QuickHelp implements Serializable {

	private static final long serialVersionUID = 8865900934641440411L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "QUICK_PROBLEM", length = 500)
	private String quickProblem;

	@Column(name = "QUICK_DESCRIPTION", length = 500)
	private String quickDesc;

	@Column(name = "CTREATED_DATE", length = 500)
	private Date createdDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER"))
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuickDesc() {
		return quickDesc;
	}

	public void setQuickDesc(String quickDesc) {
		this.quickDesc = quickDesc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQuickProblem() {
		return quickProblem;
	}

	public void setQuickProblem(String quickProblem) {
		this.quickProblem = quickProblem;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String toLogString() {
		return "QuickHelp [id=" + id + ", quickDesc=" + quickDesc + "]";
	}

}
