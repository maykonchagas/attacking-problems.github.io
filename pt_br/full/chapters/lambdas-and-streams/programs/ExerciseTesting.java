import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ExerciseTesting {
    public static void main(String[] args) {
        String input = "CRY HAVOC AND LET SLIP THE DOGS OF WAR";

        int[] letters = new int[26];
        input.chars().forEach(e -> {
            if (e >= 'A' && e <= 'Z') {
                ++letters[e - 'A'];
            }
        });


        System.out.println(Arrays.toString(letters));

        String[] words = {"Split", "portion", "Echo", "Visit", "allowance", "distribute", "NAME", "freighter", "lean", "Facade"};

        Arrays.sort(words, String::compareToIgnoreCase);
        //Arrays.sort(words, (word1, word2) -> word1.compareToIgnoreCase(word2));
        System.out.println(Arrays.toString(words));

        IntStream
            .rangeClosed(1, 100)
            .asDoubleStream()
            .map(Math::sqrt)
            .forEach(System.out::println);
        
        var numbers = Arrays.asList(75, 38, 173, 176, 11, 188, 130, 94, 159, 52);
        numbers.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

        int[] moreNumbers = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < moreNumbers.length; ++i) {
            moreNumbers[i] = random.nextInt();
        }

        long start = System.nanoTime();
        int max1 = Arrays.stream(moreNumbers)
                    .filter(e -> e < 10000)
                    .filter(e -> e % 2 != 0)
                    .max().getAsInt();
        long end = System.nanoTime();
        System.out.println("First max time:  " + (end - start)/1000000000.0);

        start = System.nanoTime();
        int max2 = Arrays.stream(moreNumbers)
                    .filter(e -> e % 2 != 0)
                    .filter(e -> e < 10000)
                    .max().getAsInt();
        end = System.nanoTime();
        System.out.println("Second max time: " + (end - start)/1000000000.0);

        System.out.println("Max 1: " + max1);
        System.out.println("Max 2: " + max2);
    }
}
