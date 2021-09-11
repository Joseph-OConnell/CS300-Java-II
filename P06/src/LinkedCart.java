
public class LinkedCart extends java.lang.Object {
  private final Cart CART; // data field of this linked Cart
  private LinkedCart previous; // reference to the previous linked cart in
  // a list of carts
  private LinkedCart next; // reference to the next linked cart in a list of carts
  
  /**
   * 
   * @param cart
   */
  public LinkedCart(Cart cart) {
    this.CART = cart;
    previous = null;
    next = null;
  }
  
  /**
   * 
   * @param cart
   * @param previous
   * @param next
   */
  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }
  
  /**
   * 
   * @return
   */
  public Cart getCart() {
    return CART;
  }
  
  /**
   * 
   * @return
   */
  public LinkedCart getNext() {
    return next;
  }
  
  /**
   * 
   * @return
   */
  public LinkedCart getPrevious() {
    return previous;
  }
  
  /**
   * 
   * @param next
   */
  public void setNext(LinkedCart next) {
    this.next = next;
  }
  
  /**
   * 
   * @param previous
   */
  public void setPrevious(LinkedCart previous) {
    this.previous = previous;
  }
}
