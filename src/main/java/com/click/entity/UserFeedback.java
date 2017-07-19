package com.click.entity;

import java.io.Serializable;

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
@Table(name = "KD_USER_FEEDBACK")
public class UserFeedback implements Serializable {

	private static final long serialVersionUID = -277283631508944707L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;	

	@Column(name = "FEED_DESCRIPTION", length = 500)
	private String feedDesc;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK1_USER_USER_FEED"))
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFeedDesc() {
		return feedDesc;
	}

	public void setFeedDesc(String feedDesc) {
		this.feedDesc = feedDesc;
	}

	public String toLogString() {
		return "UserFeedback [id=" + id + ", feedDesc=" + feedDesc + ", user=" + user + "]";
	}

	

}
