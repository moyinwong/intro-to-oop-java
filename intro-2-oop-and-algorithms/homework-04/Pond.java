public class Pond {
  public static void main(String[] args) {
    Frog peepo = new Frog("Peepo");
    Frog pepe = new Frog("Pepe", 10, 15);
    Frog peepaw = new Frog("Peepaw", 4.6, 5);
    Frog peelo = new Frog("Peelo", 2, 7);

    Fly flyA = new Fly(1, 3);
    Fly flyB = new Fly(6);
    Fly flyC = new Fly(2, 2);

    Frog.setSpecies("1331 Frogs");

    System.out.println(peepo);
    peepo.eat(flyB);
    System.out.println(flyB);

    peepo.grow(8);
    peepo.eat(flyB);
    System.out.println(flyB);
    System.out.println(peepo);

    System.out.println(peelo);

    peepaw.grow(4);
    System.out.println(peepaw);

    System.out.println(pepe);
  }
}
