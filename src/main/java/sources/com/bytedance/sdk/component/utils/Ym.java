package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Ym {
    private static final byte[] Sj = Sj("VP8X");

    public static boolean Sj(byte[] bArr, int i) {
        boolean Sj2;
        int i2;
        try {
            Sj2 = Sj(bArr, i + 12, Sj);
            i2 = i + 20;
        } catch (Throwable unused) {
        }
        if (bArr.length <= i2) {
            return false;
        }
        return Sj2 && ((bArr[i2] & 2) == 2);
    }

    private static boolean Sj(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] Sj(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }
}
