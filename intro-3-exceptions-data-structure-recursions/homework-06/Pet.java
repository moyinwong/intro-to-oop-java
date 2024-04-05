public abstract class Pet {
  private String name;
  private double health;
  private int painLevel;

  public Pet(String name, double health, int painLevel) {
    this.name = name;
    this.health = health > 1 ? 1 : health < 0 ? 0 : health;
    this.painLevel = painLevel > 10 ? 10 : painLevel < 1 ? 1 : painLevel;
  }

  public String getName() {
    return this.name;
  }

  public double getHealth() {
    return this.health;
  }

  public int getPainLevel() {
    return this.painLevel;
  }

  public abstract int treat();

  public void speak() {
    String sentence = "Hello! My name is " + this.name;
    System.out.println(this.painLevel > 5 ? sentence.toUpperCase() : sentence);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Pet) {
      Pet pet = (Pet) o;
      return pet.name.equals(this.name);
    }
    return false;
  }

  protected void heal() {
    this.health = 1;
    this.painLevel = 1;
  }
}
