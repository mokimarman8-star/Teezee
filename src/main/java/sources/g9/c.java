package g9;

import android.util.SparseArray;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.q3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.w1;
import java.io.IOException;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface c {

    public static final class a {
        public final long a;
        public final l3 b;
        public final int c;
        public final o.b d;
        public final long e;
        public final l3 f;
        public final int g;
        public final o.b h;
        public final long i;
        public final long j;

        public a(long j, l3 l3Var, int i, o.b bVar, long j2, l3 l3Var2, int i2, o.b bVar2, long j3, long j4) {
            this.a = j;
            this.b = l3Var;
            this.c = i;
            this.d = bVar;
            this.e = j2;
            this.f = l3Var2;
            this.g = i2;
            this.h = bVar2;
            this.i = j3;
            this.j = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && com.google.common.base.j.a(this.b, aVar.b) && com.google.common.base.j.a(this.d, aVar.d) && com.google.common.base.j.a(this.f, aVar.f) && com.google.common.base.j.a(this.h, aVar.h);
        }

        public int hashCode() {
            return com.google.common.base.j.b(new Object[]{Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j)});
        }
    }

    public static final class b {
        private final com.google.android.exoplayer2.util.m a;
        private final SparseArray b;

        public b(com.google.android.exoplayer2.util.m mVar, SparseArray sparseArray) {
            this.a = mVar;
            SparseArray sparseArray2 = new SparseArray(mVar.d());
            for (int i = 0; i < mVar.d(); i++) {
                int c = mVar.c(i);
                sparseArray2.append(c, (a) com.google.android.exoplayer2.util.a.e((a) sparseArray.get(c)));
            }
            this.b = sparseArray2;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public int b(int i) {
            return this.a.c(i);
        }

        public a c(int i) {
            return (a) com.google.android.exoplayer2.util.a.e((a) this.b.get(i));
        }

        public int d() {
            return this.a.d();
        }
    }

    void A(a aVar, v9.h hVar, v9.i iVar);

    void B(a aVar, long j, int i);

    void C(a aVar, na.z zVar);

    void D(a aVar);

    void E(a aVar, int i, int i2, int i3, float f);

    void F(a aVar, int i, String str, long j);

    void G(a aVar, PlaybackException playbackException);

    void H(a aVar, String str, long j);

    void I(a aVar, String str, long j, long j2);

    void J(a aVar, da.f fVar);

    void K(a aVar, float f);

    void L(a aVar, int i, com.google.android.exoplayer2.decoder.e eVar);

    void M(a aVar, boolean z, int i);

    void N(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void O(a aVar, v9.i iVar);

    void P(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void Q(a aVar);

    void R(a aVar, o2 o2Var);

    void S(a aVar, int i);

    void T(a aVar, int i, long j, long j2);

    void U(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void W(a aVar, int i);

    void X(a aVar, q3 q3Var);

    void Y(a aVar);

    void Z(a aVar, String str, long j);

    void a(a aVar, Object obj, long j);

    void a0(a aVar, int i);

    void b(a aVar);

    void b0(a aVar);

    void c(a aVar, v9.i iVar);

    void c0(a aVar, boolean z);

    void d(a aVar, boolean z);

    void d0(a aVar, v9.h hVar, v9.i iVar);

    void e(a aVar, b2 b2Var);

    void e0(a aVar, com.google.android.exoplayer2.p1 p1Var);

    void f(a aVar, com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar);

    void f0(a aVar, com.google.android.exoplayer2.video.y yVar);

    void g(a aVar, com.google.android.exoplayer2.r rVar);

    void g0(a aVar, Exception exc);

    void h(a aVar, v9.h hVar, v9.i iVar, IOException iOException, boolean z);

    void h0(a aVar);

    void i(a aVar);

    void i0(a aVar, int i);

    void j(a aVar, int i, com.google.android.exoplayer2.p1 p1Var);

    void j0(a aVar, Exception exc);

    void k0(p2 p2Var, b bVar);

    void l(a aVar, w1 w1Var, int i);

    void l0(a aVar);

    void m(a aVar, v9.h hVar, v9.i iVar);

    void m0(a aVar, Exception exc);

    void n(a aVar, int i, boolean z);

    void n0(a aVar, boolean z);

    void o(a aVar, PlaybackException playbackException);

    void o0(a aVar, p2.b bVar);

    void p(a aVar, List list);

    void p0(a aVar, int i, long j, long j2);

    void q(a aVar, boolean z);

    void q0(a aVar, long j);

    void r(a aVar, int i, com.google.android.exoplayer2.decoder.e eVar);

    void r0(a aVar, com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar);

    void s(a aVar, boolean z, int i);

    void s0(a aVar, Exception exc);

    void t(a aVar, int i, long j);

    void t0(a aVar, Metadata metadata);

    void u(a aVar, com.google.android.exoplayer2.p1 p1Var);

    void u0(a aVar, int i);

    void v0(a aVar, int i);

    void w(a aVar, boolean z);

    void w0(a aVar, String str, long j, long j2);

    void x0(a aVar, String str);

    void y(a aVar, p2.e eVar, p2.e eVar2, int i);

    void y0(a aVar, int i, int i2);

    void z(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void z0(a aVar, String str);
}
