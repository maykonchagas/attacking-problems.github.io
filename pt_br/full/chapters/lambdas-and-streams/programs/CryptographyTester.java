public class CryptographyTester {
    public static void main(String[] args) {
        String plaintext = "CRY HAVOC AND LET SLIP THE DOGS OF WAR";
        
        String cipherText = CryptographyFramework.process(plaintext, (letter, index) -> (char)((letter - 'A' + 7) % 26 + 'A'));
        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Plaintext:  " + CryptographyFramework.process(cipherText, (letter, index) -> (char)((letter - 'A' - 7 + 26) % 26 + 'A')));
        System.out.println();
    }    
}
