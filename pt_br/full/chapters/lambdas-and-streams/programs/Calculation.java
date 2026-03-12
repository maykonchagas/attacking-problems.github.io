public class Calculation implements Expression {
    private final Operator operator;
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Calculation(Operator operator,      // <.>
                       Expression leftExpression,
                       Expression rightExpression) {
        this.operator = operator;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int getValue() {                    // <.>
        int a = leftExpression.getValue();
        int b = rightExpression.getValue();
        return operator.evaluate(a, b);
    }

    public static int add(int a, int b) {      // <.>
        return a + b;
    }

    public static int subtract(int a, int b) { // <.>
        return a - b;
    }

    public static int multiply(int a, int b) { // <.>
        return a * b;
    }

    public static int divide(int a, int b) {   // <.>
        return a / b;
    }
}