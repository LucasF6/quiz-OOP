package eating.dishes;

public class DishWasher extends DishLocation {
  
  /**
   * Washes all stored dishes
   */
  public void washDishes() {
    for (Dish dish : heldDishes) {
      dish.wash();
    }
  }

}
