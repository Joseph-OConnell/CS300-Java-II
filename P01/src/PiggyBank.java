//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P1 PiggyBank add and withdrawl money from a Piggy Bank
// Files:   PiggyBank and PiggyBankTester
// Course:  CS 300 Spring 2020
//
// Author:  Joseph O'Connell
// Email:   jpoconnell2@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understood the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
public class PiggyBank {

	// Constants
	public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
	// coins names
	public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
	public final static String NO_SUCH_COIN = "N/A"; // N/A string
	private final static Random RAND_GEN = new Random(100); // generator of random integers
	
	/**
	* Returns the name of a specified coin value
	* @param coin represents a coin value in cents.
	* @return the String name of a specified coin value if it is valid and N/A if the
	* coin value is not valid
	*/
	public static String getCoinName(int coin) {
		for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++) {
			if (COINS_VALUES[i] == coin) {
				return COINS_NAMES[i];
			}
		}
		return NO_SUCH_COIN;
	}
	
	/**
	* Returns the balance of a piggy bank in cents
	* @param coins an oversize array which contains all the coins held in a piggy bank
	* @param size the total number of coins stored in coins array
	* @return the total value of the coins held in a piggy bank in cents
	*/
	public static int getBalance(int[] coins, int size) {
		int total = 0;
		for(int i = 0; i < size; i++) {
			total = total + coins[i];
		}
		return total;
	}
	
	/**
	* Returns the total number of coins of a specific coin value held in a piggy bank
	*
	* @param coinValue the value of a specific coin
	* @param coins an oversize array which contains all the coins held in a piggy
	* bank
	* @param size the total number of coins stored in coins array
	* @return the number of coins of value coinValue stored in the array coins
	*/
	public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
		int total = 0;
		for(int i = 0; i < size; i++) {
			if(coinValue == coins[i]) {
				total++;
			}
		}
		return total;
	}
	
	/**
	* Displays information about the content of a piggy bank
	*
	* @param coins an oversize array storing the coins held in a piggy bank
	* @param size number of coin held array coins
	*/
	public static void printPiggyBank(int[] coins, int size) {
	System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
	System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
	System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
	System.out.println("PENNIES: "+getSpecificCoinCount(1, coins, size));
	System.out.println("Balance: $" + getBalance(coins, size)*0.01);
	}
	
	/**
	* Adds a given coin to a piggy bank. This operation can terminate
	* successfully or unsuccessfully. For either cases, this method
	* displays a descriptive message for either cases.
	*
	* @param coin the coin value in cents to be added to the array coins
	* @param coins an oversize array storing the coins held in a piggy bank
	* @param size the total number of coins contained in the array coins
	* before this addCoin method is called.
	* @return the new size of the coins array after trying to add coin.
	*/
	public static int addCoin(int coin, int[] coins, int size) {
		boolean fail = false;
		int noCoin = 0;
		//find name of the coin we want to add
		String coin_name = getCoinName(coin);
		//check for valid US Currency
		for (int i = 0; i < COINS_VALUES.length; i++) {
			if (COINS_VALUES[i] == coin) {
				break;
			}
			if ((COINS_VALUES.length - 1) == i) {
				System.out.println( coin + " cents is not a valid US currency coin.");
				return size;
			}
		}
		//  check if there is room in the piggy bank
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] == 0) {
				noCoin = i;	//index of the first open position in the bank
				break;
			}
			else if((coins.length-1) == i) {
			System.out.println("Tried to add a " + coin_name + ", but could not because the piggy bank is full.");
			fail = true;
			}
		}
		//  successfully adding a coin to the piggy bank
		if(!fail) {
			coins[noCoin] = coin;
			size++;
		}
		return size;
	}
	
	/**
	* Removes an arbitrary coin from a piggy bank. This method may terminate
	* successfully or unsuccessfully. In either cases, a descriptive message
	* is displayed.
	*
	* @param coins an oversize array which contains the coins held in a piggy bank
	* @param size the number of coins held in the coins array before this method
	* is called
	* @return the size of coins array after this method returns successfully
	*/
	public static int removeCoin(int[] coins, int size) {
		// I know I could shorten this by looking at size, but I'm assuming size could be invalid input
		//check to see if piggy bank is empty
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] != 0) {
				break;
			}
			if((coins.length - 1) == i) {
				System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
				return size;
			}
		}
		//  remove a random coin from the array
		//  first find a spot with a coin
		int ind = 0;;
		while(true) {
		ind = RAND_GEN.nextInt(coins.length);
			if(coins[ind] != 0) {
				break;
			}
		}
		//find what the coin is, and remove it
		String coin_name = getCoinName(coins[ind]);
		coins[ind] = 0;
		size--;
		System.out.println("Removed a " + coin_name + ".");
		
		return size;
	}
	
	/**
	* Removes all the coins in a piggy bank. It also displays the total value
	* of the removed coins
	*
	* @param coins an oversize array storing the coins held in a piggy bank application
	* @param size number of coins held in coins array before this method is called
	* @return the new size of the piggy bank after removing all its coins.
	*/
	public static int emptyPiggyBank(int[] coins, int size) {
		// I know I could shorten this by looking at size, but I'm assuming size could be invalid input
		//if piggy bank is empty
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] != 0) {
				break;
			}
			if((coins.length - 1) == i) {
				System.out.println("Zero coin removed. The piggy bank is already empty.");
				return size;
			}
		}
		//  empty the piggy bank now
		int total = 0;	// sum of all removed cents
		for(int i = 0; i < coins.length; i++) {
			total = total + coins[i];
			coins[i] = 0;
		}
		System.out.println("All done. " + total + " cents removed.");
		size = 0;
		return size;
	}
	
	/**
	 * Finds the first instance of the desired coin.  This method is only called when 
	 * the coin is known to be in the bank
	 * however, it will return -1 if there is no coin found
	 * 
	 * @param coinValue value of coin to find
	 * @param coins  an oversize array storing the coins held in a piggy bank
	 * @param size number of coins stored in coins array before this method is called
	 * @return first index of the desired coin
	 */
	public static int findIndex(int coinValue, int[] coins, int size) {
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] == coinValue) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	* Removes the least number of coins needed to fulfill a withdrawal request
	*
	* @param amount amount to withdraw given in cents
	* @param coins an oversize array storing the coins held in a piggy bank
	* @param size number of coins stored in coins array before this method is called
	* @return perfect size array of 5 elements, index 0 stores the new size of
	* the piggy bank after this method returns. Indexes 1, 2, 3, and 4
	* store respectively the number of removed quarters, dimes,
	* nickels, and pennies.
	*/
	public static int[] withdraw(int amount, int[] coins, int size) {
		//sorting the COINS_VALUES & COINS_NAMES from small to large so it doesn't break my code
		int tempNum;
		String tempName = "";
		 for (int i = 1; i < COINS_VALUES.length; i++) {
			    for (int j = i; j > 0; j--) {
			    	if(COINS_VALUES[j - 1] > COINS_VALUES[j]) {
			    		tempNum = COINS_VALUES[j];
			    		tempName = COINS_NAMES[j];
			    		COINS_VALUES[j] = COINS_VALUES[j-1];
			    		COINS_NAMES[j] = COINS_NAMES[j-1];
			    		COINS_VALUES[j-1] = tempNum;
			    		COINS_NAMES[j-1] = tempName;
			    	}
			    }
		 }
		int[] withdrew = {size, 0, 0, 0, 0}; // this is the information going to be returned
		// first make sure there is enough in piggy bank
		if(getBalance(coins, size) < amount) {
			System.out.println("Unable to withdraw " + amount + " cents. NOT enough money in the piggy bank.");
			return withdrew;
		}
		// code reaches this point if the piggy bank has enough money to make change
		int total = 0;
		int tempIndex = 0;
		int[] loopTrigger = new int[coins.length*5];	//this array prevents an infinite loop
		int triggerIndex = 0;
		while(total != amount) {
			tempIndex = 0;	// this is the index of the coin that we want to withdraw
			if ((amount - total) >= COINS_VALUES[3] && getSpecificCoinCount(COINS_VALUES[3],coins, size) != 0) {
				tempIndex = findIndex(COINS_VALUES[3], coins, size);
				total = total + coins[tempIndex];
				withdrew[1]++;
				size--;
				coins[tempIndex] = coins[size];
				coins[size] = 0;
				continue;
			}
			if ((amount - total) >= COINS_VALUES[2] && getSpecificCoinCount(COINS_VALUES[2],coins, size) != 0) {
				tempIndex = findIndex(COINS_VALUES[2], coins, size);
				total = total + coins[tempIndex];
				withdrew[2]++;
				size--;
				coins[tempIndex] = coins[size];
				coins[size] = 0;
				continue;
			}
			if ((amount - total) >= COINS_VALUES[1] && getSpecificCoinCount(COINS_VALUES[1],coins, size) != 0) {
				tempIndex = findIndex(COINS_VALUES[1], coins, size);
				total = total + coins[tempIndex];
				withdrew[3]++;
				size--;
				coins[tempIndex] = coins[size];
				coins[size] = 0;
				continue;
			}
			if ((amount - total) >= COINS_VALUES[0] && getSpecificCoinCount(COINS_VALUES[0],coins, size) != 0) {
				tempIndex = findIndex(COINS_VALUES[0], coins, size);
				total = total + coins[tempIndex];
				withdrew[4]++;
				size--;
				coins[tempIndex] = coins[size];
				coins[size] = 0;
				continue;
				
			}
			loopTrigger[triggerIndex] = total;
			triggerIndex++;
			if(triggerIndex > 2 && loopTrigger[triggerIndex-1] == loopTrigger[triggerIndex-2]) {
				break;
			}
		}
		withdrew[0] = size;
		if(amount == total) {
			return withdrew;
		}
		// the code reaches here when the requested amount is less than the piggy bank has but not perfect change.  
		// remove the pennies
		int tempCoin = 0;
		
		if(total < amount) {
			tempCoin = withdrew[4];
			withdrew[4] = 0;
			total = total - (tempCoin*COINS_VALUES[0]);
			for(int i=0; i < tempCoin; i++) {
				addCoin(COINS_VALUES[0], coins, size);
				size++;
			}
			// add nickels until it runs out of nickels
			
			if(getSpecificCoinCount(COINS_VALUES[1],coins, size) != 0 ) {
				for(int i = 0; i < getSpecificCoinCount(COINS_VALUES[1],coins, size); i++) {
					if (total < amount) {
						tempIndex = findIndex(COINS_VALUES[1], coins, size);
						total = total + coins[tempIndex];
						withdrew[3]++;
						size--;
						coins[tempIndex] = coins[size];
						coins[size] = 0;
					}
					else {
						break;
					}
				}
				
			}
		}
		// remove all the nickels
		if(total < amount) {
			tempCoin = withdrew[3];
			withdrew[3] = 0;
			total = total - (tempCoin*COINS_VALUES[1]);
			for(int i=0; i < tempCoin; i++) {
				addCoin(COINS_VALUES[1], coins, size);
				size++;
			}
			// add dimes until it runs out of dimes
			if(getSpecificCoinCount(COINS_VALUES[2],coins, size) != 0 ) {
				for(int i = 0; i < getSpecificCoinCount(COINS_VALUES[2],coins, size); i++) {
					if (total < amount) {
						tempIndex = findIndex(COINS_VALUES[2], coins, size);
						total = total + coins[tempIndex];
						withdrew[2]++;
						size--;
						coins[tempIndex] = coins[size];
						coins[size] = 0;
					}
					else {
						break;
					}
				}
				
			}
		}
		// remove all the dimes
		if(total < amount) {
			tempCoin = withdrew[2];
			withdrew[2] = 0;
			total = total - (tempCoin*COINS_VALUES[2]);
			for(int i=0; i < tempCoin; i++) {
				addCoin(COINS_VALUES[1], coins, size);
				size++;
			}
			// add quarters until it runs out 
			
			if(getSpecificCoinCount(COINS_VALUES[3],coins, size) != 0 ) {
				for(int i = 0; i < getSpecificCoinCount(COINS_VALUES[3],coins, size); i++) {
					if (total < amount) {
						tempIndex = findIndex(COINS_VALUES[3], coins, size);
						total = total + coins[tempIndex];
						withdrew[1]++;
						size--;
						coins[tempIndex] = coins[size];
						coins[size] = 0;
					}
					else {
						break;
					}
				}
				
			}
		}
		withdrew[0] = size;
		return withdrew;
	}
	}

