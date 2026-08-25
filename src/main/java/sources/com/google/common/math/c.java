package com.google.common.math;

import com.google.common.base.m;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class c {
    static double a(double d) {
        m.d(!Double.isNaN(d));
        return Math.max(d, 0.0d);
    }

    static long b(double d) {
        m.e(c(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    static boolean c(double d) {
        return Math.getExponent(d) <= 1023;
    }

    static boolean d(double d) {
        return Math.getExponent(d) >= -1022;
    }

    static double e(double d) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
    }
}
