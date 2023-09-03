package eating.humans;

import eating.consumables.Consumable;
import eating.dishes.Table;
import eating.dishes.Dish.Type;

public class Human {
  protected int hungerPoints;
  protected int thirstPoints;
  protected boolean isFrustrated;
  private Table table;

  public enum Health {
    NEAR_DEATH,  // HP < 20 and TP < 20
    DEHYDRATED,  // HP >= 20 and TP < 20
    HUNGRY,      // HP < 20 and TP >= 20
    FEELING_GOOD // HP >= 20 and TP >= 20
  }

  /**
   * Creates a human with the given hunger points and thirst points. The values of hunger points
   * and thirst points should be clamped to the range [0, 100]. 
   * 
   * @param hungerPoints
   * @param thirstPoints
   */
  public Human(int hungerPoints, int thirstPoints) {
    if (hungerPoints > 100) hungerPoints = 100;
    if (hungerPoints < 0) hungerPoints = 0;
    if (thirstPoints > 100) thirstPoints = 100;
    if (thirstPoints < 0) thirstPoints = 0;
    this.hungerPoints = hungerPoints;
    this.thirstPoints = thirstPoints;
  }

  /**
   * If the human is not sitting at a table with the appropriate clean dishes, then they aren't
   * able to eat the food. Otherwise, they do eat the food. The logic for the changing of 
   * hunger or thirst points should be in the subclasses of Consumable. If the human fails to eat
   * the consumable, then he or she becomes frustrated. Otherwise, he or she is not frustrated.
   * 
   * @param consumable the thing being eaten
   * @return true if the human successfully ate the consumable
   */
  public boolean consume(Consumable consumable) {
    if (table == null || consumable.isEaten()) {
      isFrustrated = true;
      return false;
    }
    for (Type type : consumable.getRequiredDishes()) {
      if (table.getClean(type) == null) {
        isFrustrated = true;
        return false;
      }
    }
    for (Type type : consumable.getRequiredDishes()) {
      table.getClean(type).use();
    }
    consumable.getConsumedBy(this);
    isFrustrated = false;
    return true;
  }

  /**
   * The human sits at the given table. To do this, the table adds the human to one of its seats.
   * If the human is already sitting at another table, then this method does nothing. 
   * 
   * @param table what the human is sitting at
   * @return true if the human successfully sat at the table
   */
  public boolean sitAtTable(Table table) {
    if (this.table != null) {
      return false;
    }
    this.table = table;
    table.addHuman(this);
    return true;
  }

  /**
   * The human removes him or herself from the table
   */
  public void getUpFromTable() {
    if (table == null) {
      return;
    }
    table.removeHuman(this);
    table = null;
  }

  /**
   * The human's hunger points increases by count. If this increases his hunger points over 100,
   * then his hunger points becomes 100. If this count is negative, then the method does nothing.
   * 
   * @param count the amount to increase the hunger points by
   */
  public void replenishHungerPoints(int count) {
    if (hungerPoints + count > 100) {
      hungerPoints = 100;
    } else if (count > 0) {
      hungerPoints += count;
    }
  }

  /**
   * The human's thirst points increases by count. If this increases his hunger points over 100,
   * then his thirst points becomes 100. If this count is negative, then the method does nothing.
   * 
   * @param count the amount to increase the hunger points by
   */
  public void replenishThirstPoints(int count) {
    if (thirstPoints + count > 100) {
      thirstPoints = 100;
    } else if (count > 0) {
      thirstPoints += count;
    }
  }

  /**
   * Lowers hunger points by 15 and thirst points by 20
   * Does not work if neither hunger points nor thirst points are high enough
   * 
   * @return true if hunger points and thirst points were changed
   */
  public boolean runMile() {
    if (hungerPoints >= 15 && thirstPoints >= 20) {
      hungerPoints -= 15;
      thirstPoints -= 20;
      return true;
    }
    return false;
  }

  /**
   * @return true if the human is frustrated
   */
  public boolean isFrustrated() {
    return isFrustrated;
  }

  /**
   * HP < 20 and TP < 20 --> NEAR_DEATH
   * HP >= 20 and TP < 20 --> DEHYDRATED
   * HP < 20 and TP >= 20 --> HUNGRY
   * HP >= 20 and TP >= 20 --> FEELING_GOOD
   * 
   * @return the health of the human by the rules above
   */
  public Health getHealth() {
    if (hungerPoints < 20 && thirstPoints < 20) return Health.NEAR_DEATH;
    if (hungerPoints >= 20 && thirstPoints < 20) return Health.DEHYDRATED;
    if (hungerPoints < 20 && thirstPoints >= 20) return Health.HUNGRY;
    return Health.FEELING_GOOD;
  }

}
