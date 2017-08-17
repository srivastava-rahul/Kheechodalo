package com.click.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Column(name = "NAME", length = 500)
	private String name;


	@Column(name = "Testimonial_DESCRIPTION", length = 500)
	private String testimonial_desc;
	
	
	@Lob
	@Column(name = "FILE_DATA")
	private byte[] fileData;
	
	@Transient
	private String base64Encoded;

	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER"))
	private User user;*/
	
	
	
	public UserTestimonial(){}
	public UserTestimonial(String id, String email_id, String name, String testimonial_desc, byte[] fileData) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.name = name;
		this.testimonial_desc = testimonial_desc;
		this.fileData = fileData;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toLogString() {
		return "UserTestimonial [id=" + id + ", email_id=" + email_id + ", testimonial_desc=" + testimonial_desc
				+ ", fileData=" + Arrays.toString(fileData) + "]";
	}
	
	public String getBase64Encoded() {
		return base64Encoded;
	}

	public void setBase64Encoded(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}

	
	

	

	
}
