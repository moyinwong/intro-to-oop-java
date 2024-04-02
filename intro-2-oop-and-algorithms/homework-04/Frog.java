public class Frog {
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";

  private static final int DEFAULT_AGE = 5;
  private static final double DEFAULT_TONGUE_SPEED = 5.0;

  public Frog(String name) {
    this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int) (ageInYears * 12), tongueSpeed);
  }

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    this.isFroglet = age > 1 && age < 7;
  }

  public static String getSpecies() {
    return species;
  }

  public static void setSpecies(String species) {
    Frog.species = species;
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }

    if (tongueSpeed > fly.getSpeed() && fly.getMass() >= (0.5 * age)) {
      grow();
      fly.setMass(0);
    } else if (tongueSpeed <= fly.getSpeed()) {
      fly.grow(1);
    }
  }

  public String toString() {
    String froglotText = "My name is " + name + " and I’m a rare froglet! I’m " + age
        + " months old and my tongue has a speed of " + tongueSpeed + ".";
    String frogText = "My name is " + name + " and I’m a rare frog. I’m " + age
        + " months old and my tongue has a speed of " + tongueSpeed + ".";
    return isFroglet ? froglotText : frogText;
  }

  public void grow(int months) {
    while (months > 0) {
      age++;

      if (age <= 12) {
        tongueSpeed++;
      }
      if (age >= 30 && tongueSpeed > 5) {
        tongueSpeed--;
      }

      months--;
    }

    isFroglet = age > 1 && age < 7;
  }

  public void grow() {
    age++;

    if (age < 12) {
      tongueSpeed++;
    }
    if (age >= 30 && tongueSpeed > 5) {
      tongueSpeed--;
    }

    isFroglet = age > 1 && age < 7;
  }
}
