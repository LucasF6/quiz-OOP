package eating.dishes;

public class DishWasher extends DishLocation {
  
  public void washDishes() {
    for (Dish dish : heldDishes) {
      dish.wash();
    }
  }

}
