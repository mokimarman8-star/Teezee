package x9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class l extends f {
    private byte[] j;
    private volatile boolean k;

    public l(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, int i, p1 p1Var, int i2, Object obj, byte[] bArr) {
        super(kVar, nVar, i, p1Var, i2, obj, -9223372036854775807L, -9223372036854775807L);
        l lVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = p0.f;
            lVar = this;
        } else {
            lVar = this;
            bArr2 = bArr;
        }
        lVar.j = bArr2;
    }

    private void g(int i) {
        byte[] bArr = this.j;
        if (bArr.length < i + 16384) {
            this.j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    public final void cancelLoad() {
        this.k = true;
    }

    protected abstract void e(byte[] bArr, int i);

    public byte[] f() {
        return this.j;
    }

    public final void load() {
        try {
            this.i.a(this.b);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.k) {
                g(i2);
                i = this.i.read(this.j, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.k) {
                e(this.j, i2);
            }
            com.google.android.exoplayer2.upstream.m.a(this.i);
        } catch (Throwable th) {
            com.google.android.exoplayer2.upstream.m.a(this.i);
            throw th;
        }
    }
}
