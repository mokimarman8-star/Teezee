package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f7768a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f7769b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    static final Charset f7770c = Charset.forName("ISO-8859-1");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f7771d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f7772e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f7773f;

    public interface a {
        int getNumber();
    }

    public interface b {
    }

    public interface c {
        boolean isInRange(int i5);
    }

    public interface d extends List, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        d mutableCopyWithCapacity(int i5);
    }

    static {
        byte[] bArr = new byte[0];
        f7771d = bArr;
        f7772e = ByteBuffer.wrap(bArr);
        f7773f = i.k(bArr);
    }

    static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z5) {
        return z5 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i5, int i6) {
        int g5 = g(i6, bArr, i5, i6);
        if (g5 == 0) {
            return 1;
        }
        return g5;
    }

    public static int f(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    static int g(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }
}
