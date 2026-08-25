package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class n {
    public static int a(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    public static m<ByteBuffer, Long> a(o oVar) throws IOException {
        if (oVar.a() < 22) {
            return null;
        }
        m<ByteBuffer, Long> a = a(oVar, 0);
        return a != null ? a : a(oVar, 65535);
    }

    private static m<ByteBuffer, Long> a(o oVar, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long a = oVar.a();
        if (a < 22) {
            return null;
        }
        int min = ((int) Math.min(i, a - 22)) + 22;
        long j = a - min;
        ByteBuffer a2 = oVar.a(j, min);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        a2.order(byteOrder);
        int b = b(a2);
        if (b == -1) {
            return null;
        }
        a2.position(b);
        ByteBuffer slice = a2.slice();
        slice.order(byteOrder);
        return m.a(slice, Long.valueOf(j + b));
    }

    static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        for (int i2 = 0; i2 <= min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && a(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    static long b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    public static long c(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    public static long d(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    public static int e(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return a(byteBuffer, byteBuffer.position() + 10);
    }
}
