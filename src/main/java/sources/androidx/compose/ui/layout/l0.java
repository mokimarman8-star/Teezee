package androidx.compose.ui.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4190a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f4191b = m0.a(Float.NaN, Float.NaN);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static long a(long j5) {
        return j5;
    }

    public static final float b(long j5) {
        if (!(j5 != f4191b)) {
            g0.a.b("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    public static final float c(long j5) {
        if (!(j5 != f4191b)) {
            g0.a.b("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }
}
