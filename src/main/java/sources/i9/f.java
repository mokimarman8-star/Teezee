package i9;

import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.util.p0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f implements m {
    private final com.google.android.exoplayer2.upstream.g b;
    private final long c;
    private long d;
    private int f;
    private int g;
    private byte[] e = new byte[65536];
    private final byte[] a = new byte[4096];

    static {
        n1.a("goog.exo.extractor");
    }

    public f(com.google.android.exoplayer2.upstream.g gVar, long j, long j2) {
        this.b = gVar;
        this.d = j;
        this.c = j2;
    }

    private void f(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    private void h(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, p0.q(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int i(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        m(min);
        return min;
    }

    private int j(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.b.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private int k(int i) {
        int min = Math.min(this.g, i);
        m(min);
        return min;
    }

    private void m(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }

    @Override // i9.m
    public void advancePeekPosition(int i) {
        advancePeekPosition(i, false);
    }

    @Override // i9.m
    public boolean advancePeekPosition(int i, boolean z) {
        h(i);
        int i2 = this.g - this.f;
        while (i2 < i) {
            i2 = j(this.e, this.f, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.g = this.f + i2;
        }
        this.f += i;
        return true;
    }

    @Override // i9.m
    public int b(byte[] bArr, int i, int i2) {
        int min;
        h(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            min = j(this.e, i4, i2, 0, true);
            if (min == -1) {
                return -1;
            }
            this.g += min;
        } else {
            min = Math.min(i2, i5);
        }
        System.arraycopy(this.e, this.f, bArr, i, min);
        this.f += min;
        return min;
    }

    @Override // i9.m
    public long getLength() {
        return this.c;
    }

    @Override // i9.m
    public long getPeekPosition() {
        return this.d + this.f;
    }

    @Override // i9.m
    public long getPosition() {
        return this.d;
    }

    public boolean l(int i, boolean z) {
        int k = k(i);
        while (k < i && k != -1) {
            k = j(this.a, -k, Math.min(i, this.a.length + k), k, z);
        }
        f(k);
        return k != -1;
    }

    @Override // i9.m
    public void peekFully(byte[] bArr, int i, int i2) {
        peekFully(bArr, i, i2, false);
    }

    @Override // i9.m
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    @Override // i9.m
    public int read(byte[] bArr, int i, int i2) {
        int i3 = i(bArr, i, i2);
        if (i3 == 0) {
            i3 = j(bArr, i, i2, 0, true);
        }
        f(i3);
        return i3;
    }

    @Override // i9.m
    public void readFully(byte[] bArr, int i, int i2) {
        readFully(bArr, i, i2, false);
    }

    @Override // i9.m
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i(bArr, i, i2);
        while (i3 < i2 && i3 != -1) {
            i3 = j(bArr, i, i2, i3, z);
        }
        f(i3);
        return i3 != -1;
    }

    @Override // i9.m
    public void resetPeekPosition() {
        this.f = 0;
    }

    @Override // i9.m
    public int skip(int i) {
        int k = k(i);
        if (k == 0) {
            byte[] bArr = this.a;
            k = j(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        f(k);
        return k;
    }

    @Override // i9.m
    public void skipFully(int i) {
        l(i, false);
    }
}
