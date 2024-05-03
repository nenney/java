package calculator;

public class DivideOperator {
    public int operate(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }
}