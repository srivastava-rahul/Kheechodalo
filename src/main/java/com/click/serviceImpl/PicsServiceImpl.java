/**
 * 
 */
package com.click.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.daoImpl.PicsDao;
import com.click.entity.PictureUpload;

/**
 * @author parveen
 *
 */
@Component
@Transactional(readOnly = true)
public class PicsServiceImpl implements PicsService {

	@Autowired
	PicsDao picsDao;

	@Override
	@Transactional(readOnly = false)
	public PictureUpload savePic(PictureUpload pic) {
		System.out.println("save pics service");
		return picsDao.savePic(pic);
	}
}
