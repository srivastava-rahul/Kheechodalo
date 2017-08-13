package com.click.dao;

import java.util.List;

import com.click.entity.Winner;

/**
 * @author rahul
 */
public interface WinnerDao {

	/**
	 * Get List of the Winner data by Admin
	 * @param pageNo TODO
	 */
	public List<Winner> getWinner(int pageNo);

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
