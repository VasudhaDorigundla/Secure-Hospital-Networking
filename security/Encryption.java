package security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Encryption {

    public static void main(String[] args) {

        try {
            // Generate AES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();

            // Patient information
            String originalMessage =
                    "Patient ID: P101, Department: ICU, Status: Stable";

            // Encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(
                    originalMessage.getBytes()
            );

            String encryptedMessage =
                    Base64.getEncoder().encodeToString(encryptedBytes);

            // Decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes =
                    cipher.doFinal(encryptedBytes);

            String decryptedMessage =
                    new String(decryptedBytes);

            // Display results
            System.out.println("======================================");
            System.out.println("       AES ENCRYPTION & DECRYPTION");
            System.out.println("======================================");

            System.out.println("Original Message:");
            System.out.println(originalMessage);

            System.out.println("\nEncrypted Message:");
            System.out.println(encryptedMessage);

            System.out.println("\nDecrypted Message:");
            System.out.println(decryptedMessage);

            System.out.println("--------------------------------------");
            System.out.println("Encryption and decryption successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}