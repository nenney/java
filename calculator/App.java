package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 사칙연산 계산");
            System.out.println("2. 원의 넓이 계산");
            System.out.print("원하는 기능을 선택하세요 (숫자 입력): ");
            int choice = sc.nextInt();
            sc.nextLine(); // 개행문자 처리

            switch (choice) {
                case 1:
                    // 사칙연산 계산 구현
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int num2 = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0);
                    try {
                        int result = Calculator.calculate(num1, num2, operator);
                        System.out.println("결과: " + result);
                    } catch (Exception e) {
                        System.out.println("에러 발생: " + e.getMessage());
                    }
                    break;
                case 2:
                    // 원의 넓이 계산 구현
                    System.out.print("반지름을 입력하세요: ");
                    double radius = sc.nextDouble();
                    double area = Calculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + area);
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String input = sc.next();
            if (input.equals("exit")) {
                break;
            }
        }

        // 저장된 원의 넓이 값들 전체 조회
        System.out.println("저장된 원의 넓이");
        for (double area : Calculator.getAllCircleAreas()) {
            System.out.println(area);
        }

        sc.close();
    }
}