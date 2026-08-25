package com.transsion.transfer.androidasync.util;

import com.transsion.transfer.androidasync.ByteBufferList;
import java.nio.ByteBuffer;
import okio.internal.Buffer;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    int b = 0;
    int c = Buffer.SEGMENTING_THRESHOLD;
    final int a = ByteBufferList.f;

    public ByteBuffer a() {
        return b(this.b);
    }

    public ByteBuffer b(int i) {
        return ByteBufferList.t(Math.min(Math.max(i, this.c), this.a));
    }

    public int c() {
        return this.c;
    }

    public a d(int i) {
        this.c = Math.max(0, i);
        return this;
    }

    public void e(long j) {
        this.b = ((int) j) * 2;
    }
}
