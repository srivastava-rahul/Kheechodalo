package com.click.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.entity.PicUploadData;
import com.click.entity.PictureUpload;

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

	@Override
	public List<PicUploadData> getPic() {
		Query query = entityManager.createQuery("from PicUploadData");
		return (List<PicUploadData>) query.getResultList();
	}

	@Override
	public List<PictureUpload> getPicDetails() {
		Query query = entityManager.createQuery("from PictureUpload");
		return (List<PictureUpload>) query.getResultList();
	}
}
