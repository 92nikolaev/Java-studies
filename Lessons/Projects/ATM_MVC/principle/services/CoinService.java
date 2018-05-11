package com.gmail.slshukevitch.principle.services;

import com.principle.Coin;

import java.util.Collection;

/**
 * @author Kamran
 *
 * coin service interface
 */
public interface CoinService {
	/**
	 * @param cents
	 * @return
	 */
	public Collection<Coin> getOptimalChangeFor(int cents);
	/**
	 * @param cents
	 * @param propertiesFile
	 * @return
	 */
	public Collection<Coin> getChangeWithLimitedCoinSupply(int cents, String propertiesFile);
	/**
	 * @param denomination
	 * @param propertiesFile
	 * @return
	 */
	public int getNumberOfCoinsAvailableForDenomination(String denomination, String propertiesFile);
	/**
	 * @param denomination
	 * @param coinsLeft
	 */
	public void updateNumberOfCoinsAvailableForDenomination(int denomination, int coinsLeft, String propertiesFile);
}
