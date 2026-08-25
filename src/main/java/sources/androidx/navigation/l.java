package androidx.navigation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f12518a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f12519b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12520c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f12521d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f12522e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12523f;

    /* renamed from: g, reason: collision with root package name */
    private final int f12524g;

    /* renamed from: h, reason: collision with root package name */
    private final int f12525h;

    /* renamed from: i, reason: collision with root package name */
    private final int f12526i;

    /* renamed from: j, reason: collision with root package name */
    private String f12527j;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f12528a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12529b;

        /* renamed from: d, reason: collision with root package name */
        private String f12531d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12532e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f12533f;

        /* renamed from: c, reason: collision with root package name */
        private int f12530c = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f12534g = -1;

        /* renamed from: h, reason: collision with root package name */
        private int f12535h = -1;

        /* renamed from: i, reason: collision with root package name */
        private int f12536i = -1;

        /* renamed from: j, reason: collision with root package name */
        private int f12537j = -1;

        public static /* synthetic */ a i(a aVar, int i5, boolean z5, boolean z6, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                z6 = false;
            }
            return aVar.g(i5, z5, z6);
        }

        public final l a() {
            String str = this.f12531d;
            return str != null ? new l(this.f12528a, this.f12529b, str, this.f12532e, this.f12533f, this.f12534g, this.f12535h, this.f12536i, this.f12537j) : new l(this.f12528a, this.f12529b, this.f12530c, this.f12532e, this.f12533f, this.f12534g, this.f12535h, this.f12536i, this.f12537j);
        }

        public final a b(int i5) {
            this.f12534g = i5;
            return this;
        }

        public final a c(int i5) {
            this.f12535h = i5;
            return this;
        }

        public final a d(boolean z5) {
            this.f12528a = z5;
            return this;
        }

        public final a e(int i5) {
            this.f12536i = i5;
            return this;
        }

        public final a f(int i5) {
            this.f12537j = i5;
            return this;
        }

        public final a g(int i5, boolean z5, boolean z6) {
            this.f12530c = i5;
            this.f12531d = null;
            this.f12532e = z5;
            this.f12533f = z6;
            return this;
        }

        public final a h(String str, boolean z5, boolean z6) {
            this.f12531d = str;
            this.f12530c = -1;
            this.f12532e = z5;
            this.f12533f = z6;
            return this;
        }

        public final a j(boolean z5) {
            this.f12529b = z5;
            return this;
        }
    }

    public l(boolean z5, boolean z6, int i5, boolean z7, boolean z8, int i6, int i7, int i8, int i9) {
        this.f12518a = z5;
        this.f12519b = z6;
        this.f12520c = i5;
        this.f12521d = z7;
        this.f12522e = z8;
        this.f12523f = i6;
        this.f12524g = i7;
        this.f12525h = i8;
        this.f12526i = i9;
    }

    public l(boolean z5, boolean z6, String str, boolean z7, boolean z8, int i5, int i6, int i7, int i8) {
        this(z5, z6, NavDestination.j.a(str).hashCode(), z7, z8, i5, i6, i7, i8);
        this.f12527j = str;
    }

    public final int a() {
        return this.f12523f;
    }

    public final int b() {
        return this.f12524g;
    }

    public final int c() {
        return this.f12525h;
    }

    public final int d() {
        return this.f12526i;
    }

    public final int e() {
        return this.f12520c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(l.class, obj.getClass())) {
            return false;
        }
        l lVar = (l) obj;
        return this.f12518a == lVar.f12518a && this.f12519b == lVar.f12519b && this.f12520c == lVar.f12520c && Intrinsics.c(this.f12527j, lVar.f12527j) && this.f12521d == lVar.f12521d && this.f12522e == lVar.f12522e && this.f12523f == lVar.f12523f && this.f12524g == lVar.f12524g && this.f12525h == lVar.f12525h && this.f12526i == lVar.f12526i;
    }

    public final boolean f() {
        return this.f12521d;
    }

    public final boolean g() {
        return this.f12518a;
    }

    public final boolean h() {
        return this.f12522e;
    }

    public int hashCode() {
        int i5 = (((((g() ? 1 : 0) * 31) + (i() ? 1 : 0)) * 31) + this.f12520c) * 31;
        String str = this.f12527j;
        return ((((((((((((i5 + (str == null ? 0 : str.hashCode())) * 31) + (f() ? 1 : 0)) * 31) + (h() ? 1 : 0)) * 31) + this.f12523f) * 31) + this.f12524g) * 31) + this.f12525h) * 31) + this.f12526i;
    }

    public final boolean i() {
        return this.f12519b;
    }
}
