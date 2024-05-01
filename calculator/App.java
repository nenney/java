package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (Exception e) {
                System.out.println("에러 발생: " + e.getMessage());
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String input = sc.next();
            if (input.equals("exit")) {
                break;
            }
        }

        // 간접 접근을 통해 결과 출력
        System.out.println("저장된 결과");
        for (int result : calculator.getResults()) {
            System.out.println(result);
        }

        sc.close();
    }
}