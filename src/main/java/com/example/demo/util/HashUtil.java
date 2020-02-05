package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import com.google.common.base.Throwables;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;

public class HashUtil {

    private static final HashFunction FUNCTION = Hashing.md5();

    private static final HashFunction MURMUR_FUNC = Hashing.murmur3_128();

    private static final String       SALT     = "woshishei";

//    public static String encryPassword(String password){
//        HashCode code = FUNCTION.hashString(password+SALT, Charset.forName("UTF-8"));
//        return code.toString();
//    }

    public static String hashString(String input){
        HashCode code = null;
        try {
            code = MURMUR_FUNC.hashBytes(input.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            Throwables.propagate(e);
        }
        return code.toString();
    }

    private static String sha1(String input) throws Exception {
        String res = null;

        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        res = hexString.toString();
        return res;
    }

    /**
     * Encrypting password: used to store into db
     * @param password
     * returns salt and encrypted password
     */
    public static List<String> hashSSHA(String password) throws Exception {
        List<String> res = new ArrayList();

        String salt = RandomStringUtils.randomAlphabetic(10);
        System.out.println("get salt: " + salt);
        res.add(salt);

        final Base64.Encoder encoder = Base64.getEncoder();
        String info = sha1(password +  salt) + salt;
        final byte[] textByte = info.getBytes("UTF-8");
        String encrypted = encoder.encodeToString(textByte);
        System.out.println("get encrypted pwd: " + encrypted);
        res.add(encrypted);

        return res;
    }

    /**
     * Decrypting password
     * @param salt, password
     * returns hash string
     */
    public String getHashSSHA(String salt, String password) throws Exception {

        final Base64.Encoder encoder = Base64.getEncoder();
        String info = sha1(password +  salt) + salt;
        final byte[] textByte = info.getBytes("UTF-8");
        String encrypted_password = encoder.encodeToString(textByte);

        System.out.println("get encrypted pwd 2: " + encrypted_password);

        return encrypted_password;
    }


    public static void main(String[] args) {
        //System.out.println(encryPassword("111111"));
    }
}

