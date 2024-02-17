package learn.innopolis.university.task_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the last date for watering the cactus in the format dd.mm.yyyy: ");
        try {
            String lastDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            Cactus cactus = new Cactus();
            LocalDate date = cactus.nextWateringDate(lastDate);
            if (!date.minusYears(300).equals(date)) { //date.minusYears(300) - This is an option if the humidity is high and watering is not needed
                System.out.println("Next watering date: " + formatter.format(date));
            } else {
                System.out.println("Humidity too high, no need to water");
            }
        } catch (Exception e) {
            System.out.println("Input Error. Make sure you entered the date in the correct format (dd.MM.yyyy).");
        }
    }
}
