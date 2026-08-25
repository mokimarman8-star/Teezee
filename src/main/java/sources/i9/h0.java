package i9;

import android.util.Base64;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class h0 {

    private static final class a {
        public final int a;
        public final int b;
        public final long[] c;
        public final int d;
        public final boolean e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = jArr;
            this.d = i3;
            this.e = z;
        }
    }

    public static final class b {
        public final String a;
        public final String[] b;
        public final int c;

        public b(String str, String[] strArr, int i) {
            this.a = str;
            this.b = strArr;
            this.c = i;
        }
    }

    public static final class c {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;

        public c(boolean z, int i, int i2, int i3) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i10, boolean z, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i10;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private static long b(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static Metadata c(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String[] T0 = p0.T0(str, UrlUtils.EQUAL_MARK);
            if (T0.length != 2) {
                com.google.android.exoplayer2.util.s.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (T0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new com.google.android.exoplayer2.util.d0(Base64.decode(T0[1], 0))));
                } catch (RuntimeException e) {
                    com.google.android.exoplayer2.util.s.j("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new VorbisComment(T0[0], T0[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static a d(g0 g0Var) {
        if (g0Var.d(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + g0Var.b(), (Throwable) null);
        }
        int d2 = g0Var.d(16);
        int d3 = g0Var.d(24);
        long[] jArr = new long[d3];
        boolean c2 = g0Var.c();
        long j = 0;
        if (c2) {
            int d4 = g0Var.d(5) + 1;
            int i = 0;
            while (i < d3) {
                int d5 = g0Var.d(a(d3 - i));
                for (int i2 = 0; i2 < d5 && i < d3; i2++) {
                    jArr[i] = d4;
                    i++;
                }
                d4++;
            }
        } else {
            boolean c3 = g0Var.c();
            for (int i3 = 0; i3 < d3; i3++) {
                if (!c3) {
                    jArr[i3] = g0Var.d(5) + 1;
                } else if (g0Var.c()) {
                    jArr[i3] = g0Var.d(5) + 1;
                } else {
                    jArr[i3] = 0;
                }
            }
        }
        int d6 = g0Var.d(4);
        if (d6 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + d6, (Throwable) null);
        }
        if (d6 == 1 || d6 == 2) {
            g0Var.e(32);
            g0Var.e(32);
            int d7 = g0Var.d(4) + 1;
            g0Var.e(1);
            if (d6 != 1) {
                j = d3 * d2;
            } else if (d2 != 0) {
                j = b(d3, d2);
            }
            g0Var.e((int) (j * d7));
        }
        return new a(d2, d3, jArr, d6, c2);
    }

    private static void e(g0 g0Var) {
        int d2 = g0Var.d(6) + 1;
        for (int i = 0; i < d2; i++) {
            int d3 = g0Var.d(16);
            if (d3 == 0) {
                g0Var.e(8);
                g0Var.e(16);
                g0Var.e(16);
                g0Var.e(6);
                g0Var.e(8);
                int d4 = g0Var.d(4) + 1;
                for (int i2 = 0; i2 < d4; i2++) {
                    g0Var.e(8);
                }
            } else {
                if (d3 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + d3, (Throwable) null);
                }
                int d5 = g0Var.d(5);
                int[] iArr = new int[d5];
                int i3 = -1;
                for (int i4 = 0; i4 < d5; i4++) {
                    int d6 = g0Var.d(4);
                    iArr[i4] = d6;
                    if (d6 > i3) {
                        i3 = d6;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = g0Var.d(3) + 1;
                    int d7 = g0Var.d(2);
                    if (d7 > 0) {
                        g0Var.e(8);
                    }
                    for (int i7 = 0; i7 < (1 << d7); i7++) {
                        g0Var.e(8);
                    }
                }
                g0Var.e(2);
                int d10 = g0Var.d(4);
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < d5; i12++) {
                    i10 += iArr2[iArr[i12]];
                    while (i11 < i10) {
                        g0Var.e(d10);
                        i11++;
                    }
                }
            }
        }
    }

    private static void f(int i, g0 g0Var) {
        int d2 = g0Var.d(6) + 1;
        for (int i2 = 0; i2 < d2; i2++) {
            int d3 = g0Var.d(16);
            if (d3 != 0) {
                com.google.android.exoplayer2.util.s.c("VorbisUtil", "mapping type other than 0 not supported: " + d3);
            } else {
                int d4 = g0Var.c() ? g0Var.d(4) + 1 : 1;
                if (g0Var.c()) {
                    int d5 = g0Var.d(8) + 1;
                    for (int i3 = 0; i3 < d5; i3++) {
                        int i4 = i - 1;
                        g0Var.e(a(i4));
                        g0Var.e(a(i4));
                    }
                }
                if (g0Var.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", (Throwable) null);
                }
                if (d4 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        g0Var.e(4);
                    }
                }
                for (int i6 = 0; i6 < d4; i6++) {
                    g0Var.e(8);
                    g0Var.e(8);
                    g0Var.e(8);
                }
            }
        }
    }

    private static c[] g(g0 g0Var) {
        int d2 = g0Var.d(6) + 1;
        c[] cVarArr = new c[d2];
        for (int i = 0; i < d2; i++) {
            cVarArr[i] = new c(g0Var.c(), g0Var.d(16), g0Var.d(16), g0Var.d(8));
        }
        return cVarArr;
    }

    private static void h(g0 g0Var) {
        int d2 = g0Var.d(6) + 1;
        for (int i = 0; i < d2; i++) {
            if (g0Var.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", (Throwable) null);
            }
            g0Var.e(24);
            g0Var.e(24);
            g0Var.e(24);
            int d3 = g0Var.d(6) + 1;
            g0Var.e(8);
            int[] iArr = new int[d3];
            for (int i2 = 0; i2 < d3; i2++) {
                iArr[i2] = ((g0Var.c() ? g0Var.d(5) : 0) * 8) + g0Var.d(3);
            }
            for (int i3 = 0; i3 < d3; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        g0Var.e(8);
                    }
                }
            }
        }
    }

    public static b i(com.google.android.exoplayer2.util.d0 d0Var) {
        return j(d0Var, true, true);
    }

    public static b j(com.google.android.exoplayer2.util.d0 d0Var, boolean z, boolean z2) {
        if (z) {
            m(3, d0Var, false);
        }
        String A = d0Var.A((int) d0Var.t());
        int length = A.length();
        long t = d0Var.t();
        String[] strArr = new String[(int) t];
        int i = length + 15;
        for (int i2 = 0; i2 < t; i2++) {
            String A2 = d0Var.A((int) d0Var.t());
            strArr[i2] = A2;
            i = i + 4 + A2.length();
        }
        if (z2 && (d0Var.D() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", (Throwable) null);
        }
        return new b(A, strArr, i + 1);
    }

    public static d k(com.google.android.exoplayer2.util.d0 d0Var) {
        m(1, d0Var, false);
        int u = d0Var.u();
        int D = d0Var.D();
        int u2 = d0Var.u();
        int q = d0Var.q();
        if (q <= 0) {
            q = -1;
        }
        int q2 = d0Var.q();
        if (q2 <= 0) {
            q2 = -1;
        }
        int q3 = d0Var.q();
        if (q3 <= 0) {
            q3 = -1;
        }
        int D2 = d0Var.D();
        return new d(u, D, u2, q, q2, q3, (int) Math.pow(2.0d, D2 & 15), (int) Math.pow(2.0d, (D2 & 240) >> 4), (d0Var.D() & 1) > 0, Arrays.copyOf(d0Var.d(), d0Var.f()));
    }

    public static c[] l(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        m(5, d0Var, false);
        int D = d0Var.D() + 1;
        g0 g0Var = new g0(d0Var.d());
        g0Var.e(d0Var.e() * 8);
        for (int i2 = 0; i2 < D; i2++) {
            d(g0Var);
        }
        int d2 = g0Var.d(6) + 1;
        for (int i3 = 0; i3 < d2; i3++) {
            if (g0Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", (Throwable) null);
            }
        }
        e(g0Var);
        h(g0Var);
        f(i, g0Var);
        c[] g = g(g0Var);
        if (g0Var.c()) {
            return g;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", (Throwable) null);
    }

    public static boolean m(int i, com.google.android.exoplayer2.util.d0 d0Var, boolean z) {
        if (d0Var.a() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + d0Var.a(), (Throwable) null);
        }
        if (d0Var.D() != i) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i), (Throwable) null);
        }
        if (d0Var.D() == 118 && d0Var.D() == 111 && d0Var.D() == 114 && d0Var.D() == 98 && d0Var.D() == 105 && d0Var.D() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", (Throwable) null);
    }
}
