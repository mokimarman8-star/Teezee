package androidx.compose.ui.text.style;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5410b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5411c = h(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5412d = h(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5413e = h(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5414f = h(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f5415g = h(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f5416h = h(EditorInfoCompat.IME_FLAG_FORCE_ASCII);

    /* renamed from: a, reason: collision with root package name */
    private final int f5417a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return j.f5413e;
        }

        public final int b() {
            return j.f5414f;
        }

        public final int c() {
            return j.f5415g;
        }

        public final int d() {
            return j.f5411c;
        }

        public final int e() {
            return j.f5412d;
        }

        public final int f() {
            return j.f5416h;
        }
    }

    private /* synthetic */ j(int i5) {
        this.f5417a = i5;
    }

    public static final /* synthetic */ j g(int i5) {
        return new j(i5);
    }

    public static int h(int i5) {
        return i5;
    }

    public static boolean i(int i5, Object obj) {
        return (obj instanceof j) && i5 == ((j) obj).m();
    }

    public static final boolean j(int i5, int i6) {
        return i5 == i6;
    }

    public static int k(int i5) {
        return i5;
    }

    public static String l(int i5) {
        return j(i5, f5411c) ? "Ltr" : j(i5, f5412d) ? "Rtl" : j(i5, f5413e) ? "Content" : j(i5, f5414f) ? "ContentOrLtr" : j(i5, f5415g) ? "ContentOrRtl" : j(i5, f5416h) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return i(this.f5417a, obj);
    }

    public int hashCode() {
        return k(this.f5417a);
    }

    public final /* synthetic */ int m() {
        return this.f5417a;
    }

    public String toString() {
        return l(this.f5417a);
    }
}
