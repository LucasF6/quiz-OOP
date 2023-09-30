package eating.dishes;

public class Dish {

  public enum Type {
    PLATE,
    GLASS,
    FORK,
    KNIFE,
    SPOON
  }

  /**
   * Constructs a dish with the given type
   * 
   * @param type The type of dish being constructed
   */
  public Dish(Type type) {}

  /** 
   * @return the type of dish as given in the constructor
   */
  public Type getType() {
    return null;
  }

  /**
   * Makes the dish dirty
   */
  public void use() {}

  /**
   * @return true if the dish is clean
   */
  public boolean isClean() {
    return false;
  }

  /**
   * Makes the dish clean
   */
  protected void wash() {}
  
}
