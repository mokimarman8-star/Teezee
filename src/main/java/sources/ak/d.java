package ak;

import android.content.Context;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d extends zj.a {
    private Cipher a;
    private Cipher b;

    public d(Context context) {
        e.b().a(context);
    }

    private void f() {
        if (h() == null) {
            throw new Exception("key not created, please try later");
        }
        if (this.a == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, h());
            this.a = cipher;
        }
    }

    private void g() {
        if (i() == null) {
            throw new Exception("key not created, please try later");
        }
        if (this.b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, i());
            this.b = cipher;
        }
    }

    private static PrivateKey h() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey("crypto", null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static PublicKey i() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getCertificate("crypto").getPublicKey();
        } catch (Exception unused) {
            return null;
        }
    }

    public byte[] d(byte[] bArr) {
        f();
        return this.a.doFinal(bArr);
    }

    public byte[] e(byte[] bArr) {
        g();
        return this.b.doFinal(bArr);
    }
}
