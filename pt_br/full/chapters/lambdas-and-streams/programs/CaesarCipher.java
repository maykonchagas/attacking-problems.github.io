public class CaesarCipher {
    private final int key;

    public CaesarCipher(int key) {               // <.>
        while (key < 0) {
            key += 26;
        }
        key %= 26;
        this.key = key;
    }

    public char encrypt(char input, int index) { // <.>
        return (char)((input - 'A' + key) % 26 + 'A');
    }

    public char decrypt(char input, int index) { // <.>
        return (char)((input - 'A' - key + 26) % 26 + 'A');
    }    
}
