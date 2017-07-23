/**
 * 
 */
package com.click.dao;

import java.util.List;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.pojo.PictureUploadPojo;

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
	 * @param pageNo TODO
	 * @return
	 */
	List<PictureUploadPojo> findAllPics(int pageNo);

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

}