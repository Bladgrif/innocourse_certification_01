import learn.innopolis.university.task_02.Cactus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CactusTest {


//        String winterDate = "01.12.2020" > 01.01.2021
//        String winterDate = "01.01.2020" > 01.02.2020
//        String winterDate = "01.02.2020" > 01.03.2020
//        String winterDate = "29.02.2020" > 07.03.2020

    //        String SpringDate = "01.03.2020" > 08.03.2020
//        String SpringDate = "01.04.2020" > 08.04.2020
//        String SpringDate = "01.05.2020" > 08.05.2020
//        String SpringDate = "31.05.2020" > зависит от влажности / 03.06.2020
    @Test
    public void testNextWateringDateInWinter() {
        Cactus cactus = new Cactus();
        String lastDate = "01.12.2020";
        LocalDate result = cactus.nextWateringDate(lastDate);
        assertEquals(LocalDate.of(2021, 1, 1), result);
    }
}