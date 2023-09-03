package eating.dishes;

import java.util.HashSet;
import java.util.Set;

import eating.humans.Human;

public class Table extends DishLocation {
  Set<Human> sittingHumans = new HashSet<>();

  public void addHuman(Human human) {
    sittingHumans.add(human);
  }

  public void removeHuman(Human human) {
    sittingHumans.remove(human);
  }


}
