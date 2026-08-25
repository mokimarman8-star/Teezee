package com.transsion.api.gateway.utils;

import com.transsion.gslb.BuildConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class EncoderUtil {
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_SHA_1 = "SHA-1";
    public static final String ALGORITHM_SHA_256 = "SHA-256";
    public static final String ALGORITHM_SHA_512 = "SHA-512";
    public static final String ALGORITHM__SHA_384 = "SHA-384";

    public static String EncoderByAlgorithm(String str) {
        return EncoderByAlgorithm(str, ALGORITHM_SHA_256);
    }

    public static String EncoderByAlgorithm(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }
}
