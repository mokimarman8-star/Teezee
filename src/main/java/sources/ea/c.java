package ea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import da.b;
import da.i;
import da.m;
import da.n;
import ea.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c extends e {
    private final d0 g = new d0();
    private final c0 h = new c0();
    private int i = -1;
    private final boolean j;
    private final int k;
    private final b[] l;
    private b m;
    private List n;
    private List o;
    private C0045c p;
    private int q;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private static final Comparator c = new Comparator() { // from class: ea.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c2;
                c2 = c.a.c((c.a) obj, (c.a) obj2);
                return c2;
            }
        };
        public final da.b a;
        public final int b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            b.C0042b n = new b.C0042b().o(charSequence).p(alignment).h(f, i).i(i2).k(f2).l(i3).n(f3);
            if (z) {
                n.s(i4);
            }
            this.a = n.a();
            this.b = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.b, aVar.b);
        }
    }

    private static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;
        public static final int w = h(2, 2, 2, 0);
        public static final int x;
        public static final int y;
        private static final int[] z;
        private final List a = new ArrayList();
        private final SpannableStringBuilder b = new SpannableStringBuilder();
        private boolean c;
        private boolean d;
        private int e;
        private boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;

        static {
            int h = h(0, 0, 0, 0);
            x = h;
            int h2 = h(0, 0, 0, 3);
            y = h2;
            z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{h, h2, h, h, h2, h, h};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{h, h, h, h, h, h2, h2};
        }

        public b() {
            l();
        }

        public static int g(int i, int i2, int i3) {
            return h(i, i2, i3, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int h(int i, int i2, int i3, int i4) {
            int i5;
            com.google.android.exoplayer2.util.a.c(i, 0, 4);
            com.google.android.exoplayer2.util.a.c(i2, 0, 4);
            com.google.android.exoplayer2.util.a.c(i3, 0, 4);
            com.google.android.exoplayer2.util.a.c(i4, 0, 4);
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    i5 = 127;
                } else if (i4 == 3) {
                    i5 = 0;
                }
                return Color.argb(i5, i <= 1 ? 255 : 0, i2 <= 1 ? 255 : 0, i3 > 1 ? 255 : 0);
            }
            i5 = 255;
            return Color.argb(i5, i <= 1 ? 255 : 0, i2 <= 1 ? 255 : 0, i3 > 1 ? 255 : 0);
        }

        public void a(char c) {
            if (c != '\n') {
                this.b.append(c);
                return;
            }
            this.a.add(d());
            this.b.clear();
            if (this.p != -1) {
                this.p = 0;
            }
            if (this.q != -1) {
                this.q = 0;
            }
            if (this.r != -1) {
                this.r = 0;
            }
            if (this.t != -1) {
                this.t = 0;
            }
            while (true) {
                if ((!this.k || this.a.size() < this.j) && this.a.size() < 15) {
                    return;
                } else {
                    this.a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.b.length();
            if (length > 0) {
                this.b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a c() {
            Layout.Alignment alignment;
            float f;
            float f2;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < this.a.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.a.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i2 = this.l;
            if (i2 != 0) {
                if (i2 == 1) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else if (i2 == 2) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (i2 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.l);
                }
                Layout.Alignment alignment2 = alignment;
                if (this.f) {
                    f = this.h / 209.0f;
                    f2 = this.g / 74.0f;
                } else {
                    f = this.h / 99.0f;
                    f2 = this.g / 99.0f;
                }
                float f3 = (f * 0.9f) + 0.05f;
                float f4 = (f2 * 0.9f) + 0.05f;
                int i3 = this.i;
                return new a(spannableStringBuilder, alignment2, f4, 0, i3 / 3 != 0 ? 0 : i3 / 3 == 1 ? 1 : 2, f3, i3 % 3 != 0 ? 0 : i3 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.o != x, this.o, this.e);
            }
            alignment = Layout.Alignment.ALIGN_NORMAL;
            Layout.Alignment alignment22 = alignment;
            if (this.f) {
            }
            float f32 = (f * 0.9f) + 0.05f;
            float f42 = (f2 * 0.9f) + 0.05f;
            int i32 = this.i;
            return new a(spannableStringBuilder, alignment22, f42, 0, i32 / 3 != 0 ? 0 : i32 / 3 == 1 ? 1 : 2, f32, i32 % 3 != 0 ? 0 : i32 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.o != x, this.o, this.e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
                }
                if (this.r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.r, length, 33);
                }
                if (this.t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.u), this.t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.t = -1;
            this.v = 0;
        }

        public void f(boolean z2, boolean z3, boolean z4, int i, boolean z5, int i2, int i3, int i4, int i5, int i6, int i7, int i10) {
            this.c = true;
            this.d = z2;
            this.k = z3;
            this.e = i;
            this.f = z5;
            this.g = i2;
            this.h = i3;
            this.i = i6;
            int i11 = i4 + 1;
            if (this.j != i11) {
                this.j = i11;
                while (true) {
                    if ((!z3 || this.a.size() < this.j) && this.a.size() < 15) {
                        break;
                    } else {
                        this.a.remove(0);
                    }
                }
            }
            if (i7 != 0 && this.m != i7) {
                this.m = i7;
                int i12 = i7 - 1;
                q(D[i12], y, C[i12], 0, A[i12], B[i12], z[i12]);
            }
            if (i10 == 0 || this.n == i10) {
                return;
            }
            this.n = i10;
            int i13 = i10 - 1;
            m(0, 1, 1, false, false, F[i13], E[i13]);
            n(w, G[i13], x);
        }

        public boolean i() {
            return this.c;
        }

        public boolean j() {
            return !i() || (this.a.isEmpty() && this.b.length() == 0);
        }

        public boolean k() {
            return this.d;
        }

        public void l() {
            e();
            this.c = false;
            this.d = false;
            this.e = 4;
            this.f = false;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 15;
            this.k = true;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            int i = x;
            this.o = i;
            this.s = w;
            this.u = i;
        }

        public void m(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            if (this.p != -1) {
                if (!z2) {
                    this.b.setSpan(new StyleSpan(2), this.p, this.b.length(), 33);
                    this.p = -1;
                }
            } else if (z2) {
                this.p = this.b.length();
            }
            if (this.q == -1) {
                if (z3) {
                    this.q = this.b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.b.setSpan(new UnderlineSpan(), this.q, this.b.length(), 33);
                this.q = -1;
            }
        }

        public void n(int i, int i2, int i3) {
            if (this.r != -1 && this.s != i) {
                this.b.setSpan(new ForegroundColorSpan(this.s), this.r, this.b.length(), 33);
            }
            if (i != w) {
                this.r = this.b.length();
                this.s = i;
            }
            if (this.t != -1 && this.u != i2) {
                this.b.setSpan(new BackgroundColorSpan(this.u), this.t, this.b.length(), 33);
            }
            if (i2 != x) {
                this.t = this.b.length();
                this.u = i2;
            }
        }

        public void o(int i, int i2) {
            if (this.v != i) {
                a('\n');
            }
            this.v = i;
        }

        public void p(boolean z2) {
            this.d = z2;
        }

        public void q(int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
            this.o = i;
            this.l = i6;
        }
    }

    /* renamed from: ea.c$c, reason: collision with other inner class name */
    private static final class C0045c {
        public final int a;
        public final int b;
        public final byte[] c;
        int d = 0;

        public C0045c(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = new byte[(i2 * 2) - 1];
        }
    }

    public c(int i, List list) {
        this.k = i == -1 ? 1 : i;
        this.j = list != null && com.google.android.exoplayer2.util.f.i(list);
        this.l = new b[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.l[i2] = new b();
        }
        this.m = this.l[0];
    }

    private void A() {
        for (int i = 0; i < 8; i++) {
            this.l[i].l();
        }
    }

    private void k() {
        if (this.p == null) {
            return;
        }
        z();
        this.p = null;
    }

    private List l() {
        a c;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.l[i].j() && this.l[i].k() && (c = this.l[i].c()) != null) {
                arrayList.add(c);
            }
        }
        Collections.sort(arrayList, a.c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(((a) arrayList.get(i2)).a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void m(int i) {
        if (i != 0) {
            if (i == 3) {
                this.n = l();
            }
            if (i == 8) {
                this.m.b();
                return;
            }
            switch (i) {
                case 12:
                    A();
                    break;
                case 13:
                    this.m.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i >= 17 && i <= 23) {
                        s.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                        this.h.r(8);
                        break;
                    } else if (i >= 24 && i <= 31) {
                        s.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                        this.h.r(16);
                        break;
                    } else {
                        s.i("Cea708Decoder", "Invalid C0 command: " + i);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void n(int i) {
        int i2 = 1;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i3 = i - 128;
                if (this.q != i3) {
                    this.q = i3;
                    this.m = this.l[i3];
                    break;
                }
                break;
            case 136:
                while (i2 <= 8) {
                    if (this.h.g()) {
                        this.l[8 - i2].e();
                    }
                    i2++;
                }
                break;
            case 137:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.h.g()) {
                        this.l[8 - i4].p(true);
                    }
                }
                break;
            case 138:
                while (i2 <= 8) {
                    if (this.h.g()) {
                        this.l[8 - i2].p(false);
                    }
                    i2++;
                }
                break;
            case 139:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.h.g()) {
                        this.l[8 - i5].p(!r0.k());
                    }
                }
                break;
            case 140:
                while (i2 <= 8) {
                    if (this.h.g()) {
                        this.l[8 - i2].l();
                    }
                    i2++;
                }
                break;
            case 141:
                this.h.r(8);
                break;
            case 142:
                break;
            case 143:
                A();
                break;
            case 144:
                if (this.m.i()) {
                    v();
                    break;
                } else {
                    this.h.r(16);
                    break;
                }
            case 145:
                if (this.m.i()) {
                    w();
                    break;
                } else {
                    this.h.r(24);
                    break;
                }
            case 146:
                if (this.m.i()) {
                    x();
                    break;
                } else {
                    this.h.r(16);
                    break;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                s.i("Cea708Decoder", "Invalid C1 command: " + i);
                break;
            case 151:
                if (this.m.i()) {
                    y();
                    break;
                } else {
                    this.h.r(32);
                    break;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i6 = i - 152;
                q(i6);
                if (this.q != i6) {
                    this.q = i6;
                    this.m = this.l[i6];
                    break;
                }
                break;
        }
    }

    private void o(int i) {
        if (i <= 7) {
            return;
        }
        if (i <= 15) {
            this.h.r(8);
        } else if (i <= 23) {
            this.h.r(16);
        } else if (i <= 31) {
            this.h.r(24);
        }
    }

    private void p(int i) {
        if (i <= 135) {
            this.h.r(32);
            return;
        }
        if (i <= 143) {
            this.h.r(40);
        } else if (i <= 159) {
            this.h.r(2);
            this.h.r(this.h.h(6) * 8);
        }
    }

    private void q(int i) {
        b bVar = this.l[i];
        this.h.r(2);
        boolean g = this.h.g();
        boolean g2 = this.h.g();
        boolean g3 = this.h.g();
        int h = this.h.h(3);
        boolean g4 = this.h.g();
        int h2 = this.h.h(7);
        int h3 = this.h.h(8);
        int h4 = this.h.h(4);
        int h5 = this.h.h(4);
        this.h.r(2);
        int h6 = this.h.h(6);
        this.h.r(2);
        bVar.f(g, g2, g3, h, g4, h2, h3, h5, h6, h4, this.h.h(3), this.h.h(3));
    }

    private void r(int i) {
        if (i == 127) {
            this.m.a((char) 9835);
        } else {
            this.m.a((char) (i & 255));
        }
    }

    private void s(int i) {
        this.m.a((char) (i & 255));
    }

    private void t(int i) {
        if (i == 32) {
            this.m.a(' ');
        }
        if (i == 33) {
            this.m.a((char) 160);
            return;
        }
        if (i == 37) {
            this.m.a((char) 8230);
            return;
        }
        if (i == 42) {
            this.m.a((char) 352);
            return;
        }
        if (i == 44) {
            this.m.a((char) 338);
            return;
        }
        if (i == 63) {
            this.m.a((char) 376);
            return;
        }
        if (i == 57) {
            this.m.a((char) 8482);
            return;
        }
        if (i == 58) {
            this.m.a((char) 353);
            return;
        }
        if (i == 60) {
            this.m.a((char) 339);
            return;
        }
        if (i == 61) {
            this.m.a((char) 8480);
            return;
        }
        switch (i) {
            case 48:
                this.m.a((char) 9608);
                break;
            case 49:
                this.m.a((char) 8216);
                break;
            case 50:
                this.m.a((char) 8217);
                break;
            case 51:
                this.m.a((char) 8220);
                break;
            case 52:
                this.m.a((char) 8221);
                break;
            case 53:
                this.m.a((char) 8226);
                break;
            default:
                switch (i) {
                    case 118:
                        this.m.a((char) 8539);
                        break;
                    case 119:
                        this.m.a((char) 8540);
                        break;
                    case 120:
                        this.m.a((char) 8541);
                        break;
                    case 121:
                        this.m.a((char) 8542);
                        break;
                    case 122:
                        this.m.a((char) 9474);
                        break;
                    case 123:
                        this.m.a((char) 9488);
                        break;
                    case 124:
                        this.m.a((char) 9492);
                        break;
                    case 125:
                        this.m.a((char) 9472);
                        break;
                    case 126:
                        this.m.a((char) 9496);
                        break;
                    case 127:
                        this.m.a((char) 9484);
                        break;
                    default:
                        s.i("Cea708Decoder", "Invalid G2 character: " + i);
                        break;
                }
        }
    }

    private void u(int i) {
        if (i == 160) {
            this.m.a((char) 13252);
            return;
        }
        s.i("Cea708Decoder", "Invalid G3 character: " + i);
        this.m.a('_');
    }

    private void v() {
        this.m.m(this.h.h(4), this.h.h(2), this.h.h(2), this.h.g(), this.h.g(), this.h.h(3), this.h.h(3));
    }

    private void w() {
        int h = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        int h2 = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        this.h.r(2);
        this.m.n(h, h2, b.g(this.h.h(2), this.h.h(2), this.h.h(2)));
    }

    private void x() {
        this.h.r(4);
        int h = this.h.h(4);
        this.h.r(2);
        this.m.o(h, this.h.h(6));
    }

    private void y() {
        int h = b.h(this.h.h(2), this.h.h(2), this.h.h(2), this.h.h(2));
        int h2 = this.h.h(2);
        int g = b.g(this.h.h(2), this.h.h(2), this.h.h(2));
        if (this.h.g()) {
            h2 |= 4;
        }
        boolean g2 = this.h.g();
        int h3 = this.h.h(2);
        int h4 = this.h.h(2);
        int h5 = this.h.h(2);
        this.h.r(8);
        this.m.q(h, g, g2, h2, h3, h4, h5);
    }

    private void z() {
        C0045c c0045c = this.p;
        if (c0045c.d != (c0045c.b * 2) - 1) {
            s.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.p.b * 2) - 1) + ", but current index is " + this.p.d + " (sequence number " + this.p.a + ");");
        }
        c0 c0Var = this.h;
        C0045c c0045c2 = this.p;
        c0Var.o(c0045c2.c, c0045c2.d);
        boolean z = false;
        while (true) {
            if (this.h.b() <= 0) {
                break;
            }
            int h = this.h.h(3);
            int h2 = this.h.h(5);
            if (h == 7) {
                this.h.r(2);
                h = this.h.h(6);
                if (h < 7) {
                    s.i("Cea708Decoder", "Invalid extended service number: " + h);
                }
            }
            if (h2 == 0) {
                if (h != 0) {
                    s.i("Cea708Decoder", "serviceNumber is non-zero (" + h + ") when blockSize is 0");
                }
            } else if (h != this.k) {
                this.h.s(h2);
            } else {
                int e = this.h.e() + (h2 * 8);
                while (this.h.e() < e) {
                    int h3 = this.h.h(8);
                    if (h3 == 16) {
                        int h4 = this.h.h(8);
                        if (h4 <= 31) {
                            o(h4);
                        } else {
                            if (h4 <= 127) {
                                t(h4);
                            } else if (h4 <= 159) {
                                p(h4);
                            } else if (h4 <= 255) {
                                u(h4);
                            } else {
                                s.i("Cea708Decoder", "Invalid extended command: " + h4);
                            }
                            z = true;
                        }
                    } else if (h3 <= 31) {
                        m(h3);
                    } else {
                        if (h3 <= 127) {
                            r(h3);
                        } else if (h3 <= 159) {
                            n(h3);
                        } else if (h3 <= 255) {
                            s(h3);
                        } else {
                            s.i("Cea708Decoder", "Invalid base command: " + h3);
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            this.n = l();
        }
    }

    @Override // ea.e
    protected i a() {
        List list = this.n;
        this.o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    @Override // ea.e
    protected void b(m mVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(((DecoderInputBuffer) mVar).c);
        this.g.N(byteBuffer.array(), byteBuffer.limit());
        while (this.g.a() >= 3) {
            int D = this.g.D();
            int i = D & 3;
            boolean z = (D & 4) == 4;
            byte D2 = (byte) this.g.D();
            byte D3 = (byte) this.g.D();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        k();
                        int i2 = (D2 & 192) >> 6;
                        int i3 = this.i;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            A();
                            s.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.i + " current=" + i2);
                        }
                        this.i = i2;
                        int i4 = D2 & 63;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        C0045c c0045c = new C0045c(i2, i4);
                        this.p = c0045c;
                        byte[] bArr = c0045c.c;
                        int i5 = c0045c.d;
                        c0045c.d = i5 + 1;
                        bArr[i5] = D3;
                    } else {
                        com.google.android.exoplayer2.util.a.a(i == 2);
                        C0045c c0045c2 = this.p;
                        if (c0045c2 == null) {
                            s.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0045c2.c;
                            int i6 = c0045c2.d;
                            int i7 = i6 + 1;
                            c0045c2.d = i7;
                            bArr2[i6] = D2;
                            c0045c2.d = i6 + 2;
                            bArr2[i7] = D3;
                        }
                    }
                    C0045c c0045c3 = this.p;
                    if (c0045c3.d == (c0045c3.b * 2) - 1) {
                        k();
                    }
                }
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
    public /* bridge */ /* synthetic */ n dequeueOutputBuffer() {
        return super.dequeueOutputBuffer();
    }

    @Override // ea.e
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        this.q = 0;
        this.m = this.l[0];
        A();
        this.p = null;
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
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // ea.e, da.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }
}
