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

  public Dish(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void use() {
    isClean = false;
  }

  protected void wash() {
    isClean = true;
  }

  public boolean isClean() {
    return isClean;
  }
}
