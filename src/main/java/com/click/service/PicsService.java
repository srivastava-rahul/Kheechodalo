/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.PictureUpload;
import com.click.pojo.PictureUploadPojo;

/**
 * @author parveen
 */
public interface PicsService {
	
	/**
	 * Save the pic
	 * @param pic
	 * @return Pics
	 */
	PictureUpload savePic(PictureUpload pic);

	/**
	 * find picBy user id
	 * @param userId
	 * @return
	 */
	PictureUpload findPicByUserId(String userId);

	/**
	 * Find max vote of pic
	 * @return
	 */
	long findPicMaxVoteCount();

	/**
	 * Get all the pics for user 
	 * @param pageNo
	 * @return list of pics 
	 */
	List<PictureUploadPojo> findAllPics(int pageNo);

	/**
	 * 
	 * @param get pic based on emailid
	 * @return pic information
	 */
	PictureUploadPojo findPicsbyemail(String email_id);

	/**
	 * Get the information based on picid
	 * @return  pic information
	 */
	PictureUpload getSinglepicInfo(String picid);

	/**
	 * Get the information of all the pics
	 * @return
	 */
	List<PictureUpload> getPicDetails();

	/**
	 * 
	 * @param picId
	 * @param loggedInUserLoginEmailId
	 * @return
	 */
	long updateVoteCount(String picId, String loggedInUserLoginEmailId);

	/**
	 * getting all the pic information for admin
	 * @param
	 * @param loggedInUserLoginEmailId
	 * @return
	 */
	List<PictureUploadPojo> findAllPicsbyAdmin();

	/**
	 * Delete All the data from pics table
	 */
	void deleteAllPics();

	/*
	 * find the vote on a pic based on email id
	 * @param emailId
	 * @return count of vote
	 */
	long findVoteCountForAdminOfSpecificEmail(String emailId);

	/**
	 * 
	 * @return
	 */

	PictureUpload findWinnerPicByMaxVoteCount();


	/**
	 * Edit the vote on the basis of picid by admin
	 * @param picId
	 * @param by admin 
	 * @return updated vote of pic
	 */
	long updateVoteCountbyadmin(PictureUpload updatevote);
	
	/**
	 * increment the vote count on a pic
	 * @param voteConut
	 * @param emailId
	 * @return increased vote count
	 */
	long incrementVoteCountForEmail(long voteConut, String emailId);

	/**
	 * Delete the pic based on pic id
	 * @param picId
	 */
	void adminDeletePicByPicId(String picId);

}