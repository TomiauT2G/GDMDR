package com.example.gdmdr;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */





    public class SHA256Test {

        @Test
        public void testSHA256() {
            String input = "Hola, mundo!";
            String expectedHash = "5dc9dfc4c7b0b63c8fbf4f3d21d6d2c6b8c918c70f4a729edcccefc11c321b9b";

            String sha256 = getSHA256(input);
            assertEquals(expectedHash, sha256);
        }

        private String getSHA256(String input) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }

                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


