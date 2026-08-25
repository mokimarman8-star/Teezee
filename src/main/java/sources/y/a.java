package y;

import androidx.collection.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0183a f18521a = new C0183a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f18522b = b.b(0.0f, 0.0f, 2, null);

    /* renamed from: y.a$a, reason: collision with other inner class name */
    public static final class C0183a {
        private C0183a() {
        }

        public /* synthetic */ C0183a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f18522b;
        }
    }

    public static long b(long j5) {
        return j5;
    }

    public static final boolean c(long j5, long j6) {
        return j5 == j6;
    }

    public static final float d(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static final float e(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    public static int f(long j5) {
        return s.a(j5);
    }

    public static String g(long j5) {
        if (d(j5) == e(j5)) {
            return "CornerRadius.circular(" + c.a(d(j5), 1) + ')';
        }
        return "CornerRadius.elliptical(" + c.a(d(j5), 1) + ", " + c.a(e(j5), 1) + ')';
    }
}
