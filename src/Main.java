import java.util.Scanner;

/*
Вопрос: Какой оператор лучше использовать, чтобы проверить, какую операцию выполнять?
Ответ: switch.
Вопрос: Если пользователь ввёл неподдерживаемую операцию, стоит ли ему сообщить об этом?
Ответ: да, сделал ввод операции в цикле с указанием на неверный ввод.
Вопрос: Нужна ли дополнительная переменная для второго операнда? А для результата?
Ответ: Я стараюсь создавать переменные под разные действия - так выше удобочитаемость. Здесь памяти хватает.
Вопрос: Можно ли написать весь код в одном методе? Или вынести код для каждой операции в отдельный метод?
Ответ: Если придерживаться принципа единственной ответственности, то нельзя. Вынес вычисления и операции в методы.
 */
public class Main {
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