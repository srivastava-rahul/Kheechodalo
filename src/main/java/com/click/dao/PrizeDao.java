package com.click.dao;

import java.util.List;

import com.click.entity.UserPrize;

/**
 * @author rahul
 */

public interface PrizeDao {

	/**
	 * Get The list of All Prize by User
	 * @return
	 */
	List<UserPrize> getAllPrizeRecord();
	
	
	/**
	 * Saving The prize by Admin
	 * @param prizedata
	 */
	public void savePrizeRecord(UserPrize prizedata);
	
	/**
	 * Delete The prize by Admin
	 * @param prizedata
	 */
	public void deletePrizeRecord(UserPrize prizedata);

}
