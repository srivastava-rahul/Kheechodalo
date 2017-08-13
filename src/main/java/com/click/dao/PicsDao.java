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
	 * @param get user pic based on email_id
	 * @return
	 */
	 PictureUpload  findPicsbyemail(String email_id);

	/**
	 * 
	 * @return
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
	 * 
	 * @param picId
	 * @param userEmailId
	 * @return
	 */
	List<PictureUpload> findAllPicsbyAdmin();

	/**
	 * 
	 */
	void deleteAllPics();

	/**
	 * 
	 * @return
	 */
	PictureUpload findWinnerPicBymaxVoteCount();

}