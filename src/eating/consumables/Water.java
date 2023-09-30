package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Water extends Consumable {

  /**
   * @return a set containing precisely one glass
   */
  @Override
  public Set<Type> getRequiredDishes() {
    return Set.of(Type.GLASS);
  }

  /**
   * Replenishes the thirst points of the human by 15 points
   */
  @Override
  protected void modifyHuman(Human human) {
    human.replenishThirstPoints(15);
  }
  
}
