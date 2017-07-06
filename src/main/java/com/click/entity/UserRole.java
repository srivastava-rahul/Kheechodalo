package com.click.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author parveen
 *
 */
@Entity
@Table(name = "KD_USER_ROLE")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 7035048350391915603L;

	@Id
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	@Column(name = "ROLE_ID", length = 64)
	private String id;

	@Column(name = "ROLE_NAME", nullable = false, length = 160)
	private String roleName;

	@Column(name = "ROLE_DESCRIPTION", length = 400)
	private String roleDescription;

	@Column(name = "ROLE_CREATED_DATE", nullable = true)
	private Date createdDate;

	@Column(name = "ROLE_MODIFIED_DATE", nullable = true)
	private Date modifiedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
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

	public String toLogString() {
		return "UserRole [id=" + id + ", roleName=" + roleName + ", roleDescription=" + roleDescription
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
