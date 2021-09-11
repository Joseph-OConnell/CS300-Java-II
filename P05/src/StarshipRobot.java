import java.io.File;
// TODO - method headers still need to be put on for all these.

public class StarshipRobot extends FrozenStatue {
  protected float[][] beginAndEnd = new float[2][2];
  // array of two positions, that this robot moves back and forth between
  // the contents of this 2d array are organized as follows: { { beginX, beginY }, { endX, endY }}
  protected float[] destination;
  // the position that this robot is currently moving towards
  protected float speed;
  // the speed in pixels that this robot moves during each update

  /**
   * The StarshipRobot constructor.  This method calls the FrozenStatue constructor and expands
   * it by adding beginning and endpoints , destination and speed (6) variables.  The StarshipRobot 
   * object also starts facing right.  
   * 
   * @param location a 2d array that contains the beginning and ending positions of the object
   */
  public StarshipRobot(float[][] location) {
    super(location[0]);
    for (int i = 0; i < location.length; i++) {
      for (int j = 0; j < location[i].length; j++) {
        this.beginAndEnd[i][j] = location[i][j];
      }
    }
    this.destination = this.beginAndEnd[1];
    this.speed = 6;
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "starshipRobot.png";
  }

  /**
   * This method updates the position of the object by moving the object a set amount of units based 
   * on the speed variable.  It also orients the object and determines when it has reached the destination. 
   *
   * @return true if the object is within the specified range of the destination.  False if otherwise
   */
  protected boolean moveTowardDestination() {
    float xDistSub = (this.x - this.destination[0]);
    float yDistSub = (this.y - this.destination[1]);
    float xDistSqr = (float) Math.pow(xDistSub, 2);
    float yDistSqr = (float) Math.pow(yDistSub, 2);
    float distance = (float) Math.sqrt(xDistSqr + yDistSqr);
    this.x = (this.x + ((this.speed * (this.destination[0] - this.x)) / (distance)));
    this.y = (this.y + ((this.speed * (this.destination[1] - this.y)) / (distance)));
    if (this.destination[0] > this.x) // destination x position larger than x position, face right
      this.isFacingRight = true;
    else
      this.isFacingRight = false;
    if (distance < (2 * this.speed))
      return true;
    return false;
  }

  /**
   * This method redefines the destination to the new array position either beginning or end depending
   * on where the previous destination was.  
   * 
   */
  protected void updateDestination() {
    if (this.destination.equals(this.beginAndEnd[0]))
      this.destination = this.beginAndEnd[1];
    else
      this.destination = this.beginAndEnd[0];
  }

  @Override
  /**
   * The update destination method will update the objects destination when the moveTowardDestination 
   * object returns true.  AKA it will return true when it is within range of the destination. 
   * It also calls the FrozenStatue update method to draw the picture to the screen.
   */
  public void update(SimulationEngine engine) {
    super.update(engine);
    if (this.moveTowardDestination()) {
      this.updateDestination();
    }
  }
}
