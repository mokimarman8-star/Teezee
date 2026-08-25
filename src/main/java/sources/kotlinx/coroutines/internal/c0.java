package kotlinx.coroutines.internal;

import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract /* synthetic */ class c0 {
    public static final int a(String str, int i, int i2, int i3) {
        return (int) a0.c(str, i, i2, i3);
    }

    public static final long b(String str, long j, long j2, long j3) {
        String d = a0.d(str);
        if (d == null) {
            return j;
        }
        Long x = StringsKt.x(d);
        if (x == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d + '\'').toString());
        }
        long longValue = x.longValue();
        if (j2 <= longValue && longValue <= j3) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String d = a0.d(str);
        return d == null ? str2 : d;
    }

    public static final boolean d(String str, boolean z) {
        String d = a0.d(str);
        return d != null ? Boolean.parseBoolean(d) : z;
    }

    public static /* synthetic */ int e(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return a0.b(str, i, i2, i3);
    }

    public static /* synthetic */ long f(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return a0.c(str, j, j4, j3);
    }
}
