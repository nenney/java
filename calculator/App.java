import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new ArrayList<>(); // 연산 결과를 저장할 ArrayList 생성

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = 0;
            if (sc.hasNextInt()) {
                firstNumber = sc.nextInt();
            } else {
                String input = sc.next();
                if (input.equals("exit")) {
                    break;
                } else if (input.equals("remove")) {
                    if (!results.isEmpty()) {
                        System.out.println("가장 먼저 저장된 결과 " + results.get(0) + " 가 삭제되었습니다.");
                        results.remove(0);
                    } else {
                        System.out.println("삭제할 결과가 없습니다.");
                    }
                    continue; // 삭제 후 반복문 계속
                } else if (input.equals("inquiry")) {
                    System.out.println("저장된 연산 결과:");
                    for (int result : results) {
                        System.out.println(result);
                    }
                    continue; // 조회 후 반복문 계속
                } else {
                    System.out.println("잘못된 입력입니다.");
                    continue; // 잘못된 입력일 경우 반복문 계속
                }
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            int result = 0; // 결과값 초기화

            if (operator == '+') {
                result = firstNumber + secondNumber;
            } else if (operator == '-') {
                result = firstNumber - secondNumber;
            } else if (operator == '*') {
                result = firstNumber * secondNumber;
            } else if (operator == '/') {
                if (secondNumber == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue; // 오류 발생 시 반복문 계속
                }
                result = firstNumber / secondNumber;
            } else {
                System.out.println("잘못된 연산 기호입니다.");
                continue; // 잘못된 입력일 경우 반복문 계속
            }

            // 연산 결과 출력
            System.out.println("결과: " + result);

            // 결과값 리스트에 저장
            results.add(result);
        }

        System.out.println("저장된 결과");
        for (int result : results) { // 반복문을 통해 리스트에 저장된 결과를 가져옵니다.
            System.out.println(result);
        }
    }
}