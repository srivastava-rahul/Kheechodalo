package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.PicsDao;
import com.click.entity.PictureUpload;
import com.click.utils.CollectionUtil;

/**
 * @author parveen
 */
@Repository
public class PicsDaoImpl implements PicsDao {

	private static final Logger LOG = Logger.getLogger(PicsDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public PictureUpload savePic(PictureUpload pic) {
		LOG.info("Inside savePic() DaoImpl ");
		return entityManager.merge(pic);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PictureUpload findPicByUserId(String userId) {
		LOG.info("Inside findPicByUserId() DaoImpl ");
		Query query = entityManager.createQuery(
				"from PictureUpload pu left outer join fetch pu.picUploadData where (upper(pu.user.emailId) like :userId)");
		query.setParameter("userId", "%" + userId + "%");
		List<PictureUpload> dataList = query.getResultList();
		LOG.info("Result: " + dataList.size());
		if (CollectionUtil.isNotEmpty(dataList)) {
			return dataList.get(0);
		}
		return null;
	}

	@Override
	public long findPicMaxVoteCount() {
		LOG.info("Inside findPicMaxVoteCount() DaoImpl ");

		Query query = entityManager.createQuery("select max(pu.picVote) from PictureUpload pu");
		Object obj = (Number) query.getSingleResult();
		return obj != null ? ((Number) obj).longValue() : 0;
	}

	/**
	 * Get all the pics for user 
	 * @param pageNo
	 * @return list of pics 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PictureUpload> findAllPics(int pageNo) {
		LOG.info("Inside findAllPics() DaoImpl ");
		Query query = entityManager.createQuery(
				"Select distinct pu from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user left outer join pu.friendEmail u order by pu.picVote DESC, pu.uploadDate ASC ");
		query.setFirstResult(pageNo == 1 ? 0 : ((pageNo - 1) * 8));
		query.setMaxResults(8);
		List<PictureUpload> dataList = query.getResultList();

		return dataList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PictureUpload findPicsbyemail(String email_id) {
		LOG.info("Inside findPicsbyemail_id() DaoImpl ");
		PictureUpload singleuserpicdata = null;
		try {
			Query query = entityManager.createQuery(
					"Select distinct pu from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user left outer join pu.friendEmail u where upper(pu.emailId) = :emailId order by pu.picVote DESC, pu.uploadDate ASC ");
			query.setParameter("emailId", email_id.toUpperCase());
			singleuserpicdata = (PictureUpload) query.getSingleResult();

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return singleuserpicdata;
	}

	
	/**
	 * Get the information based on picid
	 * @return  pics information
	 */
	@Override
	public PictureUpload getSinglepicInfo(String picid) {
		LOG.info("Inside getSinglepicInfo() DaoImpl ");
		Query query = null;
		try {
			// query = entityManager.createQuery("from PictureUpload");
			query = entityManager
					.createQuery("from PictureUpload pi left outer join fetch pi.friendEmail where pi.id = :Id")
					.setParameter("Id", picid);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (PictureUpload) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PictureUpload> getPicDetails() {
		LOG.info("Inside findAllPics() DaoImpl ");
		Query query = null;
		try {
			query = entityManager.createQuery("from PictureUpload");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (List<PictureUpload>) query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public long updateVoteCount(String picId, String userEmailId) {
		LOG.info("Inside updateVoteCount() DaoImpl ");
		Query query = entityManager
				.createQuery("update PictureUpload pu set pu.picVote = (pu.picVote + 1) where id = :id");
		query.setParameter("id", picId);
		int voteUpdate = query.executeUpdate();
		LOG.info("vote update : " + voteUpdate);
		query = entityManager.createNativeQuery(
				"INSERT INTO KD_PIC_FRIEND_LIST(PIC_ID, FRIEND_EMAIL) VALUES(:picId, :friendEmail) ");
		query.setParameter("picId", picId);
		query.setParameter("friendEmail", userEmailId.toUpperCase());
		int friendListInsert = query.executeUpdate();
		LOG.info("friendList Insert : " + friendListInsert);

		query = entityManager.createQuery("select pu.picVote from PictureUpload pu where pu.id = :picId");
		query.setParameter("picId", picId);
		return ((Number) query.getSingleResult()).longValue();
	}

	/**
	 * Get all the pic information for Admin
	 * @param picId
	 * @param userEmailId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PictureUpload> findAllPicsbyAdmin() {
		LOG.info("Inside findAllPicsbyAdmin() DaoImpl ");
		Query query = entityManager.createQuery(
				"Select distinct pu from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user left outer join pu.friendEmail u order by pu.picVote DESC");
		// query.setFirstResult(pageNo == 1 ? 0 : (pageNo*8));
		// query.setMaxResults(8);
		List<PictureUpload> dataList = query.getResultList();
		return dataList;
	}

	/**
	 * Delete All the data from pics table
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void deleteAllPics() {
		Query query = entityManager.createNativeQuery("DELETE FROM KD_PIC_FRIEND_LIST");
		int deletedFriend = query.executeUpdate();
		LOG.info("Deleted friend Result :" + deletedFriend);

		query = entityManager.createNativeQuery("DELETE FROM KD_PICS_UPLOAD");
		int picUplaod = query.executeUpdate();
		LOG.info("Deleted picUplaod Result :" + picUplaod);

		query = entityManager.createNativeQuery("DELETE FROM KD_PIC_DATA");
		int deletedData = query.executeUpdate();
		LOG.info("Deleted data Result :" + deletedData);

	}

	@SuppressWarnings("unchecked")
	@Override
	public PictureUpload findWinnerPicBymaxVoteCount() {
		Query query = entityManager.createQuery(
				"Select distinct pu from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user left outer join pu.friendEmail u order by pu.picVote DESC, pu.uploadDate ASC ");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<PictureUpload> dataList = query.getResultList();
		if (CollectionUtil.isNotEmpty(dataList)) {
			return dataList.get(0);
		}
		return null;
	}

	/*
	 * find the vote on a pic based on email id
	 * @param emailId
	 * @return count of vote
	 */
	@Override
	public long findVoteCountForAdminOfSpecificEmail(String emailId) {
		LOG.info("Inside findVoteCountForAdminOfSpecificEmail() DaoImpl ");
		Query query = entityManager
				.createQuery("Select pu.picVote from PictureUpload pu where pu.emailId = :emailId");
		query.setParameter("emailId", emailId);
		Object obj = (Number) query.getSingleResult();
		return obj != null ? ((Number) obj).longValue() : 0;
	}

	/**
	 * increment the vote count on a pic
	 * @param voteConut
	 * @param emailId
	 * @return increased vote count
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public long incrementVoteCountForEmail(long vote,String emailId) {
		LOG.info("Inside updateVoteCount() DaoImpl "+vote +"  email : "+emailId);
		Query query = entityManager.createQuery("update PictureUpload pu set picVote = (picVote + 1) where (upper(emailId) like :emailId)");
//		 query.setParameter("vote", vote);
		 query.setParameter("emailId", "%" + emailId.toUpperCase()+"%" );
		 int voteNew = query.executeUpdate();
		 LOG.info(" voteNew :"+voteNew);
		 query = entityManager.createQuery("select pu.picVote from PictureUpload pu where (upper(emailId) like :emailId1)");
		 query.setParameter("emailId1", "%" + emailId.toUpperCase()+"%" );
		 return ((Number) query.getSingleResult()).longValue();

	}
	
	/**
	 * Edit the vote on the basis of picid by admin
	 * @param picId
	 * @param by admin 
	 * @return updated vote of pic
	 */
	@Override
	public long updateVoteCountbyadmin(PictureUpload updatevote) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Delete the pic based on pic id
	 * @param picId
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void adminDeletePicByPicId(String picId) {
		Query query = entityManager.createNativeQuery("DELETE FROM KD_PIC_FRIEND_LIST where PIC_ID = :picId");
		 query.setParameter("picId", picId);
		int deletedFriend = query.executeUpdate();
		LOG.info("Deleted friend Result :" + deletedFriend);

		query = entityManager.createNativeQuery("DELETE FROM KD_PICS_UPLOAD where ID = :picId1");
		 query.setParameter("picId1", picId);
		int picUplaod = query.executeUpdate();
		LOG.info("Deleted picUplaod Result :" + picUplaod);

		query = entityManager.createNativeQuery("DELETE FROM KD_PIC_DATA where ID = :picId2");
		 query.setParameter("picId2", picId);
		int deletedData = query.executeUpdate();
		LOG.info("Deleted data Result :" + deletedData);
		
	}

	
}