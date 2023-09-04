package eating.dishes;

public class Dish {
  private Type type;
  private boolean isClean = true;
  protected DishLocation location;

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
  public Dish(Type type) {
    this.type = type;
  }

  /** 
   * @return the type of dish as given in the constructor
   */
  public Type getType() {
    return type;
  }

  /**
   * Makes the dish dirty
   */
  public void use() {
    isClean = false;
  }

  /**
   * @return true if the dish is clean
   */
  public boolean isClean() {
    return isClean;
  }

  /**
   * Makes the dish clean
   */
  protected void wash() {
    isClean = true;
  }
  
}
