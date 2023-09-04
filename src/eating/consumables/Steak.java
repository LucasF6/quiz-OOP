package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Steak extends Consumable {

  /**
   * @return a set containing precisely one plate, one fork, and one knife
   */
  @Override
  public Set<Type> getRequiredDishes() {
    return null;
  }

  @Override
  protected void modifyHuman(Human human) {}
  
}
