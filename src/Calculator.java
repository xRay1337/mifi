import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);
        String operation;

        while (true) {
            System.out.print("Введите первое число: ");
            double operand1 = scanner.nextDouble();

            while (true) {
                System.out.print("Введите операцию(+, -, *, /): ");

                operation = scanner.next();

                if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                    break;
                }

                System.out.println("Неподдерживаемая операция, доступны только: +, -, *, /");
            }

            System.out.print("Введите второе число: ");
            double operand2 = scanner.nextDouble();

            if (operation.equals("/") && operand2 == 0) {
                System.out.println("Делить на 0 нельзя.");
                continue;
            }

            double result = calculate(operation, operand1, operand2);

            System.out.printf("%f %s %f = %f\n----------------\n", operand1, operation, operand2, result);
        }
    }

    private static double calculate(String operation, double operand1, double operand2) throws NoSuchMethodException {
        return switch (operation) {
            case "+" -> sum(operand1, operand2);
            case "-" -> subtraction(operand1, operand2);
            case "*" -> multiplication(operand1, operand2);
            case "/" -> division(operand1, operand2);
            default -> throw new NoSuchMethodException("This operation is not supported.");
        };
    }

    private static double sum(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private static double subtraction(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double division(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
