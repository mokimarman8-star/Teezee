package com.transsion.athena.aatnhe;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final Map<Character, Integer> b = new HashMap();
    private long c = 0;
    private byte d = 0;

    static {
        for (int i = 0; i < 32; i++) {
            b.put(Character.valueOf(a[i]), Integer.valueOf(i));
        }
    }

    private aethna(double d, double d2, int i) {
        int min = Math.min(i, 64);
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        boolean z = true;
        while (this.d < min) {
            if (z) {
                a(d2, dArr2);
            } else {
                a(d, dArr);
            }
            z = !z;
        }
        this.c <<= 64 - min;
    }

    public static aethna a(double d, double d2, int i) {
        if (i > 12) {
            throw new IllegalArgumentException("A geohash can only be 12 character long.");
        }
        int i2 = i * 5;
        return new aethna(d, d2, i2 <= 60 ? i2 : 60);
    }

    private void a(double d, double[] dArr) {
        double d2 = (dArr[0] + dArr[1]) / 2.0d;
        if (d >= d2) {
            this.d = (byte) (this.d + 1);
            this.c = (this.c << 1) | 1;
            dArr[0] = d2;
        } else {
            this.d = (byte) (this.d + 1);
            this.c <<= 1;
            dArr[1] = d2;
        }
    }

    public String a() {
        if (this.d % 5 != 0) {
            throw new IllegalStateException("Cannot convert a geohash to base32 if the precision is not a multiple of 5.");
        }
        StringBuilder sb = new StringBuilder();
        long j = this.c;
        int ceil = (int) Math.ceil(this.d / 5.0d);
        for (int i = 0; i < ceil; i++) {
            sb.append(a[(int) (((-576460752303423488L) & j) >>> 59)]);
            j <<= 5;
        }
        return sb.toString();
    }
}
