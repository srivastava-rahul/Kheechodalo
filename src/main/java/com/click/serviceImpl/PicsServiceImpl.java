/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.PicsDao;
import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.pojo.PictureUploadPojo;
import com.click.service.PicsService;

/**
 * @author parveen
 *
 */
@Component
@Transactional(readOnly = true)
public class PicsServiceImpl implements PicsService {

	private static final Logger LOG = Logger.getLogger(PicsServiceImpl.class);
	
	@Autowired
	PicsDao picsDao;

	@Override
	@Transactional(readOnly = false)
	public PictureUpload savePic(PictureUpload pic) {
		LOG.info("Inside savePic serviceImpl");
		return picsDao.savePic(pic);
	}

	@Override
	public PictureUpload findPicByUserId(String userId) {
		LOG.info("Inside findPicByUserId() serviceImpl");
		return picsDao.findPicByUserId(userId);
	}

	@Override
	public long findPicMaxVoteCount() {
		LOG.info("Inside findPicMaxVoteCount() serviceImpl");
		return picsDao.findPicMaxVoteCount();
	}

	@Override
	public List<PictureUploadPojo> findAllPics(int pageNo) {
		LOG.info("Inside findAllPics() serviceImpl");
		return picsDao.findAllPics(pageNo);
	}

	@Override
	public List<PicUploadData> getPic() {
		LOG.info("Inside getPic() serviceImpl");
		List<PicUploadData> listofpics = picsDao.getPic();
		return listofpics;
	}

	@Override
	public List<PictureUpload> getPicDetails() {
		LOG.info("Inside getPicDetails() serviceImpl");
		List<PictureUpload> listofpicsdetails = picsDao.getPicDetails();
		return listofpicsdetails;
	}
}