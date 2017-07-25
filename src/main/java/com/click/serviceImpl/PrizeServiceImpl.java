/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.PrizeDao;
import com.click.entity.UserPrize;
import com.click.service.PrizeService;

/**
 * @author rahul
 */

@Component
@Transactional(readOnly = true)
public class PrizeServiceImpl implements PrizeService {

	private static final Logger LOG = Logger.getLogger(PrizeServiceImpl.class);
	
	@Autowired
	PrizeDao prizeDao;

	@Override
	public List<UserPrize> getAllPrizeRecord() {
		LOG.info("Inside getAllPrizeRecord() serviceImpl "); 
		List<UserPrize> userPrize=null;
		try{
		 userPrize = prizeDao.getAllPrizeRecord();
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return userPrize;
		
	}

	@Override
	@Transactional(readOnly = false)
	public void savePrizeRecord(UserPrize prizedata) {
		LOG.info("Inside savePrizeRecord() serviceImpl ");
		try{
		prizeDao.savePrizeRecord(prizedata);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional(readOnly = false)
	public void deletePrizeRecord(UserPrize prizedata) {
		LOG.info("Inside deletePrizeRecord() serviceImpl ");
		try{
		prizeDao.deletePrizeRecord(prizedata);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
	}

}
