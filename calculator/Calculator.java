package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
    private static final List<Double> circleAreas = new ArrayList<>();

    // 생성자 수정
    public Calculator() {
        // 외부에서 직접 접근할 수 없도록 private으로 초기화됩니다.
    }

    // 사칙연산을 계산하는 메서드
    public static int calculate(int firstNumber, int secondNumber, char operator) throws ArithmeticException, IllegalArgumentException {
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
        return result;
    }

    // 원의 넓이를 구하는 메서드
    public static double calculateCircleArea(double radius) {
        // 원의 넓이 계산 구현
        double area = Math.PI * Math.pow(radius, 2);
        // 결과를 저장
        circleAreas.add(area);
        return area;
    }

    // 원의 넓이 결과값들을 조회하는 메서드
    public static List<Double> getAllCircleAreas() {
        return new ArrayList<>(circleAreas);
    }
}