/**
 * 
 */
package com.click.daoImpl;

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
	 * Get the list of all pic data 
	 * @param pic
	 * @return Pics
	 */
	List<PicUploadData> getPic();
	
	
	/**
	 * Get the list of all pic data 
	 * @param pic
	 * @return Pics
	 */
	List<PictureUpload> getPicDetails();


}
