package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0038a f5350b = new C0038a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final float f5351c = c(0.5f);

    /* renamed from: d, reason: collision with root package name */
    private static final float f5352d = c(-0.5f);

    /* renamed from: e, reason: collision with root package name */
    private static final float f5353e = c(0.0f);

    /* renamed from: a, reason: collision with root package name */
    private final float f5354a;

    /* renamed from: androidx.compose.ui.text.style.a$a, reason: collision with other inner class name */
    public static final class C0038a {
        private C0038a() {
        }

        public /* synthetic */ C0038a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return a.f5353e;
        }
    }

    private /* synthetic */ a(float f5) {
        this.f5354a = f5;
    }

    public static final /* synthetic */ a b(float f5) {
        return new a(f5);
    }

    public static float c(float f5) {
        return f5;
    }

    public static boolean d(float f5, Object obj) {
        return (obj instanceof a) && Float.compare(f5, ((a) obj).h()) == 0;
    }

    public static final boolean e(float f5, float f6) {
        return Float.compare(f5, f6) == 0;
    }

    public static int f(float f5) {
        return Float.floatToIntBits(f5);
    }

    public static String g(float f5) {
        return "BaselineShift(multiplier=" + f5 + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f5354a, obj);
    }

    public final /* synthetic */ float h() {
        return this.f5354a;
    }

    public int hashCode() {
        return f(this.f5354a);
    }

    public String toString() {
        return g(this.f5354a);
    }
}
