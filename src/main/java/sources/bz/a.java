package bz;

import android.util.Base64;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    public byte[] a(String str) {
        return Base64.decode(str, 2);
    }

    public byte[] b(String str) {
        return Base64.decode(str, 2);
    }

    public String c(byte[] bArr) {
        return new String(Base64.encode(bArr, 2));
    }
}
