package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(); // ArithmeticCalculator 인스턴스 생성

        while (true) {
            System.out.println("1. 산술 연산");
            System.out.println("2. 원의 넓이 계산");
            System.out.print("옵션  숫자 입력: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    double num1 = sc.nextDouble();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double num2 = sc.nextDouble();
                    System.out.print("연산을 입력하세요 (+, -, *, /): ");
                    char operator = sc.next().charAt(0);
                    try {
                        double result = arithmeticCalculator.calculate(Operation.valueOf(String.valueOf(operator)), num1, num2); // Operation 열거형의 valueOf 메서드를 사용하여 문자열로부터 해당하는 Enum 상수를 가져옴
                        System.out.println("결과: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("반지름을 입력하세요: ");
                    double radius = sc.nextDouble();
                    CircleCalculator circleCalculator = new CircleCalculator(); // CircleCalculator 인스턴스 생성
                    try {
                        double area = circleCalculator.calculate(Operation.CIRCLE_AREA, radius); // CircleCalculator 인스턴스를 통해 calculate 메서드 호출
                        System.out.println("원의 넓이: " + area);
                    } catch (Exception e) {
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 입력입니다. 다시 시도해주세요.");
            }

            System.out.print("계속하시겠습니까? ('exit'를 입력하여 종료): ");
            String input = sc.next();
            if ("exit".equals(input)) { // input이 null인 경우에도 NullPointerException이 발생하지 않습니다.
                break;
            }
        }

        System.out.println("저장된 원의 넓이:");
        for (Double area : Calculator.getAllCircleAreas()) {
            System.out.println(area);
        }

        sc.close();
    }
}