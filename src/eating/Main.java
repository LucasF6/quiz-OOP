package eating;

import eating.consumables.Burger;
import eating.consumables.Steak;
import eating.consumables.Water;
import eating.dishes.Dish;
import eating.dishes.DishWasher;
import eating.dishes.Table;
import eating.dishes.Dish.Type;
import eating.humans.Human;
import eating.humans.Maid;
import eating.humans.Human.Health;

public class Main {

  public static void main(String[] args) {
    boolean correct = true;

    Human fred = new Human(150, 100);
    Human sam = new Human(100, -50);

    // fred: 100, 100
    // sam: 100, 0
    if (fred.isFrustrated() || sam.isFrustrated() || fred.getHealth() != Health.FEELING_GOOD || sam.getHealth() != Health.DEHYDRATED) {
      correct = false;
    }

    Water water = new Water();
    Table table1 = new Table();
    Dish glass1 = new Dish(Type.GLASS);
    table1.addDish(glass1);
    sam.consume(water); // fail (not sitting at table)
    // sam should be frustrated
    
    if (!sam.isFrustrated()) {
      correct = false;
    }

    sam.sitAtTable(table1);
    sam.consume(water); // success
    // sam should no longer be frustrated
    // the glass should be dirty 

    if (sam.isFrustrated()) {
      correct = false;
    }

    water = new Water();
    sam.consume(water); // fail (dirty glass)
    // sam should be frustrated

    if (!sam.isFrustrated()) {
      correct = false;
    }

    Dish glass2 = new Dish(Type.GLASS);
    table1.addDish(glass2);
    sam.consume(water); // success
    // sam should no longer be frustrated
    // glass1 and glass2 are now dirty
    
    // sam: 100, 30
    if (sam.isFrustrated() || glass1.isClean() || glass2.isClean() || sam.getHealth() != Health.FEELING_GOOD) {
      correct = false;
    }

    sam.runMile();

    if (sam.getHealth() != Health.DEHYDRATED) {
      correct = false;
    }

    DishWasher dishWasher = new DishWasher();
    dishWasher.addDish(glass1); // fail (glass1 is on the table)
    dishWasher.washDishes();
    water = new Water();
    sam.consume(water); // fail (glass1 is dirty)
    // sam should be frustrated

    if (!sam.isFrustrated()) {
      correct = false;
    }

    table1.removeDish(glass1, glass2);
    dishWasher.addDish(glass1, glass2);
    dishWasher.washDishes();
    dishWasher.removeDish(glass1, glass2);
    table1.addDish(glass1, glass2);
    sam.consume(water); // success
    water = new Water();
    sam.consume(water); // success
    // sam should not be frustrated

    if (sam.isFrustrated()) {
      correct = false;
    }

    water = new Water();
    sam.consume(water); // fail (glass1 and glass2 are dirty)
    // sam should be frustrated

    if (!sam.isFrustrated()) {
      correct = false;
    }

    table1.removeDish(glass1, glass2);
    dishWasher.addDish(glass1,glass2);
    dishWasher.washDishes();
    dishWasher.removeDish(glass1, glass2);
    table1.addDish(glass1, glass2);
    sam.consume(water); // success: sam is no longer frustrated
    Table table2 = new Table();
    Dish fork = new Dish(Type.FORK);
    Dish knife = new Dish(Type.KNIFE);
    Dish plate1 = new Dish(Type.PLATE);
    table2.addDish(fork, knife, plate1);
    Steak steak = new Steak();
    sam.sitAtTable(table2); // fail (Sam is sitting at table1)
    sam.consume(steak); // fail (none of the required dishes are there)
    // sam should be frustrated

    if (!sam.isFrustrated()) {
      correct = false;
    }
    
    water = new Water();
    sam.consume(water); // success: sam is no longer frustrated
    sam.getUpFromTable();
    sam.sitAtTable(table2);
    sam.consume(steak); // success: sam shouldn't be frustrated

    if (sam.isFrustrated()) {
      correct = false;
    }

    table2.removeDish(fork, knife, plate1);
    dishWasher.addDish(fork, knife, plate1);
    dishWasher.washDishes();
    dishWasher.removeDish(fork, knife, plate1);
    table2.addDish(fork, knife, plate1);
    Dish plate2 = new Dish(Type.PLATE);
    Dish plate3 = new Dish(Type.PLATE);
    table2.addDish(plate2, plate3);
    steak = new Steak();
    Burger burger = new Burger();
    fred.sitAtTable(table2);
    fred.consume(steak); // success
    fred.consume(burger); // success
    burger = new Burger();
    sam.consume(burger); // success

    if (sam.isFrustrated() || fred.isFrustrated()) {
      correct = false;
    }

    sam.consume(burger); // fail (no clean plates)

    if (!sam.isFrustrated()) {
      correct = false;
    }
    
    fred.runMile();
    fred.runMile();
    fred.runMile();
    fred.runMile();
    fred.runMile();
    fred.runMile(); // fail (dehydrated, so fred doesn't run. His hunger isn't extreme)

    if (fred.getHealth() != Health.DEHYDRATED) {
      correct = false;
    }

    Maid maid = new Maid(10, 20);
    maid.washDishesOnTable(table2, dishWasher);
    maid.sitAtTable(table2);
    steak = new Steak();
    burger = new Burger();
    fred.consume(steak); // success because the maid cleaned all the required dishes

    if (fred.isFrustrated()) {
      correct = false;
    }

    maid.washDishesOnTable(table2, dishWasher); // fail (the maid is too tired)
    steak = new Steak();
    fred.consume(steak); // fail (the dishes required for the steak are dirty)

    if (!fred.isFrustrated()) {
      correct = false;
    }

    maid.consume(burger); // success (there is still a clean plate)
    maid.washDishesOnTable(table2, dishWasher); // success
    fred.consume(steak); // success

    if (maid.isFrustrated() || fred.isFrustrated()) {
      correct = false;
      System.out.println("here");
    }

    if (correct) {
      System.out.println("You got it!");
    } else {
      System.out.println("Something wrong happened.");
    }
  }

}
