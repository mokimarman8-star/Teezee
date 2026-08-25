package q9;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.audio.c0;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import i9.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import q9.a;
import q9.d;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class b {
    private static final byte[] a = p0.n0("OpusHead");

    private static final class a {
        public final int a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final d0 f;
        private final d0 g;
        private int h;
        private int i;

        public a(d0 d0Var, d0 d0Var2, boolean z) {
            this.g = d0Var;
            this.f = d0Var2;
            this.e = z;
            d0Var2.P(12);
            this.a = d0Var2.H();
            d0Var.P(12);
            this.i = d0Var.H();
            i9.o.a(d0Var.n() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            this.d = this.e ? this.f.I() : this.f.F();
            if (this.b == this.h) {
                this.c = this.g.H();
                this.g.Q(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.H() - 1 : -1;
            }
            return true;
        }
    }

    /* renamed from: q9.b$b, reason: collision with other inner class name */
    private static final class C0063b {
        private final String a;
        private final byte[] b;
        private final long c;
        private final long d;

        public C0063b(String str, byte[] bArr, long j, long j2) {
            this.a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }
    }

    private interface c {
        int a();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static final class d {
        public final p[] a;
        public p1 b;
        public int c;
        public int d = 0;

        public d(int i) {
            this.a = new p[i];
        }
    }

    static final class e implements c {
        private final int a;
        private final int b;
        private final d0 c;

        public e(a.b bVar, p1 p1Var) {
            d0 d0Var = bVar.b;
            this.c = d0Var;
            d0Var.P(12);
            int H = d0Var.H();
            if ("audio/raw".equals(p1Var.l)) {
                int e0 = p0.e0(p1Var.A, p1Var.y);
                if (H == 0 || H % e0 != 0) {
                    s.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + e0 + ", stsz sample size: " + H);
                    H = e0;
                }
            }
            this.a = H == 0 ? -1 : H;
            this.b = d0Var.H();
        }

        @Override // q9.b.c
        public int a() {
            return this.a;
        }

        @Override // q9.b.c
        public int getSampleCount() {
            return this.b;
        }

        @Override // q9.b.c
        public int readNextSampleSize() {
            int i = this.a;
            return i == -1 ? this.c.H() : i;
        }
    }

    static final class f implements c {
        private final d0 a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        public f(a.b bVar) {
            d0 d0Var = bVar.b;
            this.a = d0Var;
            d0Var.P(12);
            this.c = d0Var.H() & 255;
            this.b = d0Var.H();
        }

        @Override // q9.b.c
        public int a() {
            return -1;
        }

        @Override // q9.b.c
        public int getSampleCount() {
            return this.b;
        }

        @Override // q9.b.c
        public int readNextSampleSize() {
            int i = this.c;
            if (i == 8) {
                return this.a.D();
            }
            if (i == 16) {
                return this.a.J();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int D = this.a.D();
            this.e = D;
            return (D & 240) >> 4;
        }
    }

    private static final class g {
        private final int a;
        private final long b;
        private final int c;

        public g(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    public static List A(a.C0062a c0062a, x xVar, long j, DrmInitData drmInitData, boolean z, boolean z2, com.google.common.base.f fVar) {
        o oVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c0062a.d.size(); i++) {
            a.C0062a c0062a2 = (a.C0062a) c0062a.d.get(i);
            if (c0062a2.a == 1953653099 && (oVar = (o) fVar.apply(z(c0062a2, (a.b) com.google.android.exoplayer2.util.a.e(c0062a.g(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(v(oVar, (a.C0062a) com.google.android.exoplayer2.util.a.e(((a.C0062a) com.google.android.exoplayer2.util.a.e(((a.C0062a) com.google.android.exoplayer2.util.a.e(c0062a2.f(1835297121))).f(1835626086))).f(1937007212)), xVar));
            }
        }
        return arrayList;
    }

    public static Pair B(a.b bVar) {
        d0 d0Var = bVar.b;
        d0Var.P(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (d0Var.a() >= 8) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            int n2 = d0Var.n();
            if (n2 == 1835365473) {
                d0Var.P(e2);
                metadata = C(d0Var, e2 + n);
            } else if (n2 == 1936553057) {
                d0Var.P(e2);
                metadata2 = u(d0Var, e2 + n);
            }
            d0Var.P(e2 + n);
        }
        return Pair.create(metadata, metadata2);
    }

    private static Metadata C(d0 d0Var, int i) {
        d0Var.Q(8);
        e(d0Var);
        while (d0Var.e() < i) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            if (d0Var.n() == 1768715124) {
                d0Var.P(e2);
                return l(d0Var, e2 + n);
            }
            d0Var.P(e2 + n);
        }
        return null;
    }

    private static void D(d0 d0Var, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, d dVar, int i6) {
        DrmInitData drmInitData2;
        int i7;
        int i10;
        byte[] bArr;
        float f2;
        List list;
        String str;
        int i11 = i2;
        int i12 = i3;
        DrmInitData drmInitData3 = drmInitData;
        d dVar2 = dVar;
        d0Var.P(i11 + 16);
        d0Var.Q(16);
        int J = d0Var.J();
        int J2 = d0Var.J();
        d0Var.Q(50);
        int e2 = d0Var.e();
        int i13 = i;
        if (i13 == 1701733238) {
            Pair s = s(d0Var, i11, i12);
            if (s != null) {
                i13 = ((Integer) s.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((p) s.second).b);
                dVar2.a[i6] = (p) s.second;
            }
            d0Var.P(e2);
        }
        String str2 = "video/3gpp";
        String str3 = i13 == 1831958048 ? "video/mpeg" : i13 == 1211250227 ? "video/3gpp" : null;
        float f3 = 1.0f;
        byte[] bArr2 = null;
        String str4 = null;
        List list2 = null;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        ByteBuffer byteBuffer = null;
        C0063b c0063b = null;
        boolean z = false;
        while (true) {
            if (e2 - i11 >= i12) {
                drmInitData2 = drmInitData3;
                break;
            }
            d0Var.P(e2);
            int e3 = d0Var.e();
            String str5 = str2;
            int n = d0Var.n();
            if (n == 0) {
                drmInitData2 = drmInitData3;
                if (d0Var.e() - i11 == i12) {
                    break;
                }
            } else {
                drmInitData2 = drmInitData3;
            }
            i9.o.a(n > 0, "childAtomSize must be positive");
            int n2 = d0Var.n();
            if (n2 == 1635148611) {
                i9.o.a(str3 == null, null);
                d0Var.P(e3 + 8);
                com.google.android.exoplayer2.video.a b = com.google.android.exoplayer2.video.a.b(d0Var);
                list2 = b.a;
                dVar2.c = b.b;
                if (!z) {
                    f3 = b.e;
                }
                str4 = b.f;
                str = "video/avc";
            } else if (n2 == 1752589123) {
                i9.o.a(str3 == null, null);
                d0Var.P(e3 + 8);
                com.google.android.exoplayer2.video.f a2 = com.google.android.exoplayer2.video.f.a(d0Var);
                list2 = a2.a;
                dVar2.c = a2.b;
                if (!z) {
                    f3 = a2.e;
                }
                str4 = a2.f;
                str = "video/hevc";
            } else {
                if (n2 == 1685480259 || n2 == 1685485123) {
                    i7 = J2;
                    i10 = i13;
                    bArr = bArr2;
                    f2 = f3;
                    list = list2;
                    com.google.android.exoplayer2.video.d a3 = com.google.android.exoplayer2.video.d.a(d0Var);
                    if (a3 != null) {
                        str4 = a3.c;
                        str3 = "video/dolby-vision";
                    }
                } else if (n2 == 1987076931) {
                    i9.o.a(str3 == null, null);
                    str = i13 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (n2 == 1635135811) {
                    i9.o.a(str3 == null, null);
                    str = "video/av01";
                } else if (n2 == 1668050025) {
                    if (byteBuffer == null) {
                        byteBuffer = a();
                    }
                    ByteBuffer byteBuffer2 = byteBuffer;
                    byteBuffer2.position(21);
                    byteBuffer2.putShort(d0Var.z());
                    byteBuffer2.putShort(d0Var.z());
                    byteBuffer = byteBuffer2;
                    i7 = J2;
                    i10 = i13;
                    e2 += n;
                    i11 = i2;
                    i12 = i3;
                    dVar2 = dVar;
                    str2 = str5;
                    drmInitData3 = drmInitData2;
                    i13 = i10;
                    J2 = i7;
                } else if (n2 == 1835295606) {
                    if (byteBuffer == null) {
                        byteBuffer = a();
                    }
                    ByteBuffer byteBuffer3 = byteBuffer;
                    short z2 = d0Var.z();
                    short z3 = d0Var.z();
                    short z4 = d0Var.z();
                    i10 = i13;
                    short z5 = d0Var.z();
                    short z6 = d0Var.z();
                    List list3 = list2;
                    short z10 = d0Var.z();
                    byte[] bArr3 = bArr2;
                    short z11 = d0Var.z();
                    float f4 = f3;
                    short z12 = d0Var.z();
                    long F = d0Var.F();
                    long F2 = d0Var.F();
                    i7 = J2;
                    byteBuffer3.position(1);
                    byteBuffer3.putShort(z6);
                    byteBuffer3.putShort(z10);
                    byteBuffer3.putShort(z2);
                    byteBuffer3.putShort(z3);
                    byteBuffer3.putShort(z4);
                    byteBuffer3.putShort(z5);
                    byteBuffer3.putShort(z11);
                    byteBuffer3.putShort(z12);
                    byteBuffer3.putShort((short) (F / 10000));
                    byteBuffer3.putShort((short) (F2 / 10000));
                    byteBuffer = byteBuffer3;
                    list2 = list3;
                    bArr2 = bArr3;
                    f3 = f4;
                    e2 += n;
                    i11 = i2;
                    i12 = i3;
                    dVar2 = dVar;
                    str2 = str5;
                    drmInitData3 = drmInitData2;
                    i13 = i10;
                    J2 = i7;
                } else {
                    i7 = J2;
                    i10 = i13;
                    bArr = bArr2;
                    f2 = f3;
                    list = list2;
                    if (n2 == 1681012275) {
                        i9.o.a(str3 == null, null);
                        str3 = str5;
                    } else if (n2 == 1702061171) {
                        i9.o.a(str3 == null, null);
                        c0063b = i(d0Var, e3);
                        String str6 = c0063b.a;
                        byte[] bArr4 = c0063b.b;
                        list2 = bArr4 != null ? ImmutableList.of(bArr4) : list;
                        str3 = str6;
                        bArr2 = bArr;
                        f3 = f2;
                        e2 += n;
                        i11 = i2;
                        i12 = i3;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i13 = i10;
                        J2 = i7;
                    } else if (n2 == 1885434736) {
                        f3 = q(d0Var, e3);
                        list2 = list;
                        bArr2 = bArr;
                        z = true;
                        e2 += n;
                        i11 = i2;
                        i12 = i3;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i13 = i10;
                        J2 = i7;
                    } else if (n2 == 1937126244) {
                        bArr2 = r(d0Var, e3, n);
                        list2 = list;
                        f3 = f2;
                        e2 += n;
                        i11 = i2;
                        i12 = i3;
                        dVar2 = dVar;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i13 = i10;
                        J2 = i7;
                    } else if (n2 == 1936995172) {
                        int D = d0Var.D();
                        d0Var.Q(3);
                        if (D == 0) {
                            int D2 = d0Var.D();
                            if (D2 == 0) {
                                i14 = 0;
                            } else if (D2 == 1) {
                                i14 = 1;
                            } else if (D2 == 2) {
                                i14 = 2;
                            } else if (D2 == 3) {
                                i14 = 3;
                            }
                        }
                    } else if (n2 == 1668246642) {
                        int n3 = d0Var.n();
                        if (n3 == 1852009592 || n3 == 1852009571) {
                            int J3 = d0Var.J();
                            int J4 = d0Var.J();
                            d0Var.Q(2);
                            boolean z13 = n == 19 && (d0Var.D() & 128) != 0;
                            i15 = com.google.android.exoplayer2.video.c.b(J3);
                            i16 = z13 ? 1 : 2;
                            i17 = com.google.android.exoplayer2.video.c.c(J4);
                        } else {
                            s.i("AtomParsers", "Unsupported color type: " + q9.a.a(n3));
                        }
                    }
                }
                list2 = list;
                bArr2 = bArr;
                f3 = f2;
                e2 += n;
                i11 = i2;
                i12 = i3;
                dVar2 = dVar;
                str2 = str5;
                drmInitData3 = drmInitData2;
                i13 = i10;
                J2 = i7;
            }
            str3 = str;
            i7 = J2;
            i10 = i13;
            e2 += n;
            i11 = i2;
            i12 = i3;
            dVar2 = dVar;
            str2 = str5;
            drmInitData3 = drmInitData2;
            i13 = i10;
            J2 = i7;
        }
        int i18 = J2;
        byte[] bArr5 = bArr2;
        float f5 = f3;
        List list4 = list2;
        if (str3 == null) {
            return;
        }
        p1.b M = new p1.b().R(i4).e0(str3).I(str4).j0(J).Q(i18).a0(f5).d0(i5).b0(bArr5).h0(i14).T(list4).M(drmInitData2);
        int i19 = i15;
        int i20 = i16;
        int i21 = i17;
        if (i19 != -1 || i20 != -1 || i21 != -1 || byteBuffer != null) {
            M.J(new com.google.android.exoplayer2.video.c(i19, i20, i21, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (c0063b != null) {
            M.G(Ints.n(c0063b.c)).Z(Ints.n(c0063b.d));
        }
        dVar.b = M.E();
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[p0.q(4, 0, length)] && jArr[p0.q(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static int c(d0 d0Var, int i, int i2, int i3) {
        int e2 = d0Var.e();
        i9.o.a(e2 >= i2, null);
        while (e2 - i2 < i3) {
            d0Var.P(e2);
            int n = d0Var.n();
            i9.o.a(n > 0, "childAtomSize must be positive");
            if (d0Var.n() == i) {
                return e2;
            }
            e2 += n;
        }
        return -1;
    }

    private static int d(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static void e(d0 d0Var) {
        int e2 = d0Var.e();
        d0Var.Q(4);
        if (d0Var.n() != 1751411826) {
            e2 += 4;
        }
        d0Var.P(e2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void f(d0 d0Var, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, d dVar, int i5) {
        int i6;
        int E;
        int n;
        int i7;
        String str2;
        String str3;
        int i10;
        char c2;
        int i11 = i2;
        int i12 = i3;
        DrmInitData drmInitData2 = drmInitData;
        d0Var.P(i11 + 16);
        if (z) {
            i6 = d0Var.J();
            d0Var.Q(6);
        } else {
            d0Var.Q(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            int J = d0Var.J();
            d0Var.Q(6);
            E = d0Var.E();
            d0Var.P(d0Var.e() - 4);
            n = d0Var.n();
            if (i6 == 1) {
                d0Var.Q(16);
            }
            i7 = J;
        } else {
            if (i6 != 2) {
                return;
            }
            d0Var.Q(16);
            E = (int) Math.round(d0Var.l());
            i7 = d0Var.H();
            d0Var.Q(20);
            n = 0;
        }
        int e2 = d0Var.e();
        int i13 = i;
        if (i13 == 1701733217) {
            Pair s = s(d0Var, i11, i12);
            if (s != null) {
                i13 = ((Integer) s.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((p) s.second).b);
                dVar.a[i5] = (p) s.second;
            }
            d0Var.P(e2);
        }
        if (i13 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i13 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i13 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i13 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i13 == 1685353320 || i13 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i13 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i13 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i13 == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (i13 != 1935767394) {
                str3 = "audio/raw";
                if (i13 == 1819304813 || i13 == 1936684916) {
                    i10 = 2;
                } else if (i13 == 1953984371) {
                    i10 = 268435456;
                } else if (i13 == 778924082 || i13 == 778924083) {
                    str2 = "audio/mpeg";
                } else if (i13 == 1835557169) {
                    str2 = "audio/mha1";
                } else if (i13 == 1835560241) {
                    str2 = "audio/mhm1";
                } else if (i13 == 1634492771) {
                    str2 = "audio/alac";
                } else if (i13 == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (i13 == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (i13 == 1332770163) {
                    str2 = "audio/opus";
                } else if (i13 == 1716281667) {
                    str2 = "audio/flac";
                } else if (i13 == 1835823201) {
                    str2 = "audio/true-hd";
                } else {
                    i10 = -1;
                    str3 = null;
                }
                String str4 = str3;
                C0063b c0063b = null;
                String str5 = null;
                ImmutableList immutableList = null;
                while (e2 - i11 < i12) {
                    d0Var.P(e2);
                    int n2 = d0Var.n();
                    i9.o.a(n2 > 0, "childAtomSize must be positive");
                    int n3 = d0Var.n();
                    if (n3 == 1835557187) {
                        int i14 = n2 - 13;
                        byte[] bArr = new byte[i14];
                        d0Var.P(e2 + 13);
                        d0Var.j(bArr, 0, i14);
                        immutableList = ImmutableList.of(bArr);
                    } else {
                        if (n3 == 1702061171 || (z && n3 == 2002876005)) {
                            c2 = 24931;
                            int c3 = n3 == 1702061171 ? e2 : c(d0Var, 1702061171, e2, n2);
                            if (c3 != -1) {
                                c0063b = i(d0Var, c3);
                                str4 = c0063b.a;
                                byte[] bArr2 = c0063b.b;
                                if (bArr2 != null) {
                                    if ("audio/mp4a-latm".equals(str4)) {
                                        a.b f2 = com.google.android.exoplayer2.audio.a.f(bArr2);
                                        E = f2.a;
                                        i7 = f2.b;
                                        str5 = f2.c;
                                    }
                                    immutableList = ImmutableList.of(bArr2);
                                }
                            }
                        } else {
                            if (n3 == 1684103987) {
                                d0Var.P(e2 + 8);
                                dVar.b = com.google.android.exoplayer2.audio.b.c(d0Var, Integer.toString(i4), str, drmInitData2);
                            } else if (n3 == 1684366131) {
                                d0Var.P(e2 + 8);
                                dVar.b = com.google.android.exoplayer2.audio.b.g(d0Var, Integer.toString(i4), str, drmInitData2);
                            } else if (n3 == 1684103988) {
                                d0Var.P(e2 + 8);
                                dVar.b = com.google.android.exoplayer2.audio.c.b(d0Var, Integer.toString(i4), str, drmInitData2);
                            } else if (n3 == 1684892784) {
                                if (n <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + n, (Throwable) null);
                                }
                                E = n;
                                i7 = 2;
                                c2 = 24931;
                            } else if (n3 == 1684305011) {
                                dVar.b = new p1.b().R(i4).e0(str4).H(i7).f0(E).M(drmInitData2).V(str).E();
                            } else if (n3 == 1682927731) {
                                int i15 = n2 - 8;
                                byte[] bArr3 = a;
                                byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + i15);
                                d0Var.P(e2 + 8);
                                d0Var.j(copyOf, bArr3.length, i15);
                                immutableList = c0.a(copyOf);
                            } else if (n3 == 1684425825) {
                                byte[] bArr4 = new byte[n2 - 8];
                                bArr4[0] = 102;
                                bArr4[1] = 76;
                                bArr4[2] = 97;
                                bArr4[3] = 67;
                                d0Var.P(e2 + 12);
                                d0Var.j(bArr4, 4, n2 - 12);
                                immutableList = ImmutableList.of(bArr4);
                                c2 = 24931;
                            } else if (n3 == 1634492771) {
                                int i16 = n2 - 12;
                                byte[] bArr5 = new byte[i16];
                                d0Var.P(e2 + 12);
                                d0Var.j(bArr5, 0, i16);
                                Pair h = com.google.android.exoplayer2.util.f.h(bArr5);
                                int intValue = ((Integer) h.first).intValue();
                                int intValue2 = ((Integer) h.second).intValue();
                                immutableList = ImmutableList.of(bArr5);
                                c2 = 24931;
                                i7 = intValue2;
                                E = intValue;
                            } else {
                                c2 = 24931;
                            }
                            c2 = 24931;
                        }
                        e2 += n2;
                        i11 = i2;
                        i12 = i3;
                    }
                    c2 = 24931;
                    e2 += n2;
                    i11 = i2;
                    i12 = i3;
                }
                if (dVar.b == null || str4 == null) {
                }
                p1.b V = new p1.b().R(i4).e0(str4).I(str5).H(i7).f0(E).Y(i10).T(immutableList).M(drmInitData2).V(str);
                if (c0063b != null) {
                    V.G(Ints.n(c0063b.c)).Z(Ints.n(c0063b.d));
                }
                dVar.b = V.E();
                return;
            }
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i10 = -1;
        String str42 = str3;
        C0063b c0063b2 = null;
        String str52 = null;
        ImmutableList immutableList2 = null;
        while (e2 - i11 < i12) {
        }
        if (dVar.b == null) {
        }
    }

    static Pair g(d0 d0Var, int i, int i2) {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String str = null;
        Integer num = null;
        while (i3 - i < i2) {
            d0Var.P(i3);
            int n = d0Var.n();
            int n2 = d0Var.n();
            if (n2 == 1718775137) {
                num = Integer.valueOf(d0Var.n());
            } else if (n2 == 1935894637) {
                d0Var.Q(4);
                str = d0Var.A(4);
            } else if (n2 == 1935894633) {
                i4 = i3;
                i5 = n;
            }
            i3 += n;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        i9.o.a(num != null, "frma atom is mandatory");
        i9.o.a(i4 != -1, "schi atom is mandatory");
        p t = t(d0Var, i4, i5, str);
        i9.o.a(t != null, "tenc atom is mandatory");
        return Pair.create(num, (p) p0.j(t));
    }

    private static Pair h(a.C0062a c0062a) {
        a.b g2 = c0062a.g(1701606260);
        if (g2 == null) {
            return null;
        }
        d0 d0Var = g2.b;
        d0Var.P(8);
        int c2 = q9.a.c(d0Var.n());
        int H = d0Var.H();
        long[] jArr = new long[H];
        long[] jArr2 = new long[H];
        for (int i = 0; i < H; i++) {
            jArr[i] = c2 == 1 ? d0Var.I() : d0Var.F();
            jArr2[i] = c2 == 1 ? d0Var.w() : d0Var.n();
            if (d0Var.z() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            d0Var.Q(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static C0063b i(d0 d0Var, int i) {
        d0Var.P(i + 12);
        d0Var.Q(1);
        j(d0Var);
        d0Var.Q(2);
        int D = d0Var.D();
        if ((D & 128) != 0) {
            d0Var.Q(2);
        }
        if ((D & 64) != 0) {
            d0Var.Q(d0Var.D());
        }
        if ((D & 32) != 0) {
            d0Var.Q(2);
        }
        d0Var.Q(1);
        j(d0Var);
        String h = w.h(d0Var.D());
        if ("audio/mpeg".equals(h) || "audio/vnd.dts".equals(h) || "audio/vnd.dts.hd".equals(h)) {
            return new C0063b(h, null, -1L, -1L);
        }
        d0Var.Q(4);
        long F = d0Var.F();
        long F2 = d0Var.F();
        d0Var.Q(1);
        int j = j(d0Var);
        byte[] bArr = new byte[j];
        d0Var.j(bArr, 0, j);
        return new C0063b(h, bArr, F2 > 0 ? F2 : -1L, F > 0 ? F : -1L);
    }

    private static int j(d0 d0Var) {
        int D = d0Var.D();
        int i = D & 127;
        while ((D & 128) == 128) {
            D = d0Var.D();
            i = (i << 7) | (D & 127);
        }
        return i;
    }

    private static int k(d0 d0Var) {
        d0Var.P(16);
        return d0Var.n();
    }

    private static Metadata l(d0 d0Var, int i) {
        d0Var.Q(8);
        ArrayList arrayList = new ArrayList();
        while (d0Var.e() < i) {
            Metadata.Entry c2 = h.c(d0Var);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair m(d0 d0Var) {
        d0Var.P(8);
        int c2 = q9.a.c(d0Var.n());
        d0Var.Q(c2 == 0 ? 8 : 16);
        long F = d0Var.F();
        d0Var.Q(c2 == 0 ? 4 : 8);
        int J = d0Var.J();
        return Pair.create(Long.valueOf(F), "" + ((char) (((J >> 10) & 31) + 96)) + ((char) (((J >> 5) & 31) + 96)) + ((char) ((J & 31) + 96)));
    }

    public static Metadata n(a.C0062a c0062a) {
        a.b g2 = c0062a.g(1751411826);
        a.b g3 = c0062a.g(1801812339);
        a.b g4 = c0062a.g(1768715124);
        if (g2 == null || g3 == null || g4 == null || k(g2.b) != 1835299937) {
            return null;
        }
        d0 d0Var = g3.b;
        d0Var.P(12);
        int n = d0Var.n();
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            int n2 = d0Var.n();
            d0Var.Q(4);
            strArr[i] = d0Var.A(n2 - 8);
        }
        d0 d0Var2 = g4.b;
        d0Var2.P(8);
        ArrayList arrayList = new ArrayList();
        while (d0Var2.a() > 8) {
            int e2 = d0Var2.e();
            int n3 = d0Var2.n();
            int n4 = d0Var2.n() - 1;
            if (n4 < 0 || n4 >= n) {
                s.i("AtomParsers", "Skipped metadata with unknown key index: " + n4);
            } else {
                MdtaMetadataEntry f2 = h.f(d0Var2, e2 + n3, strArr[n4]);
                if (f2 != null) {
                    arrayList.add(f2);
                }
            }
            d0Var2.P(e2 + n3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void o(d0 d0Var, int i, int i2, int i3, d dVar) {
        d0Var.P(i2 + 16);
        if (i == 1835365492) {
            d0Var.x();
            String x = d0Var.x();
            if (x != null) {
                dVar.b = new p1.b().R(i3).e0(x).E();
            }
        }
    }

    private static long p(d0 d0Var) {
        d0Var.P(8);
        d0Var.Q(q9.a.c(d0Var.n()) != 0 ? 16 : 8);
        return d0Var.F();
    }

    private static float q(d0 d0Var, int i) {
        d0Var.P(i + 8);
        return d0Var.H() / d0Var.H();
    }

    private static byte[] r(d0 d0Var, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            d0Var.P(i3);
            int n = d0Var.n();
            if (d0Var.n() == 1886547818) {
                return Arrays.copyOfRange(d0Var.d(), i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    private static Pair s(d0 d0Var, int i, int i2) {
        Pair g2;
        int e2 = d0Var.e();
        while (e2 - i < i2) {
            d0Var.P(e2);
            int n = d0Var.n();
            i9.o.a(n > 0, "childAtomSize must be positive");
            if (d0Var.n() == 1936289382 && (g2 = g(d0Var, e2, n)) != null) {
                return g2;
            }
            e2 += n;
        }
        return null;
    }

    private static p t(d0 d0Var, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            d0Var.P(i5);
            int n = d0Var.n();
            if (d0Var.n() == 1952804451) {
                int c2 = q9.a.c(d0Var.n());
                d0Var.Q(1);
                if (c2 == 0) {
                    d0Var.Q(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int D = d0Var.D();
                    i3 = D & 15;
                    i4 = (D & 240) >> 4;
                }
                boolean z = d0Var.D() == 1;
                int D2 = d0Var.D();
                byte[] bArr2 = new byte[16];
                d0Var.j(bArr2, 0, 16);
                if (z && D2 == 0) {
                    int D3 = d0Var.D();
                    bArr = new byte[D3];
                    d0Var.j(bArr, 0, D3);
                }
                return new p(z, str, D2, bArr2, i4, i3, bArr);
            }
            i5 += n;
        }
    }

    private static Metadata u(d0 d0Var, int i) {
        d0Var.Q(12);
        while (d0Var.e() < i) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            if (d0Var.n() == 1935766900) {
                if (n < 14) {
                    return null;
                }
                d0Var.Q(5);
                int D = d0Var.D();
                if (D != 12 && D != 13) {
                    return null;
                }
                float f2 = D == 12 ? 240.0f : 120.0f;
                d0Var.Q(1);
                return new Metadata(new Metadata.Entry[]{new SmtaMetadataEntry(f2, d0Var.D())});
            }
            d0Var.P(e2 + n);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x042b A[EDGE_INSN: B:97:0x042b->B:98:0x042b BREAK  A[LOOP:2: B:76:0x03ca->B:92:0x0424], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static r v(o oVar, a.C0062a c0062a, x xVar) {
        c fVar;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i10;
        boolean z3;
        int i11;
        o oVar2;
        int i12;
        long[] jArr;
        int[] iArr;
        int i13;
        long j;
        long[] jArr2;
        int[] iArr2;
        int i14;
        int i15;
        int i16;
        int i17;
        long[] jArr3;
        int i18;
        boolean z4;
        int i19;
        long[] jArr4;
        int i20;
        long[] jArr5;
        int[] iArr3;
        int i21;
        boolean z5;
        int i22;
        int i23;
        a.b g2 = c0062a.g(1937011578);
        if (g2 != null) {
            fVar = new e(g2, oVar.f);
        } else {
            a.b g3 = c0062a.g(1937013298);
            if (g3 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", (Throwable) null);
            }
            fVar = new f(g3);
        }
        int sampleCount = fVar.getSampleCount();
        if (sampleCount == 0) {
            return new r(oVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        a.b g4 = c0062a.g(1937007471);
        if (g4 == null) {
            g4 = (a.b) com.google.android.exoplayer2.util.a.e(c0062a.g(1668232756));
            z = true;
        } else {
            z = false;
        }
        d0 d0Var = g4.b;
        d0 d0Var2 = ((a.b) com.google.android.exoplayer2.util.a.e(c0062a.g(1937011555))).b;
        d0 d0Var3 = ((a.b) com.google.android.exoplayer2.util.a.e(c0062a.g(1937011827))).b;
        a.b g5 = c0062a.g(1937011571);
        d0 d0Var4 = g5 != null ? g5.b : null;
        a.b g6 = c0062a.g(1668576371);
        d0 d0Var5 = g6 != null ? g6.b : null;
        a aVar = new a(d0Var2, d0Var, z);
        d0Var3.P(12);
        int H = d0Var3.H() - 1;
        int H2 = d0Var3.H();
        int H3 = d0Var3.H();
        if (d0Var5 != null) {
            d0Var5.P(12);
            i = d0Var5.H();
        } else {
            i = 0;
        }
        if (d0Var4 != null) {
            d0Var4.P(12);
            i3 = d0Var4.H();
            if (i3 > 0) {
                i2 = d0Var4.H() - 1;
            } else {
                i2 = -1;
                d0Var4 = null;
            }
        } else {
            i2 = -1;
            i3 = 0;
        }
        int a2 = fVar.a();
        String str = oVar.f.l;
        if (a2 == -1 || !(("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && H == 0 && i == 0 && i3 == 0)) {
            i4 = i3;
            z2 = false;
        } else {
            i4 = i3;
            z2 = true;
        }
        if (z2) {
            int i24 = aVar.a;
            long[] jArr6 = new long[i24];
            int[] iArr4 = new int[i24];
            while (aVar.a()) {
                int i25 = aVar.b;
                jArr6[i25] = aVar.d;
                iArr4[i25] = aVar.c;
            }
            d.b a3 = q9.d.a(a2, jArr6, iArr4, H3);
            long[] jArr7 = a3.a;
            int[] iArr5 = a3.b;
            int i26 = a3.c;
            long[] jArr8 = a3.d;
            int[] iArr6 = a3.e;
            long j2 = a3.f;
            oVar2 = oVar;
            i12 = sampleCount;
            jArr = jArr7;
            iArr = iArr5;
            i13 = i26;
            iArr2 = iArr6;
            j = j2;
            jArr2 = jArr8;
        } else {
            long[] jArr9 = new long[sampleCount];
            int[] iArr7 = new int[sampleCount];
            long[] jArr10 = new long[sampleCount];
            int[] iArr8 = new int[sampleCount];
            int i27 = i2;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            long j3 = 0;
            long j4 = 0;
            int i33 = i;
            int i34 = H3;
            int i35 = H2;
            int i36 = H;
            int i37 = i4;
            while (true) {
                i5 = i36;
                if (i28 >= sampleCount) {
                    i6 = i35;
                    i7 = i30;
                    i10 = i31;
                    break;
                }
                long j5 = j4;
                int i38 = i30;
                boolean z6 = true;
                while (i38 == 0) {
                    z6 = aVar.a();
                    if (!z6) {
                        break;
                    }
                    int i39 = i35;
                    long j6 = aVar.d;
                    i38 = aVar.c;
                    j5 = j6;
                    i35 = i39;
                    i34 = i34;
                    sampleCount = sampleCount;
                }
                int i40 = sampleCount;
                i6 = i35;
                int i41 = i34;
                if (!z6) {
                    s.i("AtomParsers", "Unexpected end of chunk data");
                    jArr9 = Arrays.copyOf(jArr9, i28);
                    iArr7 = Arrays.copyOf(iArr7, i28);
                    jArr10 = Arrays.copyOf(jArr10, i28);
                    iArr8 = Arrays.copyOf(iArr8, i28);
                    sampleCount = i28;
                    i10 = i31;
                    i7 = i38;
                    break;
                }
                if (d0Var5 != null) {
                    while (i32 == 0 && i33 > 0) {
                        i32 = d0Var5.H();
                        i31 = d0Var5.n();
                        i33--;
                    }
                    i32--;
                }
                int i42 = i31;
                jArr9[i28] = j5;
                int readNextSampleSize = fVar.readNextSampleSize();
                iArr7[i28] = readNextSampleSize;
                if (readNextSampleSize > i29) {
                    i29 = readNextSampleSize;
                }
                jArr10[i28] = j3 + i42;
                iArr8[i28] = d0Var4 == null ? 1 : 0;
                if (i28 == i27) {
                    iArr8[i28] = 1;
                    i37--;
                    if (i37 > 0) {
                        i27 = ((d0) com.google.android.exoplayer2.util.a.e(d0Var4)).H() - 1;
                    }
                }
                int i43 = i27;
                j3 += i41;
                int i44 = i6 - 1;
                if (i44 != 0 || i5 <= 0) {
                    i14 = i41;
                    i15 = i5;
                } else {
                    i44 = d0Var3.H();
                    i14 = d0Var3.n();
                    i15 = i5 - 1;
                }
                int i45 = i44;
                long j7 = j5 + iArr7[i28];
                int i46 = i38 - 1;
                i28++;
                j4 = j7;
                i27 = i43;
                i34 = i14;
                i30 = i46;
                sampleCount = i40;
                i31 = i42;
                i36 = i15;
                i35 = i45;
            }
            long j10 = j3 + i10;
            if (d0Var5 != null) {
                while (i33 > 0) {
                    if (d0Var5.H() != 0) {
                        z3 = false;
                        break;
                    }
                    d0Var5.n();
                    i33--;
                }
            }
            z3 = true;
            if (i37 == 0 && i6 == 0 && i7 == 0 && i5 == 0) {
                i11 = i32;
                if (i11 == 0 && z3) {
                    oVar2 = oVar;
                    i12 = sampleCount;
                    jArr = jArr9;
                    iArr = iArr7;
                    i13 = i29;
                    j = j10;
                    jArr2 = jArr10;
                    iArr2 = iArr8;
                }
            } else {
                i11 = i32;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            oVar2 = oVar;
            sb.append(oVar2.a);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i37);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i6);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i7);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i5);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i11);
            sb.append(!z3 ? ", ctts invalid" : "");
            s.i("AtomParsers", sb.toString());
            i12 = sampleCount;
            jArr = jArr9;
            iArr = iArr7;
            i13 = i29;
            j = j10;
            jArr2 = jArr10;
            iArr2 = iArr8;
        }
        long N0 = p0.N0(j, 1000000L, oVar2.c);
        long[] jArr11 = oVar2.h;
        if (jArr11 == null) {
            p0.P0(jArr2, 1000000L, oVar2.c);
            return new r(oVar, jArr, iArr, i13, jArr2, iArr2, N0);
        }
        if (jArr11.length == 1 && oVar2.b == 1 && jArr2.length >= 2) {
            long j11 = ((long[]) com.google.android.exoplayer2.util.a.e(oVar2.i))[0];
            long N02 = j11 + p0.N0(oVar2.h[0], oVar2.c, oVar2.d);
            i16 = i12;
            if (b(jArr2, j, j11, N02)) {
                long N03 = p0.N0(j11 - jArr2[0], oVar2.f.z, oVar2.c);
                i17 = i13;
                long N04 = p0.N0(j - N02, oVar2.f.z, oVar2.c);
                if ((N03 != 0 || N04 != 0) && N03 <= 2147483647L && N04 <= 2147483647L) {
                    xVar.a = (int) N03;
                    xVar.b = (int) N04;
                    p0.P0(jArr2, 1000000L, oVar2.c);
                    return new r(oVar, jArr, iArr, i17, jArr2, iArr2, p0.N0(oVar2.h[0], 1000000L, oVar2.d));
                }
                jArr3 = oVar2.h;
                if (jArr3.length != 1 && jArr3[0] == 0) {
                    long j12 = ((long[]) com.google.android.exoplayer2.util.a.e(oVar2.i))[0];
                    for (int i47 = 0; i47 < jArr2.length; i47++) {
                        jArr2[i47] = p0.N0(jArr2[i47] - j12, 1000000L, oVar2.c);
                    }
                    return new r(oVar, jArr, iArr, i17, jArr2, iArr2, p0.N0(j - j12, 1000000L, oVar2.c));
                }
                boolean z10 = oVar2.b != 1;
                int[] iArr9 = new int[jArr3.length];
                int[] iArr10 = new int[jArr3.length];
                long[] jArr12 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.i);
                i18 = 0;
                z4 = false;
                int i48 = 0;
                i19 = 0;
                while (true) {
                    jArr4 = oVar2.h;
                    if (i18 < jArr4.length) {
                        break;
                    }
                    long[] jArr13 = jArr;
                    int[] iArr11 = iArr;
                    long j13 = jArr12[i18];
                    if (j13 != -1) {
                        int i49 = i19;
                        boolean z11 = z4;
                        int i50 = i48;
                        long N05 = p0.N0(jArr4[i18], oVar2.c, oVar2.d);
                        iArr9[i18] = p0.i(jArr2, j13, true, true);
                        iArr10[i18] = p0.e(jArr2, j13 + N05, z10, false);
                        while (true) {
                            i23 = iArr9[i18];
                            i22 = iArr10[i18];
                            if (i23 >= i22 || (iArr2[i23] & 1) != 0) {
                                break;
                            }
                            iArr9[i18] = i23 + 1;
                        }
                        i48 = i50 + (i22 - i23);
                        z5 = z11 | (i49 != i23);
                    } else {
                        z5 = z4;
                        i22 = i19;
                    }
                    i18++;
                    z4 = z5;
                    i19 = i22;
                    jArr = jArr13;
                    iArr = iArr11;
                }
                long[] jArr14 = jArr;
                int[] iArr12 = iArr;
                boolean z12 = z4;
                i20 = 0;
                boolean z13 = z12 | (i48 != i16);
                long[] jArr15 = !z13 ? new long[i48] : jArr14;
                int[] iArr13 = !z13 ? new int[i48] : iArr12;
                int i51 = !z13 ? 0 : i17;
                int[] iArr14 = !z13 ? new int[i48] : iArr2;
                long[] jArr16 = new long[i48];
                int i52 = i51;
                int[] iArr15 = iArr12;
                long j14 = 0;
                int i53 = 0;
                while (i20 < oVar2.h.length) {
                    long j15 = oVar2.i[i20];
                    int i54 = iArr9[i20];
                    int[] iArr16 = iArr9;
                    int i55 = iArr10[i20];
                    int[] iArr17 = iArr10;
                    if (z13) {
                        int i56 = i55 - i54;
                        System.arraycopy(jArr14, i54, jArr15, i53, i56);
                        jArr5 = jArr14;
                        iArr3 = iArr15;
                        System.arraycopy(iArr3, i54, iArr13, i53, i56);
                        System.arraycopy(iArr2, i54, iArr14, i53, i56);
                    } else {
                        jArr5 = jArr14;
                        iArr3 = iArr15;
                    }
                    int i57 = i52;
                    while (i54 < i55) {
                        int i58 = i57;
                        int i59 = i55;
                        long[] jArr17 = jArr2;
                        int[] iArr18 = iArr2;
                        int[] iArr19 = iArr14;
                        long j16 = j14;
                        jArr16[i53] = p0.N0(j14, 1000000L, oVar2.d) + p0.N0(Math.max(0L, jArr2[i54] - j15), 1000000L, oVar2.c);
                        if (z13) {
                            i21 = i58;
                            if (iArr13[i53] > i21) {
                                i57 = iArr3[i54];
                                i53++;
                                i54++;
                                i55 = i59;
                                j14 = j16;
                                jArr2 = jArr17;
                                iArr2 = iArr18;
                                iArr14 = iArr19;
                            }
                        } else {
                            i21 = i58;
                        }
                        i57 = i21;
                        i53++;
                        i54++;
                        i55 = i59;
                        j14 = j16;
                        jArr2 = jArr17;
                        iArr2 = iArr18;
                        iArr14 = iArr19;
                    }
                    long[] jArr18 = jArr2;
                    long j17 = j14 + oVar2.h[i20];
                    i20++;
                    i52 = i57;
                    iArr15 = iArr3;
                    j14 = j17;
                    iArr9 = iArr16;
                    jArr2 = jArr18;
                    iArr2 = iArr2;
                    iArr10 = iArr17;
                    jArr14 = jArr5;
                    iArr14 = iArr14;
                }
                return new r(oVar, jArr15, iArr13, i52, jArr16, iArr14, p0.N0(j14, 1000000L, oVar2.d));
            }
        } else {
            i16 = i12;
        }
        i17 = i13;
        jArr3 = oVar2.h;
        if (jArr3.length != 1) {
        }
        if (oVar2.b != 1) {
        }
        int[] iArr92 = new int[jArr3.length];
        int[] iArr102 = new int[jArr3.length];
        long[] jArr122 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.i);
        i18 = 0;
        z4 = false;
        int i482 = 0;
        i19 = 0;
        while (true) {
            jArr4 = oVar2.h;
            if (i18 < jArr4.length) {
            }
            i18++;
            z4 = z5;
            i19 = i22;
            jArr = jArr13;
            iArr = iArr11;
        }
        long[] jArr142 = jArr;
        int[] iArr122 = iArr;
        boolean z122 = z4;
        i20 = 0;
        boolean z132 = z122 | (i482 != i16);
        if (!z132) {
        }
        if (!z132) {
        }
        if (!z132) {
        }
        if (!z132) {
        }
        long[] jArr162 = new long[i482];
        int i522 = i51;
        int[] iArr152 = iArr122;
        long j142 = 0;
        int i532 = 0;
        while (i20 < oVar2.h.length) {
        }
        return new r(oVar, jArr15, iArr13, i522, jArr162, iArr14, p0.N0(j142, 1000000L, oVar2.d));
    }

    private static d w(d0 d0Var, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        int i3;
        d0Var.P(12);
        int n = d0Var.n();
        d dVar = new d(n);
        for (int i4 = 0; i4 < n; i4++) {
            int e2 = d0Var.e();
            int n2 = d0Var.n();
            i9.o.a(n2 > 0, "childAtomSize must be positive");
            int n3 = d0Var.n();
            if (n3 == 1635148593 || n3 == 1635148595 || n3 == 1701733238 || n3 == 1831958048 || n3 == 1836070006 || n3 == 1752589105 || n3 == 1751479857 || n3 == 1932670515 || n3 == 1211250227 || n3 == 1987063864 || n3 == 1987063865 || n3 == 1635135537 || n3 == 1685479798 || n3 == 1685479729 || n3 == 1685481573 || n3 == 1685481521) {
                i3 = e2;
                D(d0Var, n3, i3, n2, i, i2, drmInitData, dVar, i4);
            } else if (n3 == 1836069985 || n3 == 1701733217 || n3 == 1633889587 || n3 == 1700998451 || n3 == 1633889588 || n3 == 1835823201 || n3 == 1685353315 || n3 == 1685353317 || n3 == 1685353320 || n3 == 1685353324 || n3 == 1685353336 || n3 == 1935764850 || n3 == 1935767394 || n3 == 1819304813 || n3 == 1936684916 || n3 == 1953984371 || n3 == 778924082 || n3 == 778924083 || n3 == 1835557169 || n3 == 1835560241 || n3 == 1634492771 || n3 == 1634492791 || n3 == 1970037111 || n3 == 1332770163 || n3 == 1716281667) {
                i3 = e2;
                f(d0Var, n3, e2, n2, i, str, z, drmInitData, dVar, i4);
            } else {
                if (n3 == 1414810956 || n3 == 1954034535 || n3 == 2004251764 || n3 == 1937010800 || n3 == 1664495672) {
                    x(d0Var, n3, e2, n2, i, str, dVar);
                } else if (n3 == 1835365492) {
                    o(d0Var, n3, e2, i, dVar);
                } else if (n3 == 1667329389) {
                    dVar.b = new p1.b().R(i).e0("application/x-camera-motion").E();
                }
                i3 = e2;
            }
            d0Var.P(i3 + n2);
        }
        return dVar;
    }

    private static void x(d0 d0Var, int i, int i2, int i3, int i4, String str, d dVar) {
        d0Var.P(i2 + 16);
        String str2 = "application/ttml+xml";
        ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                d0Var.j(bArr, 0, i5);
                immutableList = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else {
                if (i != 1664495672) {
                    throw new IllegalStateException();
                }
                dVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        dVar.b = new p1.b().R(i4).e0(str2).V(str).i0(j).T(immutableList).E();
    }

    private static g y(d0 d0Var) {
        long j;
        d0Var.P(8);
        int c2 = q9.a.c(d0Var.n());
        d0Var.Q(c2 == 0 ? 8 : 16);
        int n = d0Var.n();
        d0Var.Q(4);
        int e2 = d0Var.e();
        int i = c2 == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i3 >= i) {
                d0Var.Q(i);
                break;
            }
            if (d0Var.d()[e2 + i3] != -1) {
                long F = c2 == 0 ? d0Var.F() : d0Var.I();
                if (F != 0) {
                    j = F;
                }
            } else {
                i3++;
            }
        }
        d0Var.Q(16);
        int n2 = d0Var.n();
        int n3 = d0Var.n();
        d0Var.Q(4);
        int n4 = d0Var.n();
        int n5 = d0Var.n();
        if (n2 == 0 && n3 == 65536 && n4 == -65536 && n5 == 0) {
            i2 = 90;
        } else if (n2 == 0 && n3 == -65536 && n4 == 65536 && n5 == 0) {
            i2 = 270;
        } else if (n2 == -65536 && n3 == 0 && n4 == 0 && n5 == -65536) {
            i2 = 180;
        }
        return new g(n, j, i2);
    }

    private static o z(a.C0062a c0062a, a.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) {
        a.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        a.C0062a f2;
        Pair h;
        a.C0062a c0062a2 = (a.C0062a) com.google.android.exoplayer2.util.a.e(c0062a.f(1835297121));
        int d2 = d(k(((a.b) com.google.android.exoplayer2.util.a.e(c0062a2.g(1751411826))).b));
        if (d2 == -1) {
            return null;
        }
        g y = y(((a.b) com.google.android.exoplayer2.util.a.e(c0062a.g(1953196132))).b);
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = y.b;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long p = p(bVar2.b);
        long N0 = j2 != -9223372036854775807L ? p0.N0(j2, 1000000L, p) : -9223372036854775807L;
        a.C0062a c0062a3 = (a.C0062a) com.google.android.exoplayer2.util.a.e(((a.C0062a) com.google.android.exoplayer2.util.a.e(c0062a2.f(1835626086))).f(1937007212));
        Pair m = m(((a.b) com.google.android.exoplayer2.util.a.e(c0062a2.g(1835296868))).b);
        d w = w(((a.b) com.google.android.exoplayer2.util.a.e(c0062a3.g(1937011556))).b, y.a, y.c, (String) m.second, drmInitData, z2);
        if (z || (f2 = c0062a.f(1701082227)) == null || (h = h(f2)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) h.first;
            jArr2 = (long[]) h.second;
            jArr = jArr3;
        }
        if (w.b == null) {
            return null;
        }
        return new o(y.a, d2, ((Long) m.first).longValue(), p, N0, w.b, w.d, w.a, w.c, jArr, jArr2);
    }
}
