package eating.dishes;

import java.util.HashSet;
import java.util.Set;

import eating.dishes.Dish.Type;

public class DishLocation {
  protected Set<Dish> heldDishes = new HashSet<>();
  
  public void addDish(Dish... dishes) {
    for (Dish dish : dishes) {
      if (dish.location == null) {
        heldDishes.add(dish);
        dish.location = this;
      }
    }
  }

  public void removeDish(Dish... dishes) {
    for (Dish dish : dishes) {
      if (this.equals(dish.location)) {
        heldDishes.remove(dish);
        dish.location = null;
      }
    }
  }

  public Set<Dish> getHeldDishes() {
    return new HashSet<>(heldDishes);
  }

  public Dish getClean(Type type) {
    for (Dish dish : heldDishes) {
      if (type == dish.getType() && dish.isClean()) {
        return dish;
      }
    }
    return null;
  }

}