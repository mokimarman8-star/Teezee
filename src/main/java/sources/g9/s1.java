package g9;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.l3;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.q3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.w1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;
import g9.c;
import g9.t1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import x1.a2;
import x1.a3;
import x1.b2;
import x1.b3;
import x1.c2;
import x1.c3;
import x1.d2;
import x1.d3;
import x1.e2;
import x1.e3;
import x1.f2;
import x1.f3;
import x1.g2;
import x1.g3;
import x1.h2;
import x1.h3;
import x1.i2;
import x1.i3;
import x1.j2;
import x1.j3;
import x1.k2;
import x1.k3;
import x1.l2;
import x1.m2;
import x1.m3;
import x1.n2;
import x1.n3;
import x1.o3;
import x1.p3;
import x1.q2;
import x1.r2;
import x1.r3;
import x1.s2;
import x1.s3;
import x1.t2;
import x1.t3;
import x1.u2;
import x1.u3;
import x1.v1;
import x1.v2;
import x1.v3;
import x1.w2;
import x1.x1;
import x1.x2;
import x1.y1;
import x1.y2;
import x1.z1;
import x1.z2;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class s1 implements c, t1.a {
    private boolean A;
    private final Context a;
    private final t1 b;
    private final PlaybackSession c;
    private String i;
    private PlaybackMetrics.Builder j;
    private int k;
    private PlaybackException n;
    private b o;
    private b p;
    private b q;
    private com.google.android.exoplayer2.p1 r;
    private com.google.android.exoplayer2.p1 s;
    private com.google.android.exoplayer2.p1 t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private final l3.d e = new l3.d();
    private final l3.b f = new l3.b();
    private final HashMap h = new HashMap();
    private final HashMap g = new HashMap();
    private final long d = SystemClock.elapsedRealtime();
    private int l = 0;
    private int m = 0;

    private static final class a {
        public final int a;
        public final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private static final class b {
        public final com.google.android.exoplayer2.p1 a;
        public final int b;
        public final String c;

        public b(com.google.android.exoplayer2.p1 p1Var, int i, String str) {
            this.a = p1Var;
            this.b = i;
            this.c = str;
        }
    }

    private s1(Context context, PlaybackSession playbackSession) {
        this.a = context.getApplicationContext();
        this.c = playbackSession;
        r1 r1Var = new r1();
        this.b = r1Var;
        r1Var.c(this);
    }

    private boolean A0(b bVar) {
        return bVar != null && bVar.c.equals(this.b.a());
    }

    public static s1 B0(Context context) {
        MediaMetricsManager a2 = r3.a(context.getSystemService("media_metrics"));
        if (a2 == null) {
            return null;
        }
        return new s1(context, s3.a(a2));
    }

    private void C0() {
        PlaybackMetrics.Builder builder = this.j;
        if (builder != null && this.A) {
            w2.a(builder, this.z);
            x2.a(this.j, this.x);
            y2.a(this.j, this.y);
            Long l = (Long) this.g.get(this.i);
            z2.a(this.j, l == null ? 0L : l.longValue());
            Long l2 = (Long) this.h.get(this.i);
            a3.a(this.j, l2 == null ? 0L : l2.longValue());
            b3.a(this.j, (l2 == null || l2.longValue() <= 0) ? 0 : 1);
            x1.l3.a(this.c, d3.a(this.j));
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    private static int D0(int i) {
        switch (com.google.android.exoplayer2.util.p0.V(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private static DrmInitData E0(ImmutableList immutableList) {
        DrmInitData drmInitData;
        r4 it = immutableList.iterator();
        while (it.hasNext()) {
            q3.a aVar = (q3.a) it.next();
            for (int i = 0; i < aVar.a; i++) {
                if (aVar.g(i) && (drmInitData = aVar.c(i).o) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    private static int F0(DrmInitData drmInitData) {
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            UUID uuid = drmInitData.get(i).uuid;
            if (uuid.equals(com.google.android.exoplayer2.l.d)) {
                return 3;
            }
            if (uuid.equals(com.google.android.exoplayer2.l.e)) {
                return 2;
            }
            if (uuid.equals(com.google.android.exoplayer2.l.c)) {
                return 6;
            }
        }
        return 1;
    }

    private static a G0(PlaybackException playbackException, Context context, boolean z) {
        int i;
        boolean z2;
        if (playbackException.errorCode == 1001) {
            return new a(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z2 = exoPlaybackException.type == 1;
            i = exoPlaybackException.rendererFormatSupport;
        } else {
            i = 0;
            z2 = false;
        }
        HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = (Throwable) com.google.android.exoplayer2.util.a.e(playbackException.getCause());
        if (!(invalidResponseCodeException instanceof IOException)) {
            if (z2 && (i == 0 || i == 1)) {
                return new a(35, 0);
            }
            if (z2 && i == 3) {
                return new a(15, 0);
            }
            if (z2 && i == 2) {
                return new a(23, 0);
            }
            if (invalidResponseCodeException instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, com.google.android.exoplayer2.util.p0.W(((MediaCodecRenderer.DecoderInitializationException) invalidResponseCodeException).diagnosticInfo));
            }
            if (invalidResponseCodeException instanceof MediaCodecDecoderException) {
                return new a(14, com.google.android.exoplayer2.util.p0.W(((MediaCodecDecoderException) invalidResponseCodeException).diagnosticInfo));
            }
            if (invalidResponseCodeException instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (invalidResponseCodeException instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException) invalidResponseCodeException).audioTrackState);
            }
            if (invalidResponseCodeException instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException) invalidResponseCodeException).errorCode);
            }
            if (com.google.android.exoplayer2.util.p0.a < 16 || !(invalidResponseCodeException instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) invalidResponseCodeException).getErrorCode();
            return new a(D0(errorCode), errorCode);
        }
        if (invalidResponseCodeException instanceof HttpDataSource.InvalidResponseCodeException) {
            return new a(5, invalidResponseCodeException.responseCode);
        }
        if ((invalidResponseCodeException instanceof HttpDataSource.InvalidContentTypeException) || (invalidResponseCodeException instanceof ParserException)) {
            return new a(z ? 10 : 11, 0);
        }
        boolean z3 = invalidResponseCodeException instanceof HttpDataSource.HttpDataSourceException;
        if (z3 || (invalidResponseCodeException instanceof UdpDataSource.UdpDataSourceException)) {
            if (com.google.android.exoplayer2.util.z.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = invalidResponseCodeException.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : (z3 && ((HttpDataSource.HttpDataSourceException) invalidResponseCodeException).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (!(invalidResponseCodeException instanceof DrmSession.DrmSessionException)) {
            if (!(invalidResponseCodeException instanceof FileDataSource.FileDataSourceException) || !(invalidResponseCodeException.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) com.google.android.exoplayer2.util.a.e(invalidResponseCodeException.getCause())).getCause();
            return (com.google.android.exoplayer2.util.p0.a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th = (Throwable) com.google.android.exoplayer2.util.a.e(invalidResponseCodeException.getCause());
        int i2 = com.google.android.exoplayer2.util.p0.a;
        if (i2 < 21 || !(th instanceof MediaDrm.MediaDrmStateException)) {
            return (i2 < 23 || !(th instanceof MediaDrmResetException)) ? (i2 < 18 || !(th instanceof NotProvisionedException)) ? (i2 < 18 || !(th instanceof DeniedByServerException)) ? th instanceof UnsupportedDrmException ? new a(23, 0) : th instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int W = com.google.android.exoplayer2.util.p0.W(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo());
        return new a(D0(W), W);
    }

    private static Pair H0(String str) {
        String[] S0 = com.google.android.exoplayer2.util.p0.S0(str, "-");
        return Pair.create(S0[0], S0.length >= 2 ? S0[1] : null);
    }

    private static int J0(Context context) {
        switch (com.google.android.exoplayer2.util.z.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                return 7;
        }
    }

    private static int K0(w1 w1Var) {
        w1.h hVar = w1Var.b;
        if (hVar == null) {
            return 0;
        }
        int q0 = com.google.android.exoplayer2.util.p0.q0(hVar.a, hVar.b);
        if (q0 == 0) {
            return 3;
        }
        if (q0 != 1) {
            return q0 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int L0(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 1 : 4;
        }
        return 3;
    }

    private void M0(c.b bVar) {
        for (int i = 0; i < bVar.d(); i++) {
            int b2 = bVar.b(i);
            c.a c = bVar.c(b2);
            if (b2 == 0) {
                this.b.d(c);
            } else if (b2 == 11) {
                this.b.e(c, this.k);
            } else {
                this.b.b(c);
            }
        }
    }

    private void N0(long j) {
        int J0 = J0(this.a);
        if (J0 != this.m) {
            this.m = J0;
            i3.a(this.c, l2.a(k2.a(j2.a(g2.a(), J0), j - this.d)));
        }
    }

    private void O0(long j) {
        PlaybackException playbackException = this.n;
        if (playbackException == null) {
            return;
        }
        a G0 = G0(playbackException, this.a, this.v == 4);
        j3.a(this.c, v2.a(u2.a(t2.a(s2.a(q2.a(c3.a(), j - this.d), G0.a), G0.b), playbackException)));
        this.A = true;
        this.n = null;
    }

    private void P0(p2 p2Var, c.b bVar, long j) {
        if (p2Var.getPlaybackState() != 2) {
            this.u = false;
        }
        if (p2Var.c() == null) {
            this.w = false;
        } else if (bVar.a(10)) {
            this.w = true;
        }
        int X0 = X0(p2Var);
        if (this.l != X0) {
            this.l = X0;
            this.A = true;
            k3.a(this.c, g3.a(f3.a(e3.a(n3.a(), this.l), j - this.d)));
        }
    }

    private void Q0(p2 p2Var, c.b bVar, long j) {
        if (bVar.a(2)) {
            q3 currentTracks = p2Var.getCurrentTracks();
            boolean d = currentTracks.d(2);
            boolean d2 = currentTracks.d(1);
            boolean d3 = currentTracks.d(3);
            if (d || d2 || d3) {
                if (!d) {
                    V0(j, null, 0);
                }
                if (!d2) {
                    R0(j, null, 0);
                }
                if (!d3) {
                    T0(j, null, 0);
                }
            }
        }
        if (A0(this.o)) {
            b bVar2 = this.o;
            com.google.android.exoplayer2.p1 p1Var = bVar2.a;
            if (p1Var.r != -1) {
                V0(j, p1Var, bVar2.b);
                this.o = null;
            }
        }
        if (A0(this.p)) {
            b bVar3 = this.p;
            R0(j, bVar3.a, bVar3.b);
            this.p = null;
        }
        if (A0(this.q)) {
            b bVar4 = this.q;
            T0(j, bVar4.a, bVar4.b);
            this.q = null;
        }
    }

    private void R0(long j, com.google.android.exoplayer2.p1 p1Var, int i) {
        if (com.google.android.exoplayer2.util.p0.c(this.s, p1Var)) {
            return;
        }
        if (this.s == null && i == 0) {
            i = 1;
        }
        this.s = p1Var;
        W0(0, j, p1Var, i);
    }

    private void S0(p2 p2Var, c.b bVar) {
        DrmInitData E0;
        if (bVar.a(0)) {
            c.a c = bVar.c(0);
            if (this.j != null) {
                U0(c.b, c.d);
            }
        }
        if (bVar.a(2) && this.j != null && (E0 = E0(p2Var.getCurrentTracks().b())) != null) {
            n2.a(m2.a(com.google.android.exoplayer2.util.p0.j(this.j)), F0(E0));
        }
        if (bVar.a(1011)) {
            this.z++;
        }
    }

    private void T0(long j, com.google.android.exoplayer2.p1 p1Var, int i) {
        if (com.google.android.exoplayer2.util.p0.c(this.t, p1Var)) {
            return;
        }
        if (this.t == null && i == 0) {
            i = 1;
        }
        this.t = p1Var;
        W0(2, j, p1Var, i);
    }

    private void U0(l3 l3Var, o.b bVar) {
        int f;
        PlaybackMetrics.Builder builder = this.j;
        if (bVar == null || (f = l3Var.f(bVar.a)) == -1) {
            return;
        }
        l3Var.j(f, this.f);
        l3Var.r(this.f.c, this.e);
        m3.a(builder, K0(this.e.c));
        l3.d dVar = this.e;
        if (dVar.n != -9223372036854775807L && !dVar.l && !dVar.i && !dVar.i()) {
            o3.a(builder, this.e.g());
        }
        p3.a(builder, this.e.i() ? 2 : 1);
        this.A = true;
    }

    private void V0(long j, com.google.android.exoplayer2.p1 p1Var, int i) {
        if (com.google.android.exoplayer2.util.p0.c(this.r, p1Var)) {
            return;
        }
        if (this.r == null && i == 0) {
            i = 1;
        }
        this.r = p1Var;
        W0(1, j, p1Var, i);
    }

    private void W0(int i, long j, com.google.android.exoplayer2.p1 p1Var, int i2) {
        TrackChangeEvent.Builder a2 = t3.a(v1.a(i), j - this.d);
        if (p1Var != null) {
            y1.a(a2, 1);
            a2.a(a2, L0(i2));
            String str = p1Var.k;
            if (str != null) {
                b2.a(a2, str);
            }
            String str2 = p1Var.l;
            if (str2 != null) {
                c2.a(a2, str2);
            }
            String str3 = p1Var.i;
            if (str3 != null) {
                d2.a(a2, str3);
            }
            int i3 = p1Var.h;
            if (i3 != -1) {
                e2.a(a2, i3);
            }
            int i4 = p1Var.q;
            if (i4 != -1) {
                f2.a(a2, i4);
            }
            int i5 = p1Var.r;
            if (i5 != -1) {
                h2.a(a2, i5);
            }
            int i6 = p1Var.y;
            if (i6 != -1) {
                i2.a(a2, i6);
            }
            int i7 = p1Var.z;
            if (i7 != -1) {
                u3.a(a2, i7);
            }
            String str4 = p1Var.c;
            if (str4 != null) {
                Pair H0 = H0(str4);
                v3.a(a2, (String) H0.first);
                Object obj = H0.second;
                if (obj != null) {
                    x1.w1.a(a2, (String) obj);
                }
            }
            float f = p1Var.s;
            if (f != -1.0f) {
                x1.a(a2, f);
            }
        } else {
            y1.a(a2, 0);
        }
        this.A = true;
        x1.q3.a(this.c, z1.a(a2));
    }

    private int X0(p2 p2Var) {
        int playbackState = p2Var.getPlaybackState();
        if (this.u) {
            return 5;
        }
        if (this.w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i = this.l;
            if (i == 0 || i == 2) {
                return 2;
            }
            if (p2Var.getPlayWhenReady()) {
                return p2Var.k() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (p2Var.getPlayWhenReady()) {
                return p2Var.k() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.l == 0) {
            return this.l;
        }
        return 12;
    }

    @Override // g9.c
    public /* synthetic */ void A(c.a aVar, v9.h hVar, v9.i iVar) {
        g9.b.F(this, aVar, hVar, iVar);
    }

    @Override // g9.c
    public /* synthetic */ void B(c.a aVar, long j, int i) {
        g9.b.j0(this, aVar, j, i);
    }

    @Override // g9.c
    public /* synthetic */ void C(c.a aVar, na.z zVar) {
        g9.b.b0(this, aVar, zVar);
    }

    @Override // g9.c
    public /* synthetic */ void D(c.a aVar) {
        g9.b.Q(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void E(c.a aVar, int i, int i2, int i3, float f) {
        g9.b.m0(this, aVar, i, i2, i3, f);
    }

    @Override // g9.c
    public /* synthetic */ void F(c.a aVar, int i, String str, long j) {
        g9.b.q(this, aVar, i, str, j);
    }

    @Override // g9.c
    public void G(c.a aVar, PlaybackException playbackException) {
        this.n = playbackException;
    }

    @Override // g9.c
    public /* synthetic */ void H(c.a aVar, String str, long j) {
        g9.b.b(this, aVar, str, j);
    }

    @Override // g9.c
    public /* synthetic */ void I(c.a aVar, String str, long j, long j2) {
        g9.b.c(this, aVar, str, j, j2);
    }

    public LogSessionId I0() {
        return h3.a(this.c);
    }

    @Override // g9.c
    public /* synthetic */ void J(c.a aVar, da.f fVar) {
        g9.b.m(this, aVar, fVar);
    }

    @Override // g9.c
    public /* synthetic */ void K(c.a aVar, float f) {
        g9.b.n0(this, aVar, f);
    }

    @Override // g9.c
    public /* synthetic */ void L(c.a aVar, int i, com.google.android.exoplayer2.decoder.e eVar) {
        g9.b.o(this, aVar, i, eVar);
    }

    @Override // g9.c
    public /* synthetic */ void M(c.a aVar, boolean z, int i) {
        g9.b.R(this, aVar, z, i);
    }

    @Override // g9.c
    public void N(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        this.x += eVar.g;
        this.y += eVar.e;
    }

    @Override // g9.c
    public /* synthetic */ void O(c.a aVar, v9.i iVar) {
        g9.b.d0(this, aVar, iVar);
    }

    @Override // g9.c
    public /* synthetic */ void P(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        g9.b.e(this, aVar, eVar);
    }

    @Override // g9.c
    public /* synthetic */ void Q(c.a aVar) {
        g9.b.v(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void R(c.a aVar, o2 o2Var) {
        g9.b.M(this, aVar, o2Var);
    }

    @Override // g9.c
    public /* synthetic */ void S(c.a aVar, int i) {
        g9.b.S(this, aVar, i);
    }

    @Override // g9.c
    public /* synthetic */ void T(c.a aVar, int i, long j, long j2) {
        g9.b.k(this, aVar, i, j, j2);
    }

    @Override // g9.c
    public /* synthetic */ void U(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        g9.b.i0(this, aVar, eVar);
    }

    @Override // g9.t1.a
    public void V(c.a aVar, String str) {
        o.b bVar = aVar.d;
        if (bVar == null || !bVar.b()) {
            C0();
            this.i = str;
            this.j = x1.p2.a(x1.o2.a(r2.a(), "ExoPlayerLib"), "2.18.1");
            U0(aVar.b, aVar.d);
        }
    }

    @Override // g9.c
    public /* synthetic */ void W(c.a aVar, int i) {
        g9.b.U(this, aVar, i);
    }

    @Override // g9.c
    public /* synthetic */ void X(c.a aVar, q3 q3Var) {
        g9.b.c0(this, aVar, q3Var);
    }

    @Override // g9.c
    public /* synthetic */ void Y(c.a aVar) {
        g9.b.x(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void Z(c.a aVar, String str, long j) {
        g9.b.f0(this, aVar, str, j);
    }

    @Override // g9.c
    public /* synthetic */ void a(c.a aVar, Object obj, long j) {
        g9.b.T(this, aVar, obj, j);
    }

    @Override // g9.c
    public /* synthetic */ void a0(c.a aVar, int i) {
        g9.b.a0(this, aVar, i);
    }

    @Override // g9.c
    public /* synthetic */ void b(c.a aVar) {
        g9.b.u(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void b0(c.a aVar) {
        g9.b.W(this, aVar);
    }

    @Override // g9.c
    public void c(c.a aVar, v9.i iVar) {
        if (aVar.d == null) {
            return;
        }
        b bVar = new b((com.google.android.exoplayer2.p1) com.google.android.exoplayer2.util.a.e(iVar.c), iVar.d, this.b.f(aVar.b, (o.b) com.google.android.exoplayer2.util.a.e(aVar.d)));
        int i = iVar.b;
        if (i != 0) {
            if (i == 1) {
                this.p = bVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.q = bVar;
                return;
            }
        }
        this.o = bVar;
    }

    @Override // g9.c
    public /* synthetic */ void c0(c.a aVar, boolean z) {
        g9.b.X(this, aVar, z);
    }

    @Override // g9.c
    public /* synthetic */ void d(c.a aVar, boolean z) {
        g9.b.H(this, aVar, z);
    }

    @Override // g9.c
    public /* synthetic */ void d0(c.a aVar, v9.h hVar, v9.i iVar) {
        g9.b.G(this, aVar, hVar, iVar);
    }

    @Override // g9.c
    public /* synthetic */ void e(c.a aVar, com.google.android.exoplayer2.b2 b2Var) {
        g9.b.J(this, aVar, b2Var);
    }

    @Override // g9.c
    public /* synthetic */ void e0(c.a aVar, com.google.android.exoplayer2.p1 p1Var) {
        g9.b.k0(this, aVar, p1Var);
    }

    @Override // g9.c
    public /* synthetic */ void f(c.a aVar, com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar) {
        g9.b.h(this, aVar, p1Var, gVar);
    }

    @Override // g9.c
    public void f0(c.a aVar, com.google.android.exoplayer2.video.y yVar) {
        b bVar = this.o;
        if (bVar != null) {
            com.google.android.exoplayer2.p1 p1Var = bVar.a;
            if (p1Var.r == -1) {
                this.o = new b(p1Var.b().j0(yVar.a).Q(yVar.b).E(), bVar.b, bVar.c);
            }
        }
    }

    @Override // g9.c
    public /* synthetic */ void g(c.a aVar, com.google.android.exoplayer2.r rVar) {
        g9.b.s(this, aVar, rVar);
    }

    @Override // g9.c
    public /* synthetic */ void g0(c.a aVar, Exception exc) {
        g9.b.e0(this, aVar, exc);
    }

    @Override // g9.c
    public void h(c.a aVar, v9.h hVar, v9.i iVar, IOException iOException, boolean z) {
        this.v = iVar.a;
    }

    @Override // g9.c
    public /* synthetic */ void h0(c.a aVar) {
        g9.b.w(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void i(c.a aVar) {
        g9.b.A(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void i0(c.a aVar, int i) {
        g9.b.N(this, aVar, i);
    }

    @Override // g9.c
    public /* synthetic */ void j(c.a aVar, int i, com.google.android.exoplayer2.p1 p1Var) {
        g9.b.r(this, aVar, i, p1Var);
    }

    @Override // g9.c
    public /* synthetic */ void j0(c.a aVar, Exception exc) {
        g9.b.a(this, aVar, exc);
    }

    @Override // g9.t1.a
    public void k(c.a aVar, String str, String str2) {
    }

    @Override // g9.c
    public void k0(p2 p2Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        M0(bVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        S0(p2Var, bVar);
        O0(elapsedRealtime);
        Q0(p2Var, bVar, elapsedRealtime);
        N0(elapsedRealtime);
        P0(p2Var, bVar, elapsedRealtime);
        if (bVar.a(1028)) {
            this.b.g(bVar.c(1028));
        }
    }

    @Override // g9.c
    public /* synthetic */ void l(c.a aVar, w1 w1Var, int i) {
        g9.b.I(this, aVar, w1Var, i);
    }

    @Override // g9.c
    public /* synthetic */ void l0(c.a aVar) {
        g9.b.V(this, aVar);
    }

    @Override // g9.c
    public /* synthetic */ void m(c.a aVar, v9.h hVar, v9.i iVar) {
        g9.b.E(this, aVar, hVar, iVar);
    }

    @Override // g9.c
    public /* synthetic */ void m0(c.a aVar, Exception exc) {
        g9.b.j(this, aVar, exc);
    }

    @Override // g9.c
    public /* synthetic */ void n(c.a aVar, int i, boolean z) {
        g9.b.t(this, aVar, i, z);
    }

    @Override // g9.c
    public /* synthetic */ void n0(c.a aVar, boolean z) {
        g9.b.C(this, aVar, z);
    }

    @Override // g9.c
    public /* synthetic */ void o(c.a aVar, PlaybackException playbackException) {
        g9.b.P(this, aVar, playbackException);
    }

    @Override // g9.c
    public /* synthetic */ void o0(c.a aVar, p2.b bVar) {
        g9.b.l(this, aVar, bVar);
    }

    @Override // g9.c
    public /* synthetic */ void p(c.a aVar, List list) {
        g9.b.n(this, aVar, list);
    }

    @Override // g9.c
    public void p0(c.a aVar, int i, long j, long j2) {
        o.b bVar = aVar.d;
        if (bVar != null) {
            String f = this.b.f(aVar.b, (o.b) com.google.android.exoplayer2.util.a.e(bVar));
            Long l = (Long) this.h.get(f);
            Long l2 = (Long) this.g.get(f);
            this.h.put(f, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.g.put(f, Long.valueOf((l2 != null ? l2.longValue() : 0L) + i));
        }
    }

    @Override // g9.c
    public /* synthetic */ void q(c.a aVar, boolean z) {
        g9.b.D(this, aVar, z);
    }

    @Override // g9.c
    public /* synthetic */ void q0(c.a aVar, long j) {
        g9.b.i(this, aVar, j);
    }

    @Override // g9.c
    public /* synthetic */ void r(c.a aVar, int i, com.google.android.exoplayer2.decoder.e eVar) {
        g9.b.p(this, aVar, i, eVar);
    }

    @Override // g9.c
    public /* synthetic */ void r0(c.a aVar, com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar) {
        g9.b.l0(this, aVar, p1Var, gVar);
    }

    @Override // g9.c
    public /* synthetic */ void s(c.a aVar, boolean z, int i) {
        g9.b.L(this, aVar, z, i);
    }

    @Override // g9.c
    public /* synthetic */ void s0(c.a aVar, Exception exc) {
        g9.b.z(this, aVar, exc);
    }

    @Override // g9.c
    public /* synthetic */ void t(c.a aVar, int i, long j) {
        g9.b.B(this, aVar, i, j);
    }

    @Override // g9.c
    public /* synthetic */ void t0(c.a aVar, Metadata metadata) {
        g9.b.K(this, aVar, metadata);
    }

    @Override // g9.c
    public /* synthetic */ void u(c.a aVar, com.google.android.exoplayer2.p1 p1Var) {
        g9.b.g(this, aVar, p1Var);
    }

    @Override // g9.c
    public /* synthetic */ void u0(c.a aVar, int i) {
        g9.b.O(this, aVar, i);
    }

    @Override // g9.t1.a
    public void v(c.a aVar, String str) {
    }

    @Override // g9.c
    public /* synthetic */ void v0(c.a aVar, int i) {
        g9.b.y(this, aVar, i);
    }

    @Override // g9.c
    public /* synthetic */ void w(c.a aVar, boolean z) {
        g9.b.Y(this, aVar, z);
    }

    @Override // g9.c
    public /* synthetic */ void w0(c.a aVar, String str, long j, long j2) {
        g9.b.g0(this, aVar, str, j, j2);
    }

    @Override // g9.t1.a
    public void x(c.a aVar, String str, boolean z) {
        o.b bVar = aVar.d;
        if ((bVar == null || !bVar.b()) && str.equals(this.i)) {
            C0();
        }
        this.g.remove(str);
        this.h.remove(str);
    }

    @Override // g9.c
    public /* synthetic */ void x0(c.a aVar, String str) {
        g9.b.d(this, aVar, str);
    }

    @Override // g9.c
    public void y(c.a aVar, p2.e eVar, p2.e eVar2, int i) {
        if (i == 1) {
            this.u = true;
        }
        this.k = i;
    }

    @Override // g9.c
    public /* synthetic */ void y0(c.a aVar, int i, int i2) {
        g9.b.Z(this, aVar, i, i2);
    }

    @Override // g9.c
    public /* synthetic */ void z(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        g9.b.f(this, aVar, eVar);
    }

    @Override // g9.c
    public /* synthetic */ void z0(c.a aVar, String str) {
        g9.b.h0(this, aVar, str);
    }
}
