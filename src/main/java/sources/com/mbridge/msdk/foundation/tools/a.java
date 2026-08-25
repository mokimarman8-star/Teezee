package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private static byte[] b = new byte[32];
    private static byte[] a = new byte[16];

    /* renamed from: com.mbridge.msdk.foundation.tools.a$a, reason: collision with other inner class name */
    public static class C0090a extends Provider {
        public C0090a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    static {
        a(i0.a("HkzwDFeD4QuyLdx5igfZYcu9xTM9NN=="));
    }

    public static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0090a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            byte[] digest = MessageDigest.getInstance("sha-384").digest(str.getBytes());
            System.arraycopy(digest, 0, b, 0, 32);
            System.arraycopy(digest, 32, a, 0, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(String str) {
        return a(str, b, a);
    }
}
