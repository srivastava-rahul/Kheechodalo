package com.click.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author rahul
 */
@Entity
@Table(name = "KD_Testimonial")
public class UserTestimonial implements Serializable {

	private static final long serialVersionUID = 8865900934641440411L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "EMAIL_ID", length = 500)
	private String email_id;

	@Column(name = "Testimonial_DESCRIPTION", length = 500)
	private String testimonial_desc;
	
	
	@Lob
	@Column(name = "FILE_DATA")
	private byte[] fileData;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER"))
	private User user;
	
	
	
	public UserTestimonial(){}
	public UserTestimonial(String id, String email_id, String testimonial_desc, byte[] fileData, User user) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.testimonial_desc = testimonial_desc;
		this.fileData = fileData;
		this.user = user;
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

	public String getTestimonial_desc() {
		return testimonial_desc;
	}

	public void setTestimonial_desc(String testimonial_desc) {
		this.testimonial_desc = testimonial_desc;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String toLogString() {
		return "UserTestimonial [id=" + id + ", email_id=" + email_id + ", testimonial_desc=" + testimonial_desc
				+ ", fileData=" + Arrays.toString(fileData) + ", user=" + user + "]";
	}

	
	

	

	
}
