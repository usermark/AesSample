package com.github.usermark.aessample;

import com.github.usermark.aessample.sun.SunSecureRandom;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESBySunUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String encrypt(String data, String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            byte[] byteContent = data.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
            byte[] result = cipher.doFinal(byteContent);
            return new String(Base64.encodeBase64(result), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String data, String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
            byte[] result = cipher.doFinal(Base64.decodeBase64(data.getBytes(StandardCharsets.UTF_8)));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static SecretKeySpec getSecretKey(String key) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            kg.init(128);
            SecretKey secretKey = kg.generateKey();
            byte[] keyBytes = secretKey.getEncoded();
            SunSecureRandom sunRandom = new SunSecureRandom();
            sunRandom.engineSetSeed(key.getBytes(StandardCharsets.UTF_8));
            sunRandom.engineNextBytes(keyBytes);
            return new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
