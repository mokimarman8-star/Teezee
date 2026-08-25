package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5088b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f5089c = e(0);

    /* renamed from: d, reason: collision with root package name */
    private static final int f5090d = e(1);

    /* renamed from: e, reason: collision with root package name */
    private static final int f5091e = e(2);

    /* renamed from: a, reason: collision with root package name */
    private final int f5092a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return e.f5091e;
        }

        public final int b() {
            return e.f5089c;
        }

        public final int c() {
            return e.f5090d;
        }
    }

    private /* synthetic */ e(int i5) {
        this.f5092a = i5;
    }

    public static final /* synthetic */ e d(int i5) {
        return new e(i5);
    }

    private static int e(int i5) {
        return i5;
    }

    public static boolean f(int i5, Object obj) {
        return (obj instanceof e) && i5 == ((e) obj).j();
    }

    public static final boolean g(int i5, int i6) {
        return i5 == i6;
    }

    public static int h(int i5) {
        return i5;
    }

    public static String i(int i5) {
        if (i5 == f5089c) {
            return "EmojiSupportMatch.Default";
        }
        if (i5 == f5090d) {
            return "EmojiSupportMatch.None";
        }
        if (i5 == f5091e) {
            return "EmojiSupportMatch.All";
        }
        return "Invalid(value=" + i5 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f5092a, obj);
    }

    public int hashCode() {
        return h(this.f5092a);
    }

    public final /* synthetic */ int j() {
        return this.f5092a;
    }

    public String toString() {
        return i(this.f5092a);
    }
}
