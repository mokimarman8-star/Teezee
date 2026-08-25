package la;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.common.base.c;
import da.b;
import da.h;
import da.i;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends h {
    private final d0 o;
    private final boolean p;
    private final int q;
    private final int r;
    private final String s;
    private final float t;
    private final int u;

    public a(List list) {
        super("Tx3gDecoder");
        this.o = new d0();
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.q = 0;
            this.r = -1;
            this.s = "sans-serif";
            this.p = false;
            this.t = 0.85f;
            this.u = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.q = bArr[24];
        this.r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.s = "Serif".equals(p0.E(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.u = i;
        boolean z = (bArr[0] & 32) != 0;
        this.p = z;
        if (z) {
            this.t = p0.p(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.t = 0.85f;
        }
    }

    private static void A(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    private static void B(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, 16711713);
        }
    }

    private static String C(d0 d0Var) {
        char g;
        y(d0Var.a() >= 2);
        int J = d0Var.J();
        return J == 0 ? "" : (d0Var.a() < 2 || !((g = d0Var.g()) == 65279 || g == 65534)) ? d0Var.B(J, c.c) : d0Var.B(J, c.f);
    }

    private void x(d0 d0Var, SpannableStringBuilder spannableStringBuilder) {
        y(d0Var.a() >= 12);
        int J = d0Var.J();
        int J2 = d0Var.J();
        d0Var.Q(2);
        int D = d0Var.D();
        d0Var.Q(1);
        int n = d0Var.n();
        if (J2 > spannableStringBuilder.length()) {
            s.i("Tx3gDecoder", "Truncating styl end (" + J2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            J2 = spannableStringBuilder.length();
        }
        if (J < J2) {
            int i = J2;
            A(spannableStringBuilder, D, this.q, J, i, 0);
            z(spannableStringBuilder, n, this.r, J, i, 0);
            return;
        }
        s.i("Tx3gDecoder", "Ignoring styl with start (" + J + ") >= end (" + J2 + ").");
    }

    private static void y(boolean z) {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void z(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    @Override // da.h
    protected i w(byte[] bArr, int i, boolean z) {
        this.o.N(bArr, i);
        String C = C(this.o);
        if (C.isEmpty()) {
            return b.b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C);
        A(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        z(spannableStringBuilder, this.r, -1, 0, spannableStringBuilder.length(), 16711680);
        B(spannableStringBuilder, this.s, 0, spannableStringBuilder.length());
        float f = this.t;
        while (this.o.a() >= 8) {
            int e = this.o.e();
            int n = this.o.n();
            int n2 = this.o.n();
            if (n2 == 1937013100) {
                y(this.o.a() >= 2);
                int J = this.o.J();
                for (int i2 = 0; i2 < J; i2++) {
                    x(this.o, spannableStringBuilder);
                }
            } else if (n2 == 1952608120 && this.p) {
                y(this.o.a() >= 2);
                f = p0.p(this.o.J() / this.u, 0.0f, 0.95f);
            }
            this.o.P(e + n);
        }
        return new b(new b.C0042b().o(spannableStringBuilder).h(f, 0).i(0).a());
    }
}
