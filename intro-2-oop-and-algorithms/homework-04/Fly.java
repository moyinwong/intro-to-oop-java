public class Fly {
  private double mass;
  private double speed;

  private static final double DEFAULT_MASS = 5.0;
  private static final double DEFAULT_SPEED = 10.0;

  public Fly() {
    this(DEFAULT_MASS, DEFAULT_SPEED);
  }

  public Fly(double mass) {
    this(mass, DEFAULT_SPEED);
  }

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public double getMass() {
    return mass;
  }

  public void setMass(double mass) {
    this.mass = mass;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public String toString() {
    final double roundedSpeed = Math.floor(speed * 100) / 100;
    final double roundedMass = Math.floor(mass * 100) / 100;
    final String dead = "I’m dead, but I used to be a fly with a speed of " + roundedSpeed + ".";
    final String alive = "I’m a speedy fly with " + roundedSpeed + " speed and " + roundedMass + " mass.";
    return isDead() ? dead : alive;
  }

  public boolean isDead() {
    return mass == 0;
  }

  public void grow(int newMass) {
    while (newMass > 0) {
      mass++;
      if (mass <= 20) {
        speed++;
      } else if (mass > 20) {
        speed -= 0.5;
      }
      newMass--;
    }
  }
}
