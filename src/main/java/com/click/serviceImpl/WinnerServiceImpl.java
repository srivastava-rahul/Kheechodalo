/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.WinnerDao;
import com.click.entity.PictureUpload;
import com.click.entity.Winner;
import com.click.service.PicsService;
import com.click.service.WinnerService;
import com.click.utils.CollectionUtil;

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
	public List<Winner> getAllWinner(int pageNo) {
		LOG.info("Inside getWinner() serviceImpl");
		List<Winner> listofwinner = winnerDao.getWinner(pageNo);
		if (CollectionUtil.isNotEmpty(listofwinner)) {
			for (Winner winner : listofwinner) {
				try {
					if (winner.getFileData() != null) {
						byte[] encodeBase64 = Base64.encodeBase64(winner.getFileData());
						winner.setBase64Encoded(new String(encodeBase64, "UTF-8"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listofwinner;
	}

	
	@Override
	public List<Winner> getAllWinnerbyadmin() {
		LOG.info("Inside getAllWinnerbyadmin() serviceImpl");
		List<Winner> listofwinner = winnerDao.getAllWinnerbyadmin();
		if (CollectionUtil.isNotEmpty(listofwinner)) {
			for (Winner winner : listofwinner) {
				try {
					if (winner.getFileData() != null) {
						byte[] encodeBase64 = Base64.encodeBase64(winner.getFileData());
						winner.setBase64Encoded(new String(encodeBase64, "UTF-8"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
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
			Winner winner = new Winner(winnerPic);
			winnerDao.saveWinner(winner);
		}
	}

	@Override
	public Winner getLastWinner() {
		Winner winner = winnerDao.getLastWinner();
		if (winner != null) {
			LOG.info("winner name :" + winner.getWinner_name());
			try {
				if (winner.getFileData() != null) {
					byte[] encodeBase64 = Base64.encodeBase64(winner.getFileData());
					winner.setBase64Encoded(new String(encodeBase64, "UTF-8"));
				}
			} catch (Exception e) {
				LOG.error("Error while convert base64 :" + e.getMessage(), e);
			}
		}
		return winner;
	}
}
