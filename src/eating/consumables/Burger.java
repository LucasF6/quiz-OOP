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

  @Override
  protected void modifyHuman(Human human) {}
  
}
