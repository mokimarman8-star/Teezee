package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d5 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3427a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3428b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3429c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3430d = d(2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return d5.f3430d;
        }

        public final int b() {
            return d5.f3428b;
        }

        public final int c() {
            return d5.f3429c;
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
        return e(i5, f3428b) ? "Miter" : e(i5, f3429c) ? "Round" : e(i5, f3430d) ? "Bevel" : "Unknown";
    }
}
