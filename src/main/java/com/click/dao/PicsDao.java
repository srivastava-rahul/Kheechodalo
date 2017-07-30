/**
 * 
 */
package com.click.dao;

import java.util.List;

import com.click.entity.PicUploadData;
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
	 * @return
	 */
	List<PicUploadData> getPic();

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

}