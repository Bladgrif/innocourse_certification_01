package learn.innopolis.university.task_02;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static learn.innopolis.university.task_02.Sensor.getHumiditySensor;

public class Cactus implements WateringDate {

    private int humidity = getHumiditySensor();

    public int getHumidity() {
        return humidity;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate nextWateringDate(String date) {
        LocalDate localDate = LocalDate.parse(date, formatter);
        if (localDate.getMonthValue() == 12 || localDate.getMonthValue() <= 2) {
            return nextWateringDateInWinter(localDate);
        } else if (localDate.getMonthValue() > 2 && localDate.getMonthValue() < 6) {
            return nextWateringDateInSpring(localDate);
        } else if (localDate.getMonthValue() > 6 && localDate.getMonthValue() < 9) {
            return nextWateringDateInSummer(localDate);
        } else if (localDate.getMonthValue() > 9 && localDate.getMonthValue() < 12) {
            return nextWateringDateInAutumn(localDate);
        }
        return null;
    }

    private LocalDate nextWateringDateInWinter(LocalDate date) {
        if (date.plusMonths(1).getMonthValue() < 3) {
            return date.plusMonths(1);
        } else if (date.getDayOfMonth() < 7) {
            return date.plusMonths(1);
        } else {
            return date.plusMonths(1).withDayOfMonth(7);
        }
    }

    private LocalDate nextWateringDateInSpring(LocalDate date) {
        if (date.plusWeeks(1).getMonthValue() < 6) {
            return date.plusWeeks(1);
        } else if (Period.between(date.withDayOfMonth(1), date.plusWeeks(1)).getDays() > 2) {
            return nextWateringDateInSummer(date.plusWeeks(1).withDayOfMonth(1));
        } else {
            return nextWateringDateInSummer(date);
        }
    }

    private LocalDate nextWateringDateInSummer(LocalDate date) {
        if (getHumidity() < 30) {
            return date.plusDays(2);
        }
        return LocalDate.parse("01.01.0001", formatter);
    }

    private LocalDate nextWateringDateInAutumn(LocalDate date) {
        return date.plusWeeks(1);
    }
}


