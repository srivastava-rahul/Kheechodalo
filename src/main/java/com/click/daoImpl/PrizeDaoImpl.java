package com.click.daoImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.click.dao.PrizeDao;
import com.click.entity.UserPrize;
import com.click.utils.CollectionUtil;

/**
 * @author rahul
 */
@Repository
public class PrizeDaoImpl implements PrizeDao {

	private static final Logger LOG = Logger.getLogger(PrizeDaoImpl.class);

	@PersistenceContext(unitName = "entityManagerFactory")
	EntityManager entityManager;

	/**
	 * Get The list of All Prize by User
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserPrize> getAllPrizeRecord() {
		LOG.info(" Inside getAllPrizeRecord() DaoImpl GetAllPrizeRecord ");
		Query query = null;
		try {
			query = entityManager.createQuery("from UserPrize");
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return (List<UserPrize>) query.getResultList();
	}

	/**
	 * Saving The prize by Admin
	 * 
	 * @param prizedata
	 */
	@Override
	public void savePrizeRecord(UserPrize prizedata) {
		LOG.info(" Inside savePrizeRecord() DaoImpl GetAllPrizeRecord ");
		try {
			entityManager.merge(prizedata);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}

	}

	/**
	 * Delete The prize by Admin
	 * 
	 * @param prizedata
	 */
	@Override
	public void deletePrizeRecord(UserPrize prizedata) {
		LOG.info(" Inside deletePrizeRecord() DaoImpl GetAllPrizeRecord ");
		try {
			Query query = entityManager.createQuery("DELETE FROM UserPrize pz where pz.id = :id").setParameter("id",
					prizedata.getId());
			int deleteprizedata = query.executeUpdate();
			LOG.info("deleteFeedBack :" + deleteprizedata);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public String getPrizeAmountDesc() {
		LOG.info(" Inside getPrizeAmountDesc() DaoImpl Get Prize Amount");
		String prize = "Rs 50";
		try {
			Calendar date = Calendar.getInstance();
			date.setTime(new Date());
			date.set(Calendar.AM_PM, Calendar.AM);
			date.set(Calendar.HOUR, 0);
			date.set(Calendar.MINUTE, 0);
			date.set(Calendar.SECOND, 0);
			date.set(Calendar.MILLISECOND, 0);
			Date todayMoringDate = date.getTime();

			Calendar todayNight = Calendar.getInstance();
			todayNight.setTime(new Date());
			todayNight.set(Calendar.AM_PM, Calendar.PM);
			todayNight.set(Calendar.HOUR, 11);
			todayNight.set(Calendar.MINUTE, 59);
			todayNight.set(Calendar.SECOND, 59);
			todayNight.set(Calendar.MILLISECOND, 59);
			Date todayNightDate = todayNight.getTime();

			LOG.info("todayMoringDate : " + todayMoringDate + "todayNightDate : " + todayNightDate);

			Query query = entityManager.createQuery("select up.prizeAmount from UserPrize up where up.prizeDate between :todayMoringDate and :todayNightDate order by prizeDate desc");
			query.setParameter("todayMoringDate", todayMoringDate);
			query.setParameter("todayNightDate", todayNightDate);
			List<String> prizeList = query.getResultList();
			if (CollectionUtil.isNotEmpty(prizeList)) {
				prize = prizeList.get(0);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return prize;
	}

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		// date.add(Calendar.DATE, -2);
		date.set(Calendar.AM_PM, Calendar.AM);
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		Date todayMoringDate = date.getTime();

		Calendar todayNight = Calendar.getInstance();
		todayNight.setTime(new Date());
		// date.add(Calendar.DATE, -1);
		todayNight.set(Calendar.AM_PM, Calendar.PM);
		todayNight.set(Calendar.HOUR, 11);
		todayNight.set(Calendar.MINUTE, 59);
		todayNight.set(Calendar.SECOND, 59);
		todayNight.set(Calendar.MILLISECOND, 59);
		Date todayNightDate = todayNight.getTime();

		LOG.info("todayMoringDate : " + todayMoringDate + "todayNightDate : " + todayNightDate);

	}
}
