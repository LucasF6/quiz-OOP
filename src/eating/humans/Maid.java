package eating.humans;

import java.util.Set;

import eating.dishes.Dish;
import eating.dishes.DishWasher;
import eating.dishes.Table;

public class Maid extends Human {

  public Maid(int hungerPoints, int thirstPoints) {
    super(hungerPoints, thirstPoints);
  }

  public void washDishesOnTable(Table table, DishWasher dishWasher) {
    if (isFrustrated || hungerPoints < 10 || thirstPoints < 10) {
      return;
    }
    
    hungerPoints -= 10;
    thirstPoints -= 10;

    Set<Dish> dishes = table.getHeldDishes();
    for (Dish dish : dishes) {
      table.removeDish(dish);
      dishWasher.addDish(dish);
    }
    dishWasher.washDishes();
    for (Dish dish : dishes) {
      dishWasher.removeDish(dish);
      table.addDish(dish);
    }
  }
  
}
