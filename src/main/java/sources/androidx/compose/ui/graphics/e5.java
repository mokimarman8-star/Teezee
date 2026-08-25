package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e5 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3433a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final long f3434b = f5.a(0.5f, 0.5f);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return e5.f3434b;
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
        return androidx.collection.s.a(j5);
    }

    public static String g(long j5) {
        return "TransformOrigin(packedValue=" + j5 + ')';
    }
}
