public class LambdaTesting {    
    public static void main(String[] args) {
        Operator add1 = (int a, int b) -> a + b;
        System.out.println(add1.evaluate(5, -3));

        Operator add2 = (a, b) -> a + b;
        System.out.println(add2.evaluate(5, -3));

        Operator operator1 = (a, b) -> {
            if (a >= b) {
                return a;
            } else {
                return b;
            }
        };

        System.out.println(operator1.evaluate(5, -3));

        int minimum = 10;
        Operator operator2 = (a, b) -> {
            int result = minimum;
            if (a >= result) {
                result = a;
            }
            if (b >= result) {
                result = b;
            }
            return result;     
        };

        System.out.println(operator2.evaluate(5, -3));

        Operator multiply1 = new Operator() {
            @Override
            public int evaluate(int a, int b) {
                return a * b;
            }            
        };

    }
    
}
