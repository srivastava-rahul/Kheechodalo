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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author rahul
 */
@Entity
@Table(name = "KD_WINNER")
public class Winner implements Serializable {

	private static final long serialVersionUID = 8865900934641440411L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "EMAIL_ID", length = 500)
	private String email_id;

	@Column(name = "WINNER_DESCRIPTION", length = 500)
	private String winner_desc;
	
	@Lob
	@Column(name = "FILE_DATA")
	private byte[] fileData;
	
	@Column(name = "Winner_CREATED_DATE", nullable = true, length = 20)
	private Date createdDate;
	
	
	@Column(name = "Prize_DESCRIPTION", length = 500)
	private String prize_desc;
	
	@Column(name = "PIC_VOTE")
	private long picVote;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER"))
	private User user;

	
	public Winner(){}
	public Winner(String id, String email_id, String winner_desc, byte[] fileData, Date createdDate, String prize_desc,
			long picVote, User user) {
		super();
		this.id = id;
		this.email_id = email_id;
		this.winner_desc = winner_desc;
		this.fileData = fileData;
		this.createdDate = createdDate;
		this.prize_desc = prize_desc;
		this.picVote = picVote;
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
	public String getWinner_desc() {
		return winner_desc;
	}
	public void setWinner_desc(String winner_desc) {
		this.winner_desc = winner_desc;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getPrize_desc() {
		return prize_desc;
	}
	public void setPrize_desc(String prize_desc) {
		this.prize_desc = prize_desc;
	}
	public long getPicVote() {
		return picVote;
	}
	public void setPicVote(long picVote) {
		this.picVote = picVote;
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

		

	

	
}
