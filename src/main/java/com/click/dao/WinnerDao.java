package com.click.dao;

import java.util.List;

import com.click.entity.Winner;

/**
 * @author rahul
 */
public interface WinnerDao {

	/**
	 * Get List of the Winner data for User
	 * @param pageNo TODO
	 */
	public List<Winner> getWinner(int pageNo);
	
	/**
	 * Get List of the Winner data by Admin
	 * @param pageNo TODO
	 * return winner information list
	 */
	public List<Winner> getAllWinnerbyadmin();

	/**
	 * Delete Single Winner data by Admin based on id
	 */
	public void deleteWinner(Winner winnerdata);

	/**
	 * 
	 * @param winner
	 */
	public void saveWinner(Winner winner);

	/**
	 * 
	 * @return
	 */
	public Winner getLastWinner();

}
