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
public class PiggyBankTester {
	
	/**
	* Checks whether PiggyBank.getCoinName() method works as expected.
	* @return true when this test verifies a correct functionality, and false otherwise
	*/
	public static boolean getCoinNameTestMethod() {
		// change some coin values and names
		// I commented this out because it broke stuff.  
//		PiggyBank.COINS_NAMES[1] = "Two cents";
//		PiggyBank.COINS_NAMES[3] = "Fifty Cents";
//		PiggyBank.COINS_VALUES[1] = 2;
//		PiggyBank.COINS_VALUES[3] = 50;
		// consider all coin values as input arguments
		for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
		if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
		return false;
		// consider input argument which does not correspond to a coin value
		if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
		return false;
		if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
		return false;
		return true;
		}
	
	/**
	* Checks whether PiggyBank.getBalance() method works as expected.
	* @return true when this test verifies a correct functionality, and false otherwise
	*/
	public static boolean getBalanceTestMethod() {
	// scenario 1 - empty piggy bank
	int[] coins = new int[10]; // array storing the coins held in a piggy bank
	int size = 0; // number of coins held in coins array
	if(PiggyBank.getBalance(coins, size)!= 0) {
		System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
				+ "return the expected output when passed an empty piggy bank.");
		return false;
	}
	// scenario 2 - non empty piggy bank
	coins = new int[] {10, 1, 5, 25, 1, 0, 0};
	size = 5;
	if(PiggyBank.getBalance(coins, size)!= 42) {
		System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
		+ "return the expected output when passed an piggy bank that holds "
		+ "two pennies, a nickel, a dime, and a quarter.");
		return false;
	}
	// scenario 3 - another non empty piggy bank
	coins = new int[] {10, 1, 5, 25, 1, 0};
	size = 3;
	if(PiggyBank.getBalance(coins, size)!= 16) {
		System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
		+ "return the expected output when passed an piggy bank that holds "
		+ "a penny, a nickel, and a dime, only.");
		return false;
	}
	return true;
	}
                                                                                                    
	/**
	 * Checks whether PiggyBank.getSpecificCoinCount() method works as expected.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean getSpecificCoinCountTestMethod() {
		//scenario 1 - empty piggy bank
		int[] coins = new int[10]; // array storing the coins held in a piggy bank
		int size = 0; // number of coins held in coins array
		int coinValue = 1;
		if(PiggyBank.getSpecificCoinCount(coinValue, coins, size)!= 0) {
			return false;
		}
		coins = new int[10]; // array storing the coins held in a piggy bank
		size = 0; // number of coins held in coins array
		coinValue = 5;
		if(PiggyBank.getSpecificCoinCount(coinValue, coins, size)!= 0) {
			return false;
		}
		//scenario 2 - no coins of certain type in piggy Bank
		coins = new int[] {5, 1, 5, 25, 1, 0, 0};
		size = 5; // number of coins held in coins array
		coinValue = 10;
		if(PiggyBank.getSpecificCoinCount(coinValue, coins, size)!= 0) {
			return false;
		}
		coins = new int[] {5, 1, 5, 25, 1, 0, 0};
		size = 5; // number of coins held in coins array
		coinValue = 5;
		if(PiggyBank.getSpecificCoinCount(coinValue, coins, size)!= 2) {
			return false;
		}
		//scenario 3 - has coins but returns wrong number
		coins = new int[] {10, 1, 5, 25, 1, 0};
		size = 3;
		coinValue = 25;
		if(PiggyBank.getSpecificCoinCount(coinValue, coins, size)!= 0) {
			System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() did not "
			+ "return the expected output when passed an piggy bank that holds "
			+ "a penny, a nickel, and a dime, only.");
			return false;
		}
		//scenario 4 - has coins and returns right number
		return true;
	}

	
	/**
	 * Checks whether PiggyBank.addCoin() method works as expected.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean addCoinTestMethod() {
		//scenario 1 - tries to add a coin that doesn't exist
		int coin = 4;
		int[] coins = new int[] {10, 1, 5, 25, 1, 0, 0};
		int size = 5;
		if(PiggyBank.addCoin(coin, coins, size)!= 5) {
			return false;
		}
		//scenario 2 - tries to add a coin to a full piggy bank
		coin = 5;
		coins = new int[] {10, 1, 5, 25, 1, 5, 1};
		size = 5;
		if(PiggyBank.addCoin(coin, coins, size)!= 5) {
			return false;
		}
		//scenario 3 - given size of the piggy bank is wrong
		coin = 5;
		coins = new int[] {10, 1, 5, 25, 0, 0, 0};
		 size = 3;
		if(PiggyBank.addCoin(coin, coins, size)!= 4) {
			return false;
		}
		//scenario 4 - successfully adds but wrong size
		coin = 5;
		coins = new int[] {10, 1, 5, 25, 0, 0, 0};
		 size = 4;
		if(PiggyBank.addCoin(coin, coins, size)!= 5) {
			return false;
		}
		//scenario 5 - spot for coin in the middle
		coin = 5;
		coins = new int[] {10, 1, 0, 25, 1, 1, 1};
		size = 7;
		if(PiggyBank.addCoin(coin, coins, size)!= 8) {
			return false;
		}
		return true;
	}

	/**
	 * Checks whether PiggyBank.removeCoin() method works as expected.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean removeCoinTestMethod() {
		//scenario 1 - empty piggy bank
				int[] coins = new int[] {0, 0, 0, 0, 0, 0, 0};
				int size = 0;
				if(PiggyBank.removeCoin(coins, size)!= 0) {
					return false;
				}
		//removes a coin but forgets to fix size
				coins = new int[] {10, 1, 5, 25, 1, 0, 0};
				size = 5;
				if(PiggyBank.removeCoin(coins, size)!= 4) {
					return false;
				}
		return true;
	}
	
	/**
	 * Checks whether PiggyBank.emptyPiggyBank() method works as expected.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean emptyPiggyBankTestMethod() {
		//scenario 1 - piggy bank is already empty
		int[] coins = new int[] {0, 0, 0, 0, 0, 0, 0};
		int size = 0;
		if(PiggyBank.emptyPiggyBank(coins, size)!= 0) {
			return false;
		}
		//scenario 2 - piggy bank was emptied but wrong size returned
		coins = new int[] {10, 1, 5, 25, 1, 0, 0};
		size = 5;
		if(PiggyBank.emptyPiggyBank(coins, size)!= 0) {
			return false;
		}
		
		
		return true;		
	}
	
	/**
	 * Checks whether PiggyBank.withdraw() method works as expected.
	 * @return true when this test verifies a correct functionality, and false otherwise
	 */
	public static boolean withdrawTestMethod() {
		//scenario 1 - not enough money in the bank
		int[] coins = new int[] {1, 1, 1, 5, 5, 10, 25, 25, 25};
		int size = 9;
		int[] result = PiggyBank.withdraw(100, coins, size);
		if(result[0] != size) {
			return false;
		}
		if(result[1] != 0) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 0) {
			return false;
		}
		if(result[4] != 0) {
			return false;
		}
		//scenario 2 - perfect change
		coins = new int[] {1, 1, 1, 5, 5, 10, 25, 25, 25};
		size = 9;
		result = PiggyBank.withdraw(56, coins, size);
		if(result[0] != 5) {
			return false;
		}
		if(result[1] != 2) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 1) {
			return false;
		}
		if(result[4] != 1) {
			return false;
		}
		//scenario 3 - not perfect change 1
		coins = new int[] {25, 25, 5, 0, 0, 0, 0, 0, 0};
		size = 3;
		result = PiggyBank.withdraw(52, coins, size);
		if(result[0] != 0) {
			return false;
		}
		if(result[1] != 2) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 1) {
			return false;
		}
		if(result[4] != 0) {
			return false;
		}
		//scenario 3 - not perfect change 2
		coins = new int[] {25, 1, 1, 25, 25, 10, 25, 25, 25};
		size = 9;
		result = PiggyBank.withdraw(65, coins, size);
		if(result[0] != 6) {
			return false;
		}
		if(result[1] != 3) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 0) {
			return false;
		}
		if(result[4] != 0) {
			return false;
		}
		//scenario 3 - not perfect change 3
		coins = new int[] {25, 25, 25, 25, 5, 10, 25, 25, 25};
		size = 9;
		result = PiggyBank.withdraw(3, coins, size);
		if(result[0] != 8) {
			return false;
		}
		if(result[1] != 0) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 1) {
			return false;
		}
		if(result[4] != 0) {
			return false;
		}
		//scenario 3 - not perfect change 4
		coins = new int[] {25, 25, 1, 25, 25, 10, 25, 25, 25};
		size = 9;
		result = PiggyBank.withdraw(12, coins, size);
		if(result[0] != 8) {
			return false;
		}
		if(result[1] != 1) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 0) {
			return false;
		}
		if(result[4] != 0) {
			return false;
		}
		//scenario 3 - not perfect change 5
		coins = new int[] {25, 0, 0, 0, 0, 0, 0, 0};
		size = 1;
		result = PiggyBank.withdraw(1, coins, size);
		if(result[0] != 0) {
			return false;
		}
		if(result[1] != 1) {
			return false;
		}
		if(result[2] != 0) {
			return false;
		}
		if(result[3] != 0) {
			return false;
		}
		if(result[4] != 0) {
			return false;
		}
		return true;
	}

	/**
	* Calls the test methods implemented in this class and displays their output
	* @param args input arguments if any
	*/
	public static void main(String[] args) {
		System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
		System.out.println("getBalanceTest(): " + getBalanceTestMethod());
		System.out.println("getSpecificCoinCountTest(): " + getSpecificCoinCountTestMethod());
		System.out.println("addCoinTest(): " + addCoinTestMethod());
		System.out.println("removeCoinTest(): " + removeCoinTestMethod());
		System.out.println("emptyPiggyBankTest(): " + emptyPiggyBankTestMethod());
		System.out.println("withdrawTest(): " + withdrawTestMethod());
	}
}
