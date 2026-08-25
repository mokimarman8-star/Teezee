package com.cloud.hisavana.sdk;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class m1 {
    static final int[] a = new int[0];
    static final long[] b = new long[0];
    static final Object[] c = new Object[0];

    static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i8 = (i4 + i3) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i2) {
                i4 = i8 + 1;
            } else {
                if (i9 <= i2) {
                    return i8;
                }
                i3 = i8 - 1;
            }
        }
        return ~i4;
    }
}
