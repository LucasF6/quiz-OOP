package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Steak extends Consumable {

  @Override
  protected void modifyHuman(Human human) {
    human.replenishHungerPoints(40);
  }

  public Set<Type> getRequiredDishes() {
    return Set.of(Type.PLATE, Type.FORK, Type.KNIFE);
  }
  
}
