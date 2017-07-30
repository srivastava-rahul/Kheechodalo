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
import com.click.entity.PicUploadData;
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
		Query query = entityManager
				.createQuery("from PictureUpload pu left outer join fetch pu.picUploadData where pu.user.id = :userId");
		query.setParameter("userId", userId);
		List<PictureUpload> dataList = query.getResultList();
		if (CollectionUtil.isNotEmpty(dataList)) {
			return dataList.get(0);
		}
		return null;
	}

	@Override
	public long findPicMaxVoteCount() {
		LOG.info("Inside findPicMaxVoteCount() DaoImpl ");
		
		Query query = entityManager.createQuery("select max(pu.picVote) from PictureUpload pu");
		Object obj =(Number) query.getSingleResult(); 
		return obj != null ? ((Number)obj).longValue() : 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PictureUpload> findAllPics(int pageNo) {
		LOG.info("Inside findAllPics() DaoImpl ");
		Query query = entityManager.createQuery("Select distinct pu from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user left outer join pu.friendEmail u order by pu.picVote DESC");
		query.setFirstResult(pageNo == 1 ? 0 : (pageNo*8));
		query.setMaxResults(8);
		List<PictureUpload> dataList = query.getResultList();
		
		return dataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PicUploadData> getPic() {
		LOG.info("Inside getPic() DaoImpl ");
		Query query =null;
		try{
		 query = entityManager.createQuery("from PicUploadData");
		}catch(Exception e){
            LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (List<PicUploadData>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PictureUpload> getPicDetails() {
		LOG.info("Inside findAllPics() DaoImpl ");
		Query query=null;
		try{
		    query = entityManager.createQuery("from PictureUpload");
		}catch(Exception e){
            LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return (List<PictureUpload>) query.getResultList();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor =  Exception.class)
	public long updateVoteCount(String picId, String userEmailId) {
		LOG.info("Inside updateVoteCount() DaoImpl ");
		Query query= entityManager.createQuery("update PictureUpload pu set pu.picVote = (pu.picVote + 1) where id = :id");
		query.setParameter("id", picId);
		int voteUpdate = query.executeUpdate();
		LOG.info("vote update : "+ voteUpdate);
		query = entityManager.createNativeQuery("INSERT INTO KD_PIC_FRIEND_LIST(PIC_ID, FRIEND_EMAIL) VALUES(:picId, :friendEmail) ");
		query.setParameter("picId", picId);	
		query.setParameter("friendEmail", userEmailId.toUpperCase());	
		int friendListInsert = query.executeUpdate();
		LOG.info("friendList Insert : "+ friendListInsert);
		
		 query= entityManager.createQuery("select pu.picVote from PictureUpload pu where pu.id = :picId");
		 query.setParameter("picId", picId);
		 return ((Number) query.getSingleResult()).longValue();
	}
}