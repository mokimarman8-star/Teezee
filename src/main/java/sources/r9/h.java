package r9;

import com.google.android.exoplayer2.audio.c0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.common.collect.ImmutableList;
import i9.h0;
import java.util.Arrays;
import java.util.List;
import r9.i;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class h extends i {
    private static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean n;

    h() {
    }

    private long n(byte[] bArr) {
        int i;
        byte b = bArr[0];
        int i2 = b & 255;
        int i3 = b & 3;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1 && i3 != 2) {
                i = bArr[1] & 63;
            }
        } else {
            i = 1;
        }
        int i4 = i2 >> 3;
        return i * (i4 >= 16 ? 2500 << r0 : i4 >= 12 ? 10000 << (i4 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r0);
    }

    private static boolean o(d0 d0Var, byte[] bArr) {
        if (d0Var.a() < bArr.length) {
            return false;
        }
        int e = d0Var.e();
        byte[] bArr2 = new byte[bArr.length];
        d0Var.j(bArr2, 0, bArr.length);
        d0Var.P(e);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean p(d0 d0Var) {
        return o(d0Var, o);
    }

    @Override // r9.i
    protected long f(d0 d0Var) {
        return c(n(d0Var.d()));
    }

    @Override // r9.i
    protected boolean h(d0 d0Var, long j, i.b bVar) {
        if (o(d0Var, o)) {
            byte[] copyOf = Arrays.copyOf(d0Var.d(), d0Var.f());
            int c = c0.c(copyOf);
            List a = c0.a(copyOf);
            if (bVar.a != null) {
                return true;
            }
            bVar.a = new p1.b().e0("audio/opus").H(c).f0(48000).T(a).E();
            return true;
        }
        byte[] bArr = p;
        if (!o(d0Var, bArr)) {
            com.google.android.exoplayer2.util.a.i(bVar.a);
            return false;
        }
        com.google.android.exoplayer2.util.a.i(bVar.a);
        if (this.n) {
            return true;
        }
        this.n = true;
        d0Var.Q(bArr.length);
        Metadata c2 = h0.c(ImmutableList.copyOf(h0.j(d0Var, false, false).b));
        if (c2 == null) {
            return true;
        }
        bVar.a = bVar.a.b().X(c2.copyWithAppendedEntriesFrom(bVar.a.j)).E();
        return true;
    }

    @Override // r9.i
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = false;
        }
    }
}
