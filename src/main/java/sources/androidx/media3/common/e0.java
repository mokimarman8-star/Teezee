package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.b;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f8601a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f8602b = a1.C0(0);

    /* renamed from: c, reason: collision with root package name */
    private static final String f8603c = a1.C0(1);

    /* renamed from: d, reason: collision with root package name */
    private static final String f8604d = a1.C0(2);

    class a extends e0 {
        a() {
        }

        @Override // androidx.media3.common.e0
        public int b(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.e0
        public b g(int i5, b bVar, boolean z5) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.e0
        public int i() {
            return 0;
        }

        @Override // androidx.media3.common.e0
        public Object m(int i5) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.e0
        public c o(int i5, c cVar, long j5) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.e0
        public int p() {
            return 0;
        }
    }

    public static final class b {

        /* renamed from: h, reason: collision with root package name */
        private static final String f8605h = a1.C0(0);

        /* renamed from: i, reason: collision with root package name */
        private static final String f8606i = a1.C0(1);

        /* renamed from: j, reason: collision with root package name */
        private static final String f8607j = a1.C0(2);

        /* renamed from: k, reason: collision with root package name */
        private static final String f8608k = a1.C0(3);

        /* renamed from: l, reason: collision with root package name */
        private static final String f8609l = a1.C0(4);

        /* renamed from: a, reason: collision with root package name */
        public Object f8610a;

        /* renamed from: b, reason: collision with root package name */
        public Object f8611b;

        /* renamed from: c, reason: collision with root package name */
        public int f8612c;

        /* renamed from: d, reason: collision with root package name */
        public long f8613d;

        /* renamed from: e, reason: collision with root package name */
        public long f8614e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f8615f;

        /* renamed from: g, reason: collision with root package name */
        public androidx.media3.common.b f8616g = androidx.media3.common.b.f8549g;

        public int a(int i5) {
            return this.f8616g.a(i5).f8573b;
        }

        public long b(int i5, int i6) {
            b.a a5 = this.f8616g.a(i5);
            if (a5.f8573b != -1) {
                return a5.f8578g[i6];
            }
            return -9223372036854775807L;
        }

        public int c() {
            return this.f8616g.f8556b;
        }

        public int d(long j5) {
            return this.f8616g.b(j5, this.f8613d);
        }

        public int e(long j5) {
            return this.f8616g.c(j5, this.f8613d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f8610a, bVar.f8610a) && Objects.equals(this.f8611b, bVar.f8611b) && this.f8612c == bVar.f8612c && this.f8613d == bVar.f8613d && this.f8614e == bVar.f8614e && this.f8615f == bVar.f8615f && Objects.equals(this.f8616g, bVar.f8616g);
        }

        public long f(int i5) {
            return this.f8616g.a(i5).f8572a;
        }

        public long g() {
            return this.f8616g.f8557c;
        }

        public int h(int i5, int i6) {
            b.a a5 = this.f8616g.a(i5);
            if (a5.f8573b != -1) {
                return a5.f8577f[i6];
            }
            return 0;
        }

        public int hashCode() {
            Object obj = this.f8610a;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f8611b;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f8612c) * 31;
            long j5 = this.f8613d;
            int i5 = (hashCode2 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j6 = this.f8614e;
            return ((((i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + (this.f8615f ? 1 : 0)) * 31) + this.f8616g.hashCode();
        }

        public long i(int i5) {
            return this.f8616g.a(i5).f8580i;
        }

        public long j() {
            return a1.y1(this.f8613d);
        }

        public long k() {
            return this.f8613d;
        }

        public int l(int i5) {
            return this.f8616g.a(i5).c();
        }

        public int m(int i5, int i6) {
            return this.f8616g.a(i5).d(i6);
        }

        public long n() {
            return a1.y1(this.f8614e);
        }

        public long o() {
            return this.f8614e;
        }

        public int p() {
            return this.f8616g.f8559e;
        }

        public boolean q(int i5) {
            return !this.f8616g.a(i5).e();
        }

        public boolean r(int i5) {
            return i5 == c() - 1 && this.f8616g.d(i5);
        }

        public boolean s(int i5) {
            return this.f8616g.a(i5).f8581j;
        }

        public b t(Object obj, Object obj2, int i5, long j5, long j6) {
            return u(obj, obj2, i5, j5, j6, androidx.media3.common.b.f8549g, false);
        }

        public b u(Object obj, Object obj2, int i5, long j5, long j6, androidx.media3.common.b bVar, boolean z5) {
            this.f8610a = obj;
            this.f8611b = obj2;
            this.f8612c = i5;
            this.f8613d = j5;
            this.f8614e = j6;
            this.f8616g = bVar;
            this.f8615f = z5;
            return this;
        }
    }

    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public Object f8628b;

        /* renamed from: d, reason: collision with root package name */
        public Object f8630d;

        /* renamed from: e, reason: collision with root package name */
        public long f8631e;

        /* renamed from: f, reason: collision with root package name */
        public long f8632f;

        /* renamed from: g, reason: collision with root package name */
        public long f8633g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f8634h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f8635i;

        /* renamed from: j, reason: collision with root package name */
        public t.g f8636j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f8637k;

        /* renamed from: l, reason: collision with root package name */
        public long f8638l;

        /* renamed from: m, reason: collision with root package name */
        public long f8639m;

        /* renamed from: n, reason: collision with root package name */
        public int f8640n;

        /* renamed from: o, reason: collision with root package name */
        public int f8641o;

        /* renamed from: p, reason: collision with root package name */
        public long f8642p;

        /* renamed from: q, reason: collision with root package name */
        public static final Object f8617q = new Object();

        /* renamed from: r, reason: collision with root package name */
        private static final Object f8618r = new Object();

        /* renamed from: s, reason: collision with root package name */
        private static final t f8619s = new t.c().d("androidx.media3.common.Timeline").i(Uri.EMPTY).a();

        /* renamed from: t, reason: collision with root package name */
        private static final String f8620t = a1.C0(1);

        /* renamed from: u, reason: collision with root package name */
        private static final String f8621u = a1.C0(2);

        /* renamed from: v, reason: collision with root package name */
        private static final String f8622v = a1.C0(3);

        /* renamed from: w, reason: collision with root package name */
        private static final String f8623w = a1.C0(4);

        /* renamed from: x, reason: collision with root package name */
        private static final String f8624x = a1.C0(5);

        /* renamed from: y, reason: collision with root package name */
        private static final String f8625y = a1.C0(6);

        /* renamed from: z, reason: collision with root package name */
        private static final String f8626z = a1.C0(7);
        private static final String A = a1.C0(8);
        private static final String B = a1.C0(9);
        private static final String C = a1.C0(10);
        private static final String D = a1.C0(11);
        private static final String E = a1.C0(12);
        private static final String F = a1.C0(13);

        /* renamed from: a, reason: collision with root package name */
        public Object f8627a = f8617q;

        /* renamed from: c, reason: collision with root package name */
        public t f8629c = f8619s;

        public long a() {
            return a1.h0(this.f8633g);
        }

        public long b() {
            return a1.y1(this.f8638l);
        }

        public long c() {
            return this.f8638l;
        }

        public long d() {
            return a1.y1(this.f8639m);
        }

        public long e() {
            return this.f8642p;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !c.class.equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return Objects.equals(this.f8627a, cVar.f8627a) && Objects.equals(this.f8629c, cVar.f8629c) && Objects.equals(this.f8630d, cVar.f8630d) && Objects.equals(this.f8636j, cVar.f8636j) && this.f8631e == cVar.f8631e && this.f8632f == cVar.f8632f && this.f8633g == cVar.f8633g && this.f8634h == cVar.f8634h && this.f8635i == cVar.f8635i && this.f8637k == cVar.f8637k && this.f8638l == cVar.f8638l && this.f8639m == cVar.f8639m && this.f8640n == cVar.f8640n && this.f8641o == cVar.f8641o && this.f8642p == cVar.f8642p;
        }

        public boolean f() {
            return this.f8636j != null;
        }

        public c g(Object obj, t tVar, Object obj2, long j5, long j6, long j7, boolean z5, boolean z6, t.g gVar, long j8, long j9, int i5, int i6, long j10) {
            t.h hVar;
            this.f8627a = obj;
            this.f8629c = tVar != null ? tVar : f8619s;
            this.f8628b = (tVar == null || (hVar = tVar.f8887b) == null) ? null : hVar.f8986h;
            this.f8630d = obj2;
            this.f8631e = j5;
            this.f8632f = j6;
            this.f8633g = j7;
            this.f8634h = z5;
            this.f8635i = z6;
            this.f8636j = gVar;
            this.f8638l = j8;
            this.f8639m = j9;
            this.f8640n = i5;
            this.f8641o = i6;
            this.f8642p = j10;
            this.f8637k = false;
            return this;
        }

        public int hashCode() {
            int hashCode = (((217 + this.f8627a.hashCode()) * 31) + this.f8629c.hashCode()) * 31;
            Object obj = this.f8630d;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            t.g gVar = this.f8636j;
            int hashCode3 = (hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j5 = this.f8631e;
            int i5 = (hashCode3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j6 = this.f8632f;
            int i6 = (i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f8633g;
            int i7 = (((((((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f8634h ? 1 : 0)) * 31) + (this.f8635i ? 1 : 0)) * 31) + (this.f8637k ? 1 : 0)) * 31;
            long j8 = this.f8638l;
            int i8 = (i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
            long j9 = this.f8639m;
            int i9 = (((((i8 + ((int) (j9 ^ (j9 >>> 32)))) * 31) + this.f8640n) * 31) + this.f8641o) * 31;
            long j10 = this.f8642p;
            return i9 + ((int) (j10 ^ (j10 >>> 32)));
        }
    }

    protected e0() {
    }

    public int a(boolean z5) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z5) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i5, b bVar, c cVar, int i6, boolean z5) {
        int i7 = f(i5, bVar).f8612c;
        if (n(i7, cVar).f8641o != i5) {
            return i5 + 1;
        }
        int e5 = e(i7, i6, z5);
        if (e5 == -1) {
            return -1;
        }
        return n(e5, cVar).f8640n;
    }

    public int e(int i5, int i6, boolean z5) {
        if (i6 == 0) {
            if (i5 == c(z5)) {
                return -1;
            }
            return i5 + 1;
        }
        if (i6 == 1) {
            return i5;
        }
        if (i6 == 2) {
            return i5 == c(z5) ? a(z5) : i5 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int c5;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (e0Var.p() != p() || e0Var.i() != i()) {
            return false;
        }
        c cVar = new c();
        b bVar = new b();
        c cVar2 = new c();
        b bVar2 = new b();
        for (int i5 = 0; i5 < p(); i5++) {
            if (!n(i5, cVar).equals(e0Var.n(i5, cVar2))) {
                return false;
            }
        }
        for (int i6 = 0; i6 < i(); i6++) {
            if (!g(i6, bVar, true).equals(e0Var.g(i6, bVar2, true))) {
                return false;
            }
        }
        int a5 = a(true);
        if (a5 != e0Var.a(true) || (c5 = c(true)) != e0Var.c(true)) {
            return false;
        }
        while (a5 != c5) {
            int e5 = e(a5, 0, true);
            if (e5 != e0Var.e(a5, 0, true)) {
                return false;
            }
            a5 = e5;
        }
        return true;
    }

    public final b f(int i5, b bVar) {
        return g(i5, bVar, false);
    }

    public abstract b g(int i5, b bVar, boolean z5);

    public b h(Object obj, b bVar) {
        return g(b(obj), bVar, true);
    }

    public int hashCode() {
        c cVar = new c();
        b bVar = new b();
        int p5 = 217 + p();
        for (int i5 = 0; i5 < p(); i5++) {
            p5 = (p5 * 31) + n(i5, cVar).hashCode();
        }
        int i6 = (p5 * 31) + i();
        for (int i7 = 0; i7 < i(); i7++) {
            i6 = (i6 * 31) + g(i7, bVar, true).hashCode();
        }
        int a5 = a(true);
        while (a5 != -1) {
            i6 = (i6 * 31) + a5;
            a5 = e(a5, 0, true);
        }
        return i6;
    }

    public abstract int i();

    public final Pair j(c cVar, b bVar, int i5, long j5) {
        return (Pair) androidx.media3.common.util.a.e(k(cVar, bVar, i5, j5, 0L));
    }

    public final Pair k(c cVar, b bVar, int i5, long j5, long j6) {
        androidx.media3.common.util.a.c(i5, 0, p());
        o(i5, cVar, j6);
        if (j5 == -9223372036854775807L) {
            j5 = cVar.c();
            if (j5 == -9223372036854775807L) {
                return null;
            }
        }
        int i6 = cVar.f8640n;
        f(i6, bVar);
        while (i6 < cVar.f8641o && bVar.f8614e != j5) {
            int i7 = i6 + 1;
            if (f(i7, bVar).f8614e > j5) {
                break;
            }
            i6 = i7;
        }
        g(i6, bVar, true);
        long j7 = j5 - bVar.f8614e;
        long j8 = bVar.f8613d;
        if (j8 != -9223372036854775807L) {
            j7 = Math.min(j7, j8 - 1);
        }
        return Pair.create(androidx.media3.common.util.a.e(bVar.f8611b), Long.valueOf(Math.max(0L, j7)));
    }

    public int l(int i5, int i6, boolean z5) {
        if (i6 == 0) {
            if (i5 == a(z5)) {
                return -1;
            }
            return i5 - 1;
        }
        if (i6 == 1) {
            return i5;
        }
        if (i6 == 2) {
            return i5 == a(z5) ? c(z5) : i5 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i5);

    public final c n(int i5, c cVar) {
        return o(i5, cVar, 0L);
    }

    public abstract c o(int i5, c cVar, long j5);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }

    public final boolean r(int i5, b bVar, c cVar, int i6, boolean z5) {
        return d(i5, bVar, cVar, i6, z5) == -1;
    }
}
