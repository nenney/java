package calculator;

public class ArithmeticCalculator extends Calculator {
    public static Double calculate(Operation operation, Double... operands) throws ArithmeticException, IllegalArgumentException {
        if (operation == Operation.CIRCLE_AREA) {
            throw new IllegalArgumentException("Cannot perform circle area calculation in ArithmeticCalculator.");
        }
        return Calculator.calculate(operation, operands);
    }
}
