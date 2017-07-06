package com.click.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.click.entity.PictureUpload;
import com.click.entity.User;

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
}
