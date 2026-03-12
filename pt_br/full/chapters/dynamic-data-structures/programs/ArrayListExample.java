import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Random random = new Random();        
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        while (sum < 100) {
            int n = random.nextInt(10) + 1;
            list.add(n);  // Append n to end of list
            sum += n;
        }

        for (int n: list) {
            System.out.format("%3d%n", n);
        }
        System.out.println("---");
        System.out.format("%3d (%d values)%n", sum, list.size());
    }
}