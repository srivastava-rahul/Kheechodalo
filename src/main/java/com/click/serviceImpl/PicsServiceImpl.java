/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.daoImpl.PicsDao;
import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.service.PicsService;

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

	@Override
	public List<PicUploadData> getPic() {
		List<PicUploadData> listofpics=picsDao.getPic();
		return listofpics;
	}

	@Override
	public List<PictureUpload> getPicDetails() {
		List<PictureUpload> listofpicsdetails=picsDao.getPicDetails();
		return listofpicsdetails;
	}
}
