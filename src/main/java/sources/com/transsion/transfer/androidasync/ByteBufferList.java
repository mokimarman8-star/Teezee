package com.transsion.transfer.androidasync;

import android.os.Looper;
import com.transsion.transfer.androidasync.util.ArrayDeque;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ByteBufferList {
    static PriorityQueue d = new PriorityQueue(8, new Reclaimer());
    private static int e = 1048576;
    public static int f = 262144;
    static int g = 0;
    static int h = 0;
    private static final Object i = new Object();
    public static final ByteBuffer j = ByteBuffer.allocate(0);
    ArrayDeque a = new ArrayDeque();
    ByteOrder b = ByteOrder.BIG_ENDIAN;
    private int c = 0;

    static class Reclaimer implements Comparator<ByteBuffer> {
        Reclaimer() {
        }

        @Override // java.util.Comparator
        public int compare(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            return byteBuffer.capacity() > byteBuffer2.capacity() ? 1 : -1;
        }
    }

    public ByteBufferList() {
    }

    public ByteBufferList(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }

    public ByteBufferList(ByteBuffer... byteBufferArr) {
        b(byteBufferArr);
    }

    public static void A(ByteBuffer byteBuffer) {
        PriorityQueue p;
        if (byteBuffer == null || byteBuffer.isDirect() || byteBuffer.arrayOffset() != 0 || byteBuffer.array().length != byteBuffer.capacity() || byteBuffer.capacity() < 8192 || byteBuffer.capacity() > f || (p = p()) == null) {
            return;
        }
        synchronized (i) {
            while (g > e && p.size() > 0 && ((ByteBuffer) p.peek()).capacity() < byteBuffer.capacity()) {
                try {
                    g -= ((ByteBuffer) p.remove()).capacity();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (g > e) {
                return;
            }
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            g += byteBuffer.capacity();
            p.add(byteBuffer);
            h = Math.max(h, byteBuffer.capacity());
        }
    }

    private void d(int i2) {
        if (C() >= 0) {
            this.c += i2;
        }
    }

    private static PriorityQueue p() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || Thread.currentThread() != mainLooper.getThread()) {
            return d;
        }
        return null;
    }

    public static ByteBuffer t(int i2) {
        PriorityQueue p;
        if (i2 <= h && (p = p()) != null) {
            synchronized (i) {
                while (p.size() > 0) {
                    try {
                        ByteBuffer byteBuffer = (ByteBuffer) p.remove();
                        if (p.size() == 0) {
                            h = 0;
                        }
                        g -= byteBuffer.capacity();
                        if (byteBuffer.capacity() >= i2) {
                            return byteBuffer;
                        }
                    } finally {
                    }
                }
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i2));
    }

    private ByteBuffer x(int i2) {
        ByteBuffer byteBuffer;
        if (C() < i2) {
            throw new IllegalArgumentException("count : " + C() + "/" + i2);
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) this.a.peek();
        while (byteBuffer2 != null && !byteBuffer2.hasRemaining()) {
            A((ByteBuffer) this.a.remove());
            byteBuffer2 = (ByteBuffer) this.a.peek();
        }
        if (byteBuffer2 == null) {
            return j;
        }
        if (byteBuffer2.remaining() >= i2) {
            return byteBuffer2.order(this.b);
        }
        ByteBuffer t = t(i2);
        t.limit(i2);
        byte[] array = t.array();
        int i3 = 0;
        loop1: while (true) {
            byteBuffer = null;
            while (i3 < i2) {
                byteBuffer = (ByteBuffer) this.a.remove();
                int min = Math.min(i2 - i3, byteBuffer.remaining());
                byteBuffer.get(array, i3, min);
                i3 += min;
                if (byteBuffer.remaining() == 0) {
                    break;
                }
            }
            A(byteBuffer);
        }
        if (byteBuffer != null && byteBuffer.remaining() > 0) {
            this.a.addFirst(byteBuffer);
        }
        this.a.addFirst(t);
        return t.order(this.b);
    }

    public void B() {
        while (this.a.size() > 0) {
            A((ByteBuffer) this.a.remove());
        }
        this.c = 0;
    }

    public int C() {
        return this.c;
    }

    public ByteBuffer D() {
        ByteBuffer byteBuffer = (ByteBuffer) this.a.remove();
        this.c -= byteBuffer.remaining();
        return byteBuffer;
    }

    public int E() {
        return this.a.size();
    }

    public void F() {
        x(0);
    }

    public ByteBufferList a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            A(byteBuffer);
            return this;
        }
        d(byteBuffer.remaining());
        if (this.a.size() > 0) {
            ByteBuffer byteBuffer2 = (ByteBuffer) this.a.getLast();
            if (byteBuffer2.capacity() - byteBuffer2.limit() >= byteBuffer.remaining()) {
                byteBuffer2.mark();
                byteBuffer2.position(byteBuffer2.limit());
                byteBuffer2.limit(byteBuffer2.capacity());
                byteBuffer2.put(byteBuffer);
                byteBuffer2.limit(byteBuffer2.position());
                byteBuffer2.reset();
                A(byteBuffer);
                F();
                return this;
            }
        }
        this.a.add(byteBuffer);
        F();
        return this;
    }

    public ByteBufferList b(ByteBuffer... byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            a(byteBuffer);
        }
        return this;
    }

    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            A(byteBuffer);
            return;
        }
        d(byteBuffer.remaining());
        if (this.a.size() > 0) {
            ByteBuffer byteBuffer2 = (ByteBuffer) this.a.getFirst();
            if (byteBuffer2.position() >= byteBuffer.remaining()) {
                byteBuffer2.position(byteBuffer2.position() - byteBuffer.remaining());
                byteBuffer2.mark();
                byteBuffer2.put(byteBuffer);
                byteBuffer2.reset();
                A(byteBuffer);
                return;
            }
        }
        this.a.addFirst(byteBuffer);
    }

    public byte e() {
        byte b = x(1).get();
        this.c--;
        return b;
    }

    public void f(ByteBufferList byteBufferList) {
        g(byteBufferList, C());
    }

    public void g(ByteBufferList byteBufferList, int i2) {
        if (C() < i2) {
            throw new IllegalArgumentException("length");
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            ByteBuffer byteBuffer = (ByteBuffer) this.a.remove();
            int remaining = byteBuffer.remaining();
            if (remaining == 0) {
                A(byteBuffer);
            } else {
                int i4 = remaining + i3;
                if (i4 > i2) {
                    int i5 = i2 - i3;
                    ByteBuffer t = t(i5);
                    t.limit(i5);
                    byteBuffer.get(t.array(), 0, i5);
                    byteBufferList.a(t);
                    this.a.addFirst(byteBuffer);
                    break;
                }
                byteBufferList.a(byteBuffer);
                i3 = i4;
            }
        }
        this.c -= i2;
    }

    public void h(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    public void i(byte[] bArr, int i2, int i3) {
        if (C() < i3) {
            throw new IllegalArgumentException("length");
        }
        int i4 = i3;
        while (i4 > 0) {
            ByteBuffer byteBuffer = (ByteBuffer) this.a.peek();
            int min = Math.min(byteBuffer.remaining(), i4);
            if (bArr != null) {
                byteBuffer.get(bArr, i2, min);
            } else {
                byteBuffer.position(byteBuffer.position() + min);
            }
            i4 -= min;
            i2 += min;
            if (byteBuffer.remaining() == 0) {
                A(byteBuffer);
            }
        }
        this.c -= i3;
    }

    public ByteBuffer j() {
        if (C() == 0) {
            return j;
        }
        x(C());
        return D();
    }

    public ByteBuffer[] k() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.a.toArray(new ByteBuffer[this.a.size()]);
        this.a.clear();
        this.c = 0;
        return byteBufferArr;
    }

    public byte[] l() {
        byte[] bArr = new byte[C()];
        h(bArr);
        return bArr;
    }

    public char m() {
        char c = (char) x(1).get();
        this.c--;
        return c;
    }

    public int n() {
        int i2 = x(4).getInt();
        this.c -= 4;
        return i2;
    }

    public long o() {
        long j2 = x(8).getLong();
        this.c -= 8;
        return j2;
    }

    public short q() {
        short s = x(2).getShort();
        this.c -= 2;
        return s;
    }

    public boolean r() {
        return C() > 0;
    }

    public boolean s() {
        return this.c == 0;
    }

    public ByteBufferList u(ByteOrder byteOrder) {
        this.b = byteOrder;
        return this;
    }

    public String v() {
        return w(null);
    }

    public String w(Charset charset) {
        byte[] array;
        int remaining;
        int i2;
        if (charset == null) {
            charset = com.transsion.transfer.androidasync.util.c.b;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            if (byteBuffer.isDirect()) {
                array = new byte[byteBuffer.remaining()];
                remaining = byteBuffer.remaining();
                byteBuffer.get(array);
                i2 = 0;
            } else {
                array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                remaining = byteBuffer.remaining();
                i2 = arrayOffset;
            }
            sb.append(new String(array, i2, remaining, charset));
        }
        return sb.toString();
    }

    public String y() {
        return z(null);
    }

    public String z(Charset charset) {
        String w = w(charset);
        B();
        return w;
    }
}
