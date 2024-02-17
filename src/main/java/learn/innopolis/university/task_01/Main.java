package learn.innopolis.university.task_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите длину забора в сантиметрах: ");
            int length = scanner.nextInt();
            System.out.println(checkLength(length) ? "Длины забора хватит" : "Длины забора не хватит");
        } catch (Exception e) {
            System.out.println("Ошибка. Длинна забора должна быть целым числом.");
        }
    }

    private static final int LENGTH_ON_THREE_LETTERS = 62;
    private static final int SPACE_LENGTH = 12;
    private static final int REQUIRED_LENGTH = (15 / 3) * LENGTH_ON_THREE_LETTERS + 3 * SPACE_LENGTH;

    public static boolean checkLength(int length) {
        return length >= REQUIRED_LENGTH;
    }
}
