package ma;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import da.b;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends da.h {
    private final d0 o;

    public a() {
        super("Mp4WebvttDecoder");
        this.o = new d0();
    }

    private static da.b x(d0 d0Var, int i) {
        CharSequence charSequence = null;
        b.C0042b c0042b = null;
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int n = d0Var.n();
            int n2 = d0Var.n();
            int i2 = n - 8;
            String E = p0.E(d0Var.d(), d0Var.e(), i2);
            d0Var.Q(i2);
            i = (i - 8) - i2;
            if (n2 == 1937011815) {
                c0042b = f.o(E);
            } else if (n2 == 1885436268) {
                charSequence = f.q(null, E.trim(), Collections.emptyList());
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        return c0042b != null ? c0042b.o(charSequence).a() : f.l(charSequence);
    }

    @Override // da.h
    protected da.i w(byte[] bArr, int i, boolean z) {
        this.o.N(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.o.a() > 0) {
            if (this.o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int n = this.o.n();
            if (this.o.n() == 1987343459) {
                arrayList.add(x(this.o, n - 8));
            } else {
                this.o.Q(n - 8);
            }
        }
        return new b(arrayList);
    }
}
