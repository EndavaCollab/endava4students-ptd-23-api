package travel.journal.api.security.jwt;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password_Encoder implements PasswordEncoder {



    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }

//public String encode(CharSequence rawPassword) {
//    try {
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] encodedHash = digest.digest(rawPassword.toString().getBytes());
//        return bytesToHex(encodedHash);
//    } catch (NoSuchAlgorithmException e) {
//        e.printStackTrace();
//        return null;
//    }
//}

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

//    private String bytesToHex(byte[] hash) {
//        StringBuilder hexString = new StringBuilder(2 * hash.length);
//        for (byte b : hash) {
//            String hex = Integer.toHexString(0xff & b);
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        return hexString.toString();
//    }
}
