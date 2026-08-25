package s9;

import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p1;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class k implements m {
    private final String b;
    private String c;
    private i9.e0 d;
    private int f;
    private int g;
    private long h;
    private p1 i;
    private int j;
    private final com.google.android.exoplayer2.util.d0 a = new com.google.android.exoplayer2.util.d0(new byte[18]);
    private int e = 0;
    private long k = -9223372036854775807L;

    public k(String str) {
        this.b = str;
    }

    private boolean a(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.f);
        d0Var.j(bArr, this.f, min);
        int i2 = this.f + min;
        this.f = i2;
        return i2 == i;
    }

    private void e() {
        byte[] d = this.a.d();
        if (this.i == null) {
            p1 g = com.google.android.exoplayer2.audio.y.g(d, this.c, this.b, (DrmInitData) null);
            this.i = g;
            this.d.d(g);
        }
        this.j = com.google.android.exoplayer2.audio.y.a(d);
        this.h = (int) ((com.google.android.exoplayer2.audio.y.f(d) * 1000000) / this.i.z);
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var) {
        while (d0Var.a() > 0) {
            int i = this.g << 8;
            this.g = i;
            int D = i | d0Var.D();
            this.g = D;
            if (com.google.android.exoplayer2.audio.y.d(D)) {
                byte[] d = this.a.d();
                int i2 = this.g;
                d[0] = (byte) ((i2 >> 24) & 255);
                d[1] = (byte) ((i2 >> 16) & 255);
                d[2] = (byte) ((i2 >> 8) & 255);
                d[3] = (byte) (i2 & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.d);
        while (d0Var.a() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(d0Var.a(), this.j - this.f);
                    this.d.c(d0Var, min);
                    int i2 = this.f + min;
                    this.f = i2;
                    int i3 = this.j;
                    if (i2 == i3) {
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.e(j, 1, i3, 0, null);
                            this.k += this.h;
                        }
                        this.e = 0;
                    }
                } else if (a(d0Var, this.a.d(), 18)) {
                    e();
                    this.a.P(0);
                    this.d.c(this.a, 18);
                    this.e = 2;
                }
            } else if (f(d0Var)) {
                this.e = 1;
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.c = dVar.b();
        this.d = nVar.track(dVar.c(), 1);
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.k = -9223372036854775807L;
    }
}
