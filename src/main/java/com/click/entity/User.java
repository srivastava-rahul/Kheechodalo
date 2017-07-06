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
 * 
 * @author parveen
 * @author vipul
 *
 */
@Entity
@Table(name = "KD_USER")
public class User implements Serializable {

	private static final long serialVersionUID = -6598843564851420989L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "USER_FIRST_NAME", length = 100)
	private String firstName;

	@Column(name = "USER_LAST_NAME", length = 100)
	private String lastName;

	@Column(name = "USER_EMAIL", length = 100)
	private String emailId;

	@Column(name = "USER_PASSWORD", length = 100)
	private String password;

	@Column(name = "USER_GENDER", length = 1)
	private String gender;

	@Column(name = "USER_PHONE", length = 18)
	private Integer phone;

	@Column(name = "USER_DOB")
	private Date dob;

	@Column(name = "USER_CREATED_DATE", nullable = true, length = 20)
	private Date createdDate;

	@Column(name = "USER_MODIFIED_DATE", nullable = true, length = 20)
	private Date modifiedDate;

	@Column(name = "ACCOUNT_DELETED")
	private boolean deleted;

	@Column(name = "USER_STATUS")
	private boolean status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ROLE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER_ROLE"))
	private UserRole userRole;

	public User() {
		this.status = false;
		this.deleted = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", gender=" + gender + ", phone=" + phone + ", dob=" + dob
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", deleted=" + deleted
				+ ", status=" + status + "]";
	}

}
