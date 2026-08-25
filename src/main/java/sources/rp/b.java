package rp;

import android.os.Build;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.Cipher;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b extends bz.a {
    private Cipher a;
    private Cipher b;
    private Key c;
    private Key d;

    private void g() {
        try {
            i();
            if (this.a == null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.c);
                this.a = cipher;
            }
        } catch (NoClassDefFoundError unused) {
            throw new Exception("NoClassDefFound...");
        }
    }

    private void h() {
        i();
        if (this.b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.d);
            this.b = cipher;
        }
    }

    private void i() {
        if (this.c == null || this.d == null) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (Build.VERSION.SDK_INT >= 28) {
                this.c = keyStore.getKey("crypto", null);
                this.d = keyStore.getCertificate("crypto").getPublicKey();
            } else {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("crypto", null);
                this.c = privateKeyEntry.getPrivateKey();
                this.d = privateKeyEntry.getCertificate().getPublicKey();
            }
        }
    }

    public byte[] d(byte[] bArr) {
        g();
        return this.a.doFinal(bArr);
    }

    public byte[] e(String str) {
        return f(str.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] f(byte[] bArr) {
        h();
        return this.b.doFinal(bArr);
    }
}
