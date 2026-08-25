package ak;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b extends zj.a {
    private Cipher a;
    private Cipher b;
    private SecretKeySpec c;
    private byte[] d;

    private void g() {
        if (this.c == null || this.d == null) {
            throw new Exception("please call encrypt method first");
        }
        if (this.a == null) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.d);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, this.c, ivParameterSpec);
            this.a = cipher;
        }
    }

    private void h() {
        if (this.b == null) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey generateKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, generateKey);
            this.c = new SecretKeySpec(generateKey.getEncoded(), "AES");
            this.d = cipher.getIV();
            this.b = cipher;
        }
    }

    public byte[] d(byte[] bArr) {
        g();
        return this.a.doFinal(bArr);
    }

    public byte[] e(String str) {
        return f(str.getBytes("UTF-8"));
    }

    public byte[] f(byte[] bArr) {
        h();
        return this.b.doFinal(bArr);
    }

    public byte[] i() {
        SecretKeySpec secretKeySpec;
        if (this.d == null || (secretKeySpec = this.c) == null || secretKeySpec.getEncoded() == null) {
            throw new Exception("no valid key info");
        }
        byte[] encoded = this.c.getEncoded();
        byte[] bArr = this.d;
        if (encoded.length != 32 || bArr.length != 16) {
            throw new Exception("key length is not valid");
        }
        byte[] bArr2 = new byte[48];
        System.arraycopy(encoded, 0, bArr2, 0, 32);
        System.arraycopy(bArr, 0, bArr2, 32, 16);
        return bArr2;
    }
}
