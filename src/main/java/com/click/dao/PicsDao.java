/**
 * 
 */
package com.click.dao;

import java.util.List;

import com.click.entity.PictureUpload;

/**
 * @author parveen
 */
public interface PicsDao {
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
	 */	PictureUpload findPicByUserId(String userId);

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
	List<PictureUpload> findAllPics(int pageNo);

	/**
	 * 
	 * @param get
	 *            user pic based on email_id
	 * @return
	 */
	PictureUpload findPicsbyemail(String email_id);

	/**
	 * Get the information based on picid
	 * @return  pic information
	 */
	PictureUpload getSinglepicInfo(String picid);

	/**
	 * 
	 * @return
	 */
	List<PictureUpload> getPicDetails();

	/**
	 * 
	 * @param picId
	 * @param userEmailId
	 * @return
	 */
	long updateVoteCount(String picId, String userEmailId);

	/**
	 * Get all the pic information for Admin
	 * @param picId
	 * @param userEmailId
	 * @return
	 */
	List<PictureUpload> findAllPicsbyAdmin();

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

	PictureUpload findWinnerPicBymaxVoteCount();


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

	void adminDeletePicByPicId(String picId);

}