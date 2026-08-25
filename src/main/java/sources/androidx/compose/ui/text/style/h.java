package androidx.compose.ui.text.style;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5396b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5397c = i(1);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5398d = i(2);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5399e = i(3);

    /* renamed from: f, reason: collision with root package name */
    private static final int f5400f = i(4);

    /* renamed from: g, reason: collision with root package name */
    private static final int f5401g = i(5);

    /* renamed from: h, reason: collision with root package name */
    private static final int f5402h = i(6);

    /* renamed from: i, reason: collision with root package name */
    private static final int f5403i = i(EditorInfoCompat.IME_FLAG_FORCE_ASCII);

    /* renamed from: a, reason: collision with root package name */
    private final int f5404a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return h.f5399e;
        }

        public final int b() {
            return h.f5402h;
        }

        public final int c() {
            return h.f5400f;
        }

        public final int d() {
            return h.f5397c;
        }

        public final int e() {
            return h.f5398d;
        }

        public final int f() {
            return h.f5401g;
        }

        public final int g() {
            return h.f5403i;
        }
    }

    private /* synthetic */ h(int i5) {
        this.f5404a = i5;
    }

    public static final /* synthetic */ h h(int i5) {
        return new h(i5);
    }

    public static int i(int i5) {
        return i5;
    }

    public static boolean j(int i5, Object obj) {
        return (obj instanceof h) && i5 == ((h) obj).n();
    }

    public static final boolean k(int i5, int i6) {
        return i5 == i6;
    }

    public static int l(int i5) {
        return i5;
    }

    public static String m(int i5) {
        return k(i5, f5397c) ? "Left" : k(i5, f5398d) ? "Right" : k(i5, f5399e) ? "Center" : k(i5, f5400f) ? "Justify" : k(i5, f5401g) ? "Start" : k(i5, f5402h) ? "End" : k(i5, f5403i) ? "Unspecified" : "Invalid";
    }

    public boolean equals(Object obj) {
        return j(this.f5404a, obj);
    }

    public int hashCode() {
        return l(this.f5404a);
    }

    public final /* synthetic */ int n() {
        return this.f5404a;
    }

    public String toString() {
        return m(this.f5404a);
    }
}
