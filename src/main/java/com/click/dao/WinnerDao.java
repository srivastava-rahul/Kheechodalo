package com.click.dao;

import java.util.List;

import com.click.entity.Winner;

/**
 * @author rahul
 */
public interface WinnerDao {

	/**
	 * Get List of the Winner data by Admin
	 */
	public List<Winner> getWinner();

	/**
	 * Delete Single Winner data by Admin based on id
	 */
	public void deleteWinner(Winner winnerdata);

	/**
	 * 
	 * @param winner
	 */
	public void saveWinner(Winner winner);

}
