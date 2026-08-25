package com.google.common.collect;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class v2 {
    static int a(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d * highestOneBit))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    static boolean b(int i, int i2, double d) {
        return ((double) i) > d * ((double) i2) && i2 < 1073741824;
    }

    static int c(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
