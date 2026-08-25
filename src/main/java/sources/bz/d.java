package bz;

import android.util.Log;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d {
    private Cipher a;
    private Cipher b;

    public d(byte[] bArr) {
        byte[] bytes = "abcdefghijk1mnop".getBytes();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(bytes));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(bytes));
        } catch (Exception e) {
            com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
        }
    }

    public byte[] a(String str) {
        Cipher cipher = this.a;
        if (cipher != null) {
            try {
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Exception e) {
                com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
            }
        }
        return null;
    }
}
