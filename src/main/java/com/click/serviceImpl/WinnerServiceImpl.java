/**
 * 
 */
package com.click.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.click.dao.WinnerDao;
import com.click.entity.Winner;
import com.click.service.WinnerService;

/**
 * @author rahul
 */

@Component
@Transactional(readOnly = true)
public class WinnerServiceImpl implements WinnerService {

    @Autowired
    WinnerDao winnerDao;
	

	@Override
	public List<Winner> getWinner() {
		List<Winner> listofwinner=winnerDao.getWinner();
		return listofwinner;
	}

	@Override
	public void deleteWinner(Winner winnerdata) {
		winnerDao.deleteWinner(winnerdata);
		
	}

}
