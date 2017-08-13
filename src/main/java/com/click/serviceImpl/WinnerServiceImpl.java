/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.WinnerDao;
import com.click.entity.PictureUpload;
import com.click.entity.Winner;
import com.click.service.PicsService;
import com.click.service.WinnerService;

/**
 * @author rahul
 */

@Component
@Transactional(readOnly = true)
public class WinnerServiceImpl implements WinnerService {

	private static final Logger LOG = Logger.getLogger(WinnerServiceImpl.class);

	@Autowired
	WinnerDao winnerDao;

	@Autowired
	PicsService picsService;

	@Override
	public List<Winner> getWinner() {
		LOG.info("Inside getWinner() serviceImpl");
		List<Winner> listofwinner = null;
		try {
			listofwinner = winnerDao.getWinner();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return listofwinner;
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteWinner(Winner winnerdata) {
		LOG.info("Inside deleteWinner() serviceImpl");
		try {
			winnerDao.deleteWinner(winnerdata);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}

	}

	@Override
	@Transactional(readOnly = false)
	public void copyWinnerPic() {
		LOG.info("Copy winner pic service");
		PictureUpload winnerPic = picsService.findWinnerPicByMaxVoteCount();
		if (winnerPic != null) {
			Winner winner = new Winner(winnerPic.getEmailId(), winnerPic.getDescription(), winnerPic.getPicUploadData().getFileData(), winnerPic.getUploadDate(), "100 RS", winnerPic.getPicVote());
			winnerDao.saveWinner(winner);
		}
	}
}
