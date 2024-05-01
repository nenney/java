package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results;

    public Calculator() {
        results = new ArrayList<>();
    }

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
        results.add(result);
        return result;
    }

    // Getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    // Setter 메서드 (예시)
    public void setResults(List<Integer> results) {
        this.results = results;
    }
}