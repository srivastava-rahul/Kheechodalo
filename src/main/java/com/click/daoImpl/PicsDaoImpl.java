package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.PicsDao;
import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;
import com.click.pojo.PictureUploadPojo;
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
	public List<PictureUploadPojo> findAllPics(int pageNo) {
		LOG.info("Inside findAllPics() DaoImpl ");
		Query query = entityManager.createQuery("Select new com.click.pojo.PictureUploadPojo(pu.id, pu.description, pu.picVote, u.firstName, pd.fileData) from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user u order by pu.picVote DESC");
		query.setFirstResult(pageNo == 1 ? 0 : (pageNo*8));
		query.setMaxResults(8);
		List<PictureUploadPojo> dataList = query.getResultList();
		
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
}