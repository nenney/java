package calculator;

import java.util.List;

public class CircleCalculator {
    private final Calculator calculator;

    public CircleCalculator() {
        this.calculator = new Calculator();
    }

    public Double calculate(Operation operation, Double... operands) throws ArithmeticException, IllegalArgumentException {
        if (operation != Operation.CIRCLE_AREA) {
            throw new IllegalArgumentException("CircleCalculator can only perform circle area calculation.");
        }
        return calculator.calculate(Operation.CIRCLE_AREA, operands);
    }

    public void storeCircleArea(Double area) {
        Calculator.storeCircleArea(area);
    }

    public List<Double> getAllCircleAreas() {
        return Calculator.getAllCircleAreas();
    }
}