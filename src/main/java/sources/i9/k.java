package i9;

import com.google.android.exoplayer2.p1;
import i9.e0;
import java.io.EOFException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class k implements e0 {
    private final byte[] a = new byte[4096];

    @Override // i9.e0
    public int a(com.google.android.exoplayer2.upstream.g gVar, int i, boolean z, int i2) {
        int read = gVar.read(this.a, 0, Math.min(this.a.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // i9.e0
    public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i, boolean z) {
        return d0.a(this, gVar, i, z);
    }

    @Override // i9.e0
    public /* synthetic */ void c(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        d0.b(this, d0Var, i);
    }

    @Override // i9.e0
    public void d(p1 p1Var) {
    }

    @Override // i9.e0
    public void e(long j, int i, int i2, int i3, e0.a aVar) {
    }

    @Override // i9.e0
    public void f(com.google.android.exoplayer2.util.d0 d0Var, int i, int i2) {
        d0Var.Q(i);
    }
}
