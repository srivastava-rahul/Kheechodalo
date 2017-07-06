/**
 * 
 */
package com.click.daoImpl;

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

}
