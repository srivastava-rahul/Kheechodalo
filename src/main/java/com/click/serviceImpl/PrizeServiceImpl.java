/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

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

	@Autowired
	PrizeDao prizeDao;

	@Override
	public List<UserPrize> getAllPrizeRecord() {
		List<UserPrize> userPrize = prizeDao.getAllPrizeRecord();
		return userPrize;
	}

	@Override
	public void savePrizeRecord(UserPrize prizedata) {
		prizeDao.savePrizeRecord(prizedata);
		
	}

	@Override
	public void deletePrizeRecord(UserPrize prizedata) {
		prizeDao.deletePrizeRecord(prizedata);
		
	}

}
