package com.click.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author parveen
 */
public class PictureUploadPojo implements Serializable {

	private static final long serialVersionUID = -1443331105430165564L;

	private String id;

	private String picDescription;

	private long picVote;

	private String userName;

	private byte picData[];

	private boolean allowToVote;

	List<String> friendEmail;

	public PictureUploadPojo() {

	}

	/*public PictureUploadPojo(String id, String picDescription, long picVote, String userName, byte picData[],List<String> friendEmail) {
		this.id = id;
		this.picDescription = picDescription;
		this.picVote = picVote;
		this.userName = userName;
		this.picData = picData;
		this.friendEmail = friendEmail;
	}*/
	
	public PictureUploadPojo(String id, String picDescription, long picVote, String userName, byte picData[]) {
		this.id = id;
		this.picDescription = picDescription;
		this.picVote = picVote;
		this.userName = userName;
		this.picData = picData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPicDescription() {
		return picDescription;
	}

	public void setPicDescription(String picDescription) {
		this.picDescription = picDescription;
	}

	public long getPicVote() {
		return picVote;
	}

	public void setPicVote(long picVote) {
		this.picVote = picVote;
	}

	public byte[] getPicData() {
		return picData;
	}

	public void setPicData(byte[] picData) {
		this.picData = picData;
	}

	public boolean isAllowToVote() {
		return allowToVote;
	}

	public void setAllowToVote(boolean allowToVote) {
		this.allowToVote = allowToVote;
	}

	public List<String> getFriendEmail() {
		return friendEmail;
	}

	public void setFriendEmail(List<String> friendEmail) {
		this.friendEmail = friendEmail;
	}

}
