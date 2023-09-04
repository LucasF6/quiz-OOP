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
    return null;
  }

  @Override
  protected void modifyHuman(Human human) {}
  
}
