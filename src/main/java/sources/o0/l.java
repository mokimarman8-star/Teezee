package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16656a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f16657b = b(0);

    /* renamed from: c, reason: collision with root package name */
    private static final long f16658c = b(9205357640488583168L);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return l.f16657b;
        }
    }

    public static long b(long j5) {
        return j5;
    }

    public static final float c(long j5) {
        return i.g(Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    public static final float d(long j5) {
        return i.g(Float.intBitsToFloat((int) (j5 >> 32)));
    }
}
