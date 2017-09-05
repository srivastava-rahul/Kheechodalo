/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.UserPrize;

/**
 * @author vipul
 */

public interface PrizeService {

	/**
	 * Get The list of All Prize by User
	 * 
	 * @return
	 */
	List<UserPrize> getAllPrizeRecord();

	/**
	 * Saving The prize by Admin
	 * 
	 * @param prizedata
	 */
	public void savePrizeRecord(UserPrize prizedata);

	/**
	 * Delete The prize by Admin
	 * 
	 * @param prizedata
	 */
	public void deletePrizeRecord(UserPrize prizedata);

	/**
	 * 
	 * @return
	 */
	String getPrizeAmountDesc();

}
