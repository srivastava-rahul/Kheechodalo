package com.click.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
 * @author parveen
 * @author vipul
 */
@Entity
@Table(name = "KD_PICS_UPLOAD")
public class PictureUpload implements Serializable {

	private static final long serialVersionUID = -1443331105430165564L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "PIC_NAME", length = 100)
	private String picName;

	@Column(name = "PIC_DESCRIPTION", length = 300)
	private String description;

	@Column(name = "PIC_UPLOAD_SIZE", length = 10)
	private Integer picSize;

	@Column(name = "PIC_CONTENT_TYPE", length = 160)
	private String contentType;

	@Column(name = "PIC_UPLOAD_DATE")
	private Date uploadDate;

	@Column(name = "PIC_UPLOAD_EMAIL")
	private String emailId;

	@Column(name = "PIC_TIMESTAMP")
	private long timestamp;

	@Column(name = "PIC_UPLOAD_STATUS")
	private boolean uploadStatus;
	
	@Column(name = "PIC_VOTE")
	private long picVote;

	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade=CascadeType.ALL)
	@JoinColumn(name = "PIC_DATA_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PIC_DATA_ID"))
	private PicUploadData picUploadData;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PIC_USER_ID"))
	private User user;
	
	@CollectionTable(name="KD_PIC_FRIEND_LIST", joinColumns=@JoinColumn(name="PIC_ID"))
	@Column(name = "FRIEND_EMAIL")
	@ElementCollection(fetch = FetchType.LAZY, targetClass = java.lang.String.class)
	private List<String> friendEmail;

	public PictureUpload() {
		this.uploadStatus = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPicSize() {
		return picSize;
	}

	public void setPicSize(Integer picSize) {
		this.picSize = picSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(boolean uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public PicUploadData getPicUploadData() {
		return picUploadData;
	}

	public void setPicUploadData(PicUploadData picUploadData) {
		this.picUploadData = picUploadData;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public long getPicVote() {
		return picVote;
	}

	public void setPicVote(long picVote) {
		this.picVote = picVote;
	}

	public List<String> getFriendEmail() {
		return friendEmail;
	}

	public void setFriendEmail(List<String> friendEmail) {
		this.friendEmail = friendEmail;
	}

	@Override
	public String toString() {
		return "PictureUpload [id=" + id + ", picName=" + picName + ", description=" + description + ", picSize="
				+ picSize + ", contentType=" + contentType + ", uploadStatus=" + uploadStatus + ", uploadDate="
				+ uploadDate + ", emailId=" + emailId + ", timestamp=" + timestamp + "]";
	}

}
