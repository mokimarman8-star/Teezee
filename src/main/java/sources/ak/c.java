package ak;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c extends zj.a {
    private Cipher a;
    private final byte[] b;

    public c(String str) {
        this.b = b(str);
    }

    private void e() {
        if (this.a == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.b));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            this.a = cipher;
        }
    }

    private boolean f(byte[] bArr, byte[] bArr2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.b));
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(generatePublic);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public byte[] d(byte[] bArr) {
        e();
        return this.a.doFinal(bArr);
    }

    public boolean g(byte[] bArr, byte[] bArr2) {
        return f(bArr, bArr2);
    }
}
