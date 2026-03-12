public class AffineCipher {
    private final int a;
    private final int b;
    private int inverseA;

    public AffineCipher(int a, int b) {          // <.>
        this.a = a;
        this.b = b;
        inverseA = 1;                            // <.>
        while ((a * inverseA) % 26 != 1 && inverseA < 26) {
            ++inverseA;
        }

        if (inverseA >= 26) {
            throw new IllegalArgumentException(a + " has no multiplicative inverse mod 26");
        }
    }

    public char encrypt(char input, int index) { // <.>
        return (char)(((input - 'A') * a + b) % 26 + 'A');
    }

    public char decrypt(char input, int index) { // <.>
        int result = (input - 'A' - b) * inverseA;
        while (result < 0) {
            result += 26;
        }
        return (char)(result % 26 + 'A');
    }    
}
