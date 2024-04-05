public class Cat extends Pet {

  private int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    this.miceCaught = miceCaught < 0 ? 0 : miceCaught;
  }

  public Cat(String name, double health, int painLevel) {
    this(name, health, painLevel, 0);
  }

  public int getMiceCaught() {
    return this.miceCaught;
  }

  public int treat() {
    double healthBeforeHeal = this.getHealth();
    int painLevelBeforeHeal = this.getPainLevel();

    heal();

    if (this.miceCaught < 4) {
      return (int) Math.ceil((painLevelBeforeHeal * 2) / healthBeforeHeal);
    }

    if (this.miceCaught >= 4 && this.miceCaught <= 7) {
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
      sentence += "meow" + (i == level - 1 ? "" : " ");
    }
    System.out.println(level > 5 ? sentence.toUpperCase() : sentence);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Cat) {
      Cat cat = (Cat) o;
      return super.equals(o) && this.miceCaught == cat.miceCaught;
    }
    return false;
  }
}
