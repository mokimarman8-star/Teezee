package androidx.compose.foundation.text.modifiers;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0017a f2270a = new C0017a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f2271b = b(Float.NaN, Float.NaN);

    /* renamed from: androidx.compose.foundation.text.modifiers.a$a, reason: collision with other inner class name */
    public static final class C0017a {
        private C0017a() {
        }

        public /* synthetic */ C0017a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f2271b;
        }
    }

    public static long b(float f5, float f6) {
        return c((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    private static long c(long j5) {
        return j5;
    }

    public static long d(o0.e eVar) {
        return b(eVar.getDensity(), eVar.B0());
    }

    public static final boolean e(long j5, long j6) {
        return j5 == j6;
    }

    public static final float f(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static final float g(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    public static String h(long j5) {
        return "InlineDensity(density=" + f(j5) + ", fontScale=" + g(j5) + ')';
    }
}
