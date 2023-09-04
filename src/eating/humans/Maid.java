package eating.humans;

import eating.dishes.DishWasher;
import eating.dishes.Table;

public class Maid extends Human {

  /**
   * Creates a maid with the given hunger points and thirst points. The values of hunger points
   * and thirst points should be clamped to the range [0, 100]. 
   * 
   * @param hungerPoints
   * @param thirstPoints
   */
  public Maid(int hungerPoints, int thirstPoints) {
    super(hungerPoints, thirstPoints);
  }

  /**
   * Uses the dishwasher to wash all of the dishes on the table and put them back. This method
   * reduces the maid's hunger and thirst points by 10. If the maid is frustrated or does not have
   * high enough hunger or thirst points, this method does nothing.
   * 
   * @param table
   * @param dishWasher
   */
  public void washDishesOnTable(Table table, DishWasher dishWasher) {}
  
}
