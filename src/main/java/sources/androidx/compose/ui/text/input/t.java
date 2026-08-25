package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5256a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5257b = e(-1);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5258c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5259d = e(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5260e = e(2);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5261f = e(3);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return t.f5259d;
        }

        public final int b() {
            return t.f5258c;
        }

        public final int c() {
            return t.f5261f;
        }

        public final int d() {
            return t.f5260e;
        }
    }

    private static int e(int i5) {
        return i5;
    }

    public static final boolean f(int i5, int i6) {
        return i5 == i6;
    }

    public static int g(int i5) {
        return i5;
    }

    public static String h(int i5) {
        return f(i5, f5257b) ? "Unspecified" : f(i5, f5258c) ? "None" : f(i5, f5259d) ? "Characters" : f(i5, f5260e) ? "Words" : f(i5, f5261f) ? "Sentences" : "Invalid";
    }
}
