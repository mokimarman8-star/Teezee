package com.pgl.ssdk;

import com.pgl.ssdk.d;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public static h a(o oVar, r rVar, int i) throws IOException, i {
        try {
            d.a a2 = d.a(oVar, rVar);
            long b = a2.b();
            o a3 = a2.a();
            ByteBuffer a4 = a3.a(0L, (int) a3.a());
            a4.order(ByteOrder.LITTLE_ENDIAN);
            return new h(a(a4, i), b, rVar.a(), rVar.e(), rVar.d());
        } catch (b e) {
            throw new i(e.getMessage(), e);
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i) throws i {
        a(byteBuffer);
        ByteBuffer a2 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (a2.hasRemaining()) {
            i2++;
            if (a2.remaining() < 8) {
                throw new i("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            long j = a2.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new i("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int position = a2.position() + i3;
            if (i3 > a2.remaining()) {
                throw new i("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + a2.remaining());
            }
            if (a2.getInt() == i) {
                return b(a2, i3 - 4);
            }
            a2.position(position);
        }
        throw new i("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i)));
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) throws a {
        if (byteBuffer.remaining() < 4) {
            throw new a("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return b(byteBuffer, i);
        }
        throw new a("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static byte[] c(ByteBuffer byteBuffer) throws a {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new a("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new a("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
    }
}
