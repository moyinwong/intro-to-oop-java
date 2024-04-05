import java.io.FileNotFoundException;

/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

    public static void main(String[] args) {
        Clinic clinic = new Clinic("./intro-3-exceptions-data-structure-recursions/homework-06/Patients.csv");
        String dayOneReport = "";
        try {
            dayOneReport = clinic
                    .nextDay("./intro-3-exceptions-data-structure-recursions/homework-06/Appointments.csv");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        String[] dayOneAppointments = dayOneReport.split("\\n");
        for (String appointment : dayOneAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
    }
}
