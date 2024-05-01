package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 사칙연산 계산");
            System.out.println("2. 원의 넓이 계산");
            System.out.print("원하는 기능을 선택하세요 (숫자 입력): ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    double num1 = sc.nextDouble();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double num2 = sc.nextDouble();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0);
                    try {
                        double result = ArithmeticCalculator.calculate(getOperation(operator), num1, num2);
                        System.out.println("Result: " + result);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter the radius: ");
                    double radius = sc.nextDouble();
                    try {
                        double area = CircleCalculator.calculate(Operation.CIRCLE_AREA, radius);
                        System.out.println("Circle area: " + area);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String input = sc.next();
            if (input.equals("exit")) {
                break;
            }
        }

        System.out.println("Stored circle areas:");
        for (Double area : Calculator.getAllCircleAreas()) {
            System.out.println(area);
        }

        sc.close();
    }

    private static Operation getOperation(char operator) {
        switch (operator) {
            case '+':
                return Operation.ADDITION;
            case '-':
                return Operation.SUBTRACTION;
            case '*':
                return Operation.MULTIPLICATION;
            case '/':
                return Operation.DIVISION;
            default:
                throw new IllegalArgumentException("Invalid operation.");
        }
    }
}