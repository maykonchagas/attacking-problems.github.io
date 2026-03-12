public class MaxWithMinimum {
    private final int minimum;

    public MaxWithMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int max(int a, int b) {
        int result = minimum;
        if (a >= result) {
            result = a;
        }
        if (b >= result) {
            result = b;
        }
        return result;        
    }    
}
