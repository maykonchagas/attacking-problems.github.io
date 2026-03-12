public class CryptographyFramework {
    public static String process(String input, Processable processable) { // <.>
        var result = new StringBuilder();                                 // <.>
        input = input.toUpperCase();                                      // <.>
        for (int i = 0; i < input.length(); ++i) {                        // <.>
            char letter = input.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {                         // <.>
                result.append(processable.process(letter, i));            // <.>
            } else {
                result.append(letter);                                    // <.>
            }
        }

        return result.toString();                                         // <.>
    } 

    public static void main(String[] args) {
        String plaintext = "CRY HAVOC AND LET SLIP THE DOGS OF WAR";                       // <.>
        CaesarCipher caesarCipher = new CaesarCipher(7);                                   // <.>
        AffineCipher affineCipher = new AffineCipher(5, 8);                                // <.>
        VigenereCipher vigenereCipher = new VigenereCipher("SHAKESPEARE");                 // <.>
        
        System.out.println("Caesar Cipher (key = 7)");
        String cipherText = process(plaintext, caesarCipher::encrypt);                     // <.>
        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Plaintext:  " + process(cipherText, caesarCipher::decrypt));   // <.>
        System.out.println();

        System.out.println("Affine Cipher (key = 5x + 8)");
        cipherText = process(plaintext, affineCipher::encrypt);                            // <.>
        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Plaintext:  " + process(cipherText, affineCipher::decrypt));   // <.>
        System.out.println();

        System.out.println("Vigenere Cipher (key = SHAKESPEARE)");
        cipherText = process(plaintext, vigenereCipher::encrypt);                          // <.>
        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Plaintext:  " + process(cipherText, vigenereCipher::decrypt)); // <.>
    }  
}