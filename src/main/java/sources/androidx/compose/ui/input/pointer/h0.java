package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3995a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3996b = f(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3997c = f(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3998d = f(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f3999e = f(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f4000f = f(4);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return h0.f4000f;
        }

        public final int b() {
            return h0.f3998d;
        }

        public final int c() {
            return h0.f3999e;
        }

        public final int d() {
            return h0.f3997c;
        }

        public final int e() {
            return h0.f3996b;
        }
    }

    private static int f(int i5) {
        return i5;
    }

    public static final boolean g(int i5, int i6) {
        return i5 == i6;
    }

    public static int h(int i5) {
        return i5;
    }

    public static String i(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }
}
