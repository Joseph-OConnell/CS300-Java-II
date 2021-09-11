import java.io.File;

public class FrozenStatue {
  protected float x;
  // the horizontal position of this object in pixels from 0-left to 800-right
  protected float y;
  // the vertical position of this object in pixels from 0-top to 600-bottom
  protected boolean isFacingRight;
  // used to mirror image (flip left to right) only when this field is false
  protected String imageName;
// the relative path to the image file (from the working directory)
  /**
   * The FrozenStatue constructor that initializes the orientation and location of the object.  child classes
   * also use this constructor
   * 
   * @param location an array of floats with length 2 that holds the initial x and y position for the object
   */
  public FrozenStatue(float[] location) {
    this.x = location[0]; // x position
    this.y = location[1]; // y position
    this.isFacingRight = true;
    this.imageName = "images" + File.separator + "frozenStatue.png";
  }

  /**
   * This method takes in a SimulaionEngine object and calls the draw()) method on it with the current object
   * 
   * @param engine the SimulationEngine object that WinterCarnival extends.  
   */
  public void update(SimulationEngine engine) {
    engine.draw(this.imageName, this.x, this.y, this.isFacingRight);
  }
}
