package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5429c;

    /* renamed from: d, reason: collision with root package name */
    private static final o f5430d;

    /* renamed from: e, reason: collision with root package name */
    private static final o f5431e;

    /* renamed from: a, reason: collision with root package name */
    private final int f5432a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5433b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a() {
            return o.f5430d;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5434a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f5435b = d(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f5436c = d(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f5437d = d(3);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f5436c;
            }

            public final int b() {
                return b.f5435b;
            }

            public final int c() {
                return b.f5437d;
            }
        }

        private static int d(int i5) {
            return i5;
        }

        public static final boolean e(int i5, int i6) {
            return i5 == i6;
        }

        public static int f(int i5) {
            return i5;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        f5429c = new a(defaultConstructorMarker);
        b.a aVar = b.f5434a;
        f5430d = new o(aVar.a(), false, defaultConstructorMarker);
        f5431e = new o(aVar.b(), true, defaultConstructorMarker);
    }

    private o(int i5, boolean z5) {
        this.f5432a = i5;
        this.f5433b = z5;
    }

    public /* synthetic */ o(int i5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, z5);
    }

    public final int b() {
        return this.f5432a;
    }

    public final boolean c() {
        return this.f5433b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return b.e(this.f5432a, oVar.f5432a) && this.f5433b == oVar.f5433b;
    }

    public int hashCode() {
        return (b.f(this.f5432a) * 31) + androidx.compose.foundation.e.a(this.f5433b);
    }

    public String toString() {
        return Intrinsics.c(this, f5430d) ? "TextMotion.Static" : Intrinsics.c(this, f5431e) ? "TextMotion.Animated" : "Invalid";
    }
}
