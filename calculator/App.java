package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] results = new int[10]; // 연산 결과를 저장할 배열 생성
        int count = 0; // 현재 저장된 결과 개수를 나타내는 변수

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.

            int result = 0; // 결과값 초기화

            if (operator == '+') {
                result = firstNumber + secondNumber;
            } else if (operator == '-') {
                result = firstNumber - secondNumber;
            } else if (operator == '*') {
                result = firstNumber * secondNumber;
            } else if (operator == '/') {
                result = firstNumber / secondNumber;
            } else if (String.valueOf(operator).equals("exit")) { // exit를 입력하면 종료
                break;
            } else {
                System.out.println("잘못된 연산 기호입니다.");
                continue; // 오류 발생 시 프로그램 종료
            }

            // 연산 결과 출력
            System.out.println("결과: " + result);

            // 결과값 배열에 저장
            if (count < 10) {
                results[count] = result;
                count++;
            } else {
                System.out.println("배열이 가득차 결과를 저장할 수 없습니다.");
                break;
            }
        }

        System.out.println("저장된 결과");
        for (int i = 0; i < count; i++) { // 반복문을 통해 배열에 저장된 결과를 가져옵니다.
            System.out.println(results[i]);
        }
    }
}