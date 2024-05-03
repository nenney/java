package calculator;

public class ArithmeticCalculator {
    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;

    public ArithmeticCalculator() {
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }

    public double calculate(Operation operation, double... operands) throws ArithmeticException, IllegalArgumentException {
        int num1 = (int) operands[0];
        int num2 = (int) operands[1];

        switch (operation) {
            case ADDITION:
                return addOperator.operate(num1, num2);
            case SUBTRACTION:
                return subtractOperator.operate(num1, num2);
            case MULTIPLICATION:
                return multiplyOperator.operate(num1, num2);
            case DIVISION:
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return divideOperator.operate(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation.");
        }
    }
}