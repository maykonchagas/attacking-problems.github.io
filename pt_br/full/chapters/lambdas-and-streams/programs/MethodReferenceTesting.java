public class MethodReferenceTesting {
    public static void main(String[] args) {
        Operator operator = Max::max;
        System.out.println(operator.evaluate(5, -3));

        MaxWithMinimum maxObject = new MaxWithMinimum(10);
        operator = maxObject::max;
        System.out.println(operator.evaluate(5, -3));
    }
}
