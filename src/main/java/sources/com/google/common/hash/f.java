package com.google.common.hash;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class f {
    static final int a = (int) System.currentTimeMillis();

    public static d a() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static d b(int i) {
        return new Murmur3_128HashFunction(i);
    }
}
