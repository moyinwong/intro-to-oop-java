public class Dog extends Pet {
  private double droolRate;

  public Dog(String name, double health, int painLevel) {
    this(name, health, painLevel, 5.0);
  }

  public Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
  }

  public double getDroolRate() {
    return this.droolRate;
  }

  public int treat() {
    double healthBeforeHeal = this.getHealth();
    int painLevelBeforeHeal = this.getPainLevel();

    this.heal();

    if (this.droolRate < 3.5) {
      return (int) Math.ceil((painLevelBeforeHeal * 2) / healthBeforeHeal);
    }

    if (this.droolRate >= 3.5 && this.droolRate <= 7.5) {
      return (int) Math.ceil(painLevelBeforeHeal / healthBeforeHeal);
    }

    return (int) Math.ceil(painLevelBeforeHeal / (healthBeforeHeal * 2));
  }

  @Override
  public void speak() {
    super.speak();
    String sentence = "";
    int level = this.getPainLevel();
    for (int i = 0; i < this.getPainLevel(); i++) {
      sentence += "bark" + (i == level - 1 ? "" : " ");
    }
    System.out.println(level > 5 ? sentence.toUpperCase() : sentence);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Dog) {
      Dog dog = (Dog) o;
      return super.equals(o) && dog.droolRate == this.droolRate;
    }
    return false;
  }
}
