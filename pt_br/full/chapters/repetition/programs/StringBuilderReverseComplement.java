import java.util.*;

public class StringBuilderReverseComplement {
    public static void main(String[] args) {                
        Scanner in = new Scanner(System.in);      
        System.out.print("Please enter a DNA sequence: ");
        String sequence = in.next().toUpperCase();              
        StringBuilder reverseComplement = new StringBuilder();
        for (int i = 0; i < sequence.length(); ++i) {
            switch (sequence.charAt(i)) { // Get complements
                case 'A': reverseComplement.insert(0, "T"); break;
                case 'C': reverseComplement.insert(0, "G"); break;
                case 'G': reverseComplement.insert(0, "C"); break;
                case 'T': reverseComplement.insert(0, "A"); break;
            }
        }
        System.out.println("Reverse complement: " + reverseComplement.toString());
    }
}