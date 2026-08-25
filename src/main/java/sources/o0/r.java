package o0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static final a f16662e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final r f16663f = new r(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f16664a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16665b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16666c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16667d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final r a() {
            return r.f16663f;
        }
    }

    public r(int i5, int i6, int i7, int i8) {
        this.f16664a = i5;
        this.f16665b = i6;
        this.f16666c = i7;
        this.f16667d = i8;
    }

    public static /* synthetic */ r c(r rVar, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = rVar.f16664a;
        }
        if ((i9 & 2) != 0) {
            i6 = rVar.f16665b;
        }
        if ((i9 & 4) != 0) {
            i7 = rVar.f16666c;
        }
        if ((i9 & 8) != 0) {
            i8 = rVar.f16667d;
        }
        return rVar.b(i5, i6, i7, i8);
    }

    public final r b(int i5, int i6, int i7, int i8) {
        return new r(i5, i6, i7, i8);
    }

    public final int d() {
        return this.f16667d;
    }

    public final int e() {
        return this.f16667d - this.f16665b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f16664a == rVar.f16664a && this.f16665b == rVar.f16665b && this.f16666c == rVar.f16666c && this.f16667d == rVar.f16667d;
    }

    public final int f() {
        return this.f16664a;
    }

    public final int g() {
        return this.f16666c;
    }

    public final int h() {
        return this.f16665b;
    }

    public int hashCode() {
        return (((((this.f16664a * 31) + this.f16665b) * 31) + this.f16666c) * 31) + this.f16667d;
    }

    public final long i() {
        return q.a(this.f16664a, this.f16665b);
    }

    public final int j() {
        return this.f16666c - this.f16664a;
    }

    public final boolean k() {
        return this.f16664a >= this.f16666c || this.f16665b >= this.f16667d;
    }

    public final r l(int i5, int i6) {
        return new r(this.f16664a + i5, this.f16665b + i6, this.f16666c + i5, this.f16667d + i6);
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.f16664a + ", " + this.f16665b + ", " + this.f16666c + ", " + this.f16667d + ')';
    }
}
