package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3936a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3937b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f3938c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f3939d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f3940e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f3941f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f3942g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f3938c;
        }

        public final int b() {
            return e.f3937b;
        }
    }

    static {
        int c5 = c(1);
        f3937b = c5;
        int c6 = c(2);
        f3938c = c6;
        f3939d = c5;
        f3940e = c6;
        f3941f = c(3);
        f3942g = c5;
    }

    public static int c(int i5) {
        return i5;
    }

    public static final boolean d(int i5, int i6) {
        return i5 == i6;
    }
}
