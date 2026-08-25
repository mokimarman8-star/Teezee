package com.transsion.athena.anateh;

import android.util.Log;
import com.transsion.athena.config.data.model.ehanat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private Cipher a;
    private Cipher b;

    public athena(byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(ehanat.o));
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.b = cipher2;
            cipher2.init(2, secretKeySpec2, new IvParameterSpec(ehanat.o));
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
        }
    }

    public byte[] a(String str) {
        Cipher cipher = this.a;
        if (cipher != null) {
            try {
                return cipher.doFinal(str.getBytes("UTF-8"));
            } catch (Exception e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public byte[] a(byte[] bArr) {
        Cipher cipher = this.b;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public byte[] b(byte[] bArr) {
        Cipher cipher = this.a;
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
        }
        return null;
    }
}
