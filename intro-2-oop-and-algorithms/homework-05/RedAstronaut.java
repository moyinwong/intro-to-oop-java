import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
  private String skill;

  private static int DEFAULT_SUS_LEVEL = 15;
  private static String DEFAULT_SKILL = "experienced";

  public RedAstronaut(String name) {
    this(name, DEFAULT_SUS_LEVEL, DEFAULT_SKILL);
  }

  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }

  public void emergencyMeeting() {
    if (isFrozen()) {
      return;
    }

    Player[] players = Player.getPlayers();

    Arrays.sort(players);

    Player playerToBeOff = null;
    for (int i = players.length - 1; i >= 0; i--) {
      if (players[i].isFrozen() || players[i].equals(this)) {
        continue;
      }
      if (players[i].getSusLevel() == players[i - 1].getSusLevel()) {
        return;
      }

      playerToBeOff = players[i];
      break;
    }
    if (players[players.length - 1] == players[players.length - 2]) {
      return;
    }

    if (playerToBeOff != null) {
      playerToBeOff.setFrozen(true);
    }

    gameOver();
  }

  public void freeze(Player p) {
    if (isFrozen() || p instanceof Impostor || p.isFrozen()) {
      return;
    }

    if (getSusLevel() < p.getSusLevel()) {
      p.setFrozen(true);
    } else {
      setSusLevel(getSusLevel() * 2);
    }

    gameOver();
  }

  public void sabotage(Player p) {
    if (isFrozen() || p instanceof Impostor || p.isFrozen()) {
      return;
    }

    if (getSusLevel() < 20) {
      p.setSusLevel(p.getSusLevel() / 2 + p.getSusLevel());
    } else {
      p.setSusLevel(p.getSusLevel() / 4 + p.getSusLevel());
    }
  }

  @Override
  public boolean equals(Object p) {
    if (p instanceof RedAstronaut) {
      RedAstronaut red = (RedAstronaut) p;
      return red.getName() == getName() &&
          red.isFrozen() == isFrozen() &&
          red.getSusLevel() == getSusLevel() &&
          red.getSkill() == skill;
    }
    return false;
  }

  @Override
  public String toString() {
    String intro = super.toString();
    String full = intro + " I am an " + skill + " player!";
    return this.getSusLevel() > 15 ? full.toUpperCase() : full;
  }

  public String getSkill() {
    return skill;
  }
}
