package s9;

import android.net.Uri;
import i9.b0;
import java.util.Map;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements i9.l {
    public static final i9.r d = new i9.r() { // from class: s9.a
        @Override // i9.r
        public /* synthetic */ i9.l[] c(Uri uri, Map map) {
            return i9.q.a(this, uri, map);
        }

        @Override // i9.r
        public final i9.l[] createExtractors() {
            i9.l[] e;
            e = b.e();
            return e;
        }
    };
    private final c a = new c();
    private final com.google.android.exoplayer2.util.d0 b = new com.google.android.exoplayer2.util.d0(2786);
    private boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.l[] e() {
        return new i9.l[]{new b()};
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        this.a.d(nVar, new i0.d(0, 1));
        nVar.endTracks();
        nVar.g(new b0.b(-9223372036854775807L));
    }

    @Override // i9.l
    public boolean c(i9.m mVar) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(10);
        int i = 0;
        while (true) {
            mVar.peekFully(d0Var.d(), 0, 10);
            d0Var.P(0);
            if (d0Var.G() != 4801587) {
                break;
            }
            d0Var.Q(3);
            int C = d0Var.C();
            i += C + 10;
            mVar.advancePeekPosition(C);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            mVar.peekFully(d0Var.d(), 0, 6);
            d0Var.P(0);
            if (d0Var.J() != 2935) {
                mVar.resetPeekPosition();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                mVar.advancePeekPosition(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int f = com.google.android.exoplayer2.audio.b.f(d0Var.d());
                if (f == -1) {
                    return false;
                }
                mVar.advancePeekPosition(f - 6);
            }
        }
    }

    @Override // i9.l
    public int d(i9.m mVar, i9.a0 a0Var) {
        int read = mVar.read(this.b.d(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.b.P(0);
        this.b.O(read);
        if (!this.c) {
            this.a.c(0L, 4);
            this.c = true;
        }
        this.a.b(this.b);
        return 0;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.c = false;
        this.a.seek();
    }
}
