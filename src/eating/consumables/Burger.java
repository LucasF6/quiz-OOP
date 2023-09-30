package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Burger extends Consumable {

  /**
   * @return a set containing precisely one plate
   */
  @Override
  public Set<Type> getRequiredDishes() {
    return null;
  }

  /**
   * Replenishes the hunger points of the human by 25 points
   */
  @Override
  protected void modifyHuman(Human human) {}
  
}
