package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5438a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5439b = d(1);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5440c = d(2);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5441d = d(3);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return p.f5439b;
        }

        public final int b() {
            return p.f5440c;
        }

        public final int c() {
            return p.f5441d;
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
        return e(i5, f5439b) ? "Clip" : e(i5, f5440c) ? "Ellipsis" : e(i5, f5441d) ? "Visible" : "Invalid";
    }
}
