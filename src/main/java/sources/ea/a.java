package ea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.tn.lib.view.FlowLayout;
import da.b;
import da.i;
import da.m;
import da.n;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends e {
    private final int h;
    private final int i;
    private final int j;
    private final long k;
    private List n;
    private List o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private byte t;
    private byte u;
    private boolean w;
    private long x;
    private static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] A = {-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, -256, -65281};
    private static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, TaskResultKt.ERROR_LOAD_RESPONSE_ERROR_CODE, TaskResultKt.ERROR_LOAD_RESPONSE_DATA_NULL, TaskResultKt.ERROR_LOAD_NOT_DOWNLOAD, TaskResultKt.ERROR_LOAD_REQUEST_FAIL, TaskResultKt.ERROR_DOWNLOAD_FAIL, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] D = {193, TaskResultKt.RETRY, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private final d0 g = new d0();
    private final ArrayList l = new ArrayList();
    private C0043a m = new C0043a(0, 4);
    private int v = 0;

    /* renamed from: ea.a$a, reason: collision with other inner class name */
    private static final class C0043a {
        private final List a = new ArrayList();
        private final List b = new ArrayList();
        private final StringBuilder c = new StringBuilder();
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;

        /* renamed from: ea.a$a$a, reason: collision with other inner class name */
        private static class C0044a {
            public final int a;
            public final boolean b;
            public int c;

            public C0044a(int i, boolean z, int i2) {
                this.a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public C0043a(int i, int i2) {
            j(i);
            this.h = i2;
        }

        private SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 < this.a.size()) {
                C0044a c0044a = (C0044a) this.a.get(i5);
                boolean z2 = c0044a.b;
                int i7 = c0044a.a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = a.A[i7];
                    }
                    z = z3;
                }
                int i10 = c0044a.c;
                i5++;
                if (i10 != (i5 < this.a.size() ? ((C0044a) this.a.get(i5)).c : length)) {
                    if (i != -1 && !z2) {
                        q(spannableStringBuilder, i, i10);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i10;
                    }
                    if (i2 != -1 && !z) {
                        o(spannableStringBuilder, i2, i10);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i10;
                    }
                    if (i4 != i3) {
                        n(spannableStringBuilder, i6, i10, i3);
                        i3 = i4;
                        i6 = i10;
                    }
                }
            }
            if (i != -1 && i != length) {
                q(spannableStringBuilder, i, length);
            }
            if (i2 != -1 && i2 != length) {
                o(spannableStringBuilder, i2, length);
            }
            if (i6 != length) {
                n(spannableStringBuilder, i6, length, i3);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        private static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        private static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    C0044a c0044a = (C0044a) this.a.get(size);
                    int i = c0044a.c;
                    if (i != length) {
                        return;
                    }
                    c0044a.c = i - 1;
                }
            }
        }

        public da.b g(int i) {
            float f;
            int i2 = this.e + this.f;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                spannableStringBuilder.append(p0.c1((CharSequence) this.b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(p0.c1(h(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.g != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.g != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.d;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.g == 1) {
                i6 -= this.h - 1;
            }
            return new b.C0042b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i6, 1).k(f).l(i).a();
        }

        public boolean i() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        public void k() {
            this.b.add(h());
            this.c.setLength(0);
            this.a.clear();
            int min = Math.min(this.h, this.d);
            while (this.b.size() >= min) {
                this.b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.a.add(new C0044a(i, z, this.c.length()));
        }
    }

    public a(String str, int i, long j) {
        this.k = j > 0 ? j * 1000 : -9223372036854775807L;
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i == 2) {
            this.j = 1;
            this.i = 0;
        } else if (i == 3) {
            this.j = 0;
            this.i = 1;
        } else if (i != 4) {
            s.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.j = 0;
            this.i = 0;
        } else {
            this.j = 1;
            this.i = 1;
        }
        I(0);
        H();
        this.w = true;
        this.x = -9223372036854775807L;
    }

    private static boolean A(byte b) {
        return (b & 240) == 16;
    }

    private boolean B(boolean z2, byte b, byte b2) {
        if (!z2 || !A(b)) {
            this.s = false;
        } else {
            if (this.s && this.t == b && this.u == b2) {
                this.s = false;
                return true;
            }
            this.s = true;
            this.t = b;
            this.u = b2;
        }
        return false;
    }

    private static boolean C(byte b) {
        return (b & 247) == 20;
    }

    private static boolean D(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    private static boolean E(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    private static boolean F(byte b) {
        return 1 <= b && b <= 15;
    }

    private void G(byte b, byte b2) {
        if (F(b)) {
            this.w = false;
            return;
        }
        if (C(b)) {
            if (b2 != 32 && b2 != 47) {
                switch (b2) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b2) {
                            case 42:
                            case 43:
                                this.w = false;
                                break;
                        }
                }
            }
            this.w = true;
        }
    }

    private void H() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    private void I(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                ((C0043a) this.l.get(i3)).l(i);
            }
            return;
        }
        H();
        if (i2 == 3 || i == 1 || i == 0) {
            this.n = Collections.emptyList();
        }
    }

    private void J(int i) {
        this.q = i;
        this.m.m(i);
    }

    private boolean K() {
        return (this.k == -9223372036854775807L || this.x == -9223372036854775807L || f() - this.x < this.k) ? false : true;
    }

    private boolean L(byte b) {
        if (v(b)) {
            this.v = m(b);
        }
        return this.v == this.j;
    }

    private static char l(byte b) {
        return (char) B[(b & Byte.MAX_VALUE) - 32];
    }

    private static int m(byte b) {
        return (b >> 3) & 1;
    }

    private List n() {
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            da.b g = ((C0043a) this.l.get(i2)).g(Integer.MIN_VALUE);
            arrayList.add(g);
            if (g != null) {
                i = Math.min(i, g.i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            da.b bVar = (da.b) arrayList.get(i3);
            if (bVar != null) {
                if (bVar.i != i) {
                    bVar = (da.b) com.google.android.exoplayer2.util.a.e(((C0043a) this.l.get(i3)).g(i));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private static char o(byte b) {
        return (char) D[b & 31];
    }

    private static char p(byte b) {
        return (char) E[b & 31];
    }

    private static char q(byte b, byte b2) {
        return (b & 1) == 0 ? o(b2) : p(b2);
    }

    private static char r(byte b) {
        return (char) C[b & 15];
    }

    private void s(byte b) {
        this.m.e(' ');
        this.m.p((b >> 1) & 7, (b & 1) == 1);
    }

    private void t(byte b) {
        if (b == 32) {
            I(2);
            return;
        }
        if (b == 41) {
            I(3);
            return;
        }
        switch (b) {
            case 37:
                I(1);
                J(2);
                break;
            case 38:
                I(1);
                J(3);
                break;
            case 39:
                I(1);
                J(4);
                break;
            default:
                int i = this.p;
                if (i != 0) {
                    if (b == 33) {
                        this.m.f();
                        break;
                    } else {
                        switch (b) {
                            case 44:
                                this.n = Collections.emptyList();
                                int i2 = this.p;
                                if (i2 == 1 || i2 == 3) {
                                    H();
                                    break;
                                }
                            case 45:
                                if (i == 1 && !this.m.i()) {
                                    this.m.k();
                                    break;
                                }
                                break;
                            case 46:
                                H();
                                break;
                            case 47:
                                this.n = n();
                                H();
                                break;
                        }
                    }
                }
                break;
        }
    }

    private void u(byte b, byte b2) {
        int i = y[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.m.d) {
            if (this.p != 1 && !this.m.i()) {
                C0043a c0043a = new C0043a(this.p, this.q);
                this.m = c0043a;
                this.l.add(c0043a);
            }
            this.m.d = i;
        }
        boolean z2 = (b2 & 16) == 16;
        boolean z3 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.m.p(z2 ? 8 : i2, z3);
        if (z2) {
            this.m.e = z[i2];
        }
    }

    private static boolean v(byte b) {
        return (b & 224) == 0;
    }

    private static boolean w(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    private static boolean x(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    private static boolean y(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    private static boolean z(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    @Override // ea.e
    protected i a() {
        List list = this.n;
        this.o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0017 A[SYNTHETIC] */
    @Override // ea.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void b(m mVar) {
        boolean z2;
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(((DecoderInputBuffer) mVar).c);
        this.g.N(byteBuffer.array(), byteBuffer.limit());
        boolean z3 = false;
        while (true) {
            int a = this.g.a();
            int i = this.h;
            if (a < i) {
                break;
            }
            byte D2 = i == 2 ? (byte) -4 : (byte) this.g.D();
            int D3 = this.g.D();
            int D4 = this.g.D();
            if ((D2 & 2) == 0 && (D2 & 1) == this.i) {
                byte b = (byte) (D3 & 127);
                byte b2 = (byte) (D4 & 127);
                if (b != 0 || b2 != 0) {
                    boolean z4 = this.r;
                    if ((D2 & 4) == 4) {
                        boolean[] zArr = F;
                        if (zArr[D3] && zArr[D4]) {
                            z2 = true;
                            this.r = z2;
                            if (!B(z2, b, b2)) {
                                if (this.r) {
                                    G(b, b2);
                                    if (this.w && L(b)) {
                                        if (!v(b)) {
                                            this.m.e(l(b));
                                            if ((b2 & 224) != 0) {
                                                this.m.e(l(b2));
                                            }
                                        } else if (D(b, b2)) {
                                            this.m.e(r(b2));
                                        } else if (w(b, b2)) {
                                            this.m.f();
                                            this.m.e(q(b, b2));
                                        } else if (x(b, b2)) {
                                            s(b2);
                                        } else if (z(b, b2)) {
                                            u(b, b2);
                                        } else if (E(b, b2)) {
                                            this.m.f = b2 - 32;
                                        } else if (y(b, b2)) {
                                            t(b2);
                                        }
                                        z3 = true;
                                    }
                                } else if (z4) {
                                    H();
                                    z3 = true;
                                }
                            }
                        }
                    }
                    z2 = false;
                    this.r = z2;
                    if (!B(z2, b, b2)) {
                    }
                }
            }
        }
        if (z3) {
            int i2 = this.p;
            if (i2 == 1 || i2 == 3) {
                this.n = n();
                this.x = f();
            }
        }
    }

    @Override // ea.e
    /* renamed from: c */
    public /* bridge */ /* synthetic */ m dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override // ea.e
    /* renamed from: d */
    public n dequeueOutputBuffer() {
        n e;
        n dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        if (!K() || (e = e()) == null) {
            return null;
        }
        this.n = Collections.emptyList();
        this.x = -9223372036854775807L;
        e.m(f(), a(), Long.MAX_VALUE);
        return e;
    }

    @Override // ea.e
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        I(0);
        J(4);
        H();
        this.r = false;
        this.s = false;
        this.t = (byte) 0;
        this.u = (byte) 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    @Override // ea.e
    protected boolean g() {
        return this.n != this.o;
    }

    @Override // ea.e
    /* renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(m mVar) {
        super.queueInputBuffer(mVar);
    }

    @Override // ea.e
    public void release() {
    }

    @Override // ea.e, da.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }
}
