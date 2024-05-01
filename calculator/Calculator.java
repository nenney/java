package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final List<Double> circleAreas = new ArrayList<>();

    public static Double calculate(Operation operation, Double... operands) throws ArithmeticException, IllegalArgumentException {
        if (operation == Operation.CIRCLE_AREA) {
            throw new IllegalArgumentException("Cannot perform arithmetic operations on CircleCalculator.");
        }

        return switch (operation) {
            case ADDITION -> operands[0] + operands[1];
            case SUBTRACTION -> operands[0] - operands[1];
            case MULTIPLICATION -> operands[0] * operands[1];
            case DIVISION -> {
                if (operands[1] == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                yield operands[0] / operands[1];
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