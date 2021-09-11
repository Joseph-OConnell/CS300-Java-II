// File header comes here
/**
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    return false;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    return false;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. For each of those scenarios, make sure that the 
   * size of the list is appropriately updated after a call without errors of the add() method, 
   * and that the contents of the list is as expected whatever if list is read in the forward or 
   * backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
    return false;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    return false;
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    Cart cart1 = new Cart("A");
    Cart cart2 = new Cart("B");
    Cart cart3 = new Cart("C");
    Cart cart4 = new Cart("D");
    Cart cart5 = new Cart("E");
    
    AlphabetList test = new AlphabetList();
    test.add(cart1);
    test.add(cart2);
    test.add(cart4);
    test.add(cart3);
    System.out.println(test.readForward());
    System.out.println(test.readBackward());
    
    

  }
}