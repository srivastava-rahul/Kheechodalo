/**
 * 
 */
package com.click.service;

import java.util.List;

import com.click.entity.Winner;

/**
 * @author rahul
 */

public interface WinnerService {

	/**
	 * Get List of the Winner data by Admin
	 */
	public List<Winner> getAllWinner();

	/**
	 * Delete Single Winner data by Admin based on id
	 */
	public void deleteWinner(Winner winnerdata);

	/**
	 * 
	 */
	public void copyWinnerPic();

}
