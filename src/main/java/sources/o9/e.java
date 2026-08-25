package o9;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.cloud.tmc.kernel.constants.LauncherLifecycleType;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.util.x;
import com.google.common.collect.ImmutableList;
import i9.a0;
import i9.b0;
import i9.e0;
import i9.f0;
import i9.l;
import i9.m;
import i9.n;
import i9.q;
import i9.r;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class e implements l {
    public static final r c0 = new r() { // from class: o9.d
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            l[] z;
            z = e.z();
            return z;
        }
    };
    private static final byte[] d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] e0 = p0.n0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    private static final UUID h0 = new UUID(72057594037932032L, -9223371306706625679L);
    private static final Map i0;
    private long A;
    private long B;
    private t C;
    private t D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;
    private final o9.c a;
    private boolean a0;
    private final g b;
    private n b0;
    private final SparseArray c;
    private final boolean d;
    private final d0 e;
    private final d0 f;
    private final d0 g;
    private final d0 h;
    private final d0 i;
    private final d0 j;
    private final d0 k;
    private final d0 l;
    private final d0 m;
    private final d0 n;
    private ByteBuffer o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private c u;
    private boolean v;
    private int w;
    private long x;
    private boolean y;
    private long z;

    private final class b implements o9.b {
        private b() {
        }

        @Override // o9.b
        public void a(int i, int i2, m mVar) {
            e.this.k(i, i2, mVar);
        }

        @Override // o9.b
        public void endMasterElement(int i) {
            e.this.n(i);
        }

        @Override // o9.b
        public void floatElement(int i, double d) {
            e.this.q(i, d);
        }

        @Override // o9.b
        public int getElementType(int i) {
            return e.this.t(i);
        }

        @Override // o9.b
        public void integerElement(int i, long j) {
            e.this.w(i, j);
        }

        @Override // o9.b
        public boolean isLevel1Element(int i) {
            return e.this.y(i);
        }

        @Override // o9.b
        public void startMasterElement(int i, long j, long j2) {
            e.this.F(i, j, j2);
        }

        @Override // o9.b
        public void stringElement(int i, String str) {
            e.this.G(i, str);
        }
    }

    protected static final class c {
        public byte[] N;
        public f0 T;
        public boolean U;
        public e0 X;
        public int Y;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        private int g;
        public boolean h;
        public byte[] i;
        public e0.a j;
        public byte[] k;
        public DrmInitData l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;
        public float s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;
        public boolean x = false;
        public int y = -1;
        public int z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        private String W = "eng";

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            com.google.android.exoplayer2.util.a.e(this.X);
        }

        private byte[] g(String str) {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, (Throwable) null);
        }

        private byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.D * 50000.0f) + 0.5f));
            order.putShort((short) ((this.E * 50000.0f) + 0.5f));
            order.putShort((short) ((this.F * 50000.0f) + 0.5f));
            order.putShort((short) ((this.G * 50000.0f) + 0.5f));
            order.putShort((short) ((this.H * 50000.0f) + 0.5f));
            order.putShort((short) ((this.I * 50000.0f) + 0.5f));
            order.putShort((short) ((this.J * 50000.0f) + 0.5f));
            order.putShort((short) ((this.K * 50000.0f) + 0.5f));
            order.putShort((short) (this.L + 0.5f));
            order.putShort((short) (this.M + 0.5f));
            order.putShort((short) this.B);
            order.putShort((short) this.C);
            return bArr;
        }

        private static Pair k(d0 d0Var) {
            try {
                d0Var.Q(16);
                long t = d0Var.t();
                if (t == 1482049860) {
                    return new Pair("video/divx", null);
                }
                if (t == 859189832) {
                    return new Pair("video/3gpp", null);
                }
                if (t != 826496599) {
                    s.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair("video/x-unknown", null);
                }
                byte[] d = d0Var.d();
                for (int e = d0Var.e() + 20; e < d.length - 4; e++) {
                    if (d[e] == 0 && d[e + 1] == 0 && d[e + 2] == 1 && d[e + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(d, e, d.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", (Throwable) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", (Throwable) null);
            }
        }

        private static boolean l(d0 d0Var) {
            try {
                int v = d0Var.v();
                if (v == 1) {
                    return true;
                }
                if (v != 65534) {
                    return false;
                }
                d0Var.P(24);
                if (d0Var.w() == e.h0.getMostSignificantBits()) {
                    if (d0Var.w() == e.h0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", (Throwable) null);
            }
        }

        private static List m(byte[] bArr) {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i10 = i5 + 1;
                int i11 = i7 + (i2 & 255);
                if (bArr[i10] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i10, bArr2, 0, i6);
                int i12 = i10 + i6;
                if (bArr[i12] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                }
                int i13 = i12 + i11;
                if (bArr[i13] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
                }
                byte[] bArr3 = new byte[bArr.length - i13];
                System.arraycopy(bArr, i13, bArr3, 0, bArr.length - i13);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", (Throwable) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o(boolean z) {
            return "A_OPUS".equals(this.b) ? z : this.f > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0428  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x043f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x044e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x056a  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0460  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0441  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(n nVar, int i) {
            char c;
            List singletonList;
            int i2;
            String str;
            int i3;
            List list;
            String str2;
            int i4;
            byte[] bArr;
            String str3;
            p1.b bVar;
            int i5;
            int i6;
            int i7;
            com.google.android.exoplayer2.video.d a;
            String str4 = this.b;
            str4.hashCode();
            String str5 = "audio/raw";
            switch (str4.hashCode()) {
                case -2095576542:
                    if (str4.equals("V_MPEG4/ISO/AP")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -2095575984:
                    if (str4.equals("V_MPEG4/ISO/SP")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1985379776:
                    if (str4.equals("A_MS/ACM")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1784763192:
                    if (str4.equals("A_TRUEHD")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1730367663:
                    if (str4.equals("A_VORBIS")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641358:
                    if (str4.equals("A_MPEG/L2")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641357:
                    if (str4.equals("A_MPEG/L3")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1373388978:
                    if (str4.equals("V_MS/VFW/FOURCC")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -933872740:
                    if (str4.equals("S_DVBSUB")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363189:
                    if (str4.equals("V_MPEG4/ISO/ASP")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363109:
                    if (str4.equals("V_MPEG4/ISO/AVC")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -425012669:
                    if (str4.equals("S_VOBSUB")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -356037306:
                    if (str4.equals("A_DTS/LOSSLESS")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923557:
                    if (str4.equals("A_AAC")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923603:
                    if (str4.equals("A_AC3")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 62927045:
                    if (str4.equals("A_DTS")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 82318131:
                    if (str4.equals("V_AV1")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338133:
                    if (str4.equals("V_VP8")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338134:
                    if (str4.equals("V_VP9")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 99146302:
                    if (str4.equals("S_HDMV/PGS")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 444813526:
                    if (str4.equals("V_THEORA")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 542569478:
                    if (str4.equals("A_DTS/EXPRESS")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 635596514:
                    if (str4.equals("A_PCM/FLOAT/IEEE")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 725948237:
                    if (str4.equals("A_PCM/INT/BIG")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 725957860:
                    if (str4.equals("A_PCM/INT/LIT")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 738597099:
                    if (str4.equals("S_TEXT/ASS")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 855502857:
                    if (str4.equals("V_MPEGH/ISO/HEVC")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case 1045209816:
                    if (str4.equals("S_TEXT/WEBVTT")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 1422270023:
                    if (str4.equals("S_TEXT/UTF8")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 1809237540:
                    if (str4.equals("V_MPEG2")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950749482:
                    if (str4.equals("A_EAC3")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950789798:
                    if (str4.equals("A_FLAC")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 1951062397:
                    if (str4.equals("A_OPUS")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr2 = this.k;
                    singletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                    str5 = "video/mp4v-es";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null && (a = com.google.android.exoplayer2.video.d.a(new d0(bArr))) != null) {
                        str = a.c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i10 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                        bVar.H(this.O).f0(this.Q).Y(i2);
                        i5 = 1;
                    } else if (w.s(str3)) {
                        if (this.q == 0) {
                            int i11 = this.o;
                            i6 = -1;
                            if (i11 == -1) {
                                i11 = this.m;
                            }
                            this.o = i11;
                            int i12 = this.p;
                            if (i12 == -1) {
                                i12 = this.n;
                            }
                            this.p = i12;
                        } else {
                            i6 = -1;
                        }
                        float f = (this.o == i6 || (i7 = this.p) == i6) ? -1.0f : (this.n * r3) / (this.m * i7);
                        com.google.android.exoplayer2.video.c cVar = this.x ? new com.google.android.exoplayer2.video.c(this.y, this.A, this.z, h()) : null;
                        if (this.a != null && e.i0.containsKey(this.a)) {
                            i6 = ((Integer) e.i0.get(this.a)).intValue();
                        }
                        if (this.r == 0 && Float.compare(this.s, 0.0f) == 0 && Float.compare(this.t, 0.0f) == 0) {
                            if (Float.compare(this.u, 0.0f) == 0) {
                                i6 = 0;
                            } else if (Float.compare(this.t, 90.0f) == 0) {
                                i6 = 90;
                            } else if (Float.compare(this.t, -180.0f) == 0 || Float.compare(this.t, 180.0f) == 0) {
                                i6 = 180;
                            } else if (Float.compare(this.t, -90.0f) == 0) {
                                i6 = 270;
                            }
                        }
                        bVar.j0(this.m).Q(this.n).a0(f).d0(i6).b0(this.v).h0(this.w).J(cVar);
                        i5 = 2;
                    } else {
                        if (!"application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", (Throwable) null);
                        }
                        i5 = 3;
                    }
                    if (this.a != null && !e.i0.containsKey(this.a)) {
                        bVar.U(this.a);
                    }
                    p1 E = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10).T(singletonList).I(str).M(this.l).E();
                    e0 track = nVar.track(this.c, i5);
                    this.X = track;
                    track.d(E);
                    return;
                case 2:
                    if (l(new d0(g(this.b)))) {
                        int c0 = p0.c0(this.P);
                        if (c0 != 0) {
                            i2 = c0;
                            singletonList = null;
                            str = null;
                            i3 = -1;
                            bArr = this.N;
                            if (bArr != null) {
                                str = a.c;
                                str5 = "video/dolby-vision";
                                break;
                            }
                            str3 = str5;
                            int i102 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                            bVar = new p1.b();
                            if (w.o(str3)) {
                            }
                            if (this.a != null) {
                                bVar.U(this.a);
                                break;
                            }
                            p1 E2 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102).T(singletonList).I(str).M(this.l).E();
                            e0 track2 = nVar.track(this.c, i5);
                            this.X = track2;
                            track2.d(E2);
                            return;
                        }
                        s.i("MatroskaExtractor", "Unsupported PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                    } else {
                        s.i("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    }
                    str5 = "audio/x-unknown";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022).T(singletonList).I(str).M(this.l).E();
                    e0 track22 = nVar.track(this.c, i5);
                    this.X = track22;
                    track22.d(E22);
                    return;
                case 3:
                    this.T = new f0();
                    str5 = "audio/true-hd";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222).T(singletonList).I(str).M(this.l).E();
                    e0 track222 = nVar.track(this.c, i5);
                    this.X = track222;
                    track222.d(E222);
                    return;
                case 4:
                    singletonList = m(g(this.b));
                    str5 = "audio/vorbis";
                    i3 = 8192;
                    str = null;
                    i2 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222 = nVar.track(this.c, i5);
                    this.X = track2222;
                    track2222.d(E2222);
                    return;
                case 5:
                    str5 = "audio/mpeg-L2";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = 4096;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222 = nVar.track(this.c, i5);
                    this.X = track22222;
                    track22222.d(E22222);
                    return;
                case 6:
                    str5 = "audio/mpeg";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = 4096;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222 = nVar.track(this.c, i5);
                    this.X = track222222;
                    track222222.d(E222222);
                    return;
                case 7:
                    Pair k = k(new d0(g(this.b)));
                    str5 = (String) k.first;
                    singletonList = (List) k.second;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222 = nVar.track(this.c, i5);
                    this.X = track2222222;
                    track2222222.d(E2222222);
                    return;
                case '\b':
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(g(this.b), 0, bArr3, 0, 4);
                    singletonList = ImmutableList.of(bArr3);
                    str5 = "application/dvbsubs";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222 = nVar.track(this.c, i5);
                    this.X = track22222222;
                    track22222222.d(E22222222);
                    return;
                case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
                    com.google.android.exoplayer2.video.a b = com.google.android.exoplayer2.video.a.b(new d0(g(this.b)));
                    list = b.a;
                    this.Y = b.b;
                    str2 = b.f;
                    str5 = "video/avc";
                    i2 = -1;
                    i3 = -1;
                    List list2 = list;
                    str = str2;
                    singletonList = list2;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222 = nVar.track(this.c, i5);
                    this.X = track222222222;
                    track222222222.d(E222222222);
                    return;
                case 11:
                    singletonList = ImmutableList.of(g(this.b));
                    str5 = "application/vobsub";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222;
                    track2222222222.d(E2222222222);
                    return;
                case '\f':
                    str5 = "audio/vnd.dts.hd";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222222 = nVar.track(this.c, i5);
                    this.X = track22222222222;
                    track22222222222.d(E22222222222);
                    return;
                case '\r':
                    singletonList = Collections.singletonList(g(this.b));
                    a.b f2 = com.google.android.exoplayer2.audio.a.f(this.k);
                    this.Q = f2.a;
                    this.O = f2.b;
                    str = f2.c;
                    str5 = "audio/mp4a-latm";
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222;
                    track222222222222.d(E222222222222);
                    return;
                case 14:
                    str5 = "audio/ac3";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222222;
                    track2222222222222.d(E2222222222222);
                    return;
                case 15:
                case 21:
                    str5 = "audio/vnd.dts";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222222222 = nVar.track(this.c, i5);
                    this.X = track22222222222222;
                    track22222222222222.d(E22222222222222);
                    return;
                case 16:
                    str5 = "video/av01";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222;
                    track222222222222222.d(E222222222222222);
                    return;
                case LauncherLifecycleType.LAUNCHER_MINIAPP_START /* 17 */:
                    str5 = "video/x-vnd.on2.vp8";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222222222;
                    track2222222222222222.d(E2222222222222222);
                    return;
                case 18:
                    str5 = "video/x-vnd.on2.vp9";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222222222222 = nVar.track(this.c, i5);
                    this.X = track22222222222222222;
                    track22222222222222222.d(E22222222222222222);
                    return;
                case 19:
                    str5 = "application/pgs";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222222;
                    track222222222222222222.d(E222222222222222222);
                    return;
                case 20:
                    str5 = "video/x-unknown";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222222222222;
                    track2222222222222222222.d(E2222222222222222222);
                    return;
                case 22:
                    if (this.P == 32) {
                        singletonList = null;
                        str = null;
                        i2 = 4;
                        i3 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                        }
                        str3 = str5;
                        int i1022222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                        bVar = new p1.b();
                        if (w.o(str3)) {
                        }
                        if (this.a != null) {
                        }
                        p1 E22222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222222222).T(singletonList).I(str).M(this.l).E();
                        e0 track22222222222222222222 = nVar.track(this.c, i5);
                        this.X = track22222222222222222222;
                        track22222222222222222222.d(E22222222222222222222);
                        return;
                    }
                    s.i("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                    str5 = "audio/x-unknown";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222222222;
                    track222222222222222222222.d(E222222222222222222222);
                    return;
                case 23:
                    int i13 = this.P;
                    if (i13 == 8) {
                        singletonList = null;
                        str = null;
                        i2 = 3;
                        i3 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                        }
                        str3 = str5;
                        int i102222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                        bVar = new p1.b();
                        if (w.o(str3)) {
                        }
                        if (this.a != null) {
                        }
                        p1 E2222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222222222).T(singletonList).I(str).M(this.l).E();
                        e0 track2222222222222222222222 = nVar.track(this.c, i5);
                        this.X = track2222222222222222222222;
                        track2222222222222222222222.d(E2222222222222222222222);
                        return;
                    }
                    if (i13 == 16) {
                        i4 = 268435456;
                        i2 = i4;
                        singletonList = null;
                        str = null;
                        i3 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                        }
                        str3 = str5;
                        int i1022222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                        bVar = new p1.b();
                        if (w.o(str3)) {
                        }
                        if (this.a != null) {
                        }
                        p1 E22222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222222222222).T(singletonList).I(str).M(this.l).E();
                        e0 track22222222222222222222222 = nVar.track(this.c, i5);
                        this.X = track22222222222222222222222;
                        track22222222222222222222222.d(E22222222222222222222222);
                        return;
                    }
                    s.i("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                    str5 = "audio/x-unknown";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222222222222;
                    track222222222222222222222222.d(E222222222222222222222222);
                    return;
                case 24:
                    i4 = p0.c0(this.P);
                    if (i4 == 0) {
                        s.i("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                        str5 = "audio/x-unknown";
                        singletonList = null;
                        str = null;
                        i2 = -1;
                        i3 = -1;
                        bArr = this.N;
                        if (bArr != null) {
                        }
                        str3 = str5;
                        int i102222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                        bVar = new p1.b();
                        if (w.o(str3)) {
                        }
                        if (this.a != null) {
                        }
                        p1 E2222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                        e0 track2222222222222222222222222 = nVar.track(this.c, i5);
                        this.X = track2222222222222222222222222;
                        track2222222222222222222222222.d(E2222222222222222222222222);
                        return;
                    }
                    i2 = i4;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track22222222222222222222222222;
                    track22222222222222222222222222.d(E22222222222222222222222222);
                    return;
                case 25:
                    singletonList = ImmutableList.of(e.e0, g(this.b));
                    str5 = "text/x-ssa";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222222222222222;
                    track222222222222222222222222222.d(E222222222222222222222222222);
                    return;
                case 26:
                    com.google.android.exoplayer2.video.f a2 = com.google.android.exoplayer2.video.f.a(new d0(g(this.b)));
                    list = a2.a;
                    this.Y = a2.b;
                    str2 = a2.f;
                    str5 = "video/hevc";
                    i2 = -1;
                    i3 = -1;
                    List list22 = list;
                    str = str2;
                    singletonList = list22;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222222222222222222222;
                    track2222222222222222222222222222.d(E2222222222222222222222222222);
                    return;
                case 27:
                    str5 = "text/vtt";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track22222222222222222222222222222;
                    track22222222222222222222222222222.d(E22222222222222222222222222222);
                    return;
                case 28:
                    str5 = "application/x-subrip";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222222222222222222;
                    track222222222222222222222222222222.d(E222222222222222222222222222222);
                    return;
                case 29:
                    str5 = "video/mpeg2";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222222222222222222222222;
                    track2222222222222222222222222222222.d(E2222222222222222222222222222222);
                    return;
                case 30:
                    str5 = "audio/eac3";
                    singletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i1022222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E22222222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i1022222222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track22222222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track22222222222222222222222222222222;
                    track22222222222222222222222222222222.d(E22222222222222222222222222222222);
                    return;
                case 31:
                    singletonList = Collections.singletonList(g(this.b));
                    str5 = "audio/flac";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i10222222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E222222222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i10222222222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track222222222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track222222222222222222222222222222222;
                    track222222222222222222222222222222222.d(E222222222222222222222222222222222);
                    return;
                case ' ':
                    singletonList = new ArrayList(3);
                    singletonList.add(g(this.b));
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    singletonList.add(allocate.order(byteOrder).putLong(this.R).array());
                    singletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.S).array());
                    str5 = "audio/opus";
                    i3 = 5760;
                    str = null;
                    i2 = -1;
                    bArr = this.N;
                    if (bArr != null) {
                    }
                    str3 = str5;
                    int i102222222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0);
                    bVar = new p1.b();
                    if (w.o(str3)) {
                    }
                    if (this.a != null) {
                    }
                    p1 E2222222222222222222222222222222222 = bVar.R(i).e0(str3).W(i3).V(this.W).g0(i102222222222222222222222222222222222).T(singletonList).I(str).M(this.l).E();
                    e0 track2222222222222222222222222222222222 = nVar.track(this.c, i5);
                    this.X = track2222222222222222222222222222222222;
                    track2222222222222222222222222222222222.d(E2222222222222222222222222222222222);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", (Throwable) null);
            }
        }

        public void j() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.a(this.X, this.j);
            }
        }

        public void n() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        i0 = Collections.unmodifiableMap(hashMap);
    }

    public e() {
        this(0);
    }

    public e(int i) {
        this(new o9.a(), i);
    }

    e(o9.c cVar, int i) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.a = cVar;
        cVar.b(new b());
        this.d = (i & 1) == 0;
        this.b = new g();
        this.c = new SparseArray();
        this.g = new d0(4);
        this.h = new d0(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new d0(4);
        this.e = new d0(x.a);
        this.f = new d0(4);
        this.j = new d0();
        this.k = new d0();
        this.l = new d0(8);
        this.m = new d0();
        this.n = new d0();
        this.L = new int[1];
    }

    private boolean A(a0 a0Var, long j) {
        if (this.y) {
            this.A = j;
            a0Var.a = this.z;
            this.y = false;
            return true;
        }
        if (this.v) {
            long j2 = this.A;
            if (j2 != -1) {
                a0Var.a = j2;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    private void B(m mVar, int i) {
        if (this.g.f() >= i) {
            return;
        }
        if (this.g.b() < i) {
            d0 d0Var = this.g;
            d0Var.c(Math.max(d0Var.b() * 2, i));
        }
        mVar.readFully(this.g.d(), this.g.f(), i - this.g.f());
        this.g.O(i);
    }

    private void C() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.a0 = false;
        this.j.L(0);
    }

    private long D(long j) {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return p0.N0(j, j2, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private static void E(String str, long j, byte[] bArr) {
        byte[] r;
        int i;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                r = r(j, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case "S_TEXT/WEBVTT":
                r = r(j, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case "S_TEXT/UTF8":
                r = r(j, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(r, 0, bArr, i, r.length);
    }

    private int H(m mVar, c cVar, int i, boolean z) {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.b)) {
            I(mVar, d0, i);
            return p();
        }
        if ("S_TEXT/ASS".equals(cVar.b)) {
            I(mVar, f0, i);
            return p();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.b)) {
            I(mVar, g0, i);
            return p();
        }
        e0 e0Var = cVar.X;
        if (!this.V) {
            if (cVar.h) {
                this.O &= -1073741825;
                if (!this.W) {
                    mVar.readFully(this.g.d(), 0, 1);
                    this.S++;
                    if ((this.g.d()[0] & 128) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", (Throwable) null);
                    }
                    this.Z = this.g.d()[0];
                    this.W = true;
                }
                byte b2 = this.Z;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.O |= MemoryConstants.GB;
                    if (!this.a0) {
                        mVar.readFully(this.l.d(), 0, 8);
                        this.S += 8;
                        this.a0 = true;
                        this.g.d()[0] = (byte) ((z2 ? 128 : 0) | 8);
                        this.g.P(0);
                        e0Var.f(this.g, 1, 1);
                        this.T++;
                        this.l.P(0);
                        e0Var.f(this.l, 8, 1);
                        this.T += 8;
                    }
                    if (z2) {
                        if (!this.X) {
                            mVar.readFully(this.g.d(), 0, 1);
                            this.S++;
                            this.g.P(0);
                            this.Y = this.g.D();
                            this.X = true;
                        }
                        int i3 = this.Y * 4;
                        this.g.L(i3);
                        mVar.readFully(this.g.d(), 0, i3);
                        this.S += i3;
                        short s = (short) ((this.Y / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.o;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.o = ByteBuffer.allocate(i4);
                        }
                        this.o.position(0);
                        this.o.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.Y;
                            if (i5 >= i2) {
                                break;
                            }
                            int H = this.g.H();
                            if (i5 % 2 == 0) {
                                this.o.putShort((short) (H - i6));
                            } else {
                                this.o.putInt(H - i6);
                            }
                            i5++;
                            i6 = H;
                        }
                        int i7 = (i - this.S) - i6;
                        if (i2 % 2 == 1) {
                            this.o.putInt(i7);
                        } else {
                            this.o.putShort((short) i7);
                            this.o.putInt(0);
                        }
                        this.m.N(this.o.array(), i4);
                        e0Var.f(this.m, i4, 1);
                        this.T += i4;
                    }
                }
            } else {
                byte[] bArr = cVar.i;
                if (bArr != null) {
                    this.j.N(bArr, bArr.length);
                }
            }
            if (cVar.o(z)) {
                this.O |= 268435456;
                this.n.L(0);
                int f = (this.j.f() + i) - this.S;
                this.g.L(4);
                this.g.d()[0] = (byte) ((f >> 24) & 255);
                this.g.d()[1] = (byte) ((f >> 16) & 255);
                this.g.d()[2] = (byte) ((f >> 8) & 255);
                this.g.d()[3] = (byte) (f & 255);
                e0Var.f(this.g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        int f2 = i + this.j.f();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.b) && !"V_MPEGH/ISO/HEVC".equals(cVar.b)) {
            if (cVar.T != null) {
                com.google.android.exoplayer2.util.a.g(this.j.f() == 0);
                cVar.T.d(mVar);
            }
            while (true) {
                int i10 = this.S;
                if (i10 >= f2) {
                    break;
                }
                int J = J(mVar, e0Var, f2 - i10);
                this.S += J;
                this.T += J;
            }
        } else {
            byte[] d = this.f.d();
            d[0] = 0;
            d[1] = 0;
            d[2] = 0;
            int i11 = cVar.Y;
            int i12 = 4 - i11;
            while (this.S < f2) {
                int i13 = this.U;
                if (i13 == 0) {
                    K(mVar, d, i12, i11);
                    this.S += i11;
                    this.f.P(0);
                    this.U = this.f.H();
                    this.e.P(0);
                    e0Var.c(this.e, 4);
                    this.T += 4;
                } else {
                    int J2 = J(mVar, e0Var, i13);
                    this.S += J2;
                    this.T += J2;
                    this.U -= J2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.b)) {
            this.h.P(0);
            e0Var.c(this.h, 4);
            this.T += 4;
        }
        return p();
    }

    private void I(m mVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.k.b() < length) {
            this.k.M(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.k.d(), 0, bArr.length);
        }
        mVar.readFully(this.k.d(), bArr.length, i);
        this.k.P(0);
        this.k.O(length);
    }

    private int J(m mVar, e0 e0Var, int i) {
        int a2 = this.j.a();
        if (a2 <= 0) {
            return e0Var.b(mVar, i, false);
        }
        int min = Math.min(i, a2);
        e0Var.c(this.j, min);
        return min;
    }

    private void K(m mVar, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.j.a());
        mVar.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.j.j(bArr, i, min);
        }
    }

    private void h(int i) {
        if (this.C == null || this.D == null) {
            throw ParserException.createForMalformedContainer("Element " + i + " must be in a Cues", (Throwable) null);
        }
    }

    private void i(int i) {
        if (this.u != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i + " must be in a TrackEntry", (Throwable) null);
    }

    private void j() {
        com.google.android.exoplayer2.util.a.i(this.b0);
    }

    private b0 l(t tVar, t tVar2) {
        int i;
        if (this.q == -1 || this.t == -9223372036854775807L || tVar == null || tVar.c() == 0 || tVar2 == null || tVar2.c() != tVar.c()) {
            return new b0.b(this.t);
        }
        int c2 = tVar.c();
        int[] iArr = new int[c2];
        long[] jArr = new long[c2];
        long[] jArr2 = new long[c2];
        long[] jArr3 = new long[c2];
        int i2 = 0;
        for (int i3 = 0; i3 < c2; i3++) {
            jArr3[i3] = tVar.b(i3);
            jArr[i3] = this.q + tVar2.b(i3);
        }
        while (true) {
            i = c2 - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArr[i2] = (int) (jArr[i4] - jArr[i2]);
            jArr2[i2] = jArr3[i4] - jArr3[i2];
            i2 = i4;
        }
        iArr[i] = (int) ((this.q + this.p) - jArr[i]);
        long j = this.t - jArr3[i];
        jArr2[i] = j;
        if (j <= 0) {
            s.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArr = Arrays.copyOf(iArr, i);
            jArr = Arrays.copyOf(jArr, i);
            jArr2 = Arrays.copyOf(jArr2, i);
            jArr3 = Arrays.copyOf(jArr3, i);
        }
        return new i9.d(iArr, jArr, jArr2, jArr3);
    }

    private void m(c cVar, long j, int i, int i2, int i3) {
        f0 f0Var = cVar.T;
        if (f0Var != null) {
            f0Var.c(cVar.X, j, i, i2, i3, cVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.b) || "S_TEXT/ASS".equals(cVar.b) || "S_TEXT/WEBVTT".equals(cVar.b)) {
                if (this.K > 1) {
                    s.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.I;
                    if (j2 == -9223372036854775807L) {
                        s.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        E(cVar.b, j2, this.k.d());
                        int e = this.k.e();
                        while (true) {
                            if (e >= this.k.f()) {
                                break;
                            }
                            if (this.k.d()[e] == 0) {
                                this.k.O(e);
                                break;
                            }
                            e++;
                        }
                        e0 e0Var = cVar.X;
                        d0 d0Var = this.k;
                        e0Var.c(d0Var, d0Var.f());
                        i2 += this.k.f();
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.K > 1) {
                    this.n.L(0);
                } else {
                    int f = this.n.f();
                    cVar.X.f(this.n, f, 2);
                    i2 += f;
                }
            }
            cVar.X.e(j, i, i2, i3, cVar.j);
        }
        this.F = true;
    }

    private static int[] o(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private int p() {
        int i = this.T;
        C();
        return i;
    }

    private static byte[] r(long j, String str, long j2) {
        com.google.android.exoplayer2.util.a.a(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        return p0.n0(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    private static boolean x(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] z() {
        return new l[]{new e()};
    }

    protected void F(int i, long j, long j2) {
        j();
        if (i == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i == 174) {
            this.u = new c();
            return;
        }
        if (i == 187) {
            this.E = false;
            return;
        }
        if (i == 19899) {
            this.w = -1;
            this.x = -1L;
            return;
        }
        if (i == 20533) {
            s(i).h = true;
            return;
        }
        if (i == 21968) {
            s(i).x = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.q;
            if (j3 != -1 && j3 != j) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", (Throwable) null);
            }
            this.q = j;
            this.p = j2;
            return;
        }
        if (i == 475249515) {
            this.C = new t();
            this.D = new t();
        } else if (i == 524531317 && !this.v) {
            if (this.d && this.z != -1) {
                this.y = true;
            } else {
                this.b0.g(new b0.b(this.t));
                this.v = true;
            }
        }
    }

    protected void G(int i, String str) {
        if (i == 134) {
            s(i).b = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                s(i).a = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                s(i).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", (Throwable) null);
    }

    @Override // i9.l
    public final void b(n nVar) {
        this.b0 = nVar;
    }

    @Override // i9.l
    public final boolean c(m mVar) {
        return new f().b(mVar);
    }

    @Override // i9.l
    public final int d(m mVar, a0 a0Var) {
        this.F = false;
        boolean z = true;
        while (z && !this.F) {
            z = this.a.a(mVar);
            if (z && A(a0Var, mVar.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            c cVar = (c) this.c.valueAt(i);
            cVar.f();
            cVar.j();
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0231, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void k(int i, int i2, m mVar) {
        c cVar;
        int i3;
        c cVar2;
        c cVar3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i10 = 1;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (this.G != 2) {
                    return;
                }
                v((c) this.c.get(this.M), this.P, mVar, i2);
                return;
            }
            if (i == 16877) {
                u(s(i), mVar, i2);
                return;
            }
            if (i == 16981) {
                i(i);
                byte[] bArr = new byte[i2];
                this.u.i = bArr;
                mVar.readFully(bArr, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr2 = new byte[i2];
                mVar.readFully(bArr2, 0, i2);
                s(i).j = new e0.a(1, bArr2, 0, 0);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.i.d(), (byte) 0);
                mVar.readFully(this.i.d(), 4 - i2, i2);
                this.i.P(0);
                this.w = (int) this.i.F();
                return;
            }
            if (i == 25506) {
                i(i);
                byte[] bArr3 = new byte[i2];
                this.u.k = bArr3;
                mVar.readFully(bArr3, 0, i2);
                return;
            }
            if (i != 30322) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i, (Throwable) null);
            }
            i(i);
            byte[] bArr4 = new byte[i2];
            this.u.v = bArr4;
            mVar.readFully(bArr4, 0, i2);
            return;
        }
        if (this.G == 0) {
            this.M = (int) this.b.d(mVar, false, true, 8);
            this.N = this.b.b();
            this.I = -9223372036854775807L;
            this.G = 1;
            this.g.L(0);
        }
        c cVar4 = (c) this.c.get(this.M);
        if (cVar4 == null) {
            mVar.skipFully(i2 - this.N);
            this.G = 0;
            return;
        }
        cVar4.f();
        if (this.G == 1) {
            B(mVar, 3);
            int i11 = (this.g.d()[2] & 6) >> 1;
            byte b2 = 255;
            if (i11 == 0) {
                this.K = 1;
                int[] o = o(this.L, 1);
                this.L = o;
                o[0] = (i2 - this.N) - 3;
            } else {
                int i12 = 4;
                B(mVar, 4);
                int i13 = (this.g.d()[3] & 255) + 1;
                this.K = i13;
                int[] o2 = o(this.L, i13);
                this.L = o2;
                if (i11 == 2) {
                    int i14 = (i2 - this.N) - 4;
                    int i15 = this.K;
                    Arrays.fill(o2, 0, i15, i14 / i15);
                } else if (i11 == 1) {
                    int i16 = 0;
                    int i17 = 0;
                    while (true) {
                        i4 = this.K;
                        if (i16 >= i4 - 1) {
                            break;
                        }
                        this.L[i16] = 0;
                        while (true) {
                            i5 = i12 + 1;
                            B(mVar, i5);
                            int i18 = this.g.d()[i12] & 255;
                            int[] iArr = this.L;
                            i6 = iArr[i16] + i18;
                            iArr[i16] = i6;
                            if (i18 != 255) {
                                break;
                            } else {
                                i12 = i5;
                            }
                        }
                        i17 += i6;
                        i16++;
                        i12 = i5;
                    }
                    this.L[i4 - 1] = ((i2 - this.N) - i12) - i17;
                } else {
                    if (i11 != 3) {
                        throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i11, (Throwable) null);
                    }
                    int i19 = 0;
                    int i20 = 0;
                    while (true) {
                        int i21 = this.K;
                        if (i19 >= i21 - 1) {
                            cVar2 = cVar4;
                            this.L[i21 - 1] = ((i2 - this.N) - i12) - i20;
                            break;
                        }
                        this.L[i19] = i7;
                        int i22 = i12 + 1;
                        B(mVar, i22);
                        if (this.g.d()[i12] == 0) {
                            throw ParserException.createForMalformedContainer("No valid varint length mask found", (Throwable) null);
                        }
                        int i23 = i7;
                        while (true) {
                            if (i23 >= 8) {
                                cVar3 = cVar4;
                                j = 0;
                                break;
                            }
                            int i24 = i10 << (7 - i23);
                            if ((this.g.d()[i12] & i24) != 0) {
                                i22 += i23;
                                B(mVar, i22);
                                cVar3 = cVar4;
                                j = (~i24) & this.g.d()[i12] & b2;
                                int i25 = i12 + 1;
                                while (i25 < i22) {
                                    j = (j << 8) | (this.g.d()[i25] & b2);
                                    i25++;
                                    b2 = 255;
                                }
                                if (i19 > 0) {
                                    j -= (1 << ((i23 * 7) + 6)) - 1;
                                }
                            } else {
                                i23++;
                                i10 = 1;
                                b2 = 255;
                            }
                        }
                        i12 = i22;
                        if (j < -2147483648L || j > 2147483647L) {
                            break;
                        }
                        int i26 = (int) j;
                        int[] iArr2 = this.L;
                        if (i19 != 0) {
                            i26 += iArr2[i19 - 1];
                        }
                        iArr2[i19] = i26;
                        i20 += i26;
                        i19++;
                        cVar4 = cVar3;
                        i7 = 0;
                        i10 = 1;
                        b2 = 255;
                    }
                }
            }
            cVar2 = cVar4;
            this.H = this.B + D((this.g.d()[0] << 8) | (this.g.d()[1] & 255));
            cVar = cVar2;
            this.O = (cVar.d == 2 || (i == 163 && (this.g.d()[2] & 128) == 128)) ? 1 : 0;
            this.G = 2;
            this.J = 0;
            i3 = 163;
        } else {
            cVar = cVar4;
            i3 = 163;
        }
        if (i == i3) {
            while (true) {
                int i27 = this.J;
                if (i27 >= this.K) {
                    this.G = 0;
                    return;
                } else {
                    m(cVar, ((this.J * cVar.e) / 1000) + this.H, this.O, H(mVar, cVar, this.L[i27], false), 0);
                    this.J++;
                }
            }
        } else {
            while (true) {
                int i28 = this.J;
                if (i28 >= this.K) {
                    return;
                }
                int[] iArr3 = this.L;
                iArr3[i28] = H(mVar, cVar, iArr3[i28], true);
                this.J++;
            }
        }
    }

    protected void n(int i) {
        j();
        if (i == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = (c) this.c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.b)) {
                this.n.M(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.K; i3++) {
                i2 += this.L[i3];
            }
            int i4 = 0;
            while (i4 < this.K) {
                long j = this.H + ((cVar.e * i4) / 1000);
                int i5 = this.O;
                if (i4 == 0 && !this.Q) {
                    i5 |= 1;
                }
                int i6 = this.L[i4];
                int i7 = i2 - i6;
                m(cVar, j, i5, i6, i7);
                i4++;
                i2 = i7;
            }
            this.G = 0;
            return;
        }
        if (i == 174) {
            c cVar2 = (c) com.google.android.exoplayer2.util.a.i(this.u);
            String str = cVar2.b;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", (Throwable) null);
            }
            if (x(str)) {
                cVar2.i(this.b0, cVar2.c);
                this.c.put(cVar2.c, cVar2);
            }
            this.u = null;
            return;
        }
        if (i == 19899) {
            int i10 = this.w;
            if (i10 != -1) {
                long j2 = this.x;
                if (j2 != -1) {
                    if (i10 == 475249515) {
                        this.z = j2;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", (Throwable) null);
        }
        if (i == 25152) {
            i(i);
            c cVar3 = this.u;
            if (cVar3.h) {
                if (cVar3.j == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", (Throwable) null);
                }
                cVar3.l = new DrmInitData(new DrmInitData.SchemeData[]{new DrmInitData.SchemeData(com.google.android.exoplayer2.l.a, "video/webm", this.u.j.b)});
                return;
            }
            return;
        }
        if (i == 28032) {
            i(i);
            c cVar4 = this.u;
            if (cVar4.h && cVar4.i != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", (Throwable) null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.r == -9223372036854775807L) {
                this.r = 1000000L;
            }
            long j3 = this.s;
            if (j3 != -9223372036854775807L) {
                this.t = D(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.c.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", (Throwable) null);
            }
            this.b0.endTracks();
        } else {
            if (i != 475249515) {
                return;
            }
            if (!this.v) {
                this.b0.g(l(this.C, this.D));
                this.v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    protected void q(int i, double d) {
        if (i == 181) {
            s(i).Q = (int) d;
        }
        if (i == 17545) {
            this.s = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                s(i).D = (float) d;
                break;
            case 21970:
                s(i).E = (float) d;
                break;
            case 21971:
                s(i).F = (float) d;
                break;
            case 21972:
                s(i).G = (float) d;
                break;
            case 21973:
                s(i).H = (float) d;
                break;
            case 21974:
                s(i).I = (float) d;
                break;
            case 21975:
                s(i).J = (float) d;
                break;
            case 21976:
                s(i).K = (float) d;
                break;
            case 21977:
                s(i).L = (float) d;
                break;
            case 21978:
                s(i).M = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        s(i).s = (float) d;
                        break;
                    case 30324:
                        s(i).t = (float) d;
                        break;
                    case 30325:
                        s(i).u = (float) d;
                        break;
                }
        }
    }

    @Override // i9.l
    public final void release() {
    }

    protected c s(int i) {
        i(i);
        return this.u;
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.a.reset();
        this.b.e();
        C();
        for (int i = 0; i < this.c.size(); i++) {
            ((c) this.c.valueAt(i)).n();
        }
    }

    protected int t(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void u(c cVar, m mVar, int i) {
        if (cVar.g != 1685485123 && cVar.g != 1685480259) {
            mVar.skipFully(i);
            return;
        }
        byte[] bArr = new byte[i];
        cVar.N = bArr;
        mVar.readFully(bArr, 0, i);
    }

    protected void v(c cVar, int i, m mVar, int i2) {
        if (i != 4 || !"V_VP9".equals(cVar.b)) {
            mVar.skipFully(i2);
        } else {
            this.n.L(i2);
            mVar.readFully(this.n.d(), 0, i2);
        }
    }

    protected void w(int i, long j) {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j + " not supported", (Throwable) null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j + " not supported", (Throwable) null);
        }
        switch (i) {
            case 131:
                s(i).d = (int) j;
                return;
            case 136:
                s(i).V = j == 1;
                return;
            case 155:
                this.I = D(j);
                return;
            case 159:
                s(i).O = (int) j;
                return;
            case 176:
                s(i).m = (int) j;
                return;
            case 179:
                h(i);
                this.C.a(D(j));
                return;
            case 186:
                s(i).n = (int) j;
                return;
            case 215:
                s(i).c = (int) j;
                return;
            case 231:
                this.B = D(j);
                return;
            case 238:
                this.P = (int) j;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                h(i);
                this.D.a(j);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                s(i).g = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j + " not supported", (Throwable) null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j + " not supported", (Throwable) null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j + " not supported", (Throwable) null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j + " not supported", (Throwable) null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j + " not supported", (Throwable) null);
            case 21420:
                this.x = j + this.q;
                return;
            case 21432:
                int i2 = (int) j;
                i(i);
                if (i2 == 0) {
                    this.u.w = 0;
                    return;
                }
                if (i2 == 1) {
                    this.u.w = 2;
                    return;
                } else if (i2 == 3) {
                    this.u.w = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.u.w = 3;
                    return;
                }
            case 21680:
                s(i).o = (int) j;
                return;
            case 21682:
                s(i).q = (int) j;
                return;
            case 21690:
                s(i).p = (int) j;
                return;
            case 21930:
                s(i).U = j == 1;
                return;
            case 21998:
                s(i).f = (int) j;
                return;
            case 22186:
                s(i).R = j;
                return;
            case 22203:
                s(i).S = j;
                return;
            case 25188:
                s(i).P = (int) j;
                return;
            case 30114:
                this.R = j;
                return;
            case 30321:
                i(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.u.r = 0;
                    return;
                }
                if (i3 == 1) {
                    this.u.r = 1;
                    return;
                } else if (i3 == 2) {
                    this.u.r = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.u.r = 3;
                    return;
                }
            case 2352003:
                s(i).e = (int) j;
                return;
            case 2807729:
                this.r = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        i(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.u.A = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.u.A = 1;
                            return;
                        }
                    case 21946:
                        i(i);
                        int c2 = com.google.android.exoplayer2.video.c.c((int) j);
                        if (c2 != -1) {
                            this.u.z = c2;
                            return;
                        }
                        return;
                    case 21947:
                        i(i);
                        this.u.x = true;
                        int b2 = com.google.android.exoplayer2.video.c.b((int) j);
                        if (b2 != -1) {
                            this.u.y = b2;
                            return;
                        }
                        return;
                    case 21948:
                        s(i).B = (int) j;
                        return;
                    case 21949:
                        s(i).C = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    protected boolean y(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }
}
