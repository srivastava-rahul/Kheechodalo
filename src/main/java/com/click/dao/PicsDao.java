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
	 * @param pic
	 * @return Pics
	 */
	PictureUpload savePic(PictureUpload pic);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	PictureUpload findPicByUserId(String userId);

	/**
	 * 
	 * @return
	 */
	long findPicMaxVoteCount();

	/**
	 * 
	 * @param pageNo
	 * @return
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
	 * Edit the vote on the basis of pic id by admin
	 * @param picId
	 * @param vote
	 * @return
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