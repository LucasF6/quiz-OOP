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

  public Human(int hungerPoints, int thirstPoints) {
    if (hungerPoints > 100) hungerPoints = 100;
    if (hungerPoints < 0) hungerPoints = 0;
    if (thirstPoints > 100) thirstPoints = 100;
    if (thirstPoints < 0) thirstPoints = 0;
    this.hungerPoints = hungerPoints;
    this.thirstPoints = thirstPoints;
  }

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

  public boolean sitAtTable(Table table) {
    if (this.table != null) {
      return false;
    }
    this.table = table;
    table.addHuman(this);
    return true;
  }

  public void getUpFromTable() {
    if (table == null) {
      return;
    }
    table.removeHuman(this);
    table = null;
  }

  public void replenishHungerPoints(int count) {
    if (hungerPoints + count > 100) {
      hungerPoints = 100;
    } else {
      hungerPoints += count;
    }
  }

  public void replenishThirstPoints(int count) {
    if (thirstPoints + count > 100) {
      thirstPoints = 100;
    } else {
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

  public boolean isFrustrated() {
    return isFrustrated;
  }

  public Health getHealth() {
    if (hungerPoints < 20 && thirstPoints < 20) return Health.NEAR_DEATH;
    if (hungerPoints >= 20 && thirstPoints < 20) return Health.DEHYDRATED;
    if (hungerPoints < 20 && thirstPoints >= 20) return Health.HUNGRY;
    return Health.FEELING_GOOD;
  }

}
