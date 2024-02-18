import learn.innopolis.university.task_02.Cactus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CactusTest {

    @Test
    public void testNextWateringDateInWinter1() {
        Cactus cactus = new Cactus();
        String lastDate = "01.12.2024";
        LocalDate result = cactus.nextWateringDate(lastDate);
        assertEquals(LocalDate.of(2025, 1, 1), result);
    }

    @Test
    public void testNextWateringDateInWinter2() {
        Cactus cactus = new Cactus();
        String lastDate = "29.02.2024";
        LocalDate result = cactus.nextWateringDate(lastDate);
        assertEquals(LocalDate.of(2024, 3, 7), result);
    }

    @Test
    public void testNextWateringDateInWinter3() {
        Cactus cactus = new Cactus();
        String lastDate = "28.02.2024";
        LocalDate result = cactus.nextWateringDate(lastDate);
        assertEquals(LocalDate.of(2024, 3, 7), result);
    }

    @Test
    public void testNextWateringDateInSpring1() {
        Cactus cactus = new Cactus();
        String lastDate = "01.03.2024";
        LocalDate result = cactus.nextWateringDate(lastDate);
        assertEquals(LocalDate.of(2024, 3, 8), result);
    }
    @Test
    public void testNextWateringDateInSpring2() {
        Cactus cactus = new Cactus();
        String lastDate = "01.04.2024";
        LocalDate result = cactus.nextWateringDate(lastDate);
        assertEquals(LocalDate.of(2024, 4, 8), result);
    }
    @Test
    public void testNextWateringDateInSpring3() {
        Cactus cactus = new Cactus();
        String lastDate = "31.05.2024";
        LocalDate result = cactus.nextWateringDate(lastDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        int humidity = cactus.getHumidity();
        if (humidity < 30) {
            assertEquals(LocalDate.of(2024, 6, 3), result);
        }
        else {
            assertEquals(LocalDate.parse("01.01.0001", formatter), result);
        }
    }
}