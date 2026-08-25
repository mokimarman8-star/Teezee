package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5135b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5136c = d(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5137d = d(1);

    /* renamed from: a, reason: collision with root package name */
    private final int f5138a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return n.f5137d;
        }

        public final int b() {
            return n.f5136c;
        }
    }

    private /* synthetic */ n(int i5) {
        this.f5138a = i5;
    }

    public static final /* synthetic */ n c(int i5) {
        return new n(i5);
    }

    public static int d(int i5) {
        return i5;
    }

    public static boolean e(int i5, Object obj) {
        return (obj instanceof n) && i5 == ((n) obj).i();
    }

    public static final boolean f(int i5, int i6) {
        return i5 == i6;
    }

    public static int g(int i5) {
        return i5;
    }

    public static String h(int i5) {
        return f(i5, f5136c) ? "Normal" : f(i5, f5137d) ? "Italic" : "Invalid";
    }

    public boolean equals(Object obj) {
        return e(this.f5138a, obj);
    }

    public int hashCode() {
        return g(this.f5138a);
    }

    public final /* synthetic */ int i() {
        return this.f5138a;
    }

    public String toString() {
        return h(this.f5138a);
    }
}
