package calculator;

import java.util.List;

public class CircleCalculator extends Calculator {
    public static Double calculate(Operation operation, Double... operands) throws ArithmeticException, IllegalArgumentException {
        if (operation != Operation.CIRCLE_AREA) {
            throw new IllegalArgumentException("CircleCalculator can only perform circle area calculation.");
        }
        return Calculator.calculate(Operation.CIRCLE_AREA, operands);
    }

    public static void storeCircleArea(Double area) {
        Calculator.storeCircleArea(area);
    }

    public static List<Double> getAllCircleAreas() {
        return Calculator.getAllCircleAreas();
    }
}