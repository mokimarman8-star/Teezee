package ak;

import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a extends zj.a {
    private Cipher a;
    private final byte[] b;
    private final byte[] c;

    public a(byte[] bArr, byte[] bArr2) {
        this.c = bArr;
        this.b = bArr2;
        if (bArr.length != 16 && bArr.length != 24 && bArr.length != 32) {
            throw new IOException();
        }
        if (bArr2.length != 16) {
            throw new IOException();
        }
    }

    private void e() {
        if (this.a == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.c, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.b);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            this.a = cipher;
        }
    }

    public byte[] d(byte[] bArr) {
        e();
        return this.a.doFinal(bArr);
    }
}
