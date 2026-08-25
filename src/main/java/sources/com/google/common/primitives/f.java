package com.google.common.primitives;

import com.google.common.base.m;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class f {
    public static byte a(long j) {
        m.h((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int b(byte b, byte b2) {
        return c(b) - c(b2);
    }

    public static int c(byte b) {
        return b & 255;
    }
}
