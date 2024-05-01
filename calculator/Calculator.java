package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드
    public List<Integer> results;

    // Calculator 클래스의 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 사칙연산을 수행하고 결과 값을 반환하는 메서드
    public int calculate(int firstNumber, int secondNumber, char operator) throws ArithmeticException, IllegalArgumentException {

        int result = switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                yield firstNumber / secondNumber;
            }
            default -> throw new IllegalArgumentException("잘못된 연산 기호입니다.");
        };

        // 연산 결과를 저장
        results.add(result);

        return result;
    }
}