package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16652b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f16653c = b(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f16654d = b(9205357640488583168L);

    /* renamed from: a, reason: collision with root package name */
    private final long f16655a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ k(long j5) {
        this.f16655a = j5;
    }

    public static final /* synthetic */ k a(long j5) {
        return new k(j5);
    }

    public static long b(long j5) {
        return j5;
    }

    public static boolean c(long j5, Object obj) {
        return (obj instanceof k) && j5 == ((k) obj).h();
    }

    public static final float d(long j5) {
        return i.g(Float.intBitsToFloat((int) (j5 >> 32)));
    }

    public static final float e(long j5) {
        return i.g(Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    public static int f(long j5) {
        return androidx.collection.s.a(j5);
    }

    public static String g(long j5) {
        if (j5 == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) i.k(d(j5))) + ", " + ((Object) i.k(e(j5))) + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f16655a, obj);
    }

    public final /* synthetic */ long h() {
        return this.f16655a;
    }

    public int hashCode() {
        return f(this.f16655a);
    }

    public String toString() {
        return g(this.f16655a);
    }
}
