package t9;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.i0;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.a0;
import i9.e0;
import i9.l;
import i9.m;
import i9.n;
import i9.q;
import i9.r;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements l {
    public static final r h = new r() { // from class: t9.a
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            l[] f;
            f = b.f();
            return f;
        }
    };
    private n a;
    private e0 b;
    private InterfaceC0068b e;
    private int c = 0;
    private long d = -1;
    private int f = -1;
    private long g = -1;

    private static final class a implements InterfaceC0068b {
        private static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final n a;
        private final e0 b;
        private final t9.c c;
        private final int d;
        private final byte[] e;
        private final d0 f;
        private final int g;
        private final p1 h;
        private int i;
        private long j;
        private int k;
        private long l;

        public a(n nVar, e0 e0Var, t9.c cVar) {
            this.a = nVar;
            this.b = e0Var;
            this.c = cVar;
            int max = Math.max(1, cVar.c / 10);
            this.g = max;
            d0 d0Var = new d0(cVar.g);
            d0Var.v();
            int v = d0Var.v();
            this.d = v;
            int i = cVar.b;
            int i2 = (((cVar.e - (i * 4)) * 8) / (cVar.f * i)) + 1;
            if (v == i2) {
                int l = p0.l(max, v);
                this.e = new byte[cVar.e * l];
                this.f = new d0(l * h(v, i));
                int i3 = ((cVar.c * cVar.e) * 8) / v;
                this.h = new p1.b().e0("audio/raw").G(i3).Z(i3).W(h(max, i)).H(cVar.b).f0(cVar.c).Y(2).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i2 + "; got: " + v, (Throwable) null);
        }

        private void d(byte[] bArr, int i, d0 d0Var) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.c.b; i3++) {
                    e(bArr, i2, i3, d0Var.d());
                }
            }
            int g = g(this.d * i);
            d0Var.P(0);
            d0Var.O(g);
        }

        private void e(byte[] bArr, int i, int i2, byte[] bArr2) {
            t9.c cVar = this.c;
            int i3 = cVar.e;
            int i4 = cVar.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int i10 = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int min = Math.min(bArr[i5 + 2] & 255, 88);
            int i11 = n[min];
            int i12 = ((i * this.d * i4) + i2) * 2;
            bArr2[i12] = (byte) (i10 & 255);
            bArr2[i12 + 1] = (byte) (i10 >> 8);
            for (int i13 = 0; i13 < i7 * 2; i13++) {
                byte b = bArr[((i13 / 8) * i4 * 4) + i6 + ((i13 / 2) % 4)];
                int i14 = i13 % 2 == 0 ? b & 15 : (b & 255) >> 4;
                int i15 = ((((i14 & 7) * 2) + 1) * i11) >> 3;
                if ((i14 & 8) != 0) {
                    i15 = -i15;
                }
                i10 = p0.q(i10 + i15, -32768, 32767);
                i12 += i4 * 2;
                bArr2[i12] = (byte) (i10 & 255);
                bArr2[i12 + 1] = (byte) (i10 >> 8);
                int i16 = min + m[i14];
                int[] iArr = n;
                min = p0.q(i16, 0, iArr.length - 1);
                i11 = iArr[min];
            }
        }

        private int f(int i) {
            return i / (this.c.b * 2);
        }

        private int g(int i) {
            return h(i, this.c.b);
        }

        private static int h(int i, int i2) {
            return i * 2 * i2;
        }

        private void i(int i) {
            long N0 = this.j + p0.N0(this.l, 1000000L, this.c.c);
            int g = g(i);
            this.b.e(N0, 1, g, this.k - g, null);
            this.l += i;
            this.k -= g;
        }

        @Override // t9.b.InterfaceC0068b
        public void a(int i, long j) {
            this.a.g(new e(this.c, this.d, i, j));
            this.b.d(this.h);
        }

        @Override // t9.b.InterfaceC0068b
        public void b(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0035 -> B:3:0x001b). Please report as a decompilation issue!!! */
        @Override // t9.b.InterfaceC0068b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c(m mVar, long j) {
            boolean z;
            int i;
            int f;
            int l = p0.l(this.g - f(this.k), this.d) * this.c.e;
            if (j != 0) {
                z = false;
                while (!z) {
                    if (this.i >= l) {
                        break;
                    }
                    int read = mVar.read(this.e, this.i, (int) Math.min(l - r3, j));
                    if (read != -1) {
                        this.i += read;
                    }
                }
                i = this.i / this.c.e;
                if (i > 0) {
                    d(this.e, i, this.f);
                    this.i -= i * this.c.e;
                    int f2 = this.f.f();
                    this.b.c(this.f, f2);
                    int i2 = this.k + f2;
                    this.k = i2;
                    int f3 = f(i2);
                    int i3 = this.g;
                    if (f3 >= i3) {
                        i(i3);
                    }
                }
                if (z && (f = f(this.k)) > 0) {
                    i(f);
                }
                return z;
            }
            z = true;
            while (!z) {
            }
            i = this.i / this.c.e;
            if (i > 0) {
            }
            if (z) {
                i(f);
            }
            return z;
        }
    }

    /* renamed from: t9.b$b, reason: collision with other inner class name */
    private interface InterfaceC0068b {
        void a(int i, long j);

        void b(long j);

        boolean c(m mVar, long j);
    }

    private static final class c implements InterfaceC0068b {
        private final n a;
        private final e0 b;
        private final t9.c c;
        private final p1 d;
        private final int e;
        private long f;
        private int g;
        private long h;

        public c(n nVar, e0 e0Var, t9.c cVar, String str, int i) {
            this.a = nVar;
            this.b = e0Var;
            this.c = cVar;
            int i2 = (cVar.b * cVar.f) / 8;
            if (cVar.e == i2) {
                int i3 = cVar.c;
                int i4 = i3 * i2 * 8;
                int max = Math.max(i2, (i3 * i2) / 10);
                this.e = max;
                this.d = new p1.b().e0(str).G(i4).Z(i4).W(max).H(cVar.b).f0(cVar.c).Y(i).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i2 + "; got: " + cVar.e, (Throwable) null);
        }

        @Override // t9.b.InterfaceC0068b
        public void a(int i, long j) {
            this.a.g(new e(this.c, 1, i, j));
            this.b.d(this.d);
        }

        @Override // t9.b.InterfaceC0068b
        public void b(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }

        @Override // t9.b.InterfaceC0068b
        public boolean c(m mVar, long j) {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int b = this.b.b(mVar, (int) Math.min(i2 - i, j2), true);
                if (b == -1) {
                    j2 = 0;
                } else {
                    this.g += b;
                    j2 -= b;
                }
            }
            int i3 = this.c.e;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long N0 = this.f + p0.N0(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.e(N0, 1, i5, i6, null);
                this.h += i4;
                this.g = i6;
            }
            return j2 <= 0;
        }
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.b);
        p0.j(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] f() {
        return new l[]{new b()};
    }

    private void g(m mVar) {
        com.google.android.exoplayer2.util.a.g(mVar.getPosition() == 0);
        int i = this.f;
        if (i != -1) {
            mVar.skipFully(i);
            this.c = 4;
        } else {
            if (!d.a(mVar)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", (Throwable) null);
            }
            mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
            this.c = 1;
        }
    }

    private void h(m mVar) {
        t9.c b = d.b(mVar);
        int i = b.a;
        if (i == 17) {
            this.e = new a(this.a, this.b, b);
        } else if (i == 6) {
            this.e = new c(this.a, this.b, b, "audio/g711-alaw", -1);
        } else if (i == 7) {
            this.e = new c(this.a, this.b, b, "audio/g711-mlaw", -1);
        } else {
            int a2 = i0.a(i, b.f);
            if (a2 == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + b.a);
            }
            this.e = new c(this.a, this.b, b, "audio/raw", a2);
        }
        this.c = 3;
    }

    private void i(m mVar) {
        this.d = d.c(mVar);
        this.c = 2;
    }

    private int j(m mVar) {
        com.google.android.exoplayer2.util.a.g(this.g != -1);
        return ((InterfaceC0068b) com.google.android.exoplayer2.util.a.e(this.e)).c(mVar, this.g - mVar.getPosition()) ? -1 : 0;
    }

    private void k(m mVar) {
        Pair e = d.e(mVar);
        this.f = ((Long) e.first).intValue();
        long longValue = ((Long) e.second).longValue();
        long j = this.d;
        if (j != -1 && longValue == 4294967295L) {
            longValue = j;
        }
        this.g = this.f + longValue;
        long length = mVar.getLength();
        if (length != -1 && this.g > length) {
            s.i("WavExtractor", "Data exceeds input length: " + this.g + ", " + length);
            this.g = length;
        }
        ((InterfaceC0068b) com.google.android.exoplayer2.util.a.e(this.e)).a(this.f, this.g);
        this.c = 4;
    }

    @Override // i9.l
    public void b(n nVar) {
        this.a = nVar;
        this.b = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // i9.l
    public boolean c(m mVar) {
        return d.a(mVar);
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        e();
        int i = this.c;
        if (i == 0) {
            g(mVar);
            return 0;
        }
        if (i == 1) {
            i(mVar);
            return 0;
        }
        if (i == 2) {
            h(mVar);
            return 0;
        }
        if (i == 3) {
            k(mVar);
            return 0;
        }
        if (i == 4) {
            return j(mVar);
        }
        throw new IllegalStateException();
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.c = j == 0 ? 0 : 4;
        InterfaceC0068b interfaceC0068b = this.e;
        if (interfaceC0068b != null) {
            interfaceC0068b.b(j2);
        }
    }
}
