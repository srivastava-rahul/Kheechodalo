package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	@Override
	public PictureUpload savePic(PictureUpload pic) {
		return entityManager.merge(pic);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PictureUpload findPicByUserId(String userId) {
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
		Query query = entityManager.createQuery("select max(pu.picVote) from PictureUpload pu");
		return ((Number) query.getSingleResult()).longValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PictureUploadPojo> findAllPics() {
		Query query = entityManager.createQuery(
				"Select new com.click.pojo.PictureUploadPojo(pu.id, pu.description, pu.picVote, u.firstName, pd.fileData) from PictureUpload pu left outer join pu.picUploadData pd left outer join pu.user u order by pu.picVote DESC");
		List<PictureUploadPojo> dataList = query.getResultList();
		return dataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PicUploadData> getPic() {
		Query query = entityManager.createQuery("from PicUploadData");
		return (List<PicUploadData>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PictureUpload> getPicDetails() {
		Query query = entityManager.createQuery("from PictureUpload");
		return (List<PictureUpload>) query.getResultList();
	}
}