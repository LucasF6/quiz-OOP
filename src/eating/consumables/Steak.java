package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Steak extends Consumable {

  /**
   * @return a set containing precisely one plate, one fork, and one knife
   */
  public Set<Type> getRequiredDishes() {
    return Set.of(Type.PLATE, Type.FORK, Type.KNIFE);
  }

  @Override
  protected void modifyHuman(Human human) {
    human.replenishHungerPoints(40);
  }
  
}
