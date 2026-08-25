package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5262a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f5263b = j(0);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5264c = j(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5265d = j(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5266e = j(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5267f = j(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f5268g = j(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f5269h = j(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f5270i = j(7);

    /* renamed from: j, reason: collision with root package name */
    private static final int f5271j = j(8);

    /* renamed from: k, reason: collision with root package name */
    private static final int f5272k = j(9);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return u.f5265d;
        }

        public final int b() {
            return u.f5272k;
        }

        public final int c() {
            return u.f5269h;
        }

        public final int d() {
            return u.f5266e;
        }

        public final int e() {
            return u.f5271j;
        }

        public final int f() {
            return u.f5270i;
        }

        public final int g() {
            return u.f5267f;
        }

        public final int h() {
            return u.f5264c;
        }

        public final int i() {
            return u.f5268g;
        }
    }

    private static int j(int i5) {
        return i5;
    }

    public static final boolean k(int i5, int i6) {
        return i5 == i6;
    }

    public static int l(int i5) {
        return i5;
    }

    public static String m(int i5) {
        return k(i5, f5263b) ? "Unspecified" : k(i5, f5264c) ? "Text" : k(i5, f5265d) ? "Ascii" : k(i5, f5266e) ? "Number" : k(i5, f5267f) ? "Phone" : k(i5, f5268g) ? "Uri" : k(i5, f5269h) ? "Email" : k(i5, f5270i) ? "Password" : k(i5, f5271j) ? "NumberPassword" : k(i5, f5272k) ? "Decimal" : "Invalid";
    }
}
