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
 *
 */
@Entity
@Table(name = "KD_ADMIN")
public class Admin implements Serializable {

	private static final long serialVersionUID = -6598843564851420989L;

	@Id
	@Column(name = "ADMIN_ID", length = 64)
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "ADMIN_NAME", length = 100)
	private String name;

	@Column(name = "ADMIN_EMAIL", length = 100)
	private String emailId;

	@Column(name = "ADMIN_PASSWORD", length = 100)
	private String password;

	@Column(name = "ADMIN_CREATED_DATE", nullable = true, length = 20)
	private Date createdDate;

	@Column(name = "ADMIN_MODIFIED_DATE", nullable = true, length = 20)
	private Date modifiedDate;

	@Column(name = "ACCOUNT_DELETED")
	private boolean deleted;

	@Column(name = "ADMIN_STATUS")
	private boolean status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ROLE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_ADMIN_USER_ROLE"))
	private UserRole userRole;

	public Admin() {
		this.status = false;
		this.deleted = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String toLogString() {
		return "Admin [id=" + id + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", deleted=" + deleted
				+ ", status=" + status + ", userRole=" + userRole + "]";
	}

}
