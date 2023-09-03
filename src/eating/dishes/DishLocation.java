package eating.dishes;

import java.util.HashSet;
import java.util.Set;

import eating.dishes.Dish.Type;

public class DishLocation {
  protected Set<Dish> heldDishes = new HashSet<>();
  
  /**
   * Stores the list of dishes
   * 
   * @param dishes the dishes to store
   */
  public void addDish(Dish... dishes) {
    for (Dish dish : dishes) {
      if (dish.location == null) {
        heldDishes.add(dish);
        dish.location = this;
      }
    }
  }

  /**
   * Stops storing the list of dishes
   * 
   * @param dishes the dishes to stop storing
   */
  public void removeDish(Dish... dishes) {
    for (Dish dish : dishes) {
      if (this.equals(dish.location)) {
        heldDishes.remove(dish);
        dish.location = null;
      }
    }
  }

  /**
   * @return The dishes that are being stored
   */
  public Set<Dish> getHeldDishes() {
    return new HashSet<>(heldDishes);
  }

  /**
   * Gets one of the stored dishes of the given type if it is clean
   * 
   * @param type the type of clean dish to get
   * @return the clean dish or null if there aren't any
   */
  public Dish getClean(Type type) {
    for (Dish dish : heldDishes) {
      if (type == dish.getType() && dish.isClean()) {
        return dish;
      }
    }
    return null;
  }

}