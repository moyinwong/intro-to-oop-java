import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {
  private File patientFile;
  private int day;

  public Clinic(File file) {
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  public String nextDay(File f) throws FileNotFoundException {
    Scanner scanner = new Scanner(f);
    Scanner input = new Scanner(System.in);

    StringBuilder stringBuilder = new StringBuilder();

    while (scanner.hasNextLine()) {
      String[] appointmentInfo = scanner.nextLine().split(",");
      String name = appointmentInfo[0];
      String type = appointmentInfo[1];
      String time = appointmentInfo[3];
      boolean isCat = type.equals("Cat");
      boolean isDog = type.equals("Dog");
      double droolRate = 0;
      int miceCaught = 0;

      if (!isCat && !isDog) {
        throw new InvalidPetException();
      }

      if (isCat) {
        miceCaught = Integer.valueOf(appointmentInfo[2]);
      } else {
        droolRate = Double.valueOf(appointmentInfo[2]);
      }

      boolean isSuccess = false;
      double health = 0;
      int painLevel = 0;
      while (!isSuccess) {
        try {
          System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", name, type, time, name);
          health = input.nextDouble();
          isSuccess = true;
        } catch (InputMismatchException e) {
          input.nextLine();
          System.out.println("Please enter a number");
        }
      }

      isSuccess = false;
      while (!isSuccess) {
        try {
          System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
          painLevel = input.nextInt();
          isSuccess = true;
        } catch (InputMismatchException e) {
          input.nextLine();
          System.out.println("Please enter a number");
        }
      }

      Pet pet = isCat ? new Cat(name, health, painLevel, miceCaught) : new Dog(name, health, painLevel, droolRate);
      pet.speak();

      int minutesToTreat = pet.treat();
      String leftTime = addTime(time, minutesToTreat);

      String info = String.format("%s,%s,%f,Day %d,%s,%s,%.1f,%d\n",
          name,
          type,
          isCat ? miceCaught : droolRate,
          day,
          time,
          leftTime,
          health,
          painLevel);

      stringBuilder.append(info);
    }

    scanner.close();
    input.close();
    day++;
    return stringBuilder.toString();
  }

  public String nextDay(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    return nextDay(file);
  }

  public boolean addToFile(String patientInfo) {
    PrintWriter filePrint = null;
    StringBuilder stringBuilder = new StringBuilder();

    try {
      Scanner scanner = new Scanner(patientFile);

      String[] info = patientInfo.split(",");
      String name = info[0];
      int day = Integer.valueOf(info[3].split(" ")[1]);
      String timeIn = info[4];
      String timeOut = info[5];
      double health = Double.valueOf(info[6]);
      int painLevel = Integer.valueOf(info[7]);

      boolean isOldPatient = false;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] existingPatient = line.split(",");

        if (existingPatient[0].equals(name)) {
          String newInfo = String.format("Day %d,%s,%s,%.1f,%d",
              day,
              timeIn,
              timeOut,
              health,
              painLevel);
          line = line + "," + newInfo;
          isOldPatient = true;
        }

        stringBuilder.append(line + '\n');
      }

      if (!isOldPatient) {
        stringBuilder.append(patientInfo);
      }

      filePrint = new PrintWriter(patientFile);
      filePrint.println(stringBuilder.toString());
      return true;
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      return false;
    } finally {
      if (filePrint != null) {
        filePrint.close();
      }
    }

  }

  private String addTime(String timeIn, int treatmentTime) {
    int hour = Integer.valueOf(timeIn.substring(0, 2));
    int minutes = Integer.valueOf(timeIn.substring(2));
    int timespan = minutes + treatmentTime;
    int leftHour = hour + ((minutes + treatmentTime) / 60);
    int leftMinutes = (timespan % 60);
    ;

    String leftTime = "" + (leftHour < 10 ? "0" + leftHour : leftHour) + leftMinutes;
    return leftTime;
  }

}
