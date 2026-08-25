package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16647b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final float f16648c = g(0.0f);

    /* renamed from: d, reason: collision with root package name */
    private static final float f16649d = g(Float.POSITIVE_INFINITY);

    /* renamed from: e, reason: collision with root package name */
    private static final float f16650e = g(Float.NaN);

    /* renamed from: a, reason: collision with root package name */
    private final float f16651a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return i.f16648c;
        }

        public final float b() {
            return i.f16650e;
        }
    }

    private /* synthetic */ i(float f5) {
        this.f16651a = f5;
    }

    public static final /* synthetic */ i d(float f5) {
        return new i(f5);
    }

    public static int f(float f5, float f6) {
        return Float.compare(f5, f6);
    }

    public static float g(float f5) {
        return f5;
    }

    public static boolean h(float f5, Object obj) {
        return (obj instanceof i) && Float.compare(f5, ((i) obj).l()) == 0;
    }

    public static final boolean i(float f5, float f6) {
        return Float.compare(f5, f6) == 0;
    }

    public static int j(float f5) {
        return Float.floatToIntBits(f5);
    }

    public static String k(float f5) {
        if (Float.isNaN(f5)) {
            return "Dp.Unspecified";
        }
        return f5 + ".dp";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return e(((i) obj).l());
    }

    public int e(float f5) {
        return f(this.f16651a, f5);
    }

    public boolean equals(Object obj) {
        return h(this.f16651a, obj);
    }

    public int hashCode() {
        return j(this.f16651a);
    }

    public final /* synthetic */ float l() {
        return this.f16651a;
    }

    public String toString() {
        return k(this.f16651a);
    }
}
