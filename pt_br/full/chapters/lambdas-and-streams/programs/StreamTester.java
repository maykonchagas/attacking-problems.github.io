import java.util.stream.*;
import java.util.*;

public class StreamTester {
    public static void main(String[] args) {
        String[] array = {"vegetarian", "acquit", "unfair", "insert", "favorable", "origin"};   
        var words = Stream.of(array);
        words
            .filter(e -> e.length() >= 8)
            .sorted()
            .forEach(e -> System.out.println(e));
    
        List<String> list = new ArrayList<>();
        list.add("vegetarian");
        list.add("acquit");
        list.add("unfair");
        list.add("insert");
        list.add("favorable");
        list.add("origin");   
        words = list.stream();

        words
            .map(e -> e + e)
            .forEach(e -> System.out.println(e));

        words = list.stream();
        IntStream lengths = words.mapToInt(e -> e.length());
        System.out.println(lengths.max().orElseThrow());

        IntStream numbers = IntStream.of(3, 14, 7, 1, 2);
        System.out.println(numbers.sum());

        int[] numberArray = {3, 4, 5, 6, 7};
        var stream1 = IntStream.of(numberArray);
        System.out.println(stream1.max().getAsInt());
        var stream2 = IntStream.of(3, 4, 5, 6, 7);
        System.out.println(stream2.min().getAsInt());
        var stream3 = IntStream.range(3, 8);
        System.out.println(stream3.sum());
        var stream4 = IntStream.rangeClosed(3, 7);
        var stream5 = IntStream.iterate(3, e -> e + 1).limit(5);



        IntStream.rangeClosed(1, 100)
        .peek(e -> {
            try { Thread.sleep(1000); } catch (InterruptedException ex) {}            
        })
        .limit(5)
        .forEach(e -> System.out.println(e));
    }
}