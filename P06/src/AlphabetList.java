
public class AlphabetList extends java.lang.Object implements SortedListADT<Cart> {

  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that
  // can be added to this sorted list
  private static final Cart MAX_CART = new Cart("Z"); // The largest cart that
  // can be added to this sorted list
  private LinkedCart head; // head of this doubly linked list
  private LinkedCart tail; // tail of this doubly linked list
  private int size; // size of this list
  private int capacity; // maximum number of carts which can be stored in this list

  /**
   * 
   * @param capacity
   */
  public AlphabetList(int capacity) throws IllegalArgumentException {
    if (capacity < 1)
      throw new IllegalArgumentException(
          "The capacity of this list must be a non-zero a positive integer.");
    this.capacity = capacity;
  }

  /**
   * 
   */
  public AlphabetList() {
    this(26);
  }

  /**
   * 
   */
  @Override
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * 
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * 
   * @return
   */
  public int capacity() {
    return capacity;
  }


  @Override
  public void add(Cart newObject) throws IllegalArgumentException, IllegalStateException {
    // prevent null references
    if (newObject == null)
      return;
    // check if the list is full
    if (size == capacity)
      throw new IllegalStateException("This list is full. Cannot add another cart.");
    // deal with cart out of range first
    if (newObject.compareTo(MIN_CART) < 0 || newObject.compareTo(MAX_CART) > 0)
      throw new IllegalArgumentException(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    // deal with duplicate carts
    LinkedCart tempLinkedCart = head;
    for (int i = 0; i < size; i++) {
      if (tempLinkedCart.getCart().compareTo(newObject) == 0)
        throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
      tempLinkedCart = tempLinkedCart.getNext();
    }

    // now add the cart to the list
    LinkedCart newLinkedCart;
    // check if cart is the first one to get added
    if (size == 0) {
      newLinkedCart = new LinkedCart(newObject);
      head = newLinkedCart;
      tail = newLinkedCart;
      size++;
      return;
    }
    
    if (size == 1) {
      if (head.getCart().compareTo(newObject) < 0) {
        newLinkedCart = new LinkedCart(newObject);
        tail = newLinkedCart;
        newLinkedCart.setPrevious(head);
        newLinkedCart.getPrevious().setNext(newLinkedCart);
      }
      else {
        newLinkedCart = new LinkedCart(newObject);
        newLinkedCart.setNext(head);
        head = newLinkedCart;
        newLinkedCart.getNext().setPrevious(newLinkedCart);
      }
      size++;
      return;
    }

    // first find the right location for the new cart when there's at least 2
    tempLinkedCart = head;
    for (int i = 0; i < size; i++) {
      if (tempLinkedCart.getCart().compareTo(newObject) > 0) {
        break; 
      }
      if (i == size - 1)
        break;
      tempLinkedCart = tempLinkedCart.getNext();
    }

    // if the LinkedCart is at the beginning
    if (tempLinkedCart.getCart().compareTo(head.getCart()) == 0) {
      newLinkedCart = new LinkedCart(newObject);
      newLinkedCart.setNext(head);
      head = newLinkedCart;
      newLinkedCart.getNext().setPrevious(newLinkedCart);
    }
    // if the LinkedCart is at the end
    else if (newObject.compareTo(tail.getCart()) > 0) {
      newLinkedCart = new LinkedCart(newObject);
      newLinkedCart.setPrevious(tail);
      tail = newLinkedCart;
      newLinkedCart.getPrevious().setNext(newLinkedCart);
    }
    // LinkedCart is not at beginning or end
    else {
      newLinkedCart = new LinkedCart(newObject, tempLinkedCart.getPrevious(), tempLinkedCart);
      newLinkedCart.getNext().setPrevious(newLinkedCart);
      newLinkedCart.getPrevious().setNext(newLinkedCart);
      
    }
    size++;
  }

  @Override
  public int indexOf(Cart findObject) {
    LinkedCart tempLinkedCart = head;
    int index = 0;
    for (int i = 0; i < size; i++) {
      if (tempLinkedCart.getCart().compareTo(findObject) == 0) {
        index = i;
        break;
      }
      if(i == size -1) 
        return -1;
      tempLinkedCart = tempLinkedCart.getNext();
      }
    return index;
    }
  
  @Override
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }

  @Override
  public Cart get(int index) throws IndexOutOfBoundsException{
    //check for bad input
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException("Invalid index.");
    
    //now have good input
    LinkedCart tempLinkedCart = head;
    for(int i = 0; i < size; i++) {
      if(index == i)
        return tempLinkedCart.getCart();
      tempLinkedCart = tempLinkedCart.getNext();
    }
    return null;
  }

  
  @Override
  public Cart remove(int index) throws IndexOutOfBoundsException{
    //check for bad input
    if(index >= size || index < 0)
      throw new IndexOutOfBoundsException("Invalid index.");
    
    //now have good input
    //keep track of removed cart before modifying anything
    Cart removeCart = this.get(index);
    
    //deal with weird cases first
    //only one thing
    if(size == 1) {
      this.clear();
      return removeCart;
    }
    //two things
    if (size == 2) {
      if(index == 0) {
        head = tail;
        head.setNext(null);
        head.setPrevious(null);
      }
      if(index == 1) {
        tail = head;
        head.setNext(null);
        head.setPrevious(null);
      }
      size--;
      return removeCart;
    }    
    
    //if the code reaches this point, there are at least 3 items
    //deal with removing the head first
    if(index == 0) {
      head = head.getNext();
      head.setPrevious(null);
      size--;
      return removeCart;
    }
    
    //deal with removing tail
    if(index == size - 1) {
      tail = tail.getPrevious();
      tail.setNext(null);
      size--;
      return removeCart;
    }
    
    //removing somewhere in the middle
    LinkedCart tempLinkedCart = head;
    for (int i = 0; i < size; i++) {
      if (i == index)
        break;
     tempLinkedCart = tempLinkedCart.getNext(); 
    }
    tempLinkedCart.getPrevious().setNext(tempLinkedCart.getNext());
    tempLinkedCart.getNext().setPrevious(tempLinkedCart.getPrevious());
    size--;
    return removeCart;
  }
  
  public String toString(){
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
    return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
    string += currentCart.getCart().toString() + " ";
    currentCart = currentCart.getNext();
    }
    string += "]";
    return string;

  }

  public String readForward(){
    if(size == 0)
      return "";
    String forwardString = "";
    LinkedCart tempLinkedCart = head;
    for(int i = 0; i < size; i++) {
      forwardString += tempLinkedCart.getCart().getCargo();
      if(i != size -1)
        tempLinkedCart = tempLinkedCart.getNext();
    }
    return forwardString;
  }
  
  public String readBackward(){
    if(size == 0)
      return "";
    String reverseString = "";
    LinkedCart tempLinkedCart = tail;
    for(int i = 0; i < size; i++) {
      reverseString += tempLinkedCart.getCart().getCargo();
      if(i != size -1)
        tempLinkedCart = tempLinkedCart.getPrevious();
    }
    return reverseString;
  }
}
