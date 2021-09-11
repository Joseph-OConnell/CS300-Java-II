import java.io.File;

public class DancingBadger extends StarshipRobot {
  protected DanceStep[] danceSteps;
  // the sequence of directions / dance steps for this badger to move
  int stepIndex;
  // the index of the next step within danceSteps for this badger to move through

  /**
   *  The DancingBadger constructor initializes by calling the StarshipRobot constructor and then
   *  defining the required variables from that constructor and the new DanceStep array.
   * 
   * @param startingPosition A 1D float array that contains the starting position of the object
   * @param dancingSteps a 1D DanceStep array that contains the sequence of directions / dance steps for this badger to move
   */
  public DancingBadger(float[] startingPosition, DanceStep[] dancingSteps) {
    super(new float[][] {startingPosition, dancingSteps[0].getPositionAfter(startingPosition)});
    dancingSteps[0].getPositionAfter(startingPosition);
    this.imageName = "images" + File.separator + "dancingBadger.png";
    this.speed = 2;
    this.isFacingRight = true;
    this.danceSteps = dancingSteps;
    this.stepIndex = 1;
  }

  @Override
  /**
   * This updateDestination method updates the destination vector according to the next dance step.
   * After updating the destination, the stepIndex increments.  Once the length of the DanceStep array is exceeded,
   * the array repeats.  
   * 
   */
  protected void updateDestination() {
    float[] currentLocation = new float[] {this.x, this.y};
    this.destination = this.danceSteps[this.stepIndex].getPositionAfter(currentLocation);
    this.stepIndex = (this.stepIndex + 1) % danceSteps.length;
  }
}
