import java.util.*;
import java.util.stream.DoubleStream;

public class ParallelStreamTester {
    public static void main(String[] args) {
        var words = Arrays.asList("paragraph", "understand", "stir", "exemption", "dance");
        words.parallelStream().forEach(word -> System.out.println(word));

        String longest = words
            .parallelStream()
            .reduce("", (word1, word2) -> {
                if (word1.length() >= word2.length()) {
                    return word1;
                } else {
                    return word2;
                }
            });

        System.out.println(longest);

        
        double[] numbers = new double[1000000];
        for (int i = 0; i < 1000000; ++i) {
            numbers[i] = i;
        }

        long start = System.nanoTime();
        double parallelSum = DoubleStream.of(numbers)
            .parallel()
            .map(number -> Math.sin(number))
            .sum();

        long end = System.nanoTime();
        System.out.println("Parallel time: " + (end - start)/1000000000.0);
        
        start = System.nanoTime();
        double sequentialSum = DoubleStream.of(numbers)
            .map(number -> Math.sin(number))
            .sum();
        end = System.nanoTime();
        System.out.println("Sequential time: " + (end - start)/1000000000.0);

        System.out.println("Parallel sum:   " + parallelSum);
        System.out.println("Sequential sum: " + sequentialSum);


        start = System.nanoTime();
        double loopSum = 0;
        for (int i = 0; i < numbers.length; ++i) {
            loopSum += Math.sin(numbers[i]);
        }
        System.out.println("Loop sum: " + loopSum);
        end = System.nanoTime();
        System.out.println("Loop time: " + (end - start)/1000000000.0);

    }
}
