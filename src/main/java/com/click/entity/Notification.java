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
 * @author rahul
 */
@Entity
@Table(name = "KD_NOTIFICATION")
public class Notification implements Serializable {

	private static final long serialVersionUID = 8865900934641440411L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "USER_CREATED_DATE", nullable = true, length = 20)
	private Date createdDate;
	
	@Column(name = "EMAIL_ID", length = 500)
	private String email_id;

	@Column(name = "NOTIFICATION_DESCRIPTION", length = 500)
	private String notification_desc;

	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER"))
	private User user;
*/
	
	public Notification(){}
	public Notification(String id, String email_id, String notification_desc) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.notification_desc = notification_desc;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getNotification_desc() {
		return notification_desc;
	}

	public void setNotification_desc(String notification_desc) {
		this.notification_desc = notification_desc;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String toLogString() {
		return "Notification [id=" + id + ", email_id=" + email_id + ", notification_desc=" + notification_desc + "]";
	}
	

	

	
}
