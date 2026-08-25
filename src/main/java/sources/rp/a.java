package rp;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a extends bz.a {
    private Cipher a;
    private final byte[] b;

    public a(String str) {
        this.b = b(str);
    }

    private void f() {
        if (this.a == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.b));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            this.a = cipher;
        }
    }

    public byte[] d(String str) {
        return e(str.getBytes(Charset.forName("UTF-8")));
    }

    public byte[] e(byte[] bArr) {
        f();
        return this.a.doFinal(bArr);
    }
}
