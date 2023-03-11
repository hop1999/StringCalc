import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        Calculator calculator = new Calculator();
        String result = calculator.calculate(input);

        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }
        System.out.println("Результат: \"" + result + "\"");
    }
}
