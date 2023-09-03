package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Water extends Consumable {

  @Override
  protected void modifyHuman(Human human) {
    human.replenishThirstPoints(15);
  }

  @Override
  public Set<Type> getRequiredDishes() {
    return Set.of(Type.GLASS);
  }
  
}
