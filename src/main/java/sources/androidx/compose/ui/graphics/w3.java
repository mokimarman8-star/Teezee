package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class w3 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3871a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f3872b = d(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f3873c = d(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f3874d = d(2);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return w3.f3872b;
        }

        public final int b() {
            return w3.f3874d;
        }

        public final int c() {
            return w3.f3873c;
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
        return "CompositingStrategy(value=" + i5 + ')';
    }
}
