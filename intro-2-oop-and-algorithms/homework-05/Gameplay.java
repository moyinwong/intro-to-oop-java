public class Gameplay {
  public static void main(String[] args) {
    BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
    RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
    RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

    liam.sabotage(bob);
    System.out.println(bob);

    liam.sabotage(suspiciousPerson);
    System.out.println(suspiciousPerson);

    liam.freeze(albert);
    System.out.println(liam);
    System.out.println(albert);

    albert.emergencyMeeting();
    suspiciousPerson.emergencyMeeting();
    bob.emergencyMeeting();
    System.out.println(suspiciousPerson);

    heath.completeTask();
    System.out.println(heath);

    heath.completeTask();
    System.out.println(heath);

    heath.completeTask();

    liam.freeze(angel);
    System.out.println(angel);
    System.out.println(liam);

    liam.sabotage(bob);
    liam.sabotage(bob);
    System.out.println(bob);

    liam.freeze(bob);
    System.out.println(bob);

    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    System.out.println(heath);
    liam.freeze(heath);
  }
}
