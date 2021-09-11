import java.io.File;
import java.util.ArrayList;

public class WinterCarnival extends SimulationEngine {
  private ArrayList<FrozenStatue> objects = new ArrayList<FrozenStatue>();


  // TESTING STEP 2 FrozenStatue firstFrozenStatue;
  /**
   * This is the Winter Carnival constructor that is used at the beginning of every program. This
   * creates two new Frozen Statue objects at the bottom left and top right.
   */
  public WinterCarnival() {
    FrozenStatue firstFrozenStatue = new FrozenStatue(new float[] {600, 100});
    FrozenStatue secondFrozenStatue = new FrozenStatue(new float[] {200, 500});
    objects.add(firstFrozenStatue);
    objects.add(secondFrozenStatue);
    StarshipRobot firstStarshipRobot = new StarshipRobot(new float[][] {{0, 0}, {600, 100}});
    StarshipRobot secondStarshipRobot = new StarshipRobot(new float[][] {{800, 300}, {200, 500}});
    objects.add(firstStarshipRobot);
    objects.add(secondStarshipRobot);
    DanceStep[] danceBucky = new DanceStep[] {DanceStep.valueOf("Left"), DanceStep.valueOf("Right"),
        DanceStep.valueOf("Right"), DanceStep.valueOf("Left"), DanceStep.valueOf("Down"),
        DanceStep.valueOf("Left"), DanceStep.valueOf("Right"), DanceStep.valueOf("Right"),
        DanceStep.valueOf("Left"), DanceStep.valueOf("Up")};
    DancingBadger bucky1 = new DancingBadger(new float[] {304, 268}, danceBucky);
    DancingBadger bucky2 = new DancingBadger(new float[] {368, 268}, danceBucky);
    DancingBadger bucky3 = new DancingBadger(new float[] {432, 268}, danceBucky);
    DancingBadger bucky4 = new DancingBadger(new float[] {496, 268}, danceBucky);
    objects.add(bucky1);
    objects.add(bucky2);
    objects.add(bucky3);
    objects.add(bucky4);
  }


  /**
   * This method overrides the default update method so that the draw method is called repeatedly as
   * long as the simulation is running
   */
  public void update() {
    FrozenStatue intermediateStatue;
    for (int i = 0; i < objects.size(); i++) {
      intermediateStatue = objects.get(i);
      intermediateStatue.update(this);
    }
  }

  public static void main(String[] args) {
    WinterCarnival firstCarnival = new WinterCarnival();

  }
}
