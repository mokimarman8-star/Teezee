package androidx.datastore.preferences.protobuf;

import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f7623a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    private static final Class f7624b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f7625c;

    static {
        Class e5 = e("java.io.FileOutputStream");
        f7624b = e5;
        f7625c = b(e5);
    }

    private static byte[] a() {
        SoftReference softReference = (SoftReference) f7623a.get();
        if (softReference == null) {
            return null;
        }
        return (byte[]) softReference.get();
    }

    private static long b(Class cls) {
        if (cls == null) {
            return -1L;
        }
        try {
            if (k1.I()) {
                return k1.L(cls.getDeclaredField("channel"));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static byte[] c(int i5) {
        int max = Math.max(i5, 1024);
        byte[] a5 = a();
        if (a5 == null || d(max, a5.length)) {
            a5 = new byte[max];
            if (max <= 16384) {
                f(a5);
            }
        }
        return a5;
    }

    private static boolean d(int i5, int i6) {
        return i6 < i5 && ((float) i6) < ((float) i5) * 0.5f;
    }

    private static Class e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void f(byte[] bArr) {
        f7623a.set(new SoftReference(bArr));
    }

    static void g(ByteBuffer byteBuffer, OutputStream outputStream) {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!h(byteBuffer, outputStream)) {
                byte[] c5 = c(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), c5.length);
                    byteBuffer.get(c5, 0, min);
                    outputStream.write(c5, 0, min);
                }
            }
            y.c(byteBuffer, position);
        } catch (Throwable th) {
            y.c(byteBuffer, position);
            throw th;
        }
    }

    private static boolean h(ByteBuffer byteBuffer, OutputStream outputStream) {
        WritableByteChannel writableByteChannel;
        long j5 = f7625c;
        if (j5 < 0 || !f7624b.isInstance(outputStream)) {
            return false;
        }
        try {
            writableByteChannel = (WritableByteChannel) k1.G(outputStream, j5);
        } catch (ClassCastException unused) {
            writableByteChannel = null;
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }
}
