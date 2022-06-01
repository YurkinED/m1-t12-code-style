import java.util.Scanner;
import java.lang.Math;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double rate, int period) {
        double pay = amount * Math.pow((1 + rate / 12), 12 * period);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double rate, int period) {
        double pay = round(amount + amount * rate * period, 2);
        return pay;
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void runJob() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0;
        if (action == 1) outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().runJob();
    }


}
