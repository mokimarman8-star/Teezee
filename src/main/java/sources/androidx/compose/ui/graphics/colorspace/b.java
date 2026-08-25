package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3341a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f3342b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f3343c;

    /* renamed from: d, reason: collision with root package name */
    private static final long f3344d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f3345e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return b.f3344d;
        }

        public final long b() {
            return b.f3342b;
        }

        public final long c() {
            return b.f3343c;
        }
    }

    static {
        long j5 = 3;
        long j6 = j5 << 32;
        f3342b = d((0 & 4294967295L) | j6);
        f3343c = d((1 & 4294967295L) | j6);
        f3344d = d(j6 | (2 & 4294967295L));
        f3345e = d((j5 & 4294967295L) | (4 << 32));
    }

    public static long d(long j5) {
        return j5;
    }

    public static final boolean e(long j5, long j6) {
        return j5 == j6;
    }

    public static final int f(long j5) {
        return (int) (j5 >> 32);
    }

    public static int g(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static String h(long j5) {
        return e(j5, f3342b) ? "Rgb" : e(j5, f3343c) ? "Xyz" : e(j5, f3344d) ? "Lab" : e(j5, f3345e) ? "Cmyk" : "Unknown";
    }
}
