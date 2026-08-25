package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c5 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3315a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3316b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3317c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3318d = d(2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c5.f3316b;
        }

        public final int b() {
            return c5.f3317c;
        }

        public final int c() {
            return c5.f3318d;
        }
    }

    public static int d(int i5) {
        return i5;
    }

    public static final boolean e(int i5, int i6) {
        return i5 == i6;
    }

    public static int f(int i5) {
        return i5;
    }

    public static String g(int i5) {
        return e(i5, f3316b) ? "Butt" : e(i5, f3317c) ? "Round" : e(i5, f3318d) ? "Square" : "Unknown";
    }
}
