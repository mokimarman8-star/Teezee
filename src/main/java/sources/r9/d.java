package r9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import i9.a0;
import i9.e0;
import i9.l;
import i9.m;
import i9.n;
import i9.q;
import i9.r;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class d implements l {
    public static final r d = new r() { // from class: r9.c
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            l[] e;
            e = d.e();
            return e;
        }
    };
    private n a;
    private i b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] e() {
        return new l[]{new d()};
    }

    private static d0 f(d0 d0Var) {
        d0Var.P(0);
        return d0Var;
    }

    private boolean g(m mVar) {
        f fVar = new f();
        if (fVar.a(mVar, true) && (fVar.b & 2) == 2) {
            int min = Math.min(fVar.i, 8);
            d0 d0Var = new d0(min);
            mVar.peekFully(d0Var.d(), 0, min);
            if (b.p(f(d0Var))) {
                this.b = new b();
            } else if (j.r(f(d0Var))) {
                this.b = new j();
            } else if (h.p(f(d0Var))) {
                this.b = new h();
            }
            return true;
        }
        return false;
    }

    @Override // i9.l
    public void b(n nVar) {
        this.a = nVar;
    }

    @Override // i9.l
    public boolean c(m mVar) {
        try {
            return g(mVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        com.google.android.exoplayer2.util.a.i(this.a);
        if (this.b == null) {
            if (!g(mVar)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", (Throwable) null);
            }
            mVar.resetPeekPosition();
        }
        if (!this.c) {
            e0 track = this.a.track(0, 1);
            this.a.endTracks();
            this.b.d(this.a, track);
            this.c = true;
        }
        return this.b.g(mVar, a0Var);
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.m(j, j2);
        }
    }
}
