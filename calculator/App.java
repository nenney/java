package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNumber = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.

        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNumber = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0); // 사칙연산 기호를 입력받고 적합한 타입의 변수에 저장합니다.
    }
}