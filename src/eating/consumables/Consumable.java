package eating.consumables;

import java.util.Set;

import eating.dishes.Dish.Type;
import eating.humans.Human;

public abstract class Consumable {
  private boolean isEaten = false;

  /**
   * Modifies the human's thirst and hunger points, and then makes the consumable impossible to eat
   * again.
   * 
   * @param human The human who is eating the consumable
   */
  public final void getConsumedBy(Human human) {
    if (isEaten) {
      return;
    }
    modifyHuman(human);
    isEaten = true;
  }

  /**
   * @return true if the consumable was eaten already
   */
  public final boolean isEaten() {
    return isEaten;
  }

  /**
   * Required dishes could be plates, glasses, forks, knives, or spoons. 
   * 
   * @return the types of dishes required to eat the consumable
   */
  public abstract Set<Type> getRequiredDishes();

  /**
   * Modifies the hunger points or thirst points of the human
   * 
   * @param human the human to modify
   */
  protected abstract void modifyHuman(Human human);

}