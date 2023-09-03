package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public class Burger extends Consumable {

  @Override
  protected void modifyHuman(Human human) {
    human.replenishHungerPoints(25);
  }

  @Override
  public String getName() {
    return "burger";
  }

  @Override
  public Set<Type> getRequiredDishes() {
    return Set.of(Type.PLATE);
  }
  
}
