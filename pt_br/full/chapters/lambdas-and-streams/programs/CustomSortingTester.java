import java.util.Arrays;
import java.util.Comparator;

public class CustomSortingTester {
    public static void main(String[] args) {
        String[] words = {"telephone", "architecture", "union", "drawers", "fruits"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(words));

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] intValues = {34, 42, 90, 61, 29};
        Arrays.sort(intValues);
        System.out.println(Arrays.toString(intValues));

        Integer[] wrappedValues = {34, 42, 90, 61, 29};
        Arrays.sort(wrappedValues, (a, b) -> b - a);
        System.out.println(Arrays.toString(wrappedValues));

    }
}
