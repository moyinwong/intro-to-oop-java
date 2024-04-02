public class Fly {
  private float mass;
  private double speed;

  private static final float DEFAULT_MASS = 5.0f;
  private static final double DEFAULT_SPEED = 10.0;

  public Fly() {
    this(DEFAULT_MASS, DEFAULT_SPEED);
  }

  public Fly(float mass) {
    this(mass, DEFAULT_SPEED);
  }

  public Fly(float mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public float getMass() {
    return mass;
  }

  public void setMass(float mass) {
    this.mass = mass;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public String toString() {
    final double roundedSpeed = Math.round(speed * 100) / 100;
    final double roundedMass = Math.round(mass * 100) / 100;
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
      if (mass < 20) {
        speed++;
      } else {
        speed -= 0.5;
      }
      newMass--;
    }
  }
}
