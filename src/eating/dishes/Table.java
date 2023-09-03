package eating.dishes;

import java.util.HashSet;
import java.util.Set;

import eating.humans.Human;

public class Table extends DishLocation {
  Set<Human> sittingHumans = new HashSet<>();

  /**
   * Lets the human sit at the table
   * 
   * @param human the human to sit
   */
  public void addHuman(Human human) {
    sittingHumans.add(human);
  }

  /**
   * Stops the human from sitting at the table
   * 
   * @param human the human to stop sitting
   */
  public void removeHuman(Human human) {
    sittingHumans.remove(human);
  }


}
