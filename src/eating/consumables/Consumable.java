package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public abstract class Consumable {
  private boolean isEaten = false;

  public final void getConsumedBy(Human human) {
    if (isEaten) {
      return;
    }
    modifyHuman(human);
    isEaten = true;
  }

  public final boolean isEaten() {
    return isEaten;
  }

  protected abstract void modifyHuman(Human human);

  public abstract String getName();

  public abstract Set<Type> getRequiredDishes();

}