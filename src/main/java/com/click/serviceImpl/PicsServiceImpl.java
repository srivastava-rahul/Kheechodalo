/**
 * 
 */
package com.click.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.PicsDao;
import com.click.entity.PictureUpload;
import com.click.pojo.PictureUploadPojo;
import com.click.service.PicsService;
import com.click.utils.CollectionUtil;
import com.click.utils.SecurityLibrary;

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
		List<PictureUpload> list = picsDao.findAllPics(pageNo);
		List<PictureUploadPojo> pojoList = new ArrayList<>();
		if (CollectionUtil.isNotEmpty(list)) {
			for (PictureUpload pictureUpload : list) {
				PictureUploadPojo pu = new PictureUploadPojo(pictureUpload);
				// LOG.info("friend Email list :" +
				// pictureUpload.getFriendEmail().toString() + "
				// SecurityLibrary.getLoggedInUserLoginEmailId() :" +
				// SecurityLibrary.getLoggedInUserLoginEmailId());
				if (pictureUpload.getFriendEmail()
						.contains(SecurityLibrary.getLoggedInUserLoginEmailId().toUpperCase())) {
					pu.setAllowToVote(false);
				}
				pojoList.add(pu);
			}
		}

		return pojoList;
	}

	@Override
	public PictureUploadPojo findPicsbyemail(String email_id) {
		LOG.info("Inside findPicsbyemail_id() serviceImpl");
		PictureUpload singledata = picsDao.findPicsbyemail(email_id);
		PictureUploadPojo pj = null;
		if (singledata != null) {
			pj = new PictureUploadPojo(singledata);
		} else {

		}
		return pj;
	}

	/**
	 * Get the information based on picid
	 * @return  pic information
	 */
	@Override
	public PictureUpload getSinglepicInfo(String picid) {
		LOG.info("Inside getSinglepicInfo() serviceImpl");
		PictureUpload fullpicsinfo = picsDao.getSinglepicInfo(picid);
		if (fullpicsinfo != null && CollectionUtil.isNotEmpty(fullpicsinfo.getFriendEmail())) {
			for (String email : fullpicsinfo.getFriendEmail()) {
				LOG.info("info email :" + email);
			}
		}
		return fullpicsinfo;
	}

	@Override
	public List<PictureUpload> getPicDetails() {
		LOG.info("Inside getPicDetails() serviceImpl");
		List<PictureUpload> listofpicsdetails = picsDao.getPicDetails();
		return listofpicsdetails;
	}

	@Override
	@Transactional(readOnly = false)
	public long updateVoteCount(String picId, String userEmailId) {
		return picsDao.updateVoteCount(picId, userEmailId);
	}

	/**
	 * getting all the pic information for admin
	 * @param
	 * @param loggedInUserLoginEmailId
	 * @return
	 */
	@Override
	public List<PictureUploadPojo> findAllPicsbyAdmin() {
		LOG.info("Inside findAllPicsbyAdmin() serviceImpl");
		List<PictureUpload> list = picsDao.findAllPicsbyAdmin();
		List<PictureUploadPojo> pojoList = new ArrayList<>();
		if (CollectionUtil.isNotEmpty(list)) {
			for (PictureUpload pictureUpload : list) {
				PictureUploadPojo pu = new PictureUploadPojo(pictureUpload);
				// LOG.info("friend Email list :" +
				// pictureUpload.getFriendEmail().toString() + "
				// SecurityLibrary.getLoggedInUserLoginEmailId() :" +
				// SecurityLibrary.getLoggedInUserLoginEmailId());
				if (pictureUpload.getFriendEmail()
						.contains(SecurityLibrary.getLoggedInUserLoginEmailId().toUpperCase())) {
					pu.setAllowToVote(false);
				}
				pojoList.add(pu);
			}
		}

		return pojoList;
	}

	/**
	 * Delete All the data from pics table
	 */
	@Override
	@Transactional(readOnly = false)
	public void deleteAllPics() {
		picsDao.deleteAllPics();
	}

	@Override
	public PictureUpload findWinnerPicByMaxVoteCount() {
		return picsDao.findWinnerPicBymaxVoteCount();
	}

	/*
	 * find the vote on a pic based on email id
	 * @param emailId
	 * @return count of vote
	 */
	public long findVoteCountForAdminOfSpecificEmail(String emailId) {
		long voteCount = picsDao.findVoteCountForAdminOfSpecificEmail(emailId);
		return voteCount;

	}

	/**
	 * increment the vote count on a pic
	 * @param voteConut
	 * @param emailId
	 * @return increased vote count
	 */
	@Override
	public long incrementVoteCountForEmail(long vote, String emailId) {
		long voteCount = picsDao.incrementVoteCountForEmail(vote, emailId);
		return voteCount;
	}

	@Override
	@Transactional(readOnly = false)
	public long updateVoteCountbyadmin(PictureUpload updatevote) {
		return picsDao.updateVoteCountbyadmin(updatevote);

	}

	/**
	 * Delete the pic based on pic id
	 * @param picId
	 */
	@Override
	public void adminDeletePicByPicId(String picId) {
		picsDao.adminDeletePicByPicId(picId);
		
	}

}