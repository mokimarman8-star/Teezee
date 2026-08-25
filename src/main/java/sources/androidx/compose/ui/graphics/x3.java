package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class x3 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3876a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3877b = c(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3878c = c(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3879d = c(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f3880e = c(3);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return x3.f3878c;
        }

        public final int b() {
            return x3.f3877b;
        }
    }

    public static int c(int i5) {
        return i5;
    }

    public static final boolean d(int i5, int i6) {
        return i5 == i6;
    }

    public static int e(int i5) {
        return i5;
    }

    public static String f(int i5) {
        return d(i5, f3877b) ? "None" : d(i5, f3878c) ? "Low" : d(i5, f3879d) ? "Medium" : d(i5, f3880e) ? "High" : "Unknown";
    }
}
