package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final List<Double> circleAreas = new ArrayList<>();
    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;

    public Calculator() {
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }

    public Double calculate(Operation operation, Double... operands) throws ArithmeticException, IllegalArgumentException {
        if (operation == Operation.CIRCLE_AREA) {
            throw new IllegalArgumentException("Cannot perform arithmetic operations on CircleCalculator.");
        }

        int num1 = operands[0].intValue();
        int num2 = operands[1].intValue();

        return switch (operation) {
            case ADDITION -> (double) addOperator.operate(num1, num2); // int를 double로 형변환
            case SUBTRACTION -> (double) subtractOperator.operate(num1, num2); // int를 double로 형변환
            case MULTIPLICATION -> (double) multiplyOperator.operate(num1, num2); // int를 double로 형변환
            case DIVISION -> {
                if (operands[1] == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                yield (double) divideOperator.operate(num1, num2); // int를 double로 형변환
            }
            default -> throw new IllegalArgumentException("Invalid operation.");
        };
    }

    public static void storeCircleArea(Double area) {
        circleAreas.add(area);
    }

    public static List<Double> getAllCircleAreas() {
        return new ArrayList<>(circleAreas);
    }
}