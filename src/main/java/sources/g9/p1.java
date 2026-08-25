package g9;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.q3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.w1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g3;
import g9.c;
import java.io.IOException;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class p1 implements g9.a {
    private final com.google.android.exoplayer2.util.e a;
    private final l3.b b;
    private final l3.d c;
    private final a d;
    private final SparseArray e;
    private com.google.android.exoplayer2.util.r f;
    private p2 g;
    private com.google.android.exoplayer2.util.o h;
    private boolean i;

    private static final class a {
        private final l3.b a;
        private ImmutableList b = ImmutableList.of();
        private ImmutableMap c = ImmutableMap.of();
        private o.b d;
        private o.b e;
        private o.b f;

        public a(l3.b bVar) {
            this.a = bVar;
        }

        private void b(ImmutableMap.b bVar, o.b bVar2, l3 l3Var) {
            if (bVar2 == null) {
                return;
            }
            if (l3Var.f(bVar2.a) != -1) {
                bVar.h(bVar2, l3Var);
                return;
            }
            l3 l3Var2 = (l3) this.c.get(bVar2);
            if (l3Var2 != null) {
                bVar.h(bVar2, l3Var2);
            }
        }

        private static o.b c(p2 p2Var, ImmutableList immutableList, o.b bVar, l3.b bVar2) {
            l3 currentTimeline = p2Var.getCurrentTimeline();
            int currentPeriodIndex = p2Var.getCurrentPeriodIndex();
            Object q = currentTimeline.u() ? null : currentTimeline.q(currentPeriodIndex);
            int g = (p2Var.isPlayingAd() || currentTimeline.u()) ? -1 : currentTimeline.j(currentPeriodIndex, bVar2).g(com.google.android.exoplayer2.util.p0.B0(p2Var.getCurrentPosition()) - bVar2.q());
            for (int i = 0; i < immutableList.size(); i++) {
                o.b bVar3 = (o.b) immutableList.get(i);
                if (i(bVar3, q, p2Var.isPlayingAd(), p2Var.getCurrentAdGroupIndex(), p2Var.getCurrentAdIndexInAdGroup(), g)) {
                    return bVar3;
                }
            }
            if (immutableList.isEmpty() && bVar != null) {
                if (i(bVar, q, p2Var.isPlayingAd(), p2Var.getCurrentAdGroupIndex(), p2Var.getCurrentAdIndexInAdGroup(), g)) {
                    return bVar;
                }
            }
            return null;
        }

        private static boolean i(o.b bVar, Object obj, boolean z, int i, int i2, int i3) {
            if (bVar.a.equals(obj)) {
                return (z && bVar.b == i && bVar.c == i2) || (!z && bVar.b == -1 && bVar.e == i3);
            }
            return false;
        }

        private void m(l3 l3Var) {
            ImmutableMap.b builder = ImmutableMap.builder();
            if (this.b.isEmpty()) {
                b(builder, this.e, l3Var);
                if (!com.google.common.base.j.a(this.f, this.e)) {
                    b(builder, this.f, l3Var);
                }
                if (!com.google.common.base.j.a(this.d, this.e) && !com.google.common.base.j.a(this.d, this.f)) {
                    b(builder, this.d, l3Var);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    b(builder, (o.b) this.b.get(i), l3Var);
                }
                if (!this.b.contains(this.d)) {
                    b(builder, this.d, l3Var);
                }
            }
            this.c = builder.d();
        }

        public o.b d() {
            return this.d;
        }

        public o.b e() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (o.b) g3.g(this.b);
        }

        public l3 f(o.b bVar) {
            return (l3) this.c.get(bVar);
        }

        public o.b g() {
            return this.e;
        }

        public o.b h() {
            return this.f;
        }

        public void j(p2 p2Var) {
            this.d = c(p2Var, this.b, this.e, this.a);
        }

        public void k(List list, o.b bVar, p2 p2Var) {
            this.b = ImmutableList.copyOf(list);
            if (!list.isEmpty()) {
                this.e = (o.b) list.get(0);
                this.f = (o.b) com.google.android.exoplayer2.util.a.e(bVar);
            }
            if (this.d == null) {
                this.d = c(p2Var, this.b, this.e, this.a);
            }
            m(p2Var.getCurrentTimeline());
        }

        public void l(p2 p2Var) {
            this.d = c(p2Var, this.b, this.e, this.a);
            m(p2Var.getCurrentTimeline());
        }
    }

    public p1(com.google.android.exoplayer2.util.e eVar) {
        this.a = (com.google.android.exoplayer2.util.e) com.google.android.exoplayer2.util.a.e(eVar);
        this.f = new com.google.android.exoplayer2.util.r(com.google.android.exoplayer2.util.p0.Q(), eVar, new r.b() { // from class: g9.a0
            public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                p1.a1((c) obj, mVar);
            }
        });
        l3.b bVar = new l3.b();
        this.b = bVar;
        this.c = new l3.d();
        this.d = new a(bVar);
        this.e = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P1(c.a aVar, int i, p2.e eVar, p2.e eVar2, c cVar) {
        cVar.S(aVar, i);
        cVar.y(aVar, eVar, eVar2, i);
    }

    private c.a U0(o.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.g);
        l3 f = bVar == null ? null : this.d.f(bVar);
        if (bVar != null && f != null) {
            return T0(f, f.l(bVar.a, this.b).c, bVar);
        }
        int u = this.g.u();
        l3 currentTimeline = this.g.getCurrentTimeline();
        if (u >= currentTimeline.t()) {
            currentTimeline = l3.a;
        }
        return T0(currentTimeline, u, null);
    }

    private c.a V0() {
        return U0(this.d.e());
    }

    private c.a W0(int i, o.b bVar) {
        com.google.android.exoplayer2.util.a.e(this.g);
        if (bVar != null) {
            return this.d.f(bVar) != null ? U0(bVar) : T0(l3.a, i, bVar);
        }
        l3 currentTimeline = this.g.getCurrentTimeline();
        if (i >= currentTimeline.t()) {
            currentTimeline = l3.a;
        }
        return T0(currentTimeline, i, null);
    }

    private c.a X0() {
        return U0(this.d.g());
    }

    private c.a Y0() {
        return U0(this.d.h());
    }

    private c.a Z0(PlaybackException playbackException) {
        v9.j jVar;
        return (!(playbackException instanceof ExoPlaybackException) || (jVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? S0() : U0(new o.b(jVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a1(c cVar, com.google.android.exoplayer2.util.m mVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b2(c.a aVar, String str, long j, long j2, c cVar) {
        cVar.Z(aVar, str, j);
        cVar.w0(aVar, str, j2, j);
        cVar.F(aVar, 2, str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d1(c.a aVar, String str, long j, long j2, c cVar) {
        cVar.H(aVar, str, j);
        cVar.I(aVar, str, j2, j);
        cVar.F(aVar, 1, str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d2(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.N(aVar, eVar);
        cVar.L(aVar, 2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e2(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.U(aVar, eVar);
        cVar.r(aVar, 2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.P(aVar, eVar);
        cVar.L(aVar, 1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g1(c.a aVar, com.google.android.exoplayer2.decoder.e eVar, c cVar) {
        cVar.z(aVar, eVar);
        cVar.r(aVar, 1, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(c.a aVar, com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar, c cVar) {
        cVar.e0(aVar, p1Var);
        cVar.r0(aVar, p1Var, gVar);
        cVar.j(aVar, 2, p1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h1(c.a aVar, com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar, c cVar) {
        cVar.u(aVar, p1Var);
        cVar.f(aVar, p1Var, gVar);
        cVar.j(aVar, 1, p1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(c.a aVar, com.google.android.exoplayer2.video.y yVar, c cVar) {
        cVar.f0(aVar, yVar);
        cVar.E(aVar, yVar.a, yVar.b, yVar.c, yVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(p2 p2Var, c cVar, com.google.android.exoplayer2.util.m mVar) {
        cVar.k0(p2Var, new c.b(mVar, this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2() {
        final c.a S0 = S0();
        m2(S0, 1028, new r.a() { // from class: g9.h1
            public final void invoke(Object obj) {
                ((c) obj).D(c.a.this);
            }
        });
        this.f.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v1(c.a aVar, int i, c cVar) {
        cVar.Y(aVar);
        cVar.v0(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z1(c.a aVar, boolean z, c cVar) {
        cVar.d(aVar, z);
        cVar.n0(aVar, z);
    }

    public final void A(int i, o.b bVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1023, new r.a() { // from class: g9.i1
            public final void invoke(Object obj) {
                ((c) obj).b(c.a.this);
            }
        });
    }

    public final void B(int i, o.b bVar, final int i2) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1022, new r.a() { // from class: g9.u0
            public final void invoke(Object obj) {
                p1.v1(c.a.this, i2, (c) obj);
            }
        });
    }

    public final void C(int i, o.b bVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1027, new r.a() { // from class: g9.g0
            public final void invoke(Object obj) {
                ((c) obj).i(c.a.this);
            }
        });
    }

    public final void D(int i, o.b bVar, final v9.h hVar, final v9.i iVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1001, new r.a() { // from class: g9.i
            public final void invoke(Object obj) {
                ((c) obj).A(c.a.this, hVar, iVar);
            }
        });
    }

    public final void E(int i, o.b bVar, final v9.i iVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1005, new r.a() { // from class: g9.p0
            public final void invoke(Object obj) {
                ((c) obj).O(c.a.this, iVar);
            }
        });
    }

    public final void F(int i, o.b bVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1025, new r.a() { // from class: g9.j1
            public final void invoke(Object obj) {
                ((c) obj).h0(c.a.this);
            }
        });
    }

    protected final c.a S0() {
        return U0(this.d.d());
    }

    protected final c.a T0(l3 l3Var, int i, o.b bVar) {
        o.b bVar2 = l3Var.u() ? null : bVar;
        long elapsedRealtime = this.a.elapsedRealtime();
        boolean z = l3Var.equals(this.g.getCurrentTimeline()) && i == this.g.u();
        long j = 0;
        if (bVar2 == null || !bVar2.b()) {
            if (z) {
                j = this.g.getContentPosition();
            } else if (!l3Var.u()) {
                j = l3Var.r(i, this.c).e();
            }
        } else if (z && this.g.getCurrentAdGroupIndex() == bVar2.b && this.g.getCurrentAdIndexInAdGroup() == bVar2.c) {
            j = this.g.getCurrentPosition();
        }
        return new c.a(elapsedRealtime, l3Var, i, bVar2, j, this.g.getCurrentTimeline(), this.g.u(), this.d.d(), this.g.getCurrentPosition(), this.g.d());
    }

    @Override // g9.a
    public final void a(final Exception exc) {
        final c.a Y0 = Y0();
        m2(Y0, 1014, new r.a() { // from class: g9.n0
            public final void invoke(Object obj) {
                ((c) obj).m0(c.a.this, exc);
            }
        });
    }

    @Override // g9.a
    public final void b(final String str) {
        final c.a Y0 = Y0();
        m2(Y0, 1019, new r.a() { // from class: g9.a1
            public final void invoke(Object obj) {
                ((c) obj).z0(c.a.this, str);
            }
        });
    }

    @Override // g9.a
    public final void c(final String str) {
        final c.a Y0 = Y0();
        m2(Y0, 1012, new r.a() { // from class: g9.d0
            public final void invoke(Object obj) {
                ((c) obj).x0(c.a.this, str);
            }
        });
    }

    @Override // g9.a
    public final void d(final long j) {
        final c.a Y0 = Y0();
        m2(Y0, 1010, new r.a() { // from class: g9.f0
            public final void invoke(Object obj) {
                ((c) obj).q0(c.a.this, j);
            }
        });
    }

    @Override // g9.a
    public final void e(final Exception exc) {
        final c.a Y0 = Y0();
        m2(Y0, 1030, new r.a() { // from class: g9.m1
            public final void invoke(Object obj) {
                ((c) obj).g0(c.a.this, exc);
            }
        });
    }

    @Override // g9.a
    public final void f(final Object obj, final long j) {
        final c.a Y0 = Y0();
        m2(Y0, 26, new r.a() { // from class: g9.e1
            public final void invoke(Object obj2) {
                ((c) obj2).a(c.a.this, obj, j);
            }
        });
    }

    @Override // g9.a
    public final void g(final Exception exc) {
        final c.a Y0 = Y0();
        m2(Y0, 1029, new r.a() { // from class: g9.n1
            public final void invoke(Object obj) {
                ((c) obj).j0(c.a.this, exc);
            }
        });
    }

    @Override // g9.a
    public final void h(final int i, final long j, final long j2) {
        final c.a Y0 = Y0();
        m2(Y0, 1011, new r.a() { // from class: g9.f1
            public final void invoke(Object obj) {
                ((c) obj).T(c.a.this, i, j, j2);
            }
        });
    }

    @Override // g9.a
    public final void i(final long j, final int i) {
        final c.a X0 = X0();
        m2(X0, 1021, new r.a() { // from class: g9.o0
            public final void invoke(Object obj) {
                ((c) obj).B(c.a.this, j, i);
            }
        });
    }

    @Override // g9.a
    public final void j(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a Y0 = Y0();
        m2(Y0, 1007, new r.a() { // from class: g9.s0
            public final void invoke(Object obj) {
                p1.g1(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // g9.a
    public final void k(final com.google.android.exoplayer2.p1 p1Var, final com.google.android.exoplayer2.decoder.g gVar) {
        final c.a Y0 = Y0();
        m2(Y0, 1017, new r.a() { // from class: g9.v
            public final void invoke(Object obj) {
                p1.g2(c.a.this, p1Var, gVar, (c) obj);
            }
        });
    }

    public final void l(int i, o.b bVar, final v9.h hVar, final v9.i iVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1002, new r.a() { // from class: g9.g1
            public final void invoke(Object obj) {
                ((c) obj).m(c.a.this, hVar, iVar);
            }
        });
    }

    @Override // g9.a
    public final void m() {
        if (this.i) {
            return;
        }
        final c.a S0 = S0();
        this.i = true;
        m2(S0, -1, new r.a() { // from class: g9.k
            public final void invoke(Object obj) {
                ((c) obj).b0(c.a.this);
            }
        });
    }

    protected final void m2(c.a aVar, int i, r.a aVar2) {
        this.e.put(i, aVar);
        this.f.l(i, aVar2);
    }

    @Override // g9.a
    public final void n(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a X0 = X0();
        m2(X0, 1020, new r.a() { // from class: g9.z
            public final void invoke(Object obj) {
                p1.d2(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // g9.a
    public final void o(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a X0 = X0();
        m2(X0, 1013, new r.a() { // from class: g9.c0
            public final void invoke(Object obj) {
                p1.f1(c.a.this, eVar, (c) obj);
            }
        });
    }

    @Override // g9.a
    public final void onAudioDecoderInitialized(final String str, final long j, final long j2) {
        final c.a Y0 = Y0();
        m2(Y0, 1008, new r.a() { // from class: g9.d
            public final void invoke(Object obj) {
                p1.d1(c.a.this, str, j2, j, (c) obj);
            }
        });
    }

    public void onAvailableCommandsChanged(final p2.b bVar) {
        final c.a S0 = S0();
        m2(S0, 13, new r.a() { // from class: g9.u
            public final void invoke(Object obj) {
                ((c) obj).o0(c.a.this, bVar);
            }
        });
    }

    public final void onBandwidthSample(final int i, final long j, final long j2) {
        final c.a V0 = V0();
        m2(V0, 1006, new r.a() { // from class: g9.b1
            public final void invoke(Object obj) {
                ((c) obj).p0(c.a.this, i, j, j2);
            }
        });
    }

    public void onCues(final da.f fVar) {
        final c.a S0 = S0();
        m2(S0, 27, new r.a() { // from class: g9.t
            public final void invoke(Object obj) {
                ((c) obj).J(c.a.this, fVar);
            }
        });
    }

    public void onCues(final List list) {
        final c.a S0 = S0();
        m2(S0, 27, new r.a() { // from class: g9.h0
            public final void invoke(Object obj) {
                ((c) obj).p(c.a.this, list);
            }
        });
    }

    public void onDeviceInfoChanged(final com.google.android.exoplayer2.r rVar) {
        final c.a S0 = S0();
        m2(S0, 29, new r.a() { // from class: g9.x0
            public final void invoke(Object obj) {
                ((c) obj).g(c.a.this, rVar);
            }
        });
    }

    public void onDeviceVolumeChanged(final int i, final boolean z) {
        final c.a S0 = S0();
        m2(S0, 30, new r.a() { // from class: g9.y0
            public final void invoke(Object obj) {
                ((c) obj).n(c.a.this, i, z);
            }
        });
    }

    @Override // g9.a
    public final void onDroppedFrames(final int i, final long j) {
        final c.a X0 = X0();
        m2(X0, 1018, new r.a() { // from class: g9.j0
            public final void invoke(Object obj) {
                ((c) obj).t(c.a.this, i, j);
            }
        });
    }

    public void onEvents(p2 p2Var, p2.c cVar) {
    }

    public final void onIsLoadingChanged(final boolean z) {
        final c.a S0 = S0();
        m2(S0, 3, new r.a() { // from class: g9.v0
            public final void invoke(Object obj) {
                p1.z1(c.a.this, z, (c) obj);
            }
        });
    }

    public void onIsPlayingChanged(final boolean z) {
        final c.a S0 = S0();
        m2(S0, 7, new r.a() { // from class: g9.l1
            public final void invoke(Object obj) {
                ((c) obj).q(c.a.this, z);
            }
        });
    }

    public void onLoadingChanged(boolean z) {
    }

    public final void onMediaItemTransition(final w1 w1Var, final int i) {
        final c.a S0 = S0();
        m2(S0, 1, new r.a() { // from class: g9.s
            public final void invoke(Object obj) {
                ((c) obj).l(c.a.this, w1Var, i);
            }
        });
    }

    public void onMediaMetadataChanged(final b2 b2Var) {
        final c.a S0 = S0();
        m2(S0, 14, new r.a() { // from class: g9.f
            public final void invoke(Object obj) {
                ((c) obj).e(c.a.this, b2Var);
            }
        });
    }

    public final void onMetadata(final Metadata metadata) {
        final c.a S0 = S0();
        m2(S0, 28, new r.a() { // from class: g9.z0
            public final void invoke(Object obj) {
                ((c) obj).t0(c.a.this, metadata);
            }
        });
    }

    public final void onPlayWhenReadyChanged(final boolean z, final int i) {
        final c.a S0 = S0();
        m2(S0, 5, new r.a() { // from class: g9.o
            public final void invoke(Object obj) {
                ((c) obj).s(c.a.this, z, i);
            }
        });
    }

    public final void onPlaybackParametersChanged(final o2 o2Var) {
        final c.a S0 = S0();
        m2(S0, 12, new r.a() { // from class: g9.h
            public final void invoke(Object obj) {
                ((c) obj).R(c.a.this, o2Var);
            }
        });
    }

    public final void onPlaybackStateChanged(final int i) {
        final c.a S0 = S0();
        m2(S0, 4, new r.a() { // from class: g9.x
            public final void invoke(Object obj) {
                ((c) obj).i0(c.a.this, i);
            }
        });
    }

    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final c.a S0 = S0();
        m2(S0, 6, new r.a() { // from class: g9.m0
            public final void invoke(Object obj) {
                ((c) obj).u0(c.a.this, i);
            }
        });
    }

    public final void onPlayerError(final PlaybackException playbackException) {
        final c.a Z0 = Z0(playbackException);
        m2(Z0, 10, new r.a() { // from class: g9.r
            public final void invoke(Object obj) {
                ((c) obj).G(c.a.this, playbackException);
            }
        });
    }

    public void onPlayerErrorChanged(final PlaybackException playbackException) {
        final c.a Z0 = Z0(playbackException);
        m2(Z0, 10, new r.a() { // from class: g9.l0
            public final void invoke(Object obj) {
                ((c) obj).o(c.a.this, playbackException);
            }
        });
    }

    public final void onPlayerStateChanged(final boolean z, final int i) {
        final c.a S0 = S0();
        m2(S0, -1, new r.a() { // from class: g9.j
            public final void invoke(Object obj) {
                ((c) obj).M(c.a.this, z, i);
            }
        });
    }

    public void onPositionDiscontinuity(int i) {
    }

    public final void onPositionDiscontinuity(final p2.e eVar, final p2.e eVar2, final int i) {
        if (i == 1) {
            this.i = false;
        }
        this.d.j((p2) com.google.android.exoplayer2.util.a.e(this.g));
        final c.a S0 = S0();
        m2(S0, 11, new r.a() { // from class: g9.r0
            public final void invoke(Object obj) {
                p1.P1(c.a.this, i, eVar, eVar2, (c) obj);
            }
        });
    }

    public void onRenderedFirstFrame() {
    }

    public final void onRepeatModeChanged(final int i) {
        final c.a S0 = S0();
        m2(S0, 8, new r.a() { // from class: g9.e0
            public final void invoke(Object obj) {
                ((c) obj).W(c.a.this, i);
            }
        });
    }

    public final void onSeekProcessed() {
        final c.a S0 = S0();
        m2(S0, -1, new r.a() { // from class: g9.m
            public final void invoke(Object obj) {
                ((c) obj).l0(c.a.this);
            }
        });
    }

    public final void onShuffleModeEnabledChanged(final boolean z) {
        final c.a S0 = S0();
        m2(S0, 9, new r.a() { // from class: g9.o1
            public final void invoke(Object obj) {
                ((c) obj).c0(c.a.this, z);
            }
        });
    }

    public final void onSkipSilenceEnabledChanged(final boolean z) {
        final c.a Y0 = Y0();
        m2(Y0, 23, new r.a() { // from class: g9.k1
            public final void invoke(Object obj) {
                ((c) obj).w(c.a.this, z);
            }
        });
    }

    public final void onSurfaceSizeChanged(final int i, final int i2) {
        final c.a Y0 = Y0();
        m2(Y0, 24, new r.a() { // from class: g9.p
            public final void invoke(Object obj) {
                ((c) obj).y0(c.a.this, i, i2);
            }
        });
    }

    public final void onTimelineChanged(l3 l3Var, final int i) {
        this.d.l((p2) com.google.android.exoplayer2.util.a.e(this.g));
        final c.a S0 = S0();
        m2(S0, 0, new r.a() { // from class: g9.t0
            public final void invoke(Object obj) {
                ((c) obj).a0(c.a.this, i);
            }
        });
    }

    public void onTrackSelectionParametersChanged(final na.z zVar) {
        final c.a S0 = S0();
        m2(S0, 19, new r.a() { // from class: g9.b0
            public final void invoke(Object obj) {
                ((c) obj).C(c.a.this, zVar);
            }
        });
    }

    public void onTracksChanged(final q3 q3Var) {
        final c.a S0 = S0();
        m2(S0, 2, new r.a() { // from class: g9.i0
            public final void invoke(Object obj) {
                ((c) obj).X(c.a.this, q3Var);
            }
        });
    }

    @Override // g9.a
    public final void onVideoDecoderInitialized(final String str, final long j, final long j2) {
        final c.a Y0 = Y0();
        m2(Y0, 1016, new r.a() { // from class: g9.y
            public final void invoke(Object obj) {
                p1.b2(c.a.this, str, j2, j, (c) obj);
            }
        });
    }

    public final void onVideoSizeChanged(final com.google.android.exoplayer2.video.y yVar) {
        final c.a Y0 = Y0();
        m2(Y0, 25, new r.a() { // from class: g9.d1
            public final void invoke(Object obj) {
                p1.h2(c.a.this, yVar, (c) obj);
            }
        });
    }

    public final void onVolumeChanged(final float f) {
        final c.a Y0 = Y0();
        m2(Y0, 22, new r.a() { // from class: g9.w0
            public final void invoke(Object obj) {
                ((c) obj).K(c.a.this, f);
            }
        });
    }

    public final void p(int i, o.b bVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1026, new r.a() { // from class: g9.c1
            public final void invoke(Object obj) {
                ((c) obj).Q(c.a.this);
            }
        });
    }

    @Override // g9.a
    public void q(c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f.c(cVar);
    }

    @Override // g9.a
    public void r(final p2 p2Var, Looper looper) {
        com.google.android.exoplayer2.util.a.g(this.g == null || this.d.b.isEmpty());
        this.g = (p2) com.google.android.exoplayer2.util.a.e(p2Var);
        this.h = this.a.createHandler(looper, (Handler.Callback) null);
        this.f = this.f.e(looper, new r.b() { // from class: g9.l
            public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                p1.this.k2(p2Var, (c) obj, mVar);
            }
        });
    }

    @Override // g9.a
    public void release() {
        ((com.google.android.exoplayer2.util.o) com.google.android.exoplayer2.util.a.i(this.h)).post(new Runnable() { // from class: g9.g
            @Override // java.lang.Runnable
            public final void run() {
                p1.this.l2();
            }
        });
    }

    public /* synthetic */ void s(int i, o.b bVar) {
        com.google.android.exoplayer2.drm.l.a(this, i, bVar);
    }

    @Override // g9.a
    public final void t(final com.google.android.exoplayer2.p1 p1Var, final com.google.android.exoplayer2.decoder.g gVar) {
        final c.a Y0 = Y0();
        m2(Y0, 1009, new r.a() { // from class: g9.e
            public final void invoke(Object obj) {
                p1.h1(c.a.this, p1Var, gVar, (c) obj);
            }
        });
    }

    public final void u(int i, o.b bVar, final v9.h hVar, final v9.i iVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1000, new r.a() { // from class: g9.k0
            public final void invoke(Object obj) {
                ((c) obj).d0(c.a.this, hVar, iVar);
            }
        });
    }

    @Override // g9.a
    public final void v(final com.google.android.exoplayer2.decoder.e eVar) {
        final c.a Y0 = Y0();
        m2(Y0, 1015, new r.a() { // from class: g9.w
            public final void invoke(Object obj) {
                p1.e2(c.a.this, eVar, (c) obj);
            }
        });
    }

    public final void w(int i, o.b bVar, final Exception exc) {
        final c.a W0 = W0(i, bVar);
        m2(W0, MemoryConstants.KB, new r.a() { // from class: g9.q0
            public final void invoke(Object obj) {
                ((c) obj).s0(c.a.this, exc);
            }
        });
    }

    @Override // g9.a
    public final void x(List list, o.b bVar) {
        this.d.k(list, bVar, (p2) com.google.android.exoplayer2.util.a.e(this.g));
    }

    public final void y(int i, o.b bVar, final v9.i iVar) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1004, new r.a() { // from class: g9.n
            public final void invoke(Object obj) {
                ((c) obj).c(c.a.this, iVar);
            }
        });
    }

    public final void z(int i, o.b bVar, final v9.h hVar, final v9.i iVar, final IOException iOException, final boolean z) {
        final c.a W0 = W0(i, bVar);
        m2(W0, 1003, new r.a() { // from class: g9.q
            public final void invoke(Object obj) {
                ((c) obj).h(c.a.this, hVar, iVar, iOException, z);
            }
        });
    }
}
