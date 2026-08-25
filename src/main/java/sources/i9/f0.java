package i9;

import i9.e0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f0 {
    private final byte[] a = new byte[10];
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;

    public void a(e0 e0Var, e0.a aVar) {
        if (this.c > 0) {
            e0Var.e(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public void b() {
        this.b = false;
        this.c = 0;
    }

    public void c(e0 e0Var, long j, int i, int i2, int i3, e0.a aVar) {
        com.google.android.exoplayer2.util.a.h(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(e0Var, aVar);
            }
        }
    }

    public void d(m mVar) {
        if (this.b) {
            return;
        }
        mVar.peekFully(this.a, 0, 10);
        mVar.resetPeekPosition();
        if (com.google.android.exoplayer2.audio.b.i(this.a) == 0) {
            return;
        }
        this.b = true;
    }
}
