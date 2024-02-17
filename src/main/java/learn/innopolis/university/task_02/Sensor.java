package learn.innopolis.university.task_02;

import java.util.Random;

public class Sensor {

    private static Integer humiditySensor () {
        Random random = new Random();
        int humidity = random.nextInt(101);
        return humidity;
    }

    public static Integer getHumiditySensor () {
        return humiditySensor();
    }
}
