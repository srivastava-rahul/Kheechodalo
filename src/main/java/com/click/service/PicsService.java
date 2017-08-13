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
	 *            
	 * @return
	 */
	List<PictureUploadPojo> findAllPics(int pageNo);
	
	
	/**
	 * 
	 * @param get pic based on emailid
	 *            
	 * @return
	 */
	PictureUploadPojo findPicsbyemail(String email_id);

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
	 * @param loggedInUserLoginEmailId
	 * @return
	 */
	long updateVoteCount(String picId, String loggedInUserLoginEmailId);

	/**
	 * getting all the pic information for admin
	 * 
	 * @param
	 * @param loggedInUserLoginEmailId
	 * @return
	 */
	List<PictureUploadPojo> findAllPicsbyAdmin();

	/**
	 * 
	 */
	void deleteAllPics();

	/**
	 * 
	 * @return
	 */
	PictureUpload findWinnerPicByMaxVoteCount();

}