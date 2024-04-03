import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
  private int numTasks;
  private int taskSpeed;

  private static int DEFAULT_SUS_LEVEL = 15;
  private static int DEFAULT_NUM_TASKS = 6;
  private static int DEFAULT_TASK_SPEED = 10;

  public BlueAstronaut(String name) {
    this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
  }

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public void emergencyMeeting() {
    if (isFrozen()) {
      return;
    }

    Player[] players = Player.getPlayers();

    Arrays.sort(players);

    Player playerToBeOff = null;
    for (int i = players.length - 1; i >= 0; i--) {
      if (players[i].isFrozen()) {
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

  public void completeTask() {
    if (isFrozen() || this.numTasks == 0) {
      return;
    }

    this.numTasks -= this.taskSpeed > 20 ? 2 : 1;

    if (this.numTasks < 0) {
      this.numTasks = 0;
    }

    if (this.numTasks == 0) {
      System.out.println("I have completed all my tasks");
      this.setSusLevel((int) (this.getSusLevel() * 0.5));
    }
  }

  @Override
  public boolean equals(Object p) {
    if (p instanceof BlueAstronaut) {
      BlueAstronaut blue = (BlueAstronaut) p;
      return blue.getName().equals(this.getName()) &&
          blue.isFrozen() == isFrozen() &&
          blue.getSusLevel() == getSusLevel() &&
          blue.getNumTasks() == this.getNumTasks() &&
          blue.getTaskSpeed() == this.getTaskSpeed();
    }
    return false;
  }

  @Override
  public String toString() {
    String intro = super.toString();
    String full = intro + " I have " + this.numTasks + " left over.";
    return this.getSusLevel() > 15 ? full.toUpperCase() : full;
  }

  public int getNumTasks() {
    return this.numTasks;
  }

  public int getTaskSpeed() {
    return this.taskSpeed;
  }
}
