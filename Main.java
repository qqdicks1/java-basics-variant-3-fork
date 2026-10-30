import java.util.Scanner;  // This line is for development branch only

public class Main {
    public static void main(String[] args) {
        // Вариант 3: Калькулятор бонусов
        // Программа принимает массив из 5 последних покупок

        Scanner scanner = new Scanner(System.in);
        double[] purchases = new double[5];
        double totalSum = 0;
        final int COUNT = 5;

        System.out.println("Введите суммы 5 последних покупок:");

        // 1. Сбор данных и подсчет общей суммы в цикле
        for (int i = 0; i < COUNT; i++) {
            System.out.print("Покупка " + (i + 1) + ": ");
            purchases[i] = scanner.nextDouble();
            
            // Защита от отрицательных сумм
            if (purchases[i] < 0) {
                System.out.println("Сумма не может быть отрицательной. Принимаем за 0.");
                purchases[i] = 0;
            }
            totalSum += purchases[i];
        }

        // 2. Расчет кэшбэка через if-else
        double cashbackPercent = 0;
        if (totalSum > 5000) {
            cashbackPercent = 10;
        } else if (totalSum > 2000) {
            cashbackPercent = 5;
        } // иначе остается 0

        double bonusAmount = totalSum * (cashbackPercent / 100.0);

        // 3. Вывод результата
        System.out.println("\n--- Итог ---");
        System.out.printf("Общая сумма покупок: %.2f руб.%n", totalSum);
        System.out.println("Процент кэшбэка: " + cashbackPercent + "%");
        System.out.printf("Начислено бонусов: %.2f руб.%n", bonusAmount);

        scanner.close();
    }
}
