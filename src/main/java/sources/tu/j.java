package tu;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class j {
    public static final byte[] a;
    public static final String b;

    static {
        byte[] bytes = "#PART#".getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        a = bytes;
        b = "rsa_public_key.pem";
    }

    public static byte[] a(byte[] data, byte[] publicKey) {
        int i;
        int i2;
        byte[] bArr;
        Intrinsics.h(data, "data");
        Intrinsics.h(publicKey, "publicKey");
        int length = data.length;
        int i3 = 1;
        int i4 = 245;
        if (length <= 245) {
            Intrinsics.h(data, "data");
            Intrinsics.h(publicKey, "publicKey");
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            byte[] doFinal = cipher.doFinal(data);
            Intrinsics.g(doFinal, "doFinal(...)");
            return doFinal;
        }
        ArrayList arrayList = new ArrayList();
        byte[] data2 = new byte[245];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            Objects.requireNonNull(data2);
            Intrinsics.f(data2, "null cannot be cast to non-null type kotlin.ByteArray");
            data2[i6] = data[i5];
            i6 += i3;
            if (i6 == i4 || i5 == length - 1) {
                i7++;
                if (i7 != i3) {
                    for (byte b2 : a) {
                        arrayList.add(Byte.valueOf(b2));
                    }
                }
                Intrinsics.e(data2);
                Intrinsics.h(data2, "data");
                Intrinsics.h(publicKey, "publicKey");
                PublicKey generatePublic2 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey));
                Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher2.init(1, generatePublic2);
                byte[] doFinal2 = cipher2.doFinal(data2);
                Intrinsics.g(doFinal2, "doFinal(...)");
                for (byte b3 : doFinal2) {
                    arrayList.add(Byte.valueOf(b3));
                }
                if (i5 == length - 1) {
                    bArr = null;
                    i = 1;
                    i2 = 245;
                } else {
                    i = 1;
                    i2 = 245;
                    bArr = new byte[Math.min(245, (length - i5) - 1)];
                }
                i6 = 0;
            } else {
                int i8 = i4;
                i = i3;
                bArr = data2;
                i2 = i8;
            }
            i5++;
            int i9 = i2;
            data2 = bArr;
            i3 = i;
            i4 = i9;
        }
        byte[] bArr2 = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Byte b4 = (Byte) it.next();
            Intrinsics.e(b4);
            bArr2[i10] = b4.byteValue();
            i10++;
        }
        return bArr2;
    }
}
