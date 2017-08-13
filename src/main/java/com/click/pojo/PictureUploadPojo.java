package com.click.pojo;

import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.click.entity.PictureUpload;

/**
 * @author parveen
 */
public class PictureUploadPojo implements Serializable {

	private static final long serialVersionUID = -1443331105430165564L;

	public static final Logger LOG = Logger.getLogger(PictureUploadPojo.class);

	private String id;

	private String picDescription;

	private long picVote;

	private String userName;

	private String base64Encoded;

	private boolean allowToVote = true;

	private String userEmailId;
	
	public PictureUploadPojo() {

	}

	public PictureUploadPojo(String id, String picDescription, long picVote, String userName, byte picData[]) {
		this.id = id;
		this.picDescription = picDescription;
		this.picVote = picVote;
		this.userName = userName;
		// this.picData = picData;

		try {
			if (picData != null) {
				byte[] encodeBase64 = Base64.encodeBase64(picData);
				this.base64Encoded = new String(encodeBase64, "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PictureUploadPojo(PictureUpload pictureUpload) {
		this.id = pictureUpload.getId();
		this.picDescription = pictureUpload.getDescription();
		this.picVote = pictureUpload.getPicVote();
		this.userName = pictureUpload.getUser() != null ? pictureUpload.getUser().getFirstName() : null;
		this.userEmailId = pictureUpload.getUser() != null ? pictureUpload.getUser().getEmailId() : null;
		// this.picData = picData;

		try {
			if (pictureUpload.getPicUploadData() != null && pictureUpload.getPicUploadData().getFileData() != null) {
				byte[] encodeBase64 = Base64.encodeBase64(pictureUpload.getPicUploadData().getFileData());
				this.base64Encoded = new String(encodeBase64, "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public String getBase64Encoded() {
		return base64Encoded;
	}

	public void setBase64Encoded(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}

	public boolean isAllowToVote() {
		return allowToVote;
	}

	public void setAllowToVote(boolean allowToVote) {
		this.allowToVote = allowToVote;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

}
