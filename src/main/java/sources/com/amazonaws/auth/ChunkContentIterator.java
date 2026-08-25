package com.amazonaws.auth;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class ChunkContentIterator {
    private final byte[] a;
    private int b;

    public ChunkContentIterator(byte[] bArr) {
        this.a = bArr;
    }

    public boolean a() {
        return this.b < this.a.length;
    }

    public int b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (!a()) {
            return -1;
        }
        int min = Math.min(this.a.length - this.b, i2);
        System.arraycopy(this.a, this.b, bArr, i, min);
        this.b += min;
        return min;
    }
}
